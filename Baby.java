import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Takes other player's cookies.
 * Every 10-20 seconds, baby will eat away 20-40 cookies.
 * 
 * @author Patrick Hu
 * @version November 2022
 */
public class Baby extends Building
{    
    public static final int COST = 200;
    
    public Baby(Player player) {
        super(player);
        timeLower = 10;
        timeUpper = 20;
        actMark = 0 + getRandomNumberInRange(timeLower * 60, timeUpper * 60); // initial value between 10-20 seconds
    }
    
    public void act() {
        actCount++; // 60 acts = 1 second
        if (actCount == actMark) {
            eat();
            getNextActMark(timeLower, timeUpper);
        }
    }
    
    /**
     * Eats (takes) 20-40 cookies from the other player.
     */
    public void eat() {
        int amountToEat = getRandomNumberInRange(20, 40);
        CookieWorld cw = (CookieWorld)getWorld();
        Player otherPlayer = cw.getOtherPlayer(player);
        otherPlayer.setCookieCount(otherPlayer.getCookieCount() - amountToEat);
    }
}
