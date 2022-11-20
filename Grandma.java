import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Every 10 - 20 seconds produces 30-50 cookies.
 * They must be clicked by the player to collect the cookies (they are old and cannot carry them by themselves.
 * 
 * @author Patrick Hu
 * @version November 2022
 */
public class Grandma extends Building
{
    protected boolean angry;
    
    public Grandma(Player player) {
        super(player);
        animationSize = 5;
        scale = 0.53;
        angry = false;
    }
    
    public void act() {
        super.act();
        if (actCount == actMark) {
            produce(30, 50);
            actMark = getNextActMark(1, 2);
        }
        
        animate();
    }
    
    public boolean isAngry() {
        return angry;
    }
    
    public void setAngry(boolean angryState) {
        angry = angryState;
    }
}
