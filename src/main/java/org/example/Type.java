package org.example;

public enum Type {
    FRIDGE("Fridge"),
    AIR_CONDITIONER("Air Conditioner"),
    WASHER("Washer"),
    DRYER("Dryer"),
    FREEZER("Freezer"),
    STOVE("Stove"),
    DISHWASHER("Dishwasher"),
    WATER_HEATERS("Water Heaters"),
    MICROWAVE("Microwave");

    public final String label;
    Type(String label){
        this.label = label;
    }
    public String getLabel(){
        return this.label;
    }
}