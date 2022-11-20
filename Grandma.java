import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Every 10 - 20 seconds produces 30-50 cookies.
 * They must be clicked by the player to collect the cookies (they are old and cannot carry them by themselves.
 * 
 * @author Patrick Hu
 * @version November 2022
 */
public class Grandma extends Building
{
    private boolean angry;
    private int angryCount;
    private GreenfootImage angryGranny;
    
    public Grandma(Player player) {
        super(player);
        animationSize = 5;
        scale = 0.53;
        angry = false;
        angryGranny = new GreenfootImage("./images/angry-grandma.png");
        angryGranny.scale((int)(angryGranny.getWidth() * scale), (int)(angryGranny.getHeight() * scale));
    }
    
    public void act() {
        super.act();
        if(angry) {
            angryCount++;
            if(angryCount < 10) { // stagger jumping start times
                return;
            } else if(angryCount%20<10) { // jumping rate
                setRotation(90);  // jump up
            } else {
                setRotation(270);  // fall back down
            }
            move(2); // jumping speed
            setRotation(0);
            setImage(angryGranny);
            // when Grandma is angry, she begins violently destroying cookies
            if(actCount == actMark) {
                player.changeCookieCount(-getRandomNumberInRange(20, 40)); // remove 20 to 40 cookies
                actMark = getNextActMark(1, 3);
            }
        } else {
            // when Grandma is happy, she will gladly bake you several dozens of cookies!
            if (actCount == actMark) {
                produce(30, 50);
                actMark = getNextActMark(1, 2);
            }
        }
    }
    
    public boolean isAngry() {
        return angry;
    }
    
    public void setAngry(boolean angryState) {
        angry = angryState;
        if(angryState) {
            angryCount = -10 + Greenfoot.getRandomNumber(10); // stagger jumping start times
        }
    }
}

