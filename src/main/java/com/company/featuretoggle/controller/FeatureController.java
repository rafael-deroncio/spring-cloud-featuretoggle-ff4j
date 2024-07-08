package com.company.featuretoggle.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.featuretoggle.service.IFeatureService;

@RestController
@RequestMapping("/api")
public class FeatureController {

    private final IFeatureService _featureService;

    public FeatureController(IFeatureService featureService) {
        this._featureService = featureService;
    }

    @GetMapping("/features/check/{grantedClient}/{featureName}")
    ResponseEntity<Boolean> checkFeature(@PathVariable String grantedClient, @PathVariable String featureName) {
        return ResponseEntity.ok(this._featureService.check(grantedClient, featureName));
    }
}
