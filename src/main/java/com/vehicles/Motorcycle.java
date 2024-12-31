package com.vehicles;

public class Motorcycle extends Vehicle {
    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean b) {
        super(vehicleId, model, baseRentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days * 0.8; // Discount for motorcycles
    }
}
