import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.HashMap;

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
    private boolean isRed;
    private int width, height;
    private int numCookies = 0;
    private int clickers;
    private int cps;
    private int grandmas;
    private String name;
    private HashMap<Class, BuildingRow> buildingRows;
    private Label scoreText;
    
    /**
     * @param width The width all the player's stuff will take up (rows, cookie, counter text, etc.)
     * @param height The width all the player's stuff will take up (rows, cookie, counter text, etc.)
     * @param clickers How many clickers the player will start off with
     * @param cps The number of clicks per second each clicker will be able to have
     * @param grandmas  Number of starting grandmas
     * @param name The name of the player, for text displays. Example: "Player 1"
     * @param isRed Whether the player is red or not (blue)
     */
    public Player(int width, int height, int clickers, int cps, int grandmas, String name, boolean isRed) {
        this.width = width;
        this.height = height;
        this.clickers = clickers;
        this.cps = cps;
        this.grandmas = grandmas;
        this.name = name;
        this.isRed = isRed;
        
        // Set image to none
        setImage((GreenfootImage)null);
    }
    
    public void addedToWorld(World w) {
        CookieWorld cw = (CookieWorld)w;
        
        // Add cookie
        cookie = new Cookie();
        cw.addObject(cookie, getX(), getY() - 180);
        
        // Add clickers
        for (int i = 0; i < clickers; i++) {
            Clicker clicker = new Clicker(this, isRed);
            cw.addObject(clicker, getX(), 200);
        }
        
        // Add building rows
        buildingRows = new HashMap<Class, BuildingRow>();
        int rowHeight = (height - 10) / 2 / (cw.getBuildingClasses().size() - 1);
        
        for (int i = 0; i < cw.getBuildingClasses().size() - 1; i++) {
            BuildingRow buildingRow = new BuildingRow(this, cw.getBuildingClasses().get(i), width, rowHeight, 10);
            buildingRows.put(cw.getBuildingClasses().get(i), buildingRow);
            cw.addObject(buildingRows.get(cw.getBuildingClasses().get(i)), getX(), getY() + 10 + (int)((i + 0.5) * rowHeight));
        }
        
        // Add starting grandmas
        for (int i = 0; i < grandmas; i++) {
        }
        
        // Add score text
        scoreText = new Label(name + "'s Cookies: " + numCookies, 40);
        cw.addObject(scoreText, getX(), getY() - 370);
    }
    
    public void act() {
        
    }
    
    /**
     * Change the amount of cookies the player has.
     * 
     * @param x The amount to change by. If negative, it takes away cookies.
     */
    public void changeCookieCount(int x) {
        numCookies += x;
        scoreText.setValue(name + "'s Cookies: " + numCookies);
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
