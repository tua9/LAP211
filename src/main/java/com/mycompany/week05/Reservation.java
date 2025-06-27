
package com.mycompany.week05;

import java.time.LocalDateTime;

public class Reservation {
    private String bookingID;
    private String customerName;
    private String phoneNumber;
    private int roomNumber;
    private LocalDateTime bookingDate;
    private FlightInformation flightInformation;

    public Reservation(String bookingID, String customerName, String phoneNumber, int roomNumber, LocalDateTime bookingDate, FlightInformation flightInformation) {
        this.bookingID = bookingID;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.roomNumber = roomNumber;
        this.bookingDate = bookingDate;
        this.flightInformation = flightInformation;
    }

    public Reservation() {
        this.bookingID = "";
        this.customerName = "";
        this.phoneNumber = "";
        this.roomNumber = 0;
        this.bookingDate = LocalDateTime.now();
        this.flightInformation = new FlightInformation();
    }

    // Getters and setters
    public String getBookingID() { return bookingID; }
    public void setBookingID(String bookingID) { this.bookingID = bookingID; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }

    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }

    public FlightInformation getFlightInformation() { return flightInformation; }
    public void setFlightInformation(FlightInformation flightInformation) { this.flightInformation = flightInformation; }
}

