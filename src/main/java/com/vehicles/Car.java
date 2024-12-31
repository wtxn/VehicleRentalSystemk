package com.vehicles;

public class Car extends Vehicle {
    public Car(String vehicleId, String model, int rentalRate, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days;
    }
}
