import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Every 5-10 seconds, produces 500-1000 cookies
 * 
 * @author Patrick Hu 
 * @version November 2022
 */
public class AlchemyLab extends Building
{
    public AlchemyLab(Player player) {
        super(player);
        actMark = 0 + getRandomNumberInRange(5 * 60, 10 * 60); // initial value between 5-10 seconds
    }
    
    public void act() {
        actCount++;
        if (actCount == actMark) {
            produceCookies();    
            // get next act mark
        }
    }
    
    public void produceCookies() {
        int produced = getRandomNumberInRange(500, 1000);    
        player.setCookieCount(player.getNumCookies() + produced);
    }
}
