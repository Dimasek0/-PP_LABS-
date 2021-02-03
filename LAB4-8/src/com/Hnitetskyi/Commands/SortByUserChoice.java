package com.Hnitetskyi.Commands;

import com.Hnitetskyi.CarsList.TaxiPark;

public class SortByUserChoice implements Command {
    private TaxiPark park;

    public SortByUserChoice(TaxiPark park) {
        this.park = park;
    }

    @Override
    public void execute() {
        park.sortByUserChoice();
    }
}