import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An object that can be clicked
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Clickable extends Actor
{
    /**
     * Method called when a clicker clicks on this object
     * 
     * @param player The player clicking this object
     */
    public void click(Player player) {}
}
