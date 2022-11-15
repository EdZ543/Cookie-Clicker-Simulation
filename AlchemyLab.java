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
        
        setImage("./images/placeholder/alchemy-lab.png");
    }
    
    public void act() {
        super.act();
        if (actCount == actMark) {
            produceCookies();    
            actMark = getNextActMark(5, 10);
        }
    }
    
    public void produceCookies() {
        int produced = getRandomNumberInRange(500, 1000);    
        player.changeCookieCount(produced);
    }
}
