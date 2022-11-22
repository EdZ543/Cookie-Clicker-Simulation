import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuWorld here.
 * 
 * @author Caden Chan, 
 * @version 2022.11.21
 */
public class MenuWorld extends World
{
    private int[] grandmas, clickers, cpsRates; // modifiable simulation parameters
    private StartButton startButton;
    private ArrowButton test;
    public MenuWorld()
    {    
        super(1200, 800, 1); 
        // Default values
        grandmas = new int[]{1, 3};
        clickers = new int[]{3, 2};
        cpsRates = new int[]{2, 2};
        startButton = new StartButton();
        addObject(startButton, 600, 500);
        test = new ArrowButton(false);
        addObject(test, 300, 200);
    }
    public void start() {
        Greenfoot.setWorld(new CookieWorld(grandmas, clickers, cpsRates));
    }
}
