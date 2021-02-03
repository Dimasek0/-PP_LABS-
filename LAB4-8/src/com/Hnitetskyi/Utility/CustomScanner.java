package com.Hnitetskyi.Utility;

import java.util.Scanner;
import java.util.logging.Logger;

public class CustomScanner {
    private static Logger log = Logger.getLogger(CustomScanner.class.getName());
    Scanner in = new Scanner(System.in);

    public int getInt() {
        int result;
        while (!in.hasNextInt()) {
            System.out.println("That is not a number!");
            in.next();
            log.warning("User did not enter integer correctly, re-enter\n");
        }
        result = in.nextInt();
        return result;
    }

    public double getDouble() {
        double result;
        while (!in.hasNextDouble()) {
            System.out.println("That is not a number!");
            in.next();
            log.warning("User did not enter double correctly, re-enter\n");
        }
        result = in.nextDouble();
        return result;
    }

    public void nextLine() {
        in.nextLine();
    }

    public String getString() {
        String str;
        str = in.nextLine();
        return str;
    }
}