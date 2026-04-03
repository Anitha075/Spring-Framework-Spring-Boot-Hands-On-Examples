package com.Learning.SpringBootRESTAPI.config;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import javax.xml.catalog.CatalogFeatures;
import java.awt.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id="features")
public class featureendpoint {
    private final Map<String,Feature> featureMap=
            new ConcurrentHashMap<>();

    public featureendpoint() {
        featureMap.put("Department", new Feature(true));
        featureMap.put("user", new Feature(false));
        featureMap.put("Authentication", new Feature(false));
    }
    @ReadOperation
    public Map<String,Feature> features()
    {
        return featureMap;
    }
    public Feature feature(@Selector String featureName)
    {
        return featureMap.get(featureName);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Feature
    {
        private boolean isEnabled;
    }

}
