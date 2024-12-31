package com.rental;

import com.vehicles.Vehicle;

class RentalTransaction {
    private Customer customer;
    private Vehicle vehicle;
    private final int rentalDays;

    public RentalTransaction(Customer customer, Vehicle vehicle, int rentalDays) {
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
