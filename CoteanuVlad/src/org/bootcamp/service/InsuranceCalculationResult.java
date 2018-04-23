package org.bootcamp.service;


public final class InsuranceCalculationResult {
    private final String id;
    private final double cost;
    private final String vehicleType;

    public InsuranceCalculationResult(String id, double cost, String vehicleType) {
        this.id = id;
        this.cost = cost;
        this.vehicleType = vehicleType;
    }

    public String getId() {
        return id;
    }

    public double getCost() {
        return cost;
    }

    public String getVehicleType() {
        return vehicleType;
    }
}
