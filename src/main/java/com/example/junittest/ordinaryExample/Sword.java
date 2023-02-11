package com.example.junittest.ordinaryExample;

public class Sword {

    private int damage;

    public Sword (int damage)
    {
        if (damage <= 0)
            throw new IllegalArgumentException("damage should be positive");
        else
            this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


}
