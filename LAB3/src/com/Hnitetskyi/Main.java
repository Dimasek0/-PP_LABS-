package com.Hnitetskyi;

import com.Hnitetskyi.view.BattleDroid;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("\n\t\t\t   ----MENU----\n\t\t\t1. Start the Game" +
                "\n\t\t\t0. Exit");

        int buf;

        do {
            buf = in.nextInt();
            if (buf == 1) {
                new BattleDroid().start();
            }
        }
        while (buf != 0);
    }
}
