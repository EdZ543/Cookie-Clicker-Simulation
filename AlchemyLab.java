import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Every 5-10 seconds, the alchemy lab will produce 500-1000 cookies
 * 
 * @author Patrick Hu 
 * @version November 2022
 */
public class AlchemyLab extends Building
{
    public AlchemyLab(Player player) {
        super(player);
        animationSize = 6;
        
    }
    
    public void act() {
        super.act();
        if (actCount == actMark) {
            produce(500, 1000);    
            actMark = getNextActMark(2, 3);
        }
        
        animate();
    }
}
