package com.example.junittest.ordinaryExample;

public class Shield {

    private int durability;

    public Shield (int durability)
    {
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {

        this.durability = Math.max(durability, 0);

    }
}
