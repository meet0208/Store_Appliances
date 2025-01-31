package org.example;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static int length = 0;
    static Scanner scanner = new Scanner(System.in);
    static int menu_count = 1;
    static int count = 0;
    static int top = -1;
    static Type type;

    public static int printMenu() {
        int option = 0;
        while (option < 1 || option > 5) {
            System.out.print("What do you want to do? \n\t" +
                    "1. Enter new appliances (password required) \n\t" +
                    "2. Change information of an appliance (password required) \n\t" +
                    "3. Display all appliances by a specific brand \n\t" +
                    "4. Display all appliances under a certain a price. \n\t" +
                    "5. Quit \n" +
                    "Please enter your choice > ");
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {

            }
            scanner.nextLine();
            if (option < 1 || option > 5) {
                System.out.println("Invalid input option. Please enter a number between 1 and 5..");
            }
        }
        return option;
    }

    private static String getValidType(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.equals(Type.AIR_CONDITIONER.getLabel()) ||
                    input.equals(Type.DISHWASHER.getLabel()) ||
                    input.equals(Type.DRYER.getLabel()) ||
                    input.equals(Type.FREEZER.getLabel()) ||
                    input.equals(Type.FRIDGE.getLabel()) ||
                    input.equals(Type.MICROWAVE.getLabel()) ||
                    input.equals(Type.STOVE.getLabel()) ||
                    input.equals(Type.WASHER.getLabel()) ||
                    input.equals(Type.WATER_HEATERS.getLabel())) {
                return input;
            } else {
                System.out.println("Invalid Type. Below are the valid Types:\n\t" + "1. Air Conditioner\n\t"
                        + "2. Dishwasher\n\t" + "3. Dryer\n\t" + "4. Freezer\n\t" + "5. Fridge\n\t" + "6. Microwave\n\t" + "7. Stove\n\t"
                        + "8. Washer\n\t" + "9. Water Heaters");
            }
        }
    }

    private static double getValidDouble(Scanner scanner, String prompt) {
        while (true) {
            double minValue = 1;
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                double value = Double.parseDouble(input);
                if (value >= minValue) {
                    return value;
                } else {
                    System.out.println("Invalid input. Value must be greater than or equal to " + minValue + ".");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static long getValidLong(Scanner scanner, String prompt) {
        while (true) {
            long minValue = 10000000;
            System.out.print(prompt);
            String input = scanner.next();
            scanner.nextLine();
            try {
                long value = Long.parseLong(input);
                if (value >= minValue) {
                    return value;
                } else {
                    System.out.println("Invalid input. Value must be greater than or equal to " + minValue + ".");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid serial number.");
            }
        }
    }

    public static int getValidInt(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int allowed = scanner.nextInt();
                scanner.nextLine();
                if (allowed >= 1) {
                    return allowed;
                } else {
                    System.out.print("Invalid input. Minimum value should be 1: ");
                }
            } else {
                System.out.print("Invalid input only integer is allowed. Enter an integer greater than 0: ");
                scanner.next();
            }
        }
    }

    public static void printSecondMenu() {
        System.out.print("What information would you like to change?\n\t" +
                "1. brand\n\t" +
                "2. type\n\t" +
                "3. price\n\t" +
                "4. Quit\n" +
                "Enter your choice > ");
    }

    public static void updateBySerialNumber(int index, Appliance[] arr) {
        int choice = 0, flag = 0;
        while ((choice < 1 || choice > 4) || flag == 0) {
            printSecondMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.print("Enter New Brand: ");
                String brand = scanner.nextLine();
                arr[index].setBrand(brand);
            } else if (choice == 2) {
                String type = getValidType(scanner, "Enter New Type: ");
                arr[index].setType(type);
            } else if (choice == 3) {
                System.out.print("Enter New Price: ");
                double price = scanner.nextDouble();
                scanner.nextLine();
                arr[index].setPrice(price);
            } else if (choice == 4) {
                flag = 1;
            }
        }
        System.out.println(arr[index]);
    }

    public static int binarySearch(int scanner, int e, long t, Appliance[] arr) {
        if (scanner > e) {
            return -1;
        }
        int m = scanner + (e - scanner) / 2;
        if (t == arr[m].getSerialNumber()) {
            return m;
        }
        if (t > arr[m].getSerialNumber()) {
            scanner = m + 1;
            return binarySearch(scanner, e, t, arr);
        } else if (t < arr[m].getSerialNumber()) {
            e = m - 1;
            return binarySearch(scanner, e, t, arr);
        } else {
            return -1;
        }
    }

    public static void recursiveCall(int option, Appliance[] inventory) {
        switch (option) {
            case 1:
                boolean flag = false;
                count = 0;
                while (count < 3) {
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    if (Authentication.passwordChecker(password)) {
                        count++;
                    } else {
                        count = 0;
                        menu_count = 1;
                        System.out.print("Enter number of appliance to add: ");
                        int allowed = getValidInt(scanner);
                        flag = true;
                        if (allowed > 0 && allowed <= inventory.length - 1 - top) {
                            length += allowed;
                            for (int i = 0; i < allowed; i++) {
                                System.out.println("Enter data for " + (top + 2) + " appliance");
                                String type = getValidType(scanner, "Enter appliance type: ");
                                System.out.print("Enter appliance brand: ");
                                String brand = scanner.nextLine();
                                double price = getValidDouble(scanner, "Enter appliance price: ");
                                inventory[++top] = new Appliance(type, brand, price);
                                }
                        } else {
                            System.out.println("Max remaining place allowed is: " + (inventory.length - 1 - top));
                        }
                        option = printMenu();
                        recursiveCall(option, inventory);
                    }
                }

                if (!flag) {
                    if (menu_count < 4) {
                        menu_count++;
                        option = printMenu();
                        recursiveCall(option, inventory);
                    } else if (menu_count == 4) {
                        System.out.println("\nProgram detected suspicious activities and will terminate immediately!");
                        System.exit(0);
                    }
                }
                break;

            case 2:
                int count = 0, flagg = 0;
                while (count < 3 && flagg == 0) {
                    System.out.print("Enter password: ");
                    String pass = scanner.nextLine();
                    if (!Authentication.passwordChecker(pass)) {
                        count++;
                    } else {
                        long sn = getValidLong(scanner, "Enter serial number of the appliance: ");
                        int index = binarySearch(0, length - 1, sn, inventory);
                        if (index != -1) {
                            System.out.println("Appliance Serial # " + inventory[index].getSerialNumber());
                            System.out.println("Brand: " + inventory[index].getBrand());
                            System.out.println("Type: " + inventory[index].getType());
                            System.out.println("Price: " + inventory[index].getPrice());
                            updateBySerialNumber(index, inventory);
                        } else {
                            System.out.println("Store is empty. First add some appliances and then search");
                        }
                        flagg = 1;
                    }
                }
                option = printMenu();
                recursiveCall(option, inventory);
                break;

            case 3:
                System.out.print("Enter the brand by which you want to search: ");
                String brand = scanner.nextLine();
                boolean type_flag = false;
                for (int i = 0; i < inventory.length; i++) {
                    if (inventory[i] != null) {
                        if (inventory[i].brand.equalsIgnoreCase(brand)) {
                            System.out.println(inventory[i]);
                            type_flag = true;
                        }
                    }
                }
                if (!type_flag) {
                    System.out.println("No appliances found.");
                }
                option = printMenu();
                recursiveCall(option, inventory);
                break;

            case 4:
                double price = getValidDouble(scanner, "Enter the price by which you want to search: ");
                boolean price_flag = false;
                for (int i = 0; i < length; i++) {
                    if (inventory[i].getPrice() < price) {
                        System.out.println(inventory[i]);
                        price_flag = true;
                    }
                }
                if (!price_flag) {
                    System.out.println("No appliances found.");
                }
                option = printMenu();
                recursiveCall(option, inventory);
                break;

            case 5:
                System.out.println("********* Thank you for choosing our Store. GoodBye *********");
                System.exit(0);
                scanner.close();
                break;
        }
    }

    public static void main(String[] args) {
        System.out.println("******* Welcome to Project_1 Store *******");
        System.out.print("Enter maximum number of appliances a store owner can have: ");
        int max_Size = getValidInt(scanner);
        Appliance[] inventory = new Appliance[max_Size];
        int option = printMenu();
        recursiveCall(option, inventory);
        System.out.println(Arrays.toString(inventory));
    }
}

// max_size should be minimum =1, need to check if negative or string is entered
// allowed to add should also be 1, , need to check if negative or string is entered