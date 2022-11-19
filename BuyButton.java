import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.reflect.Constructor;

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
    // Clicked animation
    protected int clickedCount;
    // Buy Button's description of item
    protected Description desc;
    protected boolean isBeingHovered;
    /**
     * @param mySubclass            The subclass of Building or Powerup that is created or activated by this button
     * @param name                  The name of the Building or Powerup
     * @param cost                  The cost of the Building or Powerup
     */
    public BuyButton(Class mySubclass, String name, int cost) {
        this.mySubclass = mySubclass;
        this.name = name;
        this.cost = cost;
        clickedCount = 0;
        isBeingHovered = false;
    }

    public void addedToWorld(World w) {
        // set up button image
        icnFile = "buybutton-icns/" + mySubclass.getSimpleName().toLowerCase() + ".png";
        image = createImage();
        setImage(image);

    }

    /**
     * Simulate button being clicked by a player. Create building or activate powerup on click
     * 
     * @param p        The Player instance that has activated this button
     */
    public void click(Player player) { 
        double highlightDuration;
        Color colour;
        CooldownBar highlight;
        // Handle Buildings
        if(Building.class.isAssignableFrom(mySubclass)) {
            player.addBuilding(getX(), getY(), mySubclass);
            highlightDuration = 0.5;
            // Handle Powerups
        } else {
            Powerup powerup = createPowerup(player);
            getWorld().addObject(powerup, 0, 0);
            highlightDuration = powerup.getDuration() == 0 ? 0.5 : powerup.getDuration();
        }
        // Handle BuyButton highlighting
        colour = player.getColour() == "red" ? Color.RED : Color.BLUE;
        highlight = new CooldownBar((int)(getImage().getWidth()*0.9 +1), getImage().getHeight(), colour, highlightDuration);
        getWorld().addObject(highlight, getX(), getY());
        clickedCount = 20;
        image.scale(60, 60);
        setImage(image);
    }

    /**
     * Show button description when user hovers their cursor over the button
     */
    public void checkHover() {
        if (Greenfoot.mouseMoved(this) && !isBeingHovered) {
            desc = new Description(mySubclass);
            getWorld().addObject(desc, getX(), getY() + getImage().getHeight() + 32);
            isBeingHovered = true;
        }            
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            isBeingHovered = false;
            getWorld().removeObject(desc);            
        }
    }

    public void act() {
        if(cooldown > 0) {
            cooldown --;
        }
        if(clickedCount > 0) {
            clickedCount --;
            if(clickedCount == 0) {
                image = createImage();
                setImage(image);
            }
        }
        // test method
        if(Greenfoot.mouseClicked(this)) {
            // click(((CookieWorld)getWorld()).getP1());
            CooldownBar x = new CooldownBar((int)(getImage().getWidth()*0.9+1), getImage().getHeight(), Color.BLUE, 3);
            getWorld().addObject(x, getX(), getY());
            clickedCount = 10;
            image.scale(70, 70);
            setImage(image);
        }
        
        checkHover();
    }

    /**
     * @return Class        Subclass of Building or Powerup, purchased through this button.
     */
    public Class getMySubclass() {
        return mySubclass;
    }

    /**
     * Used by `click` method to create a new Powerup
     * @return Powerup          new instance of mySubclass, given mySubclass is a Powerup
     */
    private Powerup createPowerup(Player player) {
        try {
            Constructor<Powerup> c = mySubclass.getConstructor(Player.class);
            return c.newInstance(player);
        } catch(Exception e) {}
        return null;
    }

    /**
     * @return int      Cost, in cookies, to use button
     */
    public int getCost() {
        return cost;    
    }

    /**
     * Create the button's image upon instantiation, and whenever 
     * the click animation is over, to work around poor image quality from GreenfootImage.scale().
     * 
     * @return GreenfootImage       BuyButton's image
     */
    private GreenfootImage createImage() {
        GreenfootImage img = new GreenfootImage("buybutton-icns/btn-bg.png");
        icn = new GreenfootImage(icnFile);
        img.drawImage(icn, (img.getWidth()-icn.getWidth())/2, (img.getHeight()-icn.getHeight())/2);
        return img;
    }
}