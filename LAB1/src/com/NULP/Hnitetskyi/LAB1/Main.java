package com.NULP.Hnitetskyi.LAB1;

import com.NULP.Hnitetskyi.LAB1.CalculateArrays.CalculateArrays;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the minimum interval value: ");
        int firstElem = scanner.nextInt();
        System.out.println("Please, enter the maximum interval value: ");
        int lastElem = scanner.nextInt();
        System.out.println("Please, enter the number of elements in the fibonacci row: ");
        int fiboLen = scanner.nextInt();
        System.out.println();

        CalculateArrays arrays = new CalculateArrays(lastElem, firstElem, fiboLen);
        System.out.println("\n\nSum of odd elements: \n" + arrays.OddSum());
        System.out.println("Sum of even elements: \n" + arrays.EvenSum());
        System.out.println("\nFibonacci row: ");
        arrays.Fibonacci();

        System.out.println("\n\nPercentage of odd Fibonacci numbers: \n" + arrays.percents_odd() + "%");
        System.out.println("Percentage of even Fibonacci numbers: \n" + arrays.percents_even() + "%");
    }
}