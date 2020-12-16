package com.Hnitetskyi.droids;

public class Droid {
    private String name;
    private double health;
    private double damage;
    private Integer criticalChance;
    private Integer criticalDmg;
    private String alliance;

    public Droid(String name, double health, double damage, Integer criticalChanсe, Integer criticalDmg, String alliance) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.criticalChance = criticalChanсe;
        this.criticalDmg = criticalDmg;
        this.alliance = alliance;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getDamage() {
        return damage;
    }

    public Integer getCriticalDmg() {
        return criticalDmg;
    }

    public Integer getCriticalChance() {
        return criticalChance;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void setCriticalChance(Integer criticalChance) {
        this.criticalChance = criticalChance;
    }

    public String getAlliance() {
        return alliance;
    }

    public void getHit(double damage) {
        this.health -= damage;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public String toString() {
        return
                name +
                        ", Health = " + health +
                        ", Damage = " + damage +
                        ", Chance of Critical Damage = " + criticalChance;
    }
}
