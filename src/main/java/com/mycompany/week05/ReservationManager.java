
package com.mycompany.week05;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ReservationManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Reservation> reservations = new ArrayList<>();
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void run() {
        while (true) {
            System.out.println("\n*** Reservation Management ***");
            System.out.println("1. Create new reservation");
            System.out.println("2. Update reservation");
            System.out.println("3. Delete reservation");
            System.out.println("4. Print Flight Information");
            System.out.println("5. Print all");
            System.out.println("6. Exit");
            System.out.print("You choose: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> createReservation();
                case "2" -> updateReservation();
                case "3" -> deleteReservation();
                case "4" -> printFlightInformation();
                case "5" -> printAllReservations();
                case "6" -> {
                    System.out.println("BYE AND SEE YOU NEXT TIME");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void createReservation() {
        System.out.println("\n*** Create new reservation ***");

        String id;
        while (true) {
            System.out.print("ID: ");
            id = scanner.nextLine().trim();
            if (!ValidationUtils.isValidID(id) || idExists(id)) {
                System.out.println("Data input is invalid");
            } else break;
        }

        String name;
        while (true) {
            System.out.print("Name: ");
            name = scanner.nextLine().trim();
            if (!ValidationUtils.isValidName(name)) {
                System.out.println("Data input is invalid");
            } else break;
        }

        String phone;
        while (true) {
            System.out.print("Phone: ");
            phone = scanner.nextLine().trim();
            if (!ValidationUtils.isValidPhone(phone)) {
                System.out.println("Data input is invalid");
            } else break;
        }

        int room;
        while (true) {
            System.out.print("RoomNumbers: ");
            String roomInput = scanner.nextLine().trim();
            if (!ValidationUtils.isValidRoomNumber(roomInput)) {
                System.out.println("Data input is invalid");
            } else {
                room = Integer.parseInt(roomInput);
                break;
            }
        }

        LocalDateTime bookingDate;
        while (true) {
            try {
                System.out.print("BookingDate (dd/MM/yyyy HH:mm): ");
                bookingDate = LocalDateTime.parse(scanner.nextLine().trim(), dtf);
                if (!ValidationUtils.isValidBookingDate(bookingDate)) throw new Exception();
                break;
            } catch (Exception e) {
                System.out.println("Data input is invalid");
            }
        }

        FlightInformation flightInfo = new FlightInformation();
        System.out.print("Need airport pick up? (Y/N): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("Y")) {
            System.out.print("Flight: ");
            String flight = scanner.nextLine().trim();
            System.out.print("Seat: ");
            String seat = scanner.nextLine().trim();
            LocalDateTime pickupTime;
            while (true) {
                try {
                    System.out.print("TimePickUp (dd/MM/yyyy HH:mm): ");
                    pickupTime = LocalDateTime.parse(scanner.nextLine().trim(), dtf);
                    if (!ValidationUtils.isValidPickupTime(pickupTime, bookingDate)) throw new Exception();
                    break;
                } catch (Exception e) {
                    System.out.println("Data input is invalid");
                }
            }
            flightInfo = new FlightInformation(flight, seat, pickupTime);
        }

        reservations.add(new Reservation(id, name, phone, room, bookingDate, flightInfo));
        System.out.println("Information saved successfully.");
    }

    private static void updateReservation() {
        System.out.println("\n*** Update reservation ***");
        Reservation res = findReservation();
        if (res == null) return;

        System.out.println("If you do not want to change the information, just press enter to skip.");

        System.out.print("Name: ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty() && ValidationUtils.isValidName(name)) res.setCustomerName(name);

        System.out.print("Phone: ");
        String phone = scanner.nextLine().trim();
        if (!phone.isEmpty() && ValidationUtils.isValidPhone(phone)) res.setPhoneNumber(phone);

        System.out.print("RoomNumbers: ");
        String roomInput = scanner.nextLine().trim();
        if (!roomInput.isEmpty() && ValidationUtils.isValidRoomNumber(roomInput)) {
            res.setRoomNumber(Integer.parseInt(roomInput));
        }

        System.out.print("BookingDate (dd/MM/yyyy HH:mm): ");
        String dateInput = scanner.nextLine().trim();
        if (!dateInput.isEmpty()) {
            try {
                LocalDateTime date = LocalDateTime.parse(dateInput, dtf);
                if (ValidationUtils.isValidBookingDate(date)) res.setBookingDate(date);
            } catch (Exception ignored) {}
        }

        System.out.print("Need airport pick up? (Y/N): ");
        String pickupAns = scanner.nextLine().trim();
        if (pickupAns.equalsIgnoreCase("Y")) {
            FlightInformation f = new FlightInformation();
            System.out.print("Flight: ");
            f.setFlightNumber(scanner.nextLine().trim());
            System.out.print("Seat: ");
            f.setSeatNumber(scanner.nextLine().trim());
            while (true) {
                try {
                    System.out.print("TimePickUp (dd/MM/yyyy HH:mm): ");
                    LocalDateTime tp = LocalDateTime.parse(scanner.nextLine().trim(), dtf);
                    if (!ValidationUtils.isValidPickupTime(tp, res.getBookingDate())) throw new Exception();
                    f.setTimePickUp(tp);
                    break;
                } catch (Exception e) {
                    System.out.println("Data input is invalid");
                }
            }
            res.setFlightInformation(f);
        }

        System.out.println("Information saved successfully.");
    }

    private static void deleteReservation() {
        System.out.println("\n*** Delete reservation ***");
        Reservation res = findReservation();
        if (res == null) return;

        printReservation(res);
        System.out.print("Are you sure you want to delete this information? (Y/N): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("Y")) {
            reservations.remove(res);
            System.out.println("Information deleted successfully.");
        }
    }

    private static void printFlightInformation() {
        System.out.println("\n*** Flight Information ***");
        System.out.println("ID - Name - Phone - Flight - Seat - TimePickUp");
        reservations.stream()
                .filter(r -> !r.getFlightInformation().getFlightNumber().isEmpty())
                .sorted(Comparator.comparing(r -> r.getFlightInformation().getTimePickUp()))
                .forEach(r -> System.out.printf("%s - %s - %s - %s - %s - %s%n",
                        r.getBookingID(), r.getCustomerName(), r.getPhoneNumber(),
                        r.getFlightInformation().getFlightNumber(),
                        r.getFlightInformation().getSeatNumber(),
                        dtf.format(r.getFlightInformation().getTimePickUp())));
    }

    private static void printAllReservations() {
        System.out.println("\n*** Reservation Information ***");
        if (reservations.isEmpty()) {
            System.out.println("No information to view");
            return;
        }

        System.out.println("ID - Name - Phone - RoomNumbers - BookingDate - Flight - Seat - TimePickUp");
        for (Reservation r : reservations) {
            System.out.printf("%s - %s - %s - %d - %s - %s - %s - %s%n",
                    r.getBookingID(), r.getCustomerName(), r.getPhoneNumber(),
                    r.getRoomNumber(), dtf.format(r.getBookingDate()),
                    r.getFlightInformation().getFlightNumber(),
                    r.getFlightInformation().getSeatNumber(),
                    r.getFlightInformation().getTimePickUp() == null ? "" :
                            dtf.format(r.getFlightInformation().getTimePickUp()));
        }
    }

    private static Reservation findReservation() {
        while (true) {
            System.out.print("ID: ");
            String id = scanner.nextLine().trim();
            for (Reservation r : reservations) {
                if (r.getBookingID().equals(id)) return r;
            }
            System.out.println("No information found");
            System.out.print("You want to find again? (Y/N): ");
            if (!scanner.nextLine().trim().equalsIgnoreCase("Y")) return null;
        }
    }

    private static void printReservation(Reservation r) {
        System.out.printf("%s - %s - %s - %d - %s - %s - %s - %s%n",
                r.getBookingID(), r.getCustomerName(), r.getPhoneNumber(),
                r.getRoomNumber(), dtf.format(r.getBookingDate()),
                r.getFlightInformation().getFlightNumber(),
                r.getFlightInformation().getSeatNumber(),
                dtf.format(r.getFlightInformation().getTimePickUp()));
    }

    private static boolean idExists(String id) {
        return reservations.stream().anyMatch(r -> r.getBookingID().equals(id));
    }
}
