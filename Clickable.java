import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An object that can be clicked
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Clickable extends Actor
{
    protected boolean readyToClick = false;
    
    /**
     * Method called when a clicker clicks on this object
     * 
     * @param player The player clicking this object
     */
    public void click(Player player) {}
    
    /**
     * Gets a random number in the range from `start` to `end` inclusive.
     */
    protected int getRandomNumberInRange(int start, int end) {
       int a = Greenfoot.getRandomNumber(end - start + 1);
       return start + a;
    }
    
    /**
     * Returns whether the building must be clicked right now
     */
    public boolean isReadyToClick() {
        return readyToClick;
    }
}
