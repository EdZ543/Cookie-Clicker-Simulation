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
    public Grandma(Player player) {
        super(player);
        
        setImage("./images/placeholder/grandma.png");
    }
    
    public void act() {
        super.act();
        if (actCount == actMark) {
            produce(30, 50);
            actMark = getNextActMark(1, 2);
        }
    }
}
