import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Steals the income from the opponent's cookie factories for 5 seconds.
 * Has a 15 second cooldown.
 * 
 * @author Jonathan Zhao
 * @version 1.0 (November 1)
 */
public class StealShipment extends Sabotage
{
    public StealShipment(Player origin) {
        super(origin);
    }
    public void addedToWorld(World w) {
        super.addedToWorld(w); //required
    }
    
    public void act() {
        
    }
}
