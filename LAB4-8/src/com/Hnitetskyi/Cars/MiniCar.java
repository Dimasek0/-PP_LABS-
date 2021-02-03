package com.Hnitetskyi.Cars;


public class MiniCar extends Car {

    public MiniCar() {
        super();
    }

    public MiniCar(int price, int maxSpeed, double fuelSpend, String name) {
        super(price, maxSpeed, fuelSpend, name);
    }

    @Override
    public String toString() {
        return "Car type: mini; " + "Car name: " + name + "; Price: "
                + price + "; Maximum speed (in km/hour): " + maxSpeed + "; Fuel spend (in L/100km): " + fuelSpend + ";";
    }
}