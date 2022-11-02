import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * Credits
 * - Images
 *   - Cursor image provided by Tobias Ahlin Bjerrome
 * 
 * @author Patrick Hu, Eddie Zhuang, Caden Chan, Jonathan Zhao
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
