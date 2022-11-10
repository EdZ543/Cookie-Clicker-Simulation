import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An image that displays the number of a type of building a player has.
 * 
 * @author Patrick Hu
 * @version November 2022
 */
public class BuildingCounter extends Actor
{    
    private Player player;
    private GreenfootImage canvas;
    private GreenfootImage counter;
    protected int count;
    
    public BuildingCounter() {
        this.player = player;
        count = 50;
    }
    
    public void act() {
        draw();
    }
    
    public void draw() {
        // Start with the background (a rounded rectangle)
        GreenfootImage canvas = new GreenfootImage("./images/building-counter-bg.png");
        canvas.scale((int)(canvas.getWidth() * 0.1), (int)(canvas.getHeight() * 0.1));
        
        // Draw the counter onto the background
        String s = String.valueOf(count);
        counter = new GreenfootImage(s, 20, null, null);
        canvas.drawImage(counter, canvas.getWidth() / 2 - counter.getWidth() / 2, canvas.getHeight() / 2 - counter.getHeight() / 2);
        
        setImage(canvas);
    }
    
    public void increaseCount() {
        count++;
    }
}
