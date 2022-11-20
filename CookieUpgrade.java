import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CookieUpgrade here.
 * 
 * @author Caden Chan
 * @version 2022.11.19
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
        if(actCount %3 == 0) {
            animate();
        }
        if(actCount == 120) {
            getWorld().removeObject(this);
        }
    }
    public void upgrade(Cookie cookie) {
        cookie.levelUp();
    }
    public void animate() {  // sparkle effect on top of cookie
        Sparkle sparkle = new Sparkle(Greenfoot.getRandomNumber(60) + 90, origin.getCookie());
        getWorld().addObject(sparkle, 0, 0);
    }
}
