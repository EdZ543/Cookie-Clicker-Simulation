import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sabotage here.
 * 
 * @author Caden Chan
 * @version 2022.11.02
 */
public abstract class Sabotage extends Powerup
{
    protected Player target;
    public Sabotage(Player origin) {
        super(origin);
        this.target = ((CookieWorld)getWorld()).getOtherPlayer(origin);
    }
    
    public void act() {
        
    }
}
