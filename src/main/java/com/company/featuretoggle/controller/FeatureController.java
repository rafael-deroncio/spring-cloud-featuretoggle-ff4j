package com.company.featuretoggle.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.ff4j.core.Feature;
import org.ff4j.exception.FeatureNotFoundException;

import com.company.featuretoggle.service.IFeatureService;

@RestController
@RequestMapping("/api/features")
public class FeatureController {

    private final IFeatureService _featureService;

    public FeatureController(IFeatureService featureService) {
        this._featureService = featureService;
    }

    @GetMapping
    public ResponseEntity<List<Feature>> getAllFeatures() {
        List<Feature> features = _featureService.getAllFeatures();
        return ResponseEntity.ok(features);
    }

    @GetMapping("/{featureId}")
    public ResponseEntity<Feature> getFeatureById(@PathVariable String featureId) {
        try {
            Feature feature = _featureService.getFeature(featureId);
            return ResponseEntity.ok(feature);
        } catch (FeatureNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{featureId}")
    public ResponseEntity<Void> createFeature(@PathVariable String featureId) {
        _featureService.createFeature(featureId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{featureId}")
    public ResponseEntity<Void> toggleFeature(@PathVariable String featureId, @RequestParam boolean enable) {
        _featureService.toggleFeature(featureId, enable);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{featureId}")
    public ResponseEntity<Void> deleteFeature(@PathVariable String featureId) {
        _featureService.deleteFeature(featureId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{featureId}/check")
    public ResponseEntity<Boolean> checkFeature(@PathVariable String featureId) {
        boolean isEnabled = _featureService.checkFeature(featureId);
        return ResponseEntity.ok(isEnabled);
    }
}
