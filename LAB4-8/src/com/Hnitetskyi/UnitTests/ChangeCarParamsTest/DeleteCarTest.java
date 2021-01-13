package com.Hnitetskyi.UnitTests.ChangeCarParamsTest;

import com.Hnitetskyi.Cars.LargeCar;
import com.Hnitetskyi.Cars.MediumCar;
import com.Hnitetskyi.Cars.MiniCar;
import com.Hnitetskyi.Cars.SmallCar;
import com.Hnitetskyi.CarsList.TaxiPark;

import static org.junit.Assert.fail;

public class DeleteCarTest {
    private boolean testDelete() {
        TaxiPark expected = new TaxiPark();
        expected.addCar(new MiniCar(22500, 150, 2.5, "Test2"));
        expected.addCar(new SmallCar(30000, 165, 3, "Test3"));
        expected.addCar(new MediumCar(35000, 170, 4, "Test4"));

        TaxiPark park = new TaxiPark();

        park.addCar(new MiniCar(22500, 150, 2.5, "Test2"));
        park.addCar(new SmallCar(30000, 165, 3, "Test3"));
        park.addCar(new MediumCar(35000, 170, 4, "Test4"));
        park.addCar(new LargeCar(32500, 155, 5.4, "Test1"));

        park.removeCar(3);
        return TaxiPark.isParksEqual(expected.getCars(), park.getCars());
    }

    @org.junit.Test
    public void testDeleteCar() {
        if (!testDelete()) fail("The deleting is not working correctly");
    }
}