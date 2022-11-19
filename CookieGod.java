import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  
 * @author Patrick Hu
 * @version November 2022
 */
public class CookieGod extends Building
{
    public CookieGod(Player player) {
        super(player);
        
        setImage("./images/placeholder/cookie-god.png");
    }
    
    public void act() {
        super.act();
        if (actCount == actMark) {
            produce(9000, 9000);
            actMark = getNextActMark(2, 3);
        }
    }
}
