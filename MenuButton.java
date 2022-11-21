import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class MenuButton extends Actor
{
    public abstract void clicked();
    public void act()
    {
        if(Greenfoot.mouseClicked(this)) {
            clicked();
        }
    }
}
