package com.company.featuretoggle.configuration;

import org.ff4j.FF4j;
import org.ff4j.web.FF4jDispatcherServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AutoConfigureAfter(FeatureFlagForJavaConfiguration.class)
public class FeatureFlagForJavaWebConsoleConfiguration {

    @Value("${spring.security.user.name}")
    private String _username;

    @Value("${spring.security.user.password}")
    private String _password;

    @Value("${spring.security.user.roles}")
    private String[] _roles;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/api/**").permitAll()
                        .requestMatchers("/console/**").hasRole(_roles[0])
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .defaultSuccessUrl("/console", true)
                        .permitAll())
                .build();
    }

    @Bean
    UserDetailsService userDetailsService(BCryptPasswordEncoder encoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername(_username)
                .password(encoder.encode(_password))
                .roles(_roles)
                .build());
        return manager;
    }

    @Bean
    BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @ConditionalOnMissingBean
    FF4jDispatcherServlet ff4jDispatcherServlet(FF4j ff4j) {
        FF4jDispatcherServlet ff4jDispatcherServlet = new FF4jDispatcherServlet();
        ff4jDispatcherServlet.setFf4j(ff4j);
        return ff4jDispatcherServlet;
    }

    @Bean
    ServletRegistrationBean<FF4jDispatcherServlet> servletRegistrationBean(FF4jDispatcherServlet servlet) {
        return new ServletRegistrationBean<FF4jDispatcherServlet>(servlet, "/console/*");
    }
}