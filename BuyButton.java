import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuyButton here.
 * 
 * @author Caden Chan
 * @version 2022.11.02
 */
public class BuyButton extends Actor
{
    protected GreenfootImage actionIcon;
    protected int cooldown;  // if cooldown > 0, cannot activate button.
    protected int highlightClick;  // highlightClick tracks how many acts the button needs to be highlighted for, after being clicked by a player
    protected boolean active;  // if neither player can afford the upgrade, grey-out the button
    protected Class mySubclass;  // the subclass associated with the button (either a subclass of Builidng or a subclass of Powerup)
    // info that will be displayed: cost, cookie output impact per second
    protected int cost;
    public BuyButton(Class mySubclass, int cost) {
        
    }
    public BuyButton(Class mySubclass, int cost, int cookieOutput) {
        
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
