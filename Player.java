import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int numCookies;
    
    public Player() {
        numCookies = 0;  
    }
    
    public void act() {
        
    }
    
    public void increaseCookies(int x) {
        numCookies += x;
    }
}
