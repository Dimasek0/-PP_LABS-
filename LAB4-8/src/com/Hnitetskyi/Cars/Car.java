package com.Hnitetskyi.Cars;

import java.io.Serializable;

public class Car implements Serializable {
    protected String name = "base car";
    protected int price = 1000;
    protected int maxSpeed = 100;       //in km/h
    protected double fuelSpend = 2.5;   //in L/100km

    public Car() {

    }

    public Car(int price, int maxSpeed, double fuelSpend, String name) {
        this.price = price;
        this.maxSpeed = maxSpeed;
        this.fuelSpend = fuelSpend;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car type: default; " + "Car name: " + name + "; Price: " + price + "; " +
                "Maximum speed (in km/hour): " + maxSpeed + "; Fuel spend (in L/100km): " + fuelSpend + ";";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSpeed() {
        return maxSpeed;
    }

    public void setSpeed(int speed) {
        this.maxSpeed = speed;
    }

    public double getFuelSpend() {
        return fuelSpend;
    }

    public void setFuelSpend(double fuelSpend) {
        this.fuelSpend = fuelSpend;
    }
}
