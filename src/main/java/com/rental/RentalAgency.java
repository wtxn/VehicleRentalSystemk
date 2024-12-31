package com.rental;

import com.vehicles.Vehicle;
import com.rental.exceptions.RentalException;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Vehicle> fleet;
    private List<Customer> customers;

    public RentalAgency() {
        fleet = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    // Rent a vehicle to a customer
    public void rentVehicle(String vehicleId, String customerId, int days) throws RentalException {
        Vehicle vehicle = findVehicle(vehicleId);
        if (vehicle == null) {
            throw new RentalException("Vehicle not found.");
        }

        if (!vehicle.isAvailableForRental()) {
            throw new RentalException("Vehicle is not available.");
        }

        Customer customer = findCustomer(customerId);
        if (customer == null) {
            throw new RentalException("Customer not found.");
        }

        // Rent the vehicle to the customer
        vehicle.setAvailable(false);  // Mark the vehicle as rented
        customer.addRental(vehicle, days);

        double rentalCost = vehicle.calculateRentalCost(days);
        System.out.println("Rental successful! Rental cost: $" + rentalCost);
    }

    // Return a rented vehicle
    public void returnVehicle(String vehicleId) throws RentalException {
        Vehicle vehicle = findVehicle(vehicleId);
        if (vehicle == null) {
            throw new RentalException("Vehicle not found.");
        }

        if (vehicle.isAvailableForRental()) {
            throw new RentalException("Vehicle is not currently rented.");
        }

        vehicle.setAvailable(true);  // Mark the vehicle as available
        System.out.println("Vehicle returned successfully!");
    }

    // View available vehicles
    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : fleet) {
            if (vehicle.isAvailableForRental()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }

    // Get a customer by ID
    public Customer getCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    // Helper methods to find vehicle and customer
    private Vehicle findVehicle(String vehicleId) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }

    private Customer findCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }
}
