import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CookieMonster here.
 * 
 * @author Caden Chan
 * @version 2022.11.02
 */
public class CookieMonster extends Sabotage
{
    private int percentToTake;
    private int takenCookies;
    
    public CookieMonster(Player origin) {
        super(origin);
        percentToTake = getRandomNumberInRange(10, 25);
    }
    
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        takenCookies = target.getCookieCount() * (int)((double)percentToTake / 100);
        target.changeCookieCount(-takenCookies);
    }
    
    public void act() {
        actCount++;
        animate();
        if(actCount == duration*60) {
            getWorld().removeObject(this);
        }   
    }
    
    public void animate() {
        // show cookie monster walking past
    }
}
