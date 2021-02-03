package com.Hnitetskyi.Commands;

import com.Hnitetskyi.CarsList.TaxiPark;

public class FindAllCarsInRangeByUserChoice implements Command {
    private TaxiPark park;

    public FindAllCarsInRangeByUserChoice(TaxiPark park) {
        this.park = park;
    }

    @Override
    public void execute() {
        park.findAllCarsInRangeByUserChoice();
    }
}