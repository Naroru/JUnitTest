package com.example.junittest.ordinaryExample;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShieldTest {

    private Shield shield;

    @BeforeEach()
    public void createShield()
    {
        shield = new Shield(100);

    }

    @Test
    public void ShieldDurabilityShouldBe100()
    {
        assertEquals(100, shield.getDurability());
    }

    @Test
    public void ShieldDurabilityShouldBe0()
    {
        shield.setDurability(-10);
        assertEquals(0, shield.getDurability());
    }

}