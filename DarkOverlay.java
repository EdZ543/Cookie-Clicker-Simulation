import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DarkOverlay here.
 * 
 * @author Patrick Hu
 * @version November 2022
 */
public class DarkOverlay extends Actor
{
    public DarkOverlay() {
        setImage("./black.png");
        getImage().scale(1200, 800);
        getImage().setTransparency(210);
    }
}
