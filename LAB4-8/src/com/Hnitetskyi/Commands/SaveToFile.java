package com.Hnitetskyi.Commands;

import com.Hnitetskyi.CarsList.TaxiPark;
import com.Hnitetskyi.Utility.CustomScanner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Logger;

public class SaveToFile implements Command {
    private static Logger log = Logger.getLogger(CustomScanner.class.getName());
    private TaxiPark park;

    public SaveToFile(TaxiPark park) {
        this.park = park;
    }

    public void saveObject(String fileName) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
            log.warning("Can't find file with name: " + fileName);
        }
        try {
            objectOutputStream.writeObject(park.getCars());
        } catch (IOException e) {
            e.printStackTrace();
            log.warning("Can't write data to file!");
        }
        try {
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("Successfully saved data to file");
    }

    @Override
    public void execute() {
        saveObject("park.ser");
    }
}