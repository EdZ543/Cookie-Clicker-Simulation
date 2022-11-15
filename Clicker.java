import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Simulates the cursor of the players, which clicks the cookies, buy buttons, and buildings. Also available as a building, which is a copy of the main cursor that just stays in one place and clicks the cookie.
 * 
 * @author Eddie Zhuang
 * @version November 2022
 */ 
public class Clicker extends SuperSmoothMover
{
    private Player player;
    private int lagTimer = 0;
    private GreenfootImage image;
    private GreenfootImage laggingImage = new GreenfootImage("lag.gif");
    private int targetX = -1, targetY = -1;

    /**
     * @param player The player that the clicker belongs to
     * @param isRed Whether the player is red or not
     */
    public Clicker(Player player, String colour) {
        this.player = player;
        
        if (colour == "red") {
            image = new GreenfootImage("red_cursor.png");
        } else if (colour == "blue") {
            image = new GreenfootImage("blue_cursor.png");
        } else if (colour == "white") {
            image = new GreenfootImage("cursor.png");
        }
        
        image.scale(30, 40);
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
     * Makes cursor glide to a actor and then click
     */
    public void click(Actor actor) {}
    
    /**
     * Returns a random point on an an actor in a circular region
     */
    private int[] getRandomPointOnActor(Actor actor) {
        GreenfootImage image = actor.getImage();
        int radius = image.getWidth();
        
        double direction = Math.random() * (2 * Math.PI);
        double magnitude = Math.random() * radius;
        int x = (int)(actor.getX() + Math.cos(direction) * magnitude);
        int y = (int)(actor.getY() + Math.sin(direction) * magnitude);
        int[] ret = {x, y};
        
        return ret;
    }
    
    /**
     * Returns whether the cursor is currently moving towards a position in order to click it
     */
    public boolean clicking() {
        return targetX == -1 && targetY == -1;
    }
}
