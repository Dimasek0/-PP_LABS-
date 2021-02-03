package com.Hnitetskyi.Utility;

import com.Hnitetskyi.Commands.*;
import com.Hnitetskyi.CarsList.TaxiPark;

import java.util.logging.Logger;

public class Menu {
    private static Logger log = Logger.getLogger(CustomScanner.class.getName());
    private static final int numberOfCommands = 9;
    private CustomScanner in = new CustomScanner();
    TaxiPark taxiPark = new TaxiPark();
    Developer developer = new Developer(
            new FindAllCarsInRangeByUserChoice(taxiPark),
            new PrintAllCars(taxiPark),
            new SortByUserChoice(taxiPark),
            new AddCarFromKeyboard(taxiPark),
            new ChangeCarParams(taxiPark),
            new SaveToFile(taxiPark),
            new LoadFromFile(taxiPark));

    public void consoleMenu() {
        while (true) {
            System.out.println("Choose options\n1. Print all cars from park\n2. Add car from keyboard\n" +
                    "3. Sort all cars\n4. Find all cars in range\n5. Change parameters of cars\n6. Save " +
                    "program\n7. Load program\n8. Exit");
            int userOptions;
            do {
                userOptions = in.getInt();
            } while (userOptions < 1 || userOptions > numberOfCommands);
            if (userOptions == 1) {
                developer.printAllCarsDev();
            }
            if (userOptions == 2) {
                developer.addCarFromKeyboardDev();
            }
            if (userOptions == 3) {
                developer.sortByUserChoiceDev();
            }
            if (userOptions == 4) {
                developer.findAllCarsInRangeByUserChoiceDev();
            }
            if (userOptions == 5) {
                developer.changeCarParamsDev();
            }
            if (userOptions == 6) {
                developer.saveToFileDev();
            }
            if (userOptions == 7) {
                developer.loadFromFileDev();
            }
            if (userOptions == 8) {
                System.out.println("Exiting...");
                log.info("Exit the program");
                break;
            }
        }
    }
}