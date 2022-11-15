import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuyButton here.
 * 
 * @author Caden Chan
 * @version 2022.11.14
 */
public class BuyButton extends Clickable
{
    protected int cooldown;  // if cooldown > 0, cannot activate button.
    protected int highlightClick;  // highlightClick tracks how many acts the button needs to be highlighted for, after being clicked by a player
    protected boolean active;  // if neither player can afford the upgrade, grey-out the button
    // info that will be displayed: cost, subclass name, icon
    protected int cost;
    protected Class mySubclass;  // the subclass associated with the button (either a subclass of Builidng or a subclass of Powerup)
    protected String name;
    // Button Attributes
    protected String icnFile;
    protected GreenfootImage icn;
    protected GreenfootImage image;
    /**
     * @param mySubclass            The subclass of Building or Powerup that is created or activated by this button
     * @param name                  The name of the Building or Powerup
     * @param cost                  The cost of the Building or Powerup
     */
    public BuyButton(Class mySubclass, String name, int cost) {
        this.mySubclass = mySubclass;
        this.name = name;
        this.cost = cost;
    }
    public void addedToWorld(World w) {
        // set up button image
        image = new GreenfootImage("buybutton-icns/btn-bg.png");
        icnFile = "buybutton-icns/" + mySubclass.getSimpleName().toLowerCase() + ".png";
        icn = new GreenfootImage(icnFile);
        image.drawImage(icn, (image.getWidth()-icn.getWidth())/2, (image.getHeight()-icn.getHeight())/2);
        setImage(image);
    }
    
    /**
     * Simulate button being clicked by a player. Create building or activate powerup on click
     * 
     * @param p        The Player instance that has activated this button
     */
    public void click(Player p) {
        
    }
    /**
     * Show button description when user hovers their cursor over the button
     */
    public void hover() {
        
    }
    public void act() {
        if(cooldown > 0) {
            cooldown --;
        }
        // test method
        if(Greenfoot.mouseClicked(this)) {
            // image.setColor(new Color(0, 0, 0, 50));
            // image.fill();
            // setImage(image);
            getWorld().addObject(new CooldownBar((int)(getImage().getWidth()*0.9), getImage().getHeight(), Color.BLUE, 3), getX(), getY());
        }
    }
    public Class getMySubclass() {
        return mySubclass;
    }
    
    public int getCost() {
        return cost;    
    }
}