// Bus Reservation module
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class busRes {
    public static void main(String[] args) throws ParseException {
        ArrayList<Bus> buses = new ArrayList<Bus>();
        ArrayList<Booking> bookings = new ArrayList<Booking>();

        // Adding bus objects to buses list
        buses.add(new Bus(1, true, 2));
        buses.add(new Bus(2, true, 50));
        buses.add(new Bus(3, true, 55));

        // Display bus information
        for (Bus b : buses) {
            b.displayBusInfo();
        }

        int userOpt = 1;
        Scanner s = new Scanner(System.in);

        while (userOpt == 1) {
            System.out.println("Enter 1 to book and 2 to exit");
            userOpt = s.nextInt();

            if (userOpt == 1) {
                Booking booking = new Booking();

                if (Booking.isAvailable(bookings, buses, booking.busNo, booking.date)) {
                    bookings.add(booking);
                    System.out.println("Your booking is confirmed");
                } else {
                    System.out.println("Sorry! Bus is full. Try another bus or date.");
                }
            }
        }
    }
}

// Bus module

class Bus {
    private int busNo;
    private boolean ac;
    private int capacity;

    // Constructor for Bus class
    public Bus(int busNo, boolean ac, int capacity) {
        this.busNo = busNo;
        this.ac = ac;
        this.capacity = capacity;
    }

    // Accessor and mutator methods for Bus class
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public boolean getAc() {
        return ac;
    }

    public void setAc(boolean ac) {
        this.ac = ac;
    }

    public void displayBusInfo() {
        System.out.println("Bus No: " + busNo + " AC: " + ac + " Total Capacity: " + capacity);
    }
}

// Booking Module
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Booking {
    String passengerName;
    int busNo;
    Date date;

    // Constructor to get details from the passenger
    public Booking() throws ParseException {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name of passenger : ");
        passengerName = s.next();
        System.out.println("Enter bus number : ");
        busNo = s.nextInt();
        System.out.println("Enter the date (dd-MM-yyyy) : ");
        String dateInput = s.next();

        // Convert String to Date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        date = dateFormat.parse(dateInput);
    }

    // Method to check availability
    public static boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses, int busNo, Date date) {
        int capacity = 0;

        // Find the bus and get its capacity
        for (Bus bus : buses) {
            if (bus.getBusNo() == busNo) {
                capacity = bus.getCapacity();
                break; // Once found, no need to continue the loop
            }
        }

        int booked = 0;

        // Count the bookings for the specific bus and date
        for (Booking b : bookings) {
            if (b.busNo == busNo && b.date.equals(date)) {
                booked++;
            }
        }

        // Check if available
        return booked < capacity;
    }
}
