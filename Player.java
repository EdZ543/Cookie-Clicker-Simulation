import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A player in this simulation, of which there are two.
 * Adjustable properties:
 * - Clicks per second
 * - Number of clickers
 * - Number of starting grandmas
 * 
 * @author Eddie Zhuang
 * @version November 2022
 */
public class Player extends Actor
{
    private Cookie cookie;
    
    private int numCookies = 0;
    private int clickers;
    private int cps;
    private int grandmas;
    private String name;
    
    /**
     * @param clickers How many clickers the player will start off with
     * @param cps The number of clicks per second each clicker will be able to have
     * @param grandmas  Number of starting grandmas
     * @param name The name of the player, for text displays. Example: "Player 1"
     */
    public Player(int clickers, int cps, int grandmas, String name) {
        this.clickers = clickers;
        this.cps = cps;
        this.grandmas = grandmas;
        this.name = name;
        
        // Set image to none
        setImage((GreenfootImage)null);
    }
    
    public void addedToWorld(World w) {
        // Add cookie
        //cookie = new Cookie();
        //w.addObject(cookie, getX(), getY() - 400);
        
        // Add clickers
        for (int i = 0; i < clickers; i++) {
            
        }
        
        // Add building rows
        
        // Add starting grandmas
        
        // Add score text
    }
    
    public void act() {
        
    }
    
    /**
     * Change the amount of cookies the player has.
     * 
     * @param dx The amount to change by. If negative, it takes away cookies.
     */
    public void changeCookieCount(int dx) {
        numCookies += dx;
    }
    
    /**
     * Returns the amount of cookies that the player has.
     * 
     * @return int The number of cookies
     */
    public int getCookieCount() {
        return numCookies;
    }
    
    /**
     * Returns the name of the player
     * 
     * @return String The name
     */
    public String getName() {
        return name;
    }
}
