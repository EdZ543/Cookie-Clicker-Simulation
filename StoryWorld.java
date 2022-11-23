import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world with story. The story provides a motive and explanation for the simulation.
 * 
 * @author Jonathan Zhao
 * @version 2022.11.22
 */
public class StoryWorld extends World
{   
    private int storyIndex = 0;
    
    public StoryWorld() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        
        GreenfootImage bg = new GreenfootImage("story/story0.png");
        setBackground(bg);
    }
    
    public void act() {
        WelcomeWorld.tracks[0].play();
        
        if (Greenfoot.mouseClicked(this)) {
            if (storyIndex == 8) {
                Greenfoot.setWorld(new MenuWorld(WelcomeWorld.tracks));
                return;
            }
            
            storyIndex++;
            GreenfootImage bg = new GreenfootImage("story/story" + storyIndex + ".png");
            setBackground(bg);
        }
    }
    
    public void stopped() {
        WelcomeWorld.tracks[0].pause();
        WelcomeWorld.tracks[1].pause();
    }
}
