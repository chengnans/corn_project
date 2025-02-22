package com.cheng.model;

import java.util.List;

public class EnvironmentDataResponse {

    private Double temperature;
    private Double humidity;
    private Double soilMoisture;
    private List<String> recentPlans;

    // Getters and Setters
    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getSoilMoisture() {
        return soilMoisture;
    }

    public void setSoilMoisture(Double soilMoisture) {
        this.soilMoisture = soilMoisture;
    }

    public List<String> getRecentPlans() {
        return recentPlans;
    }

    public void setRecentPlans(List<String> recentPlans) {
        this.recentPlans = recentPlans;
    }
}
