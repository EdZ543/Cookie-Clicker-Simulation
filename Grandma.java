import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Every 2-5 seconds produces 30-50 cookies.
 * They must be clicked by the player to collect the cookies (they are old and cannot carry them by themselves.
 * 
 * @author Patrick Hu, Eddie Zhuang, Caden Chan
 * @version November 2022
 */
public class Grandma extends Building
{
    private boolean angry;
    private int angryCount;
    private GreenfootImage angryGranny, readyGranny;
    private boolean reverseDementiaActive;
    private int initialX, initialY; // store inital y position for when grandma calms down from jumping (when angry)

    public Grandma(Player player) {
        super(player);
        animationSize = 5;
        scale = 0.53;
        angry = false;
        reverseDementiaActive = false;
        angryGranny = new GreenfootImage("powerup-icns/angry-grandma.png");
        readyGranny = new GreenfootImage("./gifs/grandma/4.png");
        
        angryGranny.scale((int)(angryGranny.getWidth() * scale), (int)(angryGranny.getHeight() * scale));
        readyGranny.scale((int)(readyGranny.getWidth() * scale), (int)(readyGranny.getHeight() * scale));
    }

    public void addedToWorld(World w) {
        super.addedToWorld(w);
        initialX = getX();
        initialY = getY();
    }

    public void act() {
        super.act();
        if (angry) {
            readyToClick = false;
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
                player.changeCookieCount(-getRandomNumberInRange(60, 100)); // remove 60 to 100 cookies
                actMark = getNextActMark(1, 3);
            }
        } else {
            // when Grandma is happy, she will gladly bake you several dozens of cookies!
            if (actCount == actMark) {
                readyToClick = true;
            }
        }

        if (readyToClick) {
            setImage(readyGranny);
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

    public void click(Player player) {
        if (reverseDementiaActive) {
            produce(60, 100);
        }
        else {
            produce(30, 50);   
        }
        actMark = getNextActMark(2, 5);
        readyToClick = false;
    }

    public void reverseDementia() {
        reverseDementiaActive = true;
    }

    public void undoReverseDementia() {
        reverseDementiaActive = false;
    }

    public int getInitialX() {
         return initialX;
    }
    
    public int getInitialY() {
        return initialY;
    }
}

