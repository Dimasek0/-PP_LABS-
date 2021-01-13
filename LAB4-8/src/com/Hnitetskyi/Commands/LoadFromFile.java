package com.Hnitetskyi.Commands;

import com.Hnitetskyi.Cars.Car;
import com.Hnitetskyi.CarsList.TaxiPark;
import com.Hnitetskyi.Utility.CustomScanner;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;

public class LoadFromFile implements Command {
    private TaxiPark park;

    public LoadFromFile(TaxiPark park) {
        this.park = park;
    }

    private static Logger log = Logger.getLogger(CustomScanner.class.getName());

    public void loadObject(Object obj, String fileName) {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(
                    new FileInputStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            log.warning("Can't find file with name: " + fileName);
        }
        try {
            if (objectInputStream != null) {
                park.setCars((ArrayList<Car>) objectInputStream.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (objectInputStream != null) {
                objectInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("Successfully loaded data from file");
    }

    @Override
    public void execute() {
        loadObject(park, "park.ser");
    }
}