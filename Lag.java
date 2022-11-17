import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lag here.
 * 
 * @author Caden Chan
 * @version 2022.11.02
 */
public class Lag extends Sabotage
{
    public Lag(Player origin) {
        super(origin);
        duration = Greenfoot.getRandomNumber(3) + 3; // 3-5 seconds
    }
    public void addedToWorld(World w) {
        target.lagClickers(duration);
    }
    public void act() {
        actCount++;
        animate();
        if(actCount == duration*60) {
            getWorld().removeObject(this);
        }
    }
    public void animate() {
        // show a wifi signal failure symbol; fade after a bit
    }
}
