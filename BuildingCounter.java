import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An image that displays the number of a type of building a player has.
 * 
 * @author Patrick Hu
 * @version November 2022
 */
public class BuildingCounter extends Actor
{
    // these may be useless
    private Color lineColor = Color.BLACK;
    private Color fillColor = Color.WHITE;
    private Color transparent = new Color(0,0,0,0);
    
    Player player;
    GreenfootImage canvas;
    GreenfootImage counter;
    protected int count;
    
    public BuildingCounter(Player player) {
        setImage("./images/building-counter-bg.png");
        this.player = player;
        count = 0;
    }
    
    public void act() {
        draw();
    }
    
    public void draw() {
        // start with the background (a rounded rectangle)
        GreenfootImage canvas = new GreenfootImage("./images/building-counter-bg.png");
        // canvas may need to be re sized
        
        // draw the counter onto the background
        String s = String.valueOf(count);
        counter = new GreenfootImage(s, 20, null, null);
        canvas.drawImage(counter, canvas.getWidth() / 2, canvas.getHeight() / 2);
        
        setImage(canvas);
    }
    
    public void increaseCount() {
        count++;
    }
}
