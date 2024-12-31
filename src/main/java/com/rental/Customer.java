package com.rental;

import com.vehicles.Vehicle;

public class Customer {
    private final String name;
    private final String customerId;
    private int loyaltyPoints;

    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
        this.loyaltyPoints = 0;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void addLoyaltyPoints(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("Points cannot be negative.");
        }
        this.loyaltyPoints += points;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", customerId='" + customerId + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }

    public String getCurrentRentals() {
        return "";
    }

    public void addRental(Vehicle vehicle, int days) {
    }
}
