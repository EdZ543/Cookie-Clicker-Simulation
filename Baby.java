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
    public Baby(Player player) {
        super(player);
        
        setImage("./images/placeholder/baby.png");
    }
    
    public void act() {
        super.act();
        if (actCount == actMark) {
            eat();
            actMark = getNextActMark(10, 20);
        }
    }
    
    /**
     * Eats (takes) 20-40 cookies from the other player.
     */
    public void eat() {
        int amountToEat = getRandomNumberInRange(20, 40);
        CookieWorld cw = (CookieWorld)getWorld();
        Player otherPlayer = cw.getOtherPlayer(player);
        otherPlayer.changeCookieCount(-amountToEat);
    }
}
