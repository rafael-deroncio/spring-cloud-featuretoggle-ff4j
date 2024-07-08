package com.company.featuretoggle.service;

import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.ff4j.exception.FeatureNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeatureService implements IFeatureService {

    private final FF4j _ff4j;

    public FeatureService(FF4j ff4j) {
        this._ff4j = ff4j;
    }

    @Override
    public List<Feature> getAllFeatures() {
        return new ArrayList<>(_ff4j.getFeatureStore().readAll().values());
    }

    @Override
    public Feature getFeature(String featureId) throws FeatureNotFoundException {
        return _ff4j.getFeature(featureId);
    }

    @Override
    public void createFeature(String featureId) {
        _ff4j.createFeature(featureId);
    }

    @Override
    public void toggleFeature(String featureId, boolean enable) {
        _ff4j.getFeature(featureId).setEnable(enable);
    }

    @Override
    public void deleteFeature(String featureId) {
        _ff4j.delete(featureId);
    }

    @Override
    public boolean checkFeature(String featureId) {
        return _ff4j.check(featureId);
    }
}
