import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Every 5-10 seconds, the alchemy lab will produce 500-1000 cookies
 * 
 * @author Patrick Hu 
 * @version November 2022
 */
public class AlchemyLab extends Building
{   
    public static final int COST = 2000;
    public AlchemyLab(Player player) {
        super(player);
        timeLower = 5;
        timeUpper = 10;
        actMark = 0 + getRandomNumberInRange(timeLower * 60, timeUpper * 60); // initial value between 5-10 seconds
        
        // increase player's building count for alchemy lab
        //player.buildingCount
    }
    
    public void act() {
        actCount++;
        if (actCount == actMark) {
            produceCookies();    
            actMark = getNextActMark(timeLower, timeUpper);
        }
    }
    
    public void produceCookies() {
        int produced = getRandomNumberInRange(500, 1000);    
        player.changeCookieCount(produced);
    }
}
