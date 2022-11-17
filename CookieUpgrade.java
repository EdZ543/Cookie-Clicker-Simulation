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
    
    public static void upgrade(Cookie cookie) {
        cookie.levelUp();
    }
    
    public static void click() {
        
    }
}
