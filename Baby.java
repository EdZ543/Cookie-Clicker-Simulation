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
        animationSize = 11;
        scale = 0.5;
    }
    
    public void act() {
        super.act();
        if (actCount == actMark) {
            eat();
            actMark = getNextActMark(3, 3);
        }
    }
    
    /**
     * Eats(removes) 20-40 cookies from the other player.
     */
    public void eat() {        
        int amountToEat;
        if (Building.LUCKY) {
            amountToEat = 70;
        }
        else {
            amountToEat = getRandomNumberInRange(50, 70);   
        }
        
        CookieWorld cw = (CookieWorld)getWorld();
        Player otherPlayer = cw.getOtherPlayer(player);
        otherPlayer.changeCookieCount(-amountToEat);
    }
}
