import java.util.Scanner;

class Ride {
    String rideId;
    String passengerName;
    double distance;

    Ride(String rideId, String passengerName, double distance) {
        this.rideId = rideId;
        this.passengerName = passengerName;
        this.distance = distance;
    }

    double calculateFare() {
        return 0;
    }

    void display() {
        System.out.printf("%s %s %.2f%n",
                rideId, passengerName, calculateFare());
    }
}

class CarRide extends Ride {
    CarRide(String rideId, String passengerName, double distance) {
        super(rideId, passengerName, distance);
    }

    @Override
    double calculateFare() {
        return 50 + distance * 15;
    }
}

class BikeRide extends Ride {
    BikeRide(String rideId, String passengerName, double distance) {
        super(rideId, passengerName, distance);
    }

    @Override
    double calculateFare() {
        return 20 + distance * 8;
    }
}

class AutoRide extends Ride {
    AutoRide(String rideId, String passengerName, double distance) {
        super(rideId, passengerName, distance);
    }

    @Override
    double calculateFare() {
        return 30 + distance * 10;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int type = sc.nextInt();
            String rideId = sc.next();
            String passengerName = sc.next();
            double distance = sc.nextDouble();

            Ride ride;

            if (type == 1) {
                ride = new CarRide(rideId, passengerName, distance);
            } else if (type == 2) {
                ride = new BikeRide(rideId, passengerName, distance);
            } else {
                ride = new AutoRide(rideId, passengerName, distance);
            }

            ride.display();
        }

        sc.close();
    }
}
OUTPUT:
3
1 R101 Rahul 10
2 R102 Priya 5
3 R103 Arun 8

R101 Rahul 200.00
R102 Priya 60.00
R103 Arun 110.00
