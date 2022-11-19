import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Superclass for all Effects.
 * @author Mr. Cohen
 * @version November 2022
 */
public class Effect extends Actor
{
    protected GreenfootImage image;
    protected int duration, fadeLen;
    
    protected void fade (int timeLeft, int fadeTime) {
        double percent = timeLeft / (double)fadeTime;
        // Transparency 0 -- 255
        int newTransparency = (int)(percent * 255);
        image.setTransparency(newTransparency);
    }
}