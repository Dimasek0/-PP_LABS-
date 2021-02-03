package com.Hnitetskyi.Cars;

public class LargeCar extends Car {
    public LargeCar() {
        super();
    }

    public LargeCar(int price, int maxSpeed, double fuelSpend, String name) {
        super(price, maxSpeed, fuelSpend, name);
    }

    @Override
    public String toString() {
        return "Car type: large; " + "Car name: " + name + "; Price: " + price +
                "; Maximum speed (in km/hour): " + maxSpeed + "; Fuel spend (in L/100km): " + fuelSpend + ";";
    }
}