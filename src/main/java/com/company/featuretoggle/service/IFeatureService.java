package com.company.featuretoggle.service;

import org.ff4j.core.Feature;
import org.ff4j.exception.FeatureNotFoundException;

import java.util.List;

/**
 * Interface for managing features using FF4J.
 */
public interface IFeatureService {

    /**
     * Retrieves all available features.
     *
     * @return List of all features.
     */
    List<Feature> getAllFeatures();

    /**
     * Retrieves a feature by its ID.
     *
     * @param featureId ID of the feature to retrieve.
     * @return The feature corresponding to the specified ID.
     * @throws FeatureNotFoundException If the feature does not exist.
     */
    Feature getFeature(String featureId) throws FeatureNotFoundException;

    /**
     * Creates a new feature with the specified ID.
     *
     * @param featureId ID of the new feature to create.
     */
    void createFeature(String featureId);

    /**
     * Toggles a feature with the specified ID.
     *
     * @param featureId ID of the feature to toggle.
     * @param enable    Boolean value indicating whether to enable (true) or disable (false) the feature.
     */
    void toggleFeature(String featureId, boolean enable);

    /**
     * Deletes a feature by its ID.
     *
     * @param featureId ID of the feature to delete.
     */
    void deleteFeature(String featureId);

    /**
     * Checks if a feature is enabled.
     *
     * @param featureId ID of the feature to check.
     * @return true if the feature is enabled, false otherwise.
     */
    boolean checkFeature(String featureId);
}
