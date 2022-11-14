import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuyButton here.
 * 
 * @author Caden Chan
 * @version 2022.11.02
 */
public class BuyButton extends Actor
{
    private int cooldown;  // if cooldown > 0, cannot activate button.
    private int highlightClick;  // highlightClick tracks how many acts the button needs to be highlighted for, after being clicked by a player
    private boolean active;  // if neither player can afford the upgrade, grey-out the button
    // info that will be displayed: cost, subclass name, icon
    private int cost;
    private Class mySubclass;  // the subclass associated with the button (either a subclass of Builidng or a subclass of Powerup)
    private String name;
    // Button Attributes
    private final int WIDTH = 100, HEIGHT = 100;
    private String icnFile;
    private GreenfootImage icn;
    private GreenfootImage image;
    public BuyButton(Class mySubclass, String name, int cost) {
        this.mySubclass = mySubclass;
        this.name = name;
        this.cost = cost;
        // set up button image
        image = new GreenfootImage("buybutton-icns/btn-bg.png");
        icnFile = "buybutton-icns/" + mySubclass.getSimpleName().toLowerCase() + ".png";
        icn = new GreenfootImage(icnFile);
        image.drawImage(icn, 10, 10);
        // image.setColor(bgColor);
        // image.fill();
        setImage(image);
    }
    
    /**
     * Highlight button & add building to [Player p]'s collection
     * - For when the Player who activates the button is the Player that receives the building
     * @param p        The Player instance that has activated this button
     */
    public void click(Player p) {
        click(p, p);
    }
    /**
     * Highlight button & add building to [target p]'s collection
     * @param p         The Player instance that has activated this button
     * @param target    The Player instance that receives the building
     */
    public void click(Player p, Player target) {
        // highlight button with player colour
        // add buidling to target's collection
    }
    public void hover() {
        
    }
    public void act() {
        if(cooldown > 0) {
            cooldown --;
        }
    }
    public Class getMySubclass() {
        return mySubclass;
    }
    
    public int getCost() {
        return cost;    
    }
}