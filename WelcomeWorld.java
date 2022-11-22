import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The title screen
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WelcomeWorld extends World
{
    private GreenfootImage bg;
    private GoButton nextButton;
    private Label tempTitle;
    private Label tempAuthors;
    /**
     * The first screen seen by the user
     */
    public WelcomeWorld()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        // Background
        bg = new GreenfootImage("welcome-background.png");
        setBackground(bg);
        // Button brings user to the MenuWorld
        nextButton = new GoButton();
        addObject(nextButton, 600, 600);
        // Title
        tempTitle = new Label("Cookie Clicker Simulation!", 60);
        addObject(tempTitle, 600, 100);
        // Authors
        tempAuthors = new Label("By Patrick H., Jonathan Z., Eddie Z., Caden C.", 40);
        addObject(tempAuthors, 600, 160);
    }
    /**
     * Go to the menu screen, represented by <code>MenuWorld</code>
     */
    public void goToMenu() {
        Greenfoot.setWorld(new MenuWorld());
    }
}
