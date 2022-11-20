import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.reflect.Constructor;

/**
 * Write a description of class BuyButton here.
 * 
 * @author Caden Chan
 * @version 2022.11.19
 */
public class BuyButton extends Clickable
{
    protected int cooldown;  // if cooldown > 0, cannot activate button.
    protected int highlightClick;  // highlightClick tracks how many acts the button needs to be highlighted for, after being clicked by a player
    protected boolean active;  // if neither player can afford the upgrade, grey-out the button
    protected boolean maxedOut;
    // info that will be displayed: cost, subclass name, icon
    protected int cost;
    protected Class mySubclass;  // the subclass associated with the button (either a subclass of Builidng or a subclass of Powerup)
    protected String name;
    // Button Attributes
    GreenfootImage activeImage, inactiveImage;
    // Clicked animation
    protected int clickedCount;
    // Hover Area for the showing of Descriptions
    HoverArea hover;
    Player lastPlayer;
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
        hover = new HoverArea(this);
        active = true;
        maxedOut = false;
        lastPlayer = null;
    }

    public void addedToWorld(World w) {
        // set up button image
        activeImage = new GreenfootImage("buybutton-icns/" + mySubclass.getSimpleName().toLowerCase() + ".png");
        inactiveImage = new GreenfootImage("buybutton-icns/" + mySubclass.getSimpleName().toLowerCase() + "-off.png");
        // image = createImage();
        setImage(activeImage);
        // add HoverArea
        getWorld().addObject(hover, getX(), getY());
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
        // Handle variable changes
        clickedCount = 20;
        activeImage.scale(60, 60);
        setImage(activeImage);  // helps maintain button image quality
        active = true;
        
        // Handle Cookie Rocket
        if(mySubclass == CookieRocket.class) {
            return;
        //Handle Powerups
        } else if(Building.class.isAssignableFrom(mySubclass)) {
            player.addBuilding(getX(), getY(), mySubclass);
            highlightDuration = 0.5;
        // Handle Powerups
        } else {
            Powerup powerup = createPowerup(player);
            getWorld().addObject(powerup, 0, 0);
            highlightDuration = powerup.getDuration() == 0 ? 0.5 : powerup.getDuration();
        }
        // Handle BuyButton highlighting & visuals
        colour = player.getColour() == "red" ? Color.RED : Color.BLUE;
        highlight = new CooldownBar((int)(getImage().getWidth()*0.9 +1), getImage().getHeight(), colour, highlightDuration);
        getWorld().addObject(highlight, getX(), getY());
        
        // Charge player for purchase
        player.changeCookieCount(-cost);
        lastPlayer = player;
    }

    public void act() {
        if(cooldown > 0) {
            cooldown --;
        }
        if(clickedCount > 0) {
            clickedCount --;
            if(clickedCount == 0) {
                activeImage = new GreenfootImage("buybutton-icns/" + mySubclass.getSimpleName().toLowerCase() + ".png"); //maintain image quality
                ((CookieWorld)getWorld()).toggleButton(this, lastPlayer.getCookieCount());
                // setActive(true);  // if maxedOut after click, stay inactive. otherwise, make active again (which will then change depending on `handleActiveStateButtons()` in `CookieWorld`
            }
        }
        // test method
        if(Greenfoot.mouseClicked(hover)) {
            click(((CookieWorld)getWorld()).getP1());
            // CooldownBar x = new CooldownBar((int)(getImage().getWidth()*0.9+1), getImage().getHeight(), Color.BLUE, 3);
            // getWorld().addObject(x, getX(), getY());
            // clickedCount = 10;
            // image.scale(70, 70);
            // setImage(image);
        }
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
    
    public void setCost(int cookies) {
        cost = cookies;
    }

    public void setActive(boolean activeState) {
        active = activeState;
        if(activeState) {
            setImage(activeImage);
        } else {
            setImage(inactiveImage);
        }
    }
    public boolean isActive() {
        return active;
    }
    public void setMaxedOut(boolean maxed) {
        if(maxedOut == maxed) { // nothing changes
            return;
        }
        maxedOut = maxed;
        if(maxed) {
            GreenfootImage maxIcon = new GreenfootImage("buybutton-icns/max.png");
            GreenfootImage maxImage = new GreenfootImage(maxIcon.getWidth(), maxIcon.getWidth());
            maxImage.drawImage(new GreenfootImage("buybutton-icns/max.png"), 0, 30);
            maxImage.setTransparency(230);
            hover.setImage(maxImage);
            setActive(false);
        } else {
            hover.setImage(new GreenfootImage(getImage().getWidth(), getImage().getHeight()));
        }
    }
    public boolean isMaxedOut() {
        return maxedOut;
    }
}