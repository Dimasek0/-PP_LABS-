package com.Hnitetskyi.Commands;

import com.Hnitetskyi.CarsList.TaxiPark;

public class ChangeCarParams implements Command {
    private TaxiPark park;

    public ChangeCarParams(TaxiPark park) {
        this.park = park;
    }

    @Override
    public void execute() {
        park.changeCarParams();
    }
}