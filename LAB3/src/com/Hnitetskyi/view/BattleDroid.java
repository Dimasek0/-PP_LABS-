package com.Hnitetskyi.view;

import com.Hnitetskyi.arena.SoloBattle;
import com.Hnitetskyi.arena.TeamFight;
import com.Hnitetskyi.droids.ArmorDroid;
import com.Hnitetskyi.droids.Droid;
import com.Hnitetskyi.droids.DroidHealer;

import java.util.Scanner;

public class BattleDroid {
    public void start() {
        Scanner in = new Scanner(System.in);
        System.out.println("\n\t\t  ----Game Mode----\n\t\t\t1. 1 vs 1" +
                "\n\t\t\t2. Team Fight");

        int buf;

        buf = in.nextInt();
        if (buf == 1) {
            Droid firstDr = choose();
            Droid secondDr = choose();
            SoloBattle l = new SoloBattle(firstDr, secondDr);
            l.fight();
        }
        if (buf == 2) {
            Droid[] team1;
            Droid[] team2;
            team1 = new Droid[3];
            team2 = new Droid[3];

            System.out.println("\n\t\t\t--Team 1--");
            for (int i = 0; i < 3; i++) {
                team1[i] = choose();
            }

            System.out.println("\n\t\t\t--Team 2--");
            for (int i = 0; i < 3; i++) {
                team2[i] = choose();
            }
            TeamFight m = new TeamFight(team1, team2, 3);
            m.fight();
        }
    }

    Droid choose() {
        /*кольори нарощюють 2 до шансу крит удару*/
        Droid blackDr = new Droid("Black", 150, 10, 20, 220,
                "color");
        Droid whiteDr = new Droid("White", 133, 16, 50, 20,
                "color");

        /*стихії нарощюють дмг з кожним ударом на 2*/
        Droid earthDr = new Droid("Earth", 200, 5, 60, 200,
                "elemental");
        Droid fireDr = new Droid("Fire", 94, 20, 5, 888,
                "elemental");

        /*extend droids*/
        Droid heavyDr = new ArmorDroid("Tank", 100, 8, 15, 20,
                "elemental", 50);
        Droid healerDr = new DroidHealer("Healer", 100, 15, 10, 150,
                "color", 5);

        System.out.println("\tChoose the Droid from list:\n1. " + blackDr.toString() +
                "\n2. " + whiteDr.toString() +
                "\n3. " + earthDr.toString() +
                "\n4. " + fireDr.toString() +
                "\n5. " + healerDr.toString() +
                "\n6. " + heavyDr.toString() + "\n0. Exit");

        Scanner in = new Scanner(System.in);
        int buf;
        buf = in.nextInt();

        if (buf == 1) {
            return blackDr;
        } else if (buf == 2) {
            return whiteDr;
        } else if (buf == 3) {
            return earthDr;
        } else if (buf == 4) {
            return fireDr;
        } else if (buf == 5) {
            return healerDr;
        } else if (buf == 6) {
            return heavyDr;
        } else System.exit(0);
        return null;
    }
}
