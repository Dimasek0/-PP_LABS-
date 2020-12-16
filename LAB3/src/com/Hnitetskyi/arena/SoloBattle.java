package com.Hnitetskyi.arena;

import java.util.Random;

import com.Hnitetskyi.droids.Droid;

import java.util.concurrent.TimeUnit;

public class SoloBattle {
    private Droid attacker;
    private Droid defender;
    private int currentRound = 0;

    public SoloBattle(Droid firstDroid, Droid secondDroid) {
        if (new Random().nextBoolean()) {
            attacker = firstDroid;
            defender = secondDroid;
        } else {
            attacker = secondDroid;
            defender = firstDroid;
        }
    }

    public void fight() {
        do {
            swapOpponents();
            nextRound();
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (defender.isAlive());
        printWinnerInfo();
    }

    private void nextRound() {
        Random r = new Random();
        currentRound++;
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
        printRoundInfo(damage, isCritical);
    }

    private void swapOpponents() {
        Droid newDefender = attacker;
        Droid newAttacker = defender;
        defender = newDefender;
        attacker = newAttacker;
    }

    private void printRoundInfo(double damage, boolean critical) {
        printSeparator();
        System.out.println("\t\t\tRound " + currentRound);
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

    private void printWinnerInfo() {
        printSeparator();
        System.out.println("\u001B[31m" + "\t\t----The WINNER is " + attacker.getName().toUpperCase() +
                "----" + "\u001B[0m");
    }

    private void printSeparator() {
        System.out.println("\n--------------------------------------------\n");
    }
}
