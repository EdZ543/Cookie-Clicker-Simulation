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
        startButton = new StartButton();
        addObject(startButton, 600, 500);
        test = new ArrowButton(false);
        addObject(test, 300, 200);
    }
}
