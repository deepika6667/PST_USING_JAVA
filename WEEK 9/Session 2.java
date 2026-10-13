TASK 6:
Ride Sharing Platform Simulator:
import java.util.*;

class Driver {
    int driverId;
    String name;
    boolean available;

    Driver(int driverId, String name) {
        this.driverId = driverId;
        this.name = name;
        this.available = true;
    }
}

class Ride {
    int rideId;
    String passengerName;
    String pickup;
    String destination;
    double distance;
    double fare;
    String status;
    Driver driver;

    Ride(int rideId, String passengerName, String pickup,
         String destination, double distance) {
        this.rideId = rideId;
        this.passengerName = passengerName;
        this.pickup = pickup;
        this.destination = destination;
        this.distance = distance;
        this.fare = distance * 15.0;
        this.status = "Booked";
        this.driver = null;
    }

    void display() {
        System.out.println("\nRide ID: " + rideId);
        System.out.println("Passenger: " + passengerName);
        System.out.println("Pickup: " + pickup);
        System.out.println("Destination: " + destination);
        System.out.println("Distance: " + distance + " km");
        System.out.printf("Fare: Rs. %.2f%n", fare);
        System.out.println("Status: " + status);
        System.out.println("Driver: " +
                (driver == null ? "Not assigned" : driver.name));
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Driver> drivers = new ArrayList<>();
    static ArrayList<Ride> rides = new ArrayList<>();
    static int nextRideId = 1;

    static void initializeDrivers() {
        drivers.add(new Driver(101, "Arun"));
        drivers.add(new Driver(102, "Kumar"));
        drivers.add(new Driver(103, "Priya"));
    }

    static void bookRide() {
        sc.nextLine();

        System.out.print("Enter passenger name: ");
        String passenger = sc.nextLine().trim();

        System.out.print("Enter pickup location: ");
        String pickup = sc.nextLine().trim();

        System.out.print("Enter destination: ");
        String destination = sc.nextLine().trim();

        System.out.print("Enter distance in km: ");
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid distance.");
            sc.next();
            return;
        }
        double distance = sc.nextDouble();

        if (passenger.isEmpty() || pickup.isEmpty()
                || destination.isEmpty() || distance <= 0) {
            System.out.println("Invalid ride details.");
            return;
        }

        Driver assignedDriver = null;

        for (Driver d : drivers) {
            if (d.available) {
                assignedDriver = d;
                break;
            }
        }

        if (assignedDriver == null) {
            System.out.println("No drivers available.");
            return;
        }

        Ride ride = new Ride(nextRideId++, passenger, pickup,
                destination, distance);

        ride.driver = assignedDriver;
        assignedDriver.available = false;
        rides.add(ride);

        System.out.println("\nRide booked successfully!");
        ride.display();
    }

    static Ride findRide(int id) {
        for (Ride r : rides) {
            if (r.rideId == id) {
                return r;
            }
        }
        return null;
    }

    static void completeRide() {
        System.out.print("Enter ride ID: ");
        int id = sc.nextInt();

        Ride ride = findRide(id);

        if (ride == null) {
            System.out.println("Ride not found.");
        } else if (!ride.status.equals("Booked")) {
            System.out.println("Ride is already " + ride.status + ".");
        } else {
            ride.status = "Completed";
            ride.driver.available = true;
            System.out.printf("Ride completed! Total fare: Rs. %.2f%n",
                    ride.fare);
        }
    }

    static void cancelRide() {
        System.out.print("Enter ride ID: ");
        int id = sc.nextInt();

        Ride ride = findRide(id);

        if (ride == null) {
            System.out.println("Ride not found.");
        } else if (!ride.status.equals("Booked")) {
            System.out.println("Only booked rides can be cancelled.");
        } else {
            ride.status = "Cancelled";
            ride.driver.available = true;
            System.out.println("Ride cancelled successfully.");
        }
    }

    static void viewRideHistory() {
        if (rides.isEmpty()) {
            System.out.println("No rides available.");
            return;
        }

        for (Ride ride : rides) {
            ride.display();
        }
    }

    static void viewDrivers() {
        System.out.println("\n--- Driver List ---");
        for (Driver d : drivers) {
            System.out.println("ID: " + d.driverId
                    + ", Name: " + d.name
                    + ", Status: "
                    + (d.available ? "Available" : "On a ride"));
        }
    }

    public static void main(String[] args) {
        initializeDrivers();

        int choice = 0;

        do {
            System.out.println("\n=== Ride Sharing Platform ===");
            System.out.println("1. Book a Ride");
            System.out.println("2. Complete a Ride");
            System.out.println("3. Cancel a Ride");
            System.out.println("4. View Ride History");
            System.out.println("5. View Drivers");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bookRide();
                    break;
                case 2:
                    completeRide();
                    break;
                case 3:
                    cancelRide();
                    break;
                case 4:
                    viewRideHistory();
                    break;
                case 5:
                    viewDrivers();
                    break;
                case 6:
                    System.out.println("Thank you for using the platform!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);

        sc.close();
    }
}
OUTPUT:
=== Ride Sharing Platform ===
1. Book a Ride
2. Complete a Ride
3. Cancel a Ride
4. View Ride History
5. View Drivers
6. Exit
Enter your choice: 1
Enter passenger name: deepika
Enter pickup location: queens hostel
Enter destination: central
Enter distance in km: 32

Ride booked successfully!

Ride ID: 1
Passenger: deepika
Pickup: queens hostel
Destination: central
Distance: 32.0 km
Fare: Rs. 480.00
Status: Booked
Driver: Arun

=== Ride Sharing Platform ===
1. Book a Ride
2. Complete a Ride
3. Cancel a Ride
4. View Ride History
5. View Drivers
6. Exit
Enter your choice: 2
Enter ride ID: 1
Ride completed! Total fare: Rs. 480.00

=== Ride Sharing Platform ===
1. Book a Ride
2. Complete a Ride
3. Cancel a Ride
4. View Ride History
5. View Drivers
6. Exit
Enter your choice: 3
Enter ride ID: 1
Only booked rides can be cancelled.

=== Ride Sharing Platform ===
1. Book a Ride
2. Complete a Ride
3. Cancel a Ride
4. View Ride History
5. View Drivers
6. Exit
Enter your choice: 4

Ride ID: 1
Passenger: deepika
Pickup: queens hostel
Destination: central
Distance: 32.0 km
Fare: Rs. 480.00
Status: Completed
Driver: Arun

=== Ride Sharing Platform ===
1. Book a Ride
2. Complete a Ride
3. Cancel a Ride
4. View Ride History
5. View Drivers
6. Exit
Enter your choice: 5

--- Driver List ---
ID: 101, Name: Arun, Status: Available
ID: 102, Name: Kumar, Status: Available
ID: 103, Name: Priya, Status: Available

=== Ride Sharing Platform ===
1. Book a Ride
2. Complete a Ride
3. Cancel a Ride
4. View Ride History
5. View Drivers
6. Exit
Enter your choice: 6
Thank you for using the platform!

