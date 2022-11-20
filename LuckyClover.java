import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LuckyClover here.
 * 
 * @author Caden Chan
 * @version 2022.11.19
 */
public class LuckyClover extends Powerup
{
    public LuckyClover(Player origin) {
        super(origin);
    }
    
    public void addedToWorld(World w) {
        Building.LUCKY = true;
    }
        
    public void act() {
        actCount ++;
        if(actCount == duration*60) {
            Building.LUCKY = false;
            getWorld().removeObject(this);
        }
    }
    public void animate() {
        
    }
}
