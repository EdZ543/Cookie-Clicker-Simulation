import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author Patrick Hu
 * @version November 2022
 */
public class Player extends Actor
{
    private int numCookies;
    
    public Player() {
        numCookies = 0;  
    }
    
    public void act() {
        
    }
    
    public void setCookieCount(int x) {
        numCookies = x;
    }
    
    public int getCookieCount() {
        return numCookies;
    }
}
