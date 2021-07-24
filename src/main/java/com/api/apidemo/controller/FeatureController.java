package com.api.apidemo.controller;


import com.api.apidemo.model.Feature;
import com.api.apidemo.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/feature")
public class FeatureController {

    @Autowired
    FeatureRepository featureRepository;

    @GetMapping()
    public ResponseEntity<Object> checkAccessByEmailFeatureName(String  email, String featureName) {

        Optional<Feature> feature = featureRepository.findByEmailAndFeatureName(email,featureName).stream().findFirst();

        try {
            if (feature.isPresent()) {
                HashMap<String, Boolean> map = new HashMap<>();
                map.put("canAccess", feature.get().isEnable());
                return new ResponseEntity<Object>(map, HttpStatus.OK);
            } else
                return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);

        } catch (Exception e)
        {
            return new ResponseEntity<Object>( null, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @PostMapping()
    public ResponseEntity createFeature(@RequestBody Feature feature)
    {
        try {

            Optional<Feature> featureDt = featureRepository.findByEmailAndFeatureName(feature.getEmail(),feature.getFeatureName()).stream().findFirst();

            if(!featureDt.isPresent())
            {

                featureRepository.save(new Feature(feature.getFeatureName(), feature.getEmail(), feature.isEnable()));
                return new ResponseEntity(HttpStatus.OK);

            }
            else if( featureDt.isPresent() && featureDt.get().isEnable() != feature.isEnable())
            {

                Feature _feature = featureDt.get();
                _feature.setEnable(feature.isEnable());
                 featureRepository.save(_feature);
                return new ResponseEntity(HttpStatus.OK);

            }
            else

                return new ResponseEntity(HttpStatus.NOT_MODIFIED);


        } catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
