package com.api.apidemo.repository;

import com.api.apidemo.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
   List<Feature> findByEmailAndFeatureName(String email, String featureName);

}
