
package com.mycompany.week05;

import java.time.LocalDateTime;

public class ValidationUtils {
    public static boolean isValidID(String id) {
        return id.matches("\\d{6}");
    }

    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z ]+");
    }

    public static boolean isValidPhone(String phone) {
        return phone.matches("\\d{12}");
    }

    public static boolean isValidRoomNumber(String room) {
        return room.matches("\\d{4}");
    }

    public static boolean isValidBookingDate(LocalDateTime bookingDate) {
        return bookingDate.isAfter(LocalDateTime.now());
    }

    public static boolean isValidPickupTime(LocalDateTime pickupTime, LocalDateTime bookingDate) {
        return pickupTime.isAfter(LocalDateTime.now()) && pickupTime.isBefore(bookingDate);
    }
}
