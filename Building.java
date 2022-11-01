import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Building here.
 * 
 * @author Patrick Hu
 * @version November 2022
 */
public abstract class Building extends Actor
{
    protected int actCount;
    
    public Building() {
        actCount = 0;
    }
    
    public void act() {
        
    }
    
    public int getRandomNumberInRange(int start, int end) {
       int a = Greenfoot.getRandomNumber(end - start + 1);
       return start + a;
    }
}
