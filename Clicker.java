import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Simulates the cursor of the players, which clicks the cookies, buy buttons, and buildings. Also available as a building, which is a copy of the main cursor that just stays in one place and clicks the cookie.
 * 
 * @author Eddie Zhuang
 * @version November 2022
 */ 
public class Clicker extends SuperSmoothMover
{
    private Color colour;
    private Player player;
    private int lagTimer = 0;
    private GreenfootImage image;
    private GreenfootImage laggingImage = new GreenfootImage("lag.gif");

    /**
     * @param player The player that the clicker belongs to
     * @param image The cursor's image
     * @param color The color of the cursor
     */
    public Clicker(Player player, GreenfootImage image, Color colour) {
        this.player = player;
        this.image = image;
        this.colour = colour;
        
        setImage(image);
    }

    /**
     * Act - do whatever the Clicker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Change image and freeze if lagging out
        if (lagTimer > 0) {
            if (lagTimer == 1) {
                setImage(image);
            }
            
            lagTimer--;
        }
    }

    /**
     * Causes the cursor to become a loading symbol and not click for a number of seconds.
     * 
     * @param seconds Number of seconds the clicker will lag out for
     */
    public void lagOut(int seconds) {
        setImage(laggingImage);
        lagTimer = seconds * 60;
    }
    
    /**
     * Makes cursor glide to a specific x and y coordinate
     */
    public void moveTo(int x, int y) {}
    
    /**
     * Makes cursor click whatever it is currently on
     */
    public void click() {}
    
    /**
     * Returns the colour of the cursor
     */
    public Color getColour() {
        return colour;
    }
}
