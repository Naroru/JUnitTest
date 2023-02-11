package com.example.junittest.ordinaryExample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.*;

class SwordTest {

    private Sword sword;

    @BeforeEach
    public void createSword()
    {
        sword = new Sword(15);
    }

    @Test
    void damageShouldBe15() {
        assertEquals(15,sword.getDamage());
    }

    @ParameterizedTest
    @ValueSource(ints = {11, 22, 43, 12})
    public void testSetDamage(int damage)
    {
        sword.setDamage(damage);
        assertEquals(damage,sword.getDamage());
    }

    @ParameterizedTest
    @CsvSource({"11,11", "22,22", "43,43"})
    public void testSetDamage2(int damage, int expectedDamage)
    {
        sword.setDamage(damage);
        assertEquals(sword.getDamage(),expectedDamage);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "testData.csv",lineSeparator = "|")
    public void testSetDamage3(int damage, int expectedDamage)
    {
        sword.setDamage(damage);
        assertEquals(sword.getDamage(),expectedDamage);
    }


    @Test
    void damageShouldBePositive() {
        assertThrows(IllegalArgumentException.class,() -> new Sword(0));
    }

}