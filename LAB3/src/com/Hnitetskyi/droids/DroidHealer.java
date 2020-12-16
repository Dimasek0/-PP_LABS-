package com.Hnitetskyi.droids;

public class DroidHealer extends Droid {
    private int heal;

    public DroidHealer(String name, double health, double damage, Integer criticalChance,
                       Integer criticalDmg, String alliance, int heal) {
        super(name, health, damage, criticalChance, criticalDmg, alliance);
        this.heal = heal;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    @Override
    public void getHit(double damage) {
        setHealth(getHealth() - damage + getHeal());
    }

    @Override
    public String toString() {
        return
                getName() +
                        ", Health = " + getHealth() +
                        ", Damage = " + getDamage() +
                        ", Chance of Critical Damage = " + getCriticalChance() +
                        ", Heal Amount = " + getHeal();
    }
}
