package com.mycompany.week07;

import java.util.*;

public class FruitShopManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Fruit> fruits = new ArrayList<>();
    private static final Hashtable<String, List<OrderItem>> orders = new Hashtable<>();

    public static void run() {
        while (true) {
            System.out.println("\nFRUIT SHOP SYSTEM");
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
            System.out.print("Please choose 1-4: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> createFruit();
                case "2" -> viewOrders();
                case "3" -> shopping();
                case "4" -> {
                    System.out.println("THANK YOU! BYE!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void createFruit() {
        while (true) {
            try {
                System.out.print("Enter Fruit ID (int): ");
                int id = Integer.parseInt(scanner.nextLine().trim());

                System.out.print("Enter Fruit Name: ");
                String name = scanner.nextLine().trim();

                System.out.print("Enter Price ($): ");
                double price = Double.parseDouble(scanner.nextLine().trim());

                System.out.print("Enter Quantity: ");
                int quantity = Integer.parseInt(scanner.nextLine().trim());

                System.out.print("Enter Origin: ");
                String origin = scanner.nextLine().trim();

                fruits.add(new Fruit(id, name, price, quantity, origin));
                System.out.print("Do you want to continue (Y/N)? ");
                String answer = scanner.nextLine().trim();
                if (answer.equalsIgnoreCase("N")) break;
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
            }
        }

        System.out.println("\nList of available fruits:");
        printFruitList();
    }

    private static void shopping() {
        if (fruits.isEmpty()) {
            System.out.println("No fruits available.");
            return;
        }

        List<OrderItem> cart = new ArrayList<>();

        while (true) {
            System.out.println("\nList of Fruit:");
            printFruitList();

            System.out.print("Select item number: ");
            int itemIndex = Integer.parseInt(scanner.nextLine().trim()) - 1;

            if (itemIndex < 0 || itemIndex >= fruits.size()) {
                System.out.println("Invalid item.");
                continue;
            }

            Fruit selectedFruit = fruits.get(itemIndex);
            System.out.println("You selected: " + selectedFruit.getName());

            System.out.print("Please input quantity: ");
            int qty = Integer.parseInt(scanner.nextLine().trim());

            if (qty <= 0 || qty > selectedFruit.getQuantity()) {
                System.out.println("Invalid quantity. Available: " + selectedFruit.getQuantity());
                continue;
            }

            selectedFruit.setQuantity(selectedFruit.getQuantity() - qty);
            cart.add(new OrderItem(selectedFruit, qty));

            System.out.print("Do you want to order now (Y/N)? ");
            String orderNow = scanner.nextLine().trim();

            if (orderNow.equalsIgnoreCase("Y")) {
                System.out.println("\nYour Order:");
                double total = 0;
                int count = 1;
                for (OrderItem item : cart) {
                    double amount = item.getAmount();
                    System.out.printf("%d. %s | %d | %.2f$ | %.2f$\n",
                            count++, item.getFruit().getName(),
                            item.getQuantity(), item.getFruit().getPrice(), amount);
                    total += amount;
                }
                System.out.printf("Total: %.2f$\n", total);

                System.out.print("Input your name: ");
                String name = scanner.nextLine().trim();
                orders.put(name, cart);
                System.out.println("Order saved. Returning to main menu...");
                break;
            }
        }
    }

    private static void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders to display.");
            return;
        }

        for (String customer : orders.keySet()) {
            System.out.println("\nCustomer: " + customer);
            System.out.println("Product | Quantity | Price | Amount");
            double total = 0;
            int count = 1;
            for (OrderItem item : orders.get(customer)) {
                double amount = item.getAmount();
                System.out.printf("%d. %s | %d | %.2f$ | %.2f$\n",
                        count++, item.getFruit().getName(),
                        item.getQuantity(), item.getFruit().getPrice(), amount);
                total += amount;
            }
            System.out.printf("Total: %.2f$\n", total);
        }
    }

    private static void printFruitList() {
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        int i = 1;
        for (Fruit f : fruits) {
            if (f.getQuantity() > 0) {
                System.out.printf("%d. %s | %s | %.2f$\n", i++, f.getName(), f.getOrigin(), f.getPrice());
            }
        }
    }
}
