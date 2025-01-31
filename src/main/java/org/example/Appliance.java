package org.example;
/**
 * The {@code Appliance} class represents an appliance with attributes such as type, brand,
 * serial number, and price. It includes methods for setting and retrieving appliance details
 * and tracking the number of created appliances.
 *
 * <p>Each appliance is assigned a unique serial number starting from 10,000,000, which increments
 * automatically for each new appliance instance.</p>
 *
 * @author Meet Boghani
 * @author NishithKumar Soni
 * @version 1.0
 */
public class Appliance{

    /** The type of the appliance (e.g., refrigerator, oven). */
    String type;
    /** The brand of the appliance (e.g., Samsung, LG). */
    String brand;
    /** The unique serial number of the appliance. */
    private long serialNumber;
    /** A static counter to generate unique serial numbers. */
    private static long serialCounter = 10000000;
    /** The price of the appliance. */
    private double price;
    /** A static counter to track the number of created appliances. */
    private static int counter=0;

    /**
     * Default constructor that initializes an appliance with empty type and brand,
     * a default price of $1, and assigns a unique serial number.
     */
    public Appliance(){
        type = "";
        brand = "";
        price = 1;
        serialNumber = serialCounter;
        serialCounter++;
        counter++;
    }

    /**
     * Parameterized constructor that initializes an appliance with the specified type, brand, and price.
     * If the provided price is less than or equal to 1, it is set to 1 by default.
     *
     * @param type  The type of the appliance.
     * @param brand The brand of the appliance.
     * @param price The price of the appliance.
     */
    public Appliance(String type, String brand, double price){
        this.type = type;
        this.brand = brand;
        if(price<=1) {
            price = 1;
        }
        this.price = price;
        serialNumber = serialCounter;
        serialCounter++;
        counter++;
    }

    /**
     * Copy constructor that creates a new appliance by copying the attributes
     * of another appliance, except for the serial number.
     *
     * @param a The appliance to copy.
     */
    public Appliance(Appliance a){
        this.type = a.type;
        this.price = a.price;
        this.brand = a.brand;
        serialNumber = serialCounter;
        serialCounter++;
    }

    /**
     * Gets the type of the appliance.
     *
     * @return The type of the appliance.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the appliance.
     *
     * @param type The new type of the appliance.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the brand of the appliance.
     *
     * @return The brand of the appliance.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the brand of the appliance.
     *
     * @param brand The new brand of the appliance.
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets the price of the appliance.
     *
     * @return The price of the appliance.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the unique serial number of the appliance.
     *
     * @return The serial number of the appliance.
     */
    public long getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the serial number of the appliance.
     *
     * @param serialNumber The new serial number.
     */
    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * Sets the price of the appliance.
     *
     * @param price The new price of the appliance.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns a string representation of the appliance, including its type, brand,
     * serial number, and price.
     *
     * @return A formatted string with appliance details.
     */
    @Override
    public String toString() {
        System.out.println("******************************");
        return "\t  Appliance Details\n" +
                "******************************\n\t" +
                "Type: " + type + "\n\t" +
                "Brand: " + brand + "\n\t" +
                "Serial Number: " + serialNumber +"\n\t" +
                "Price: " + price + "\n" +
                 "******************************\n";
    }

    /**
     * Returns the total number of appliances created.
     *
     * @return The count of created appliances.
     */
    public static int findNumberOfCreatedAppliances(){
        return counter;
    }

    /**
     * Compares this appliance with another appliance and checks if they are equal based
     * on their type, brand, and price.
     *
     * @param obj The appliance to compare with.
     */
    public void equals(Appliance obj){
        if(this.type.equals(obj.type) && this.price==obj.price && this.brand.equals(obj.brand)){
            System.out.println("Both the objects are equal.");
        }
        else{
            System.out.println("Different objects.");
        }
    }
}