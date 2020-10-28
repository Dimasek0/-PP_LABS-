package com.NULP.Hnitetskyi.LAB1.CalculateArrays;

public class CalculateArrays {
    private final int fibonacciLength;
    private final int lastElement;
    private final int firstElement;
    private int sum_even;
    private int sum_odd;
    private int max_even;
    private int max_odd;
    private int count_of_odd = 0;
    private int count_of_even = 0;
    private int[] array_fibo;

    public CalculateArrays(int firstElement, int lastElement, int fibonacciLength) {
        this.firstElement = firstElement;
        this.lastElement = lastElement;
        this.fibonacciLength = fibonacciLength;
        array_fibo = new int[fibonacciLength];

        outputOddEven();
    }

    private void outputOddEven() {
        int odd = lastElement;
        int even = firstElement;

        if (odd % 2 == 0) {
            odd++;
        }
        System.out.println("Odd numbers in descending order: ");
        for (int i = odd; i <= firstElement; i += 2) {
            System.out.print(i + " ");
            sum_odd += i;
        }
        if (even % 2 == 1) {
            even--;
        }
        max_even = even;
        if (firstElement % 2 == 1) {
            max_odd = firstElement;
        } else {
            max_odd = firstElement - 1;
        }
        System.out.println("\nEven numbers in ascending order: ");
        for (int i = even; i >= lastElement; i -= 2) {
            System.out.print(i + " ");
            sum_even += i;
        }
    }

    public int EvenSum() {
        return sum_even;
    }

    public int OddSum() {
        return sum_odd;
    }

    public void Fibonacci() {
        int firstFiboElement = max_odd;
        int secondFiboElement = max_even;
        array_fibo[0] = firstFiboElement;
        array_fibo[1] = secondFiboElement;
        int index = 2;
        int fiboElement;

        System.out.print(firstFiboElement + " " + secondFiboElement + " ");
        for (int i = 0; i < fibonacciLength - 2; i++) {
            fiboElement = firstFiboElement + secondFiboElement;

            array_fibo[index] = fiboElement;
            index++;

            System.out.print(fiboElement + " ");
            firstFiboElement = secondFiboElement;
            secondFiboElement = fiboElement;
        }
    }

    public double percents_odd() {
        for (int i = 0; i < fibonacciLength; i++) {
            if (array_fibo[i] % 2 == 1) {
                count_of_odd++;
            }
        }
        return ((double) count_of_odd / (double) (fibonacciLength)) * 100.0;
    }

    public double percents_even() {
        for (int i = 0; i < fibonacciLength; i++) {
            if (array_fibo[i] % 2 == 0) {
                count_of_even++;
            }
        }
        return ((double) count_of_even / (double) (fibonacciLength)) * 100.0;
    }
}