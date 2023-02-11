package com.example.junittest.ordinaryExample;

import java.lang.reflect.Method;

public class Warrior {

    private Shield shield;
    private Sword sword;

    public Warrior(Shield shield, Sword sword) {
        this.shield = shield;
        this.sword = sword;
    }

    public void hitEnemyShield(Warrior enemy)
    {
        Shield enemyShield = enemy.getShield();
        int enemyShieldDurabiliy = enemyShield.getDurability();
        enemyShield.setDurability(enemyShieldDurabiliy - sword.getDamage());
    }

public void saySomething(String something)
{
    System.out.println(something);
}
    private int somePrivateMethodThatReturn5()
    {
        return 5;
    }
    private String somePrivateMethodThatReturnString(String someString)
    {
        return someString;
    }


    public void makeAShortRest()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Shield getShield() {
        return shield;
    }

    public Sword getSword() {
        return sword;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }

    public void setSword(Sword sword) {
        this.sword = sword;
    }



}
