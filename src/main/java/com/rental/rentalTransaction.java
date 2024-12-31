package com.rental;

import com.vehicles.Vehicle;

public class rentalTransaction {
    private Customer customer;
    private Vehicle vehicle;
    private int rentalDays;

    public rentalTransaction(Customer customer, Vehicle vehicle, int rentalDays) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
    }

    @Override
    public String toString() {
        return "RentalTransaction{" +
                "customer=" + customer +
                ", vehicle=" + vehicle +
                ", rentalDays=" + rentalDays +
                '}';
    }
}
