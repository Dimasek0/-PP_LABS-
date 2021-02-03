package com.Hnitetskyi.UnitTests.LoadAndSave;

import com.Hnitetskyi.Cars.LargeCar;
import com.Hnitetskyi.Cars.MediumCar;
import com.Hnitetskyi.Cars.MiniCar;
import com.Hnitetskyi.Cars.SmallCar;
import com.Hnitetskyi.CarsList.TaxiPark;
import com.Hnitetskyi.Commands.LoadFromFile;
import com.Hnitetskyi.Commands.SaveToFile;

import static org.junit.Assert.fail;

public class SaveCarsTest {
    private boolean testLoad() {
        TaxiPark expected = new TaxiPark();
        TaxiPark park = new TaxiPark();
        SaveToFile save = new SaveToFile(expected);
        LoadFromFile load = new LoadFromFile(park);

        expected.addCar(new MiniCar(22500, 150, 2.5, "Test2"));
        expected.addCar(new SmallCar(30000, 165, 3, "Test3"));
        expected.addCar(new LargeCar(32500, 155, 5.4, "Test1"));
        expected.addCar(new MediumCar(35000, 170, 4, "Test4"));

        save.saveObject("parktestoutput.ser");
        load.loadObject(park, "parktestoutput.ser");
        return TaxiPark.isParksEqual(expected.getCars(), park.getCars());
    }

    @org.junit.Test
    public void testSaveCars() {
        if (!testLoad()) fail("The saving is not working correctly");
    }
}