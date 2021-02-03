package com.Hnitetskyi.UnitTests.Sort;

import com.Hnitetskyi.Cars.LargeCar;
import com.Hnitetskyi.Cars.MediumCar;
import com.Hnitetskyi.Cars.MiniCar;
import com.Hnitetskyi.Cars.SmallCar;
import com.Hnitetskyi.CarsList.TaxiPark;

import static org.junit.Assert.*;

public class SortBySpeedTest {
    private boolean testSort() {
        TaxiPark expected = new TaxiPark();
        expected.addCar(new MiniCar(22500, 150, 2.5, "Test2"));
        expected.addCar(new LargeCar(32500, 155, 5.4, "Test1"));
        expected.addCar(new SmallCar(30000, 165, 3, "Test3"));
        expected.addCar(new MediumCar(35000, 170, 4, "Test4"));

        TaxiPark park = new TaxiPark();

        park.addCar(new MediumCar(35000, 170, 4, "Test4"));
        park.addCar(new LargeCar(32500, 155, 5.4, "Test1"));
        park.addCar(new MiniCar(22500, 150, 2.5, "Test2"));
        park.addCar(new SmallCar(30000, 165, 3, "Test3"));

        park.sortByMaxSpeed();
        return TaxiPark.isParksEqual(expected.getCars(), park.getCars());
    }

    @org.junit.Test
    public void testSortBySpeed() {
        if (!testSort()) fail("The sorting is not working correctly");
    }
}