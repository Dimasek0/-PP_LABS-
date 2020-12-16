package com.Hnitetskyi.arena;

import com.Hnitetskyi.droids.Droid;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TeamFight {
    private Droid[] team1;
    private Droid[] team2;
    private int n;
    private int round = 1;

    public TeamFight(Droid[] team1, Droid[] team2, int n) {
        this.team1 = team1;
        this.team2 = team2;
        this.n = n;
    }

    public void fight() {
        boolean winner = false;
        do {
            if (dividesByTwo(round)) {
                for (int i = 0; i < n; i++) {
                    if (team1[i].isAlive() && team2[i].isAlive())
                        nextRound(team1[i], team2[i]);
                    else if (i < n - 1 && team1[i].isAlive() && team2[i++].isAlive())
                        nextRound(team1[i], team2[i++]);
                    else if (i < n - 1 && team2[i].isAlive() && !team1[i++].isAlive())
                        nextRound(team1[i], team2[0]);
                }
            } else {
                for (int i = 0; i < n; i++) {
                    if (team2[i].isAlive() && team1[i].isAlive())
                        nextRound(team2[i], team1[i]);
                    else if (i < n - 1 && team2[i].isAlive() && team1[i++].isAlive())
                        nextRound(team2[i], team1[i++]);
                    else if (i < n - 1 && team2[i].isAlive() && !team1[i++].isAlive())
                        nextRound(team2[i], team1[0]);
                }
            }
            round++;
            for (int i = 0; i < n; i++) {
                if (team2[i].isAlive()) {
                    break;
                }
                winner = true;
                printSeparator();
                System.out.println("\u001B[31m" + "\t\t----The WINNER is TEAM 1----" +
                        "\u001B[0m");
            }
            for (int i = 0; i < n; i++) {
                if (team1[i].isAlive()) {
                    break;
                }
                winner = true;
                printSeparator();
                System.out.println("\u001B[31m" + "\t\t----The WINNER is TEAM 2----" +
                        "\u001B[0m");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (!winner);
    }

    static boolean dividesByTwo(int a) {
        return (a % 2 == 0);
    }

    private void nextRound(Droid attacker, Droid defender) {
        Random r = new Random();
        double damage = attacker.getDamage();
        Integer critCh = attacker.getCriticalChance();
        Integer critDmg = attacker.getCriticalDmg();
        boolean isCritical = false;
        if (r.nextInt(100) < critCh) {
            double trueDmg = damage;
            damage *= (double) critDmg / 100;
            defender.getHit(damage + trueDmg);
            isCritical = true;
        } else {
            defender.getHit(damage);
        }
        if (attacker.getAlliance().equals("color")) {
            attacker.setCriticalChance(attacker.getCriticalChance() + 2);
        } else if (attacker.getAlliance().equals("elemental")) {
            attacker.setDamage(attacker.getDamage() + 2);
        }
        printRoundInfo(damage, isCritical, attacker, defender);
    }

    private void printRoundInfo(double damage, boolean critical, Droid attacker, Droid defender) {
        printSeparator();
        System.out.println("\t\t\tRound " + round);
        if (critical) {
            System.out.println(attacker.getName() + " |hits| " + defender.getName()
                    + " |w/ DMG " + damage + "|" + "\u001B[31m" + "\t!!!CRITICAL HIT!!!" +
                    "\u001B[0m");
        } else {
            System.out.println(attacker.getName() + " |hits| " + defender.getName()
                    + " |w/ DMG " + damage + "|");
        }
        System.out.println("\nDefender: " + defender);
        System.out.println("Attacker: " + attacker);
    }

    private void printSeparator() {
        System.out.println("\n--------------------------------------------\n");
    }
}
