package com.vehicles;

public class Truck extends Vehicle {
    private final double additionalFee;

    public Truck(String vehicleId, String model, double baseRentalRate, double additionalFee) {
        super(vehicleId, model, baseRentalRate);
        this.additionalFee = additionalFee;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getBaseRentalRate() * days) + additionalFee;
    }
}
