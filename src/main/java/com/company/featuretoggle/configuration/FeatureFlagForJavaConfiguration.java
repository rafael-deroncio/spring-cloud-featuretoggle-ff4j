package com.company.featuretoggle.configuration;

import javax.sql.DataSource;

import org.ff4j.FF4j;
import org.ff4j.security.SpringSecurityAuthorisationManager;
import org.ff4j.springjdbc.store.EventRepositorySpringJdbc;
import org.ff4j.springjdbc.store.FeatureStoreSpringJdbc;
import org.ff4j.springjdbc.store.PropertyStoreSpringJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeatureFlagForJavaConfiguration {

    @Autowired
    private DataSource _dataSource;

    @Bean
    FF4j FeatureFlagForJava() {
        FF4j ff4j = new FF4j();

        ff4j.setFeatureStore(this.featureStore());
        ff4j.setPropertiesStore(this.propertyStore());
        ff4j.setEventRepository(this.eventRepository());
        ff4j.setAuthorizationsManager(this.securityAuthorisationManager());
        ff4j.audit(true);
        ff4j.autoCreate(true);

        return ff4j;
    }

    private FeatureStoreSpringJdbc featureStore() {
        FeatureStoreSpringJdbc featureStore = new FeatureStoreSpringJdbc(_dataSource);
        featureStore.createSchema();
        return featureStore;
    }

    private PropertyStoreSpringJdbc propertyStore() {
        PropertyStoreSpringJdbc propertyStore = new PropertyStoreSpringJdbc(_dataSource);
        propertyStore.createSchema();
        return propertyStore;
    }

    private EventRepositorySpringJdbc eventRepository() {
        EventRepositorySpringJdbc eventRepository = new EventRepositorySpringJdbc(_dataSource);
        eventRepository.createSchema();
        return eventRepository;
    }

    private SpringSecurityAuthorisationManager securityAuthorisationManager() {
        SpringSecurityAuthorisationManager securityAuthorisationManager = new SpringSecurityAuthorisationManager();
        return securityAuthorisationManager;
    }
}
