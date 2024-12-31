package com.rental;

import com.vehicles.Car;
import com.vehicles.Motorcycle;
import com.vehicles.Truck;
import com.vehicles.Vehicle;
import com.rental.exceptions.RentalException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create rental agency
        RentalAgency agency = new RentalAgency();

        // Create vehicles
        Vehicle car1 = new Car("V123", "Toyota Camry", 50, 4);  // 50 is base rate, 4 doors
        Vehicle car2 = new Car("V124", "Honda Civic", 45, 4);
        Vehicle motorcycle1 = new Motorcycle("V125", "Yamaha YZF", 30, true);  // 30 is base rate, has helmet
        Vehicle truck1 = new Truck("V126", "Ford F-150", 100, 2000);  // 100 is base rate, 2000kg load capacity

        // Add vehicles to fleet
        agency.addVehicle(car1);
        agency.addVehicle(car2);
        agency.addVehicle(motorcycle1);
        agency.addVehicle(truck1);

        // Create customers
        Customer customer1 = new Customer("C001", "John Doe");
        Customer customer2 = new Customer("C002", "Jane Smith");

        // Register customers
        agency.registerCustomer(customer1);
        agency.registerCustomer(customer2);

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Main menu loop
        while (true) {
            System.out.println("\n------ Rental Agency Menu ------");
            System.out.println("1. Rent a vehicle");
            System.out.println("2. Return a vehicle");
            System.out.println("3. View customer details");
            System.out.println("4. View available vehicles");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // Rent a vehicle
                    System.out.print("Enter Customer ID: ");
                    String customerId = scanner.nextLine();

                    System.out.print("Enter Vehicle ID to rent: ");
                    String vehicleId = scanner.nextLine();

                    System.out.print("Enter rental days: ");
                    int days = scanner.nextInt();

                    try {
                        agency.rentVehicle(vehicleId, customerId, days);
                    } catch (RentalException e) {
                        System.out.println("Error during rental: " + e.getMessage());
                    }
                    break;

                case 2:
                    // Return a vehicle
                    System.out.print("Enter Vehicle ID to return: ");
                    String returnVehicleId = scanner.nextLine();

                    try {
                        agency.returnVehicle(returnVehicleId);
                    } catch (RentalException e) {
                        System.out.println("Error during vehicle return: " + e.getMessage());
                    }
                    break;

                case 3:
                    // View customer details (including loyalty points and rentals)
                    System.out.print("Enter Customer ID to view details: ");
                    String customerDetailsId = scanner.nextLine();

                    Customer customer = agency.getCustomer(customerDetailsId);
                    if (customer != null) {
                        System.out.println("Customer: " + customer.getName());
                        System.out.println("Loyalty Points: " + customer.getLoyaltyPoints());
                        System.out.println("Current Rentals: " + customer.getCurrentRentals());
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    // View available vehicles
                    System.out.println("Available vehicles:");
                    agency.getAvailableVehicles().forEach(vehicle -> {
                        System.out.println(vehicle.getModel() + " (" + vehicle.getVehicleId() + ") - $" + vehicle.calculateRentalCost(1) + " per day");
                    });
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting the rental system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
