package com.company.featuretoggle.service;

/**
 * Interface for feature toggle service.
 */
public interface IFeatureService {

    /**
     * Checks if a feature is enabled for a specific client.
     *
     * @param grante the client name
     * @param feature the feature name
     * @return true if the feature is enabled for the client, false otherwise
     */
    boolean check(String grante, String feature);
}
