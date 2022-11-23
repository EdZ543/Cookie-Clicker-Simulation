import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world with story. The story provides a motive and explanation for the simulation.
 * 
 * @author Jonathan Zhao
 * @version 2022.11.22
 */
public class StoryWorld extends World
{   
    /**
     * Constructor for objects of class StoryWorld.
     * 
     */
    public StoryWorld() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        
        GreenfootImage bg = new GreenfootImage("story/storybg.png");
        setBackground(bg);
    }
    

}
