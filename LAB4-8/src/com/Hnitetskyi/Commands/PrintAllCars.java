package com.Hnitetskyi.Commands;

import com.Hnitetskyi.CarsList.TaxiPark;

public class PrintAllCars implements Command {
    private TaxiPark park;

    public PrintAllCars(TaxiPark park) {
        this.park = park;
    }

    @Override
    public void execute() {
        park.printAllCars();
    }
}