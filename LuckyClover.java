import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LuckyClover here.
 * 
 * @author Caden Chan
 * @version 2022.11.19
 */
public class LuckyClover extends Powerup
{
    private GreenfootImage image;
    private int rotationCount;
    public LuckyClover(Player origin) {
        super(origin);
        image = new GreenfootImage("effect/luckyclover0.png");
        setImage(image);
        image.setTransparency(180);
        duration = (6 + Greenfoot.getRandomNumber(3))*60; // random duration from 6-8 seconds, in acts
        actCount = duration;
        rotationCount = 0;
    }
    
    public void addedToWorld(World w) {
        Building.LUCKY = true;
        setLocation(origin.getCookie().getX(), origin.getCookie().getY());
    }
        
    public void act() {
        if(actCount % 3 == 0) {
            setRotation(rotationCount);
            rotationCount+=3;
        }
        if(actCount%25 == 0) {
            addSparkle();
        }
        if(actCount == 0) {
            Building.LUCKY = false;
            getWorld().removeObject(this);
        } else if (actCount <= 120){
            Effect.fade (image, actCount, 120, 180);
        }
        actCount --;
    }
    public void addSparkle() {  // sparkle effect on top of cookie
        Sparkle sparkle = new Sparkle(Greenfoot.getRandomNumber(60) + 90, this, LuckyClover.class);
        getWorld().addObject(sparkle, 0, 0);
    }
}
