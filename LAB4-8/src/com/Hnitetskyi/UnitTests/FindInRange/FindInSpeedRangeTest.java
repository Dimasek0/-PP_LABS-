package com.Hnitetskyi.UnitTests.FindInRange;

import com.Hnitetskyi.Cars.LargeCar;
import com.Hnitetskyi.Cars.MediumCar;
import com.Hnitetskyi.Cars.MiniCar;
import com.Hnitetskyi.Cars.SmallCar;
import com.Hnitetskyi.CarsList.TaxiPark;
import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;

import static org.junit.Assert.fail;

public class FindInSpeedRangeTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    private boolean checkSearchCommand() {
        String expected = "2) Car type: large; Car name: Test1; Price: 32500; Maximum speed (in km/hour): " +
                "155; Fuel spend (in L/100km): 5.4;\r\n3) Car type: mini; Car name: Test2; Price: 22500; " +
                "Maximum speed (in km/hour): 150; Fuel spend (in L/100km): 2.5;\r\n";

        TaxiPark park = new TaxiPark();
        park.addCar(new MediumCar(35000, 170, 4, "Test4"));
        park.addCar(new LargeCar(32500, 155, 5.4, "Test1"));
        park.addCar(new MiniCar(22500, 150, 2.5, "Test2"));
        park.addCar(new SmallCar(30000, 165, 3, "Test3"));

        park.findAllCarsInSpeedRange(150, 155);
        return outContent.toString().equals(expected);
    }

    @org.junit.Test
    public void testFindInRange() throws ParseException {
        if (!checkSearchCommand()) fail("The searching is not working correctly");
    }
}