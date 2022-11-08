import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Powerup here.
 * 
 * !IMPORTANT: All subclasses of Powerup MUST have the `public static final int COST` field (final keyword is optional).
 * 
 * @author Caden Chan
 * @version 2022.11.02
 */
public abstract class Powerup extends Actor
{
    protected int duration;
    protected int actCount;
    protected Player target;  // Player that is affected by the Powerup
    
    // public abstract void onClickButton();
    public Powerup(Player target) {
        this.target = target;
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
    
    public int getDuration() {
        return duration;
    }
    public Player getTarget() {
        return target;
    }
}
