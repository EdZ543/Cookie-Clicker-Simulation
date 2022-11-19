import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Transports cookies from another the Cookie-verse.
 * 
 * @author Patrick Hu
 * @version November 2022
 */
public class Portal extends Building
{
    public Portal(Player player) {
        super(player);
    }
    
    public void act() {
        super.act();
        if (actCount == actMark) {
            produce(2000, 4000);
            actMark = getNextActMark(3, 3);
        }
    }
}
