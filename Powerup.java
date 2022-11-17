import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Powerup here.
 * 
 * 
 * @author Caden Chan
 * @version 2022.11.02
 */
public abstract class Powerup extends SuperSmoothMover
{
    protected int duration;
    protected int actCount;
    protected Player origin;  // Player that activated the Powerup
    
    public Powerup(Player origin) {
        this.origin = origin;
        actCount = 0;
    }
    /**
     * Act - do whatever the PowerUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    /**
     * @return int          How long the powerup lasts
     */
    public int getDuration() {
        return duration;
    }
    /**
     * @return Player       The player that activated this powerup
     */
    public Player getOriginPlayer() {
        return origin;
    }
}
