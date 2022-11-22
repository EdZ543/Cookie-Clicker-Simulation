import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An image of a cookie rocket that will accelerate upwards, signifying
 * the victory of the winning player!
 * 
 * @author Patrick Hu 
 * @version November 2022
 */
public class CookieRocket extends SuperSmoothMover
{    
    private double scale;
    private double speed;
    private double acceleration;
    private Player player; // the player who won
    
    public CookieRocket(Player player) {
        this.player = player;
        scale = 3;
        speed = 0.2;
        acceleration = 0.2;
        
        setImage("./cookie-rocket.png");
        getImage().scale((int)(getImage().getWidth() * scale), (int)(getImage().getHeight() * scale));
        setRotation(-90);
    }
    
    public void addedToWorld(World w) {
        CookieWorld cw = (CookieWorld)w;
        // apply dark overlay to rest of world
        DarkOverlay overlay = new DarkOverlay();
        cw.addObject(overlay, cw.getWidth() / 2, cw.getHeight() / 2);
    }
    
    public void act() {
        accelerate();
        checkEdges();
    }
    
    /**
     * Accelerates the rocket upwards.
     */
    public void accelerate() {
        speed += acceleration;
        move(speed);
    }
    
    public void checkEdges() {
        // if at top of world
        if (getY() <= 0) {
            Greenfoot.setWorld(new EndWorld(player));
        }
    }
}
