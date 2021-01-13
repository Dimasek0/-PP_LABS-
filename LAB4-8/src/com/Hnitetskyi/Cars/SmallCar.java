package com.Hnitetskyi.Cars;

public class SmallCar extends Car {
    public SmallCar() {
        super();
    }

    public SmallCar(int price, int maxSpeed, double fuelSpend, String name) {
        super(price, maxSpeed, fuelSpend, name);
    }

    @Override
    public String toString() {
        return "Car type: small; " + "Car name: " + name +
                "; Price: " + price + "; Maximum speed (in km/hour): "
                + maxSpeed + "; Fuel spend (in L/100km): " + fuelSpend + ";";
    }
}