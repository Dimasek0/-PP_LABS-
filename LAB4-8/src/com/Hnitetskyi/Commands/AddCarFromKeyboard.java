package com.Hnitetskyi.Commands;

import com.Hnitetskyi.CarsList.TaxiPark;

public class AddCarFromKeyboard implements Command {
    private TaxiPark park;

    public AddCarFromKeyboard(TaxiPark park) {
        this.park = park;
    }

    @Override
    public void execute() {
        park.addCarFromKeyboard();
    }
}