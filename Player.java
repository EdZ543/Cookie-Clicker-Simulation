import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author Patrick Hu
 * @version November 2022
 */
public class Player extends Actor
{
    private int numCookies = 0;
    
    public Player() {
        // Set image to none
        setImage((GreenfootImage)null);
        
        // Add cookie
        
        // Add clickers
        
        // Add building rows
        
        // Add score text
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
