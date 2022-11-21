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
    private boolean isDrinkingMilk; // whether the baby was given a milk bottle
    
    public Baby(Player player) {
        super(player);
        animationSize = 11;
        scale = 0.5;
        isDrinkingMilk = false;
    }
    
    public void act() {
        super.act();
        if (actCount == actMark) {
            eat();
            actMark = getNextActMark(1, 1);
        }
        
        if (isDrinkingMilk) {
            fade();
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
            amountToEat = getRandomNumberInRange(70, 90);   
        }
        
        CookieWorld cw = (CookieWorld)getWorld();
        Player otherPlayer = cw.getOtherPlayer(player);
        otherPlayer.changeCookieCount(-amountToEat);
    }
    
    /**
     * Changes baby's image to it drinking a bottle of milk. This happens when the 
     * Milk Bottles powerup is activated.
     */
    public void drinkMilk() {
        setImage("./images/baby-drinking-milk.png");
        isDrinkingMilk = true;
    }
    
    /**
     * Gradually fades out the baby and then removes it from the world.
     */
    public void fade() {
        int curTransparency = getImage().getTransparency();
        if (curTransparency == 0) {
            getWorld().removeObject(this);
            return;
        }
        int newTransparency = getImage().getTransparency() - 5;
        if (actCount % 15 == 0) {
            getImage().setTransparency(newTransparency);
        }
    }
}
