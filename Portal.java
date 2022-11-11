import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Transports cookies from another dimension
 * Every 5-10 seconds, produces 50-100 cookies
 * 
 * @author Eddie Zhuang
 * @version November 2022
 */
public class Portal extends Building
{
    public Portal(Player player) {
        super(player);
    }
    
    public void act()
    {
        super.act();
        if (actCount == actMark) {
            player.changeCookieCount(getRandomNumberInRange(50, 100));
            actMark = getNextActMark(10, 20);
        }
    }
}
