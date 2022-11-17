import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CookieUpgrade here.
 * 
 * @author Caden Chan
 * @version 2022.11.02
 */
public class CookieUpgrade extends Powerup
{
    public CookieUpgrade(Player origin) {  
        super(origin);
    }
    public void addedToWorld(World w) {
        upgrade(origin.getCookie());
    }
    public void act() {
        actCount ++;
        animate();
        if(actCount == 120) {
            getWorld().removeObject(this);
        }
    }
    public void upgrade(Cookie cookie) {
        cookie.levelUp();
    }
    public void animate() { // some sort of effect that plays when cookie is upgraded (i.e. sparkles??)
        // idea: add sparkle pngs, which fade over time
    }
}
