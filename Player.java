import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

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
    private int width, height;
    private int numCookies = 0;
    private int clickers;
    private int cps;
    private int grandmas;
    private String name;
    private ArrayList<BuildingRow> buildingRows = new ArrayList<BuildingRow>();
    
    /**
     * @param width The width all the player's stuff will take up (rows, cookie, counter text, etc.)
     * @param height The width all the player's stuff will take up (rows, cookie, counter text, etc.)
     * @param clickers How many clickers the player will start off with
     * @param cps The number of clicks per second each clicker will be able to have
     * @param grandmas  Number of starting grandmas
     * @param name The name of the player, for text displays. Example: "Player 1"
     */
    public Player(int width, int height, int clickers, int cps, int grandmas, String name) {
        this.width = width;
        this.height = height;
        this.clickers = clickers;
        this.cps = cps;
        this.grandmas = grandmas;
        this.name = name;
        
        // Set image to none
        setImage((GreenfootImage)null);
    }
    
    public void addedToWorld(World w) {
        CookieWorld cw = (CookieWorld)w;
        
        // Add cookie
        
        
        // Add clickers
        for (int i = 0; i < clickers; i++) {
            
        }
        
        // Add building rows
        int rowHeight = height / 2 / cw.getBuildingClasses().size();
        for (int i = 0; i < cw.getBuildingClasses().size(); i++) {

            buildingRows.add(new BuildingRow(cw.getBuildingClasses().get(i), width, rowHeight, 10));
            getWorld().addObject(buildingRows.get(i), getX(), getY() + (int)((i + 0.5) * rowHeight));
        }
        
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
