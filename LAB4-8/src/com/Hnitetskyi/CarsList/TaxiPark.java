package com.Hnitetskyi.CarsList;

import com.Hnitetskyi.Cars.*;
import com.Hnitetskyi.Utility.CustomScanner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Logger;

public class TaxiPark implements Serializable {
    private static Logger log = Logger.getLogger(CustomScanner.class.getName());
    private int priceOfPark = 0;
    private ArrayList<Car> Cars = new ArrayList<>();
    CustomScanner in = new CustomScanner();

    public ArrayList<Car> getCars() {
        return this.Cars;
    }

    public void setCars(ArrayList<Car> cars) {
        Cars = cars;
    }

    public void addCar(Car Car) {
        Cars.add(Car);
        priceOfPark += Car.getPrice();
        log.info("New car added successfully");
    }

    public void removeCar(int index) {
        priceOfPark -= Cars.get(index).getPrice();
        Cars.remove(index);
        log.info("Car number " + index + " removed successfully");
    }

    public void printAllCars() {
        int sizeOfPark = Cars.size();
        System.out.println("All cars in the park: ");
        if (sizeOfPark > 0) {
            for (int i = 0; i < sizeOfPark; i++) {
                System.out.println(i + 1 + ") " + Cars.get(i).toString());
            }
            System.out.println("Price of the park: " + priceOfPark);
            log.info("Printed all cars from the park");
        } else System.out.println("There is no cars in the park");
        log.info("Trying to print all cars, but not one of them was created");
    }

    private void changeCarParamsOptions(int carChoice) {
        int userChoice;
        while (true) {
            System.out.println("What do you want to do with this car?\n1. Delete car\n2. Change price of car\n" +
                    "3. Change fuel spend of car\n4. Change max speed of car\n5. Change name of car\n6. Back");
            do {
                userChoice = in.getInt();
            } while (userChoice < 1 || userChoice > 6);
            if (userChoice == 1) {
                removeCar(carChoice);
                break;
            } else if (userChoice == 2) {
                System.out.print("Enter new price of car: ");
                changeCarPrice(carChoice, in.getInt());
            } else if (userChoice == 3) {
                System.out.print("Enter new fuel spend of car: ");
                changeCarFuelSpend(carChoice, in.getDouble());
            } else if (userChoice == 4) {
                System.out.print("Enter new max speed of car: ");
                changeCarSpeed(carChoice, in.getInt());
            } else if (userChoice == 5) {
                in.nextLine();
                System.out.println("Enter new name of car: ");
                changeCarName(carChoice, in.getString());
            } else if (userChoice == 6) {
                break;
            }
        }
    }

    public void changeCarPrice(int carIndex, int newPrice) {
        priceOfPark -= Cars.get(carIndex).getPrice();
        Cars.get(carIndex).setPrice(newPrice);
        priceOfPark += newPrice;
        log.info("Car number " + carIndex + " changed the price to " + newPrice);
    }

    public void changeCarSpeed(int carIndex, int newSpeed) {
        Cars.get(carIndex).setSpeed(newSpeed);
        log.info("Car number " + carIndex + " changed the speed to " + newSpeed);
    }

    public void changeCarFuelSpend(int carIndex, double newFuelSpend) {
        Cars.get(carIndex).setFuelSpend(newFuelSpend);
        log.info("Car number " + carIndex + " changed the fuel spend to " + newFuelSpend);
    }

    public void changeCarName(int carIndex, String newName) {
        Cars.get(carIndex).setName(newName);
        log.info("Car number " + carIndex + " changed the name to " + newName);
    }

    public void changeCarParams() {
        int carChoice;

        System.out.println("List of all cars: ");
        if (Cars.size() > 0) {
            for (int i = 0; i < Cars.size(); i++) {
                System.out.println(i + 1 + ") " + Cars.get(i).toString());
            }
            System.out.println("Please, select number of car to interact with: ");
            do {
                carChoice = in.getInt();
            } while (carChoice < 1 || carChoice > Cars.size());
            changeCarParamsOptions(carChoice - 1);
            log.info("User selected car number " + carChoice + " to change its parameters");
        } else {
            System.out.println("There is no cars in the park!");
            log.info("Trying to change car parameters, but not one of them was created");
        }
    }

    public void addCarFromKeyboard() {
        int userChoice;
        int maxSpeed;
        int price;
        String name;
        double fuelSpend;
        System.out.println("Choose type of car:\n1. Mini car\n2. Small car\n3. Medium car\n4. Large car");
        do {
            userChoice = in.getInt();
        } while (userChoice < 1 || userChoice > 4);
        in.nextLine();
        System.out.print("Enter name of car: ");
        name = in.getString();
        System.out.print("Enter max speed of car: ");
        maxSpeed = in.getInt();
        System.out.print("Enter fuel spend: ");
        fuelSpend = in.getDouble();
        System.out.print("Enter price: ");
        price = in.getInt();
        if (userChoice == 1) {
            addCar(new MiniCar(price, maxSpeed, fuelSpend, name));
        } else if (userChoice == 2) {
            addCar(new SmallCar(price, maxSpeed, fuelSpend, name));
        } else if (userChoice == 3) {
            addCar(new MediumCar(price, maxSpeed, fuelSpend, name));
        } else if (userChoice == 4) {
            addCar(new LargeCar(price, maxSpeed, fuelSpend, name));
        }
        log.info("Created new car with parameters: price - " + price +
                "; Max speed - " + maxSpeed + "; Fuel spend - " + fuelSpend + "; Name - " + name);
    }

    public void sortByUserChoice() {
        int userChoice;
        System.out.println("1. Sort cars by fuel spend\n2.Sort cars by max speed\n3. Sort cars by price\n4. Back");
        do {
            userChoice = in.getInt();
        } while (userChoice < 1 || userChoice > 4);
        if (userChoice == 1) {
            sortByFuelSpend();
        } else if (userChoice == 2) {
            sortByMaxSpeed();
        } else if (userChoice == 3) {
            sortByPrice();
        }
    }

    public void findAllCarsInRangeByUserChoice() {
        int userChoice;
        System.out.println("1. Print all cars in fuel spend range\n2. " +
                "Print all cars in max speed range\n3. Print all cars in price range\n4. Back");
        do {
            userChoice = in.getInt();
        } while (userChoice < 1 || userChoice > 4);
        if (userChoice == 1) {
            findAllCarsInFuelSpendRangeByKeyboard();
        } else if (userChoice == 2) {
            findAllCarsInSpeedRangeByKeyboard();
        } else if (userChoice == 3) {
            findAllCarsInPriceRangeByKeyboard();
        }
    }

    public void sortByFuelSpend() {
        Cars.sort(Comparator.comparing(Car::getFuelSpend));
        log.info("Successfully sorted all cars by fuel spend");
    }

    public void sortByMaxSpeed() {
        Cars.sort(Comparator.comparing(Car::getSpeed));
        log.info("Successfully sorted all cars by max speed");
    }

    public void sortByPrice() {
        Cars.sort(Comparator.comparing(Car::getPrice));
        log.info("Successfully sorted all cars by price");
    }

    public void findAllCarsInSpeedRange(int firstSpeed, int secondSpeed) {
        if (firstSpeed > secondSpeed) {
            int firstSpeedTemp = firstSpeed;
            firstSpeed = secondSpeed;
            secondSpeed = firstSpeedTemp;
        }

        for (int i = 0; i < Cars.size(); i++) {
            int carSpeed = Cars.get(i).getSpeed();
            if (carSpeed >= firstSpeed && carSpeed <= secondSpeed) {
                System.out.println(i + 1 + ") " + Cars.get(i).toString());
            }
        }
        log.info("Successfully found all cars in the speed range");
    }

    public void findAllCarsInPriceRange(int firstPrice, int secondPrice) {
        if (firstPrice > secondPrice) {
            int firstPriceTemp = firstPrice;
            firstPrice = secondPrice;
            secondPrice = firstPriceTemp;
        }

        for (int i = 0; i < Cars.size(); i++) {
            int carPrice = Cars.get(i).getPrice();
            if (carPrice >= firstPrice && carPrice <= secondPrice) {
                System.out.println(i + 1 + ") " + Cars.get(i).toString());
            }
        }
        log.info("Successfully found all cars in the price range");
    }

    public void findAllCarsInFuelSpendRange(double firstFuelSpend, double secondFuelSpend) {
        if (firstFuelSpend > secondFuelSpend) {
            double firstFuelSpendTemp = firstFuelSpend;
            firstFuelSpend = secondFuelSpend;
            secondFuelSpend = firstFuelSpendTemp;
        }

        for (int i = 0; i < Cars.size(); i++) {
            double carFuelSpend = Cars.get(i).getFuelSpend();
            if (carFuelSpend >= firstFuelSpend && carFuelSpend <= secondFuelSpend) {
                System.out.println(i + 1 + ") " + Cars.get(i).toString());
            }
        }
        log.info("Successfully found all cars in the fuel spend range");
    }

    public void findAllCarsInSpeedRangeByKeyboard() {
        int firstSpeed;
        int secondSpeed;
        System.out.print("Search cars by speed.\nEnter first maximum speed (in km/h): ");
        firstSpeed = in.getInt();
        System.out.print("Enter second maximum speed (in km/h): ");
        secondSpeed = in.getInt();
        findAllCarsInSpeedRange(firstSpeed, secondSpeed);

    }

    public void findAllCarsInPriceRangeByKeyboard() {
        int firstPrice;
        int secondPrice;
        System.out.print("Search cars by price.\nEnter first price: ");
        firstPrice = in.getInt();
        System.out.print("Enter second price: ");
        secondPrice = in.getInt();
        findAllCarsInPriceRange(firstPrice, secondPrice);
    }

    public void findAllCarsInFuelSpendRangeByKeyboard() {
        double firstFuelSpend;
        double secondFuelSpend;
        System.out.print("Search cars by speed.\nEnter first maximum speed (in km/h): ");
        firstFuelSpend = in.getDouble();
        System.out.print("Enter second maximum speed (in km/h): ");
        secondFuelSpend = in.getDouble();
        findAllCarsInFuelSpendRange(firstFuelSpend, secondFuelSpend);
    }

    public static boolean isParksEqual(ArrayList<?> arr1, ArrayList<?> arr2) {
        if (arr1.size() != arr2.size()) return false;
        boolean res = true;
        for (int i = 0; i < arr1.size(); i++)
            if (!arr1.get(i).toString().equals(arr2.get(i).toString())) {
                res = false;
                break;
            }
        return res;
    }
}