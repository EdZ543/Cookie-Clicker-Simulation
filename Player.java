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
 * "AI" behaviour:
 * - If it has enough cookies to buy the cookie rocket, it shall do so immediately
 * - Default state: choose a random point on the cookie and click there
 * - Every 10-15 clicks, it shall attempt to perform a random action:
 *   - Click on a random clickable building
 *   - Buy a random building 
 *   - Buy a random powerup
 *   - Buy a random sabotage
 * 
 * @author Eddie Zhuang
 * @version November 2022
 */
public class Player extends Clickable
{
    private Cookie cookie;
    private String colour;
    private int width, height;
    private int numCookies = 0;
    private int clickers;
    private int cps;
    private int grandmas;
    private String name;
    private HashMap<Class, BuildingRow> buildingRows;
    private Label scoreText;
    private Clicker clicker;
    private int clickCount = 0;
    private Clicker[] clickerBuildings;
    
    /**
     * @param width The width all the player's stuff will take up (rows, cookie, counter text, etc.)
     * @param height The width all the player's stuff will take up (rows, cookie, counter text, etc.)
     * @param clickers How many clickers the player will start off with
     * @param cps The number of clicks per second each clicker will be able to have
     * @param grandmas  Number of starting grandmas
     * @param name The name of the player, for text displays. Example: "Player 1"
     * @param isRed Whether the player is red or not (blue)
     */
    public Player(int width, int height, int clickers, int cps, int grandmas, String name, String colour) {
        this.width = width;
        this.height = height;
        this.clickers = clickers;
        this.cps = cps;
        this.grandmas = grandmas;
        this.name = name;
        this.colour = colour;
        
        // Set image to none
        setImage((GreenfootImage)null);
    }
    
    public void addedToWorld(World w) {
        CookieWorld cw = (CookieWorld)w;
        
        // Add cookie
        cookie = new Cookie();
        cw.addObject(cookie, getX(), getY() - 170);
        
        // Add stationary clickers
        clickerBuildings = new Clicker[clickers];
        for (int i = 0; i < clickers; i++) {
            clickerBuildings[i] = new Clicker(this, "white", 5);
            cw.addObject(clickerBuildings[i], getX(), 200);
        }
        
        // Add sentient clicker
        clicker = new Clicker(this, colour, 5);
        cw.addObject(clicker, getX(), 200);
        
        // Add building rows
        buildingRows = new HashMap<Class, BuildingRow>();
        int rowHeight = (height - 10) / 2 / cw.getBuildingClasses().size();
        
        for (int i = 0; i < cw.getBuildingClasses().size(); i++) {
            BuildingRow buildingRow = new BuildingRow(this, cw.getBuildingClasses().get(i), width, rowHeight, 10);
            buildingRows.put(cw.getBuildingClasses().get(i), buildingRow);
            cw.addObject(buildingRows.get(cw.getBuildingClasses().get(i)), getX(), getY() + 10 + (int)((i + 0.5) * rowHeight));
        }
        
        // Add starting grandmas
        for (int i = 0; i < grandmas; i++) {
            buildingRows.get(Grandma.class).addBuilding();
        }
        
        // Add score text
        scoreText = new Label(name + "'s Cookies:\n" + numCookies, 35);
        cw.addObject(scoreText, getX(), getY() - 360);
    }
    
    public void act() {
        // Control main clicker
        if (!clicker.clicking()) {
            // If it has enough cookies to buy the cookie rocket, it shall do so immediately
            
            
            // Default state: choose a random point on the cookie and click there
            //clicker.click(cookie);
            
            // Every 10-15 clicks, it shall attempt to perform a random action:
            // Click on a random clickable building
            // Buy a random building 
            // Buy a random powerup
            // Buy a random sabotage
        }
        
        // Control non-sentient clickers
        for (int i = 0; i < clickers; i++) {
            if (!clickerBuildings[i].clicking()) {
                clickerBuildings[i].click(cookie);
            }
        }
    }
    
    /**
     * Change the amount of cookies the player has.
     * 
     * @param x The amount to change by. If negative, it takes away cookies.
     */
    public void changeCookieCount(int x) {
        numCookies += x;
        scoreText.setValue(name + "'s Cookies:\n" + numCookies);
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
    
    /**
     * Returns the colour of the player
     * 
     * @return String The colour
     */
    public String getColour() {
        return colour;
    }
    
    /**
     * Adds a building to the player's building rows
     * 
     * @param x The starting x position of the building (will move towards appropriate place)
     * @param y The starting y position of the building
     * @param buildingClass The class of the building
     */
    public void addBuilding(int x, int y, Class buildingClass) {
        buildingRows.get(buildingClass).addBuilding(x, y);
    }
}
