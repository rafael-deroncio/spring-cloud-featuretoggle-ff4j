package com.company.featuretoggle.service;

import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class FeatureService implements IFeatureService {

    private final FF4j _ff4j;

    public FeatureService(FF4j ff4j) {
        this._ff4j = ff4j;
    }

    @Override
    public boolean check(String granted, String feature) {
        Feature toggle = _ff4j.getFeature(feature);

        if (toggle == null || !toggle.isEnable()) {
            return false;
        }

        String[] grantes = toggle.getFlippingStrategy()
                .getInitParams()
                .get("grantedClients")
                .trim()
                .toLowerCase()
                .replace(" ", "")
                .split(",");

        if (Arrays.asList(grantes).contains(granted.toLowerCase().trim())) {
            return toggle.isEnable();
        }

        return false;
    }
}
