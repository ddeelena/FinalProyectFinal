package co.edu.cue.finalproyect.Model;

import java.util.Comparator;

public class Car {
    private String name;
    private String type;
    private String ubication;

    private double price;
    private double days;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDays() {
        return days;
    }

    public void setDays(double days) {
        this.days = days;
    }

    public Car(String name, String type, String ubication, double price, double days) {
        this.name = name;
        this.type = type;
        this.ubication = ubication;
        this.price = price;
        this.days = days;
    }


}
