import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    // World variables
    GreenfootImage background;
    public MyWorld()
    {    
        super(1200, 800, 1); 
        // Set world background
        background = new GreenfootImage("background0.png");
        setBackground(background);
    }
}
