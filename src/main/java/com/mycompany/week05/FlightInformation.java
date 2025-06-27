package com.mycompany.week05;


import java.time.LocalDateTime;

public class FlightInformation {
    private String flightNumber;
    private String seatNumber;
    private LocalDateTime timePickUp;

    public FlightInformation(String flightNumber, String seatNumber, LocalDateTime timePickUp) {
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.timePickUp = timePickUp;
    }

    public FlightInformation() {
        this.flightNumber = "";
        this.seatNumber = "";
        this.timePickUp = LocalDateTime.now();
    }

    // Getters and setters
    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public LocalDateTime getTimePickUp() { return timePickUp; }
    public void setTimePickUp(LocalDateTime timePickUp) { this.timePickUp = timePickUp; }
}

