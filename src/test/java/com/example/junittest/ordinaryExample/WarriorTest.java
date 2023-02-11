package com.example.junittest.ordinaryExample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    private Warrior warrior;

    @BeforeEach
    public void createAWarrior()
    {
        Shield shield = new Shield(100);
        Sword sword = new Sword(10);

        warrior = new Warrior(shield, sword);
    }

    @Test
    void enemyShieldDurabilityShouldBe90() {

        Shield enemyShield = new Shield(100);
        Sword enemySword = new Sword(10);

        Warrior enemy = new Warrior(enemyShield,enemySword);

        warrior.hitEnemyShield(enemy);
        assertEquals(90, enemy.getShield().getDurability());
    }

    @Test()
    void warriorRestShouldBeNoLonger1500() {
        assertTimeout(Duration.ofMillis(1500), () -> warrior.makeAShortRest());
    }

    @Test
    void warriorShouldHaveNewShield() {

        Shield newShield = new Shield(200);
        warrior.setShield(newShield);
        assertEquals(newShield, warrior.getShield());
    }

    @Test
    void warriorShouldHaveNewSword() {
        Sword newSword= new Sword(50);
        warrior.setSword(newSword);
        assertEquals(newSword, warrior.getSword());

    }

    @Test
    public void testPrivateMethodShouldReturn5()
    {
        try {
            // второй параметр - класс параметра функции из Warrior. Если у функции нет параметров - то null
            Method method = Warrior.class.getDeclaredMethod("somePrivateMethodThatReturn5",null);
            method.setAccessible(true);
            assertEquals(5,(int)method.invoke(warrior));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void somePrivateMethodThatReturnString_ShouldReturnABC() {
        Method method = null;
        try {
            method = Warrior.class.getDeclaredMethod("somePrivateMethodThatReturnString", String.class);
            method.setAccessible(true);
            assertEquals("ABC", method.invoke(warrior, "ABC").toString());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    void saySomethingTest() {

        String consoleOutput = null;
        PrintStream originalOutput = System.out;

        try{
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(100);
            PrintStream capture = new PrintStream(outputStream);
            System.setOut(capture);

            warrior.saySomething("Hello, my friend!");

            capture.flush(); //выбрасываем данные в outputStream
            consoleOutput = outputStream.toString();

            System.setOut(originalOutput);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        assertEquals("Hello, my friend!\r\n", consoleOutput);
    }
}