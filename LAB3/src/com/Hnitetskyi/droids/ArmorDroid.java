package com.Hnitetskyi.droids;

public class ArmorDroid extends Droid {
    private int armor;

    public ArmorDroid(String name, double health, double damage, Integer criticalChance,
                      Integer criticalDmg, String alliance, int armor) {
        super(name, health, damage, criticalChance, criticalDmg, alliance);
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public void getHit(double damage) {
        if (getArmor() > 0) {
            if (damage > getArmor()) {
                setHealth(getHealth() + getArmor() - damage);
            }
            setArmor(getArmor() - 10);
        }
    }

    @Override
    public String toString() {
        return
                getName() +
                        ", Health = " + getHealth() +
                        ", Damage = " + getDamage() +
                        ", Chance of Critical Damage = " + getCriticalChance() +
                        ", Armor amount = " + getArmor();
    }
}