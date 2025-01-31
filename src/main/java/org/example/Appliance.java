package org.example;

public class Appliance{
    String type;
    String brand;
    private long serialNumber;
    private static long serialCounter = 10000000;
    private double price;
    private static int counter=0;

    public Appliance(){
        type = "";
        brand = "";
        price = 1;
        serialNumber = serialCounter;
        serialCounter++;
        counter++;
    }

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

    public Appliance(Appliance a){
        this.type = a.type;
        this.price = a.price;
        this.brand = a.brand;
        serialNumber = serialCounter;
        serialCounter++;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setPrice(double price) {
        this.price = price;
    }

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

    public static int findNumberOfCreatedAppliances(){
        return counter;
    }

    public void equals(Appliance obj){
        if(this.type.equals(obj.type) && this.price==obj.price && this.brand.equals(obj.brand)){
            System.out.println("Both the objects are equal.");
        }
        else{
            System.out.println("Different objects.");
        }
    }
}