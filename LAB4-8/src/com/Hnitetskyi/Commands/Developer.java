package com.Hnitetskyi.Commands;

public class Developer {

    private Command printAllCars;
    private Command findAllCarsInRangeByUserChoice;
    private Command sortByUserChoice;
    private Command addCarFromKeyboard;
    private Command changeCarParams;
    private Command saveToFile;
    private Command loadFromFile;

    public Developer(Command findAllCarsInRangeByUserChoice, Command printAllCars, Command sortByUserChoice, Command addCarFromKeyboard,
                     Command changeCarParams, Command saveToFile, Command loadFromFile) {
        this.findAllCarsInRangeByUserChoice = findAllCarsInRangeByUserChoice;
        this.addCarFromKeyboard = addCarFromKeyboard;
        this.changeCarParams = changeCarParams;
        this.printAllCars = printAllCars;
        this.sortByUserChoice = sortByUserChoice;
        this.saveToFile = saveToFile;
        this.loadFromFile = loadFromFile;
    }

    public void printAllCarsDev() {
        printAllCars.execute();
    }

    public void findAllCarsInRangeByUserChoiceDev() {
        findAllCarsInRangeByUserChoice.execute();
    }

    public void sortByUserChoiceDev() {
        sortByUserChoice.execute();
    }

    public void addCarFromKeyboardDev() {
        addCarFromKeyboard.execute();
    }

    public void changeCarParamsDev() {
        changeCarParams.execute();
    }

    public void saveToFileDev() {
        saveToFile.execute();
    }

    public void loadFromFileDev() {
        loadFromFile.execute();
    }
}