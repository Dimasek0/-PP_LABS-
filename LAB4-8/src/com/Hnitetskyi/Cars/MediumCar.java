package com.Hnitetskyi.Cars;

public class MediumCar extends Car {

    public MediumCar() {
        super();
    }

    public MediumCar(int price, int maxSpeed, double fuelSpend, String name) {
        super(price, maxSpeed, fuelSpend, name);
    }

    @Override
    public String toString() {
        return "Car type: medium; " + "Car name: " + name + "; Price: " +
                price + "; Maximum speed (in km/hour): " + maxSpeed + "; " +
                "Fuel spend (in L/100km): " + fuelSpend + ";";
    }
}