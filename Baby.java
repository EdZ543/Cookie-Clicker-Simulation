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
    private int drinkingCount, drinkingActs;
    private GreenfootImage drinkingSprite;
    public Baby(Player player) {
        super(player);
        animationSize = 11;
        scale = 0.5;
        isDrinkingMilk = false;
        drinkingCount = 0;
        drinkingActs = 90;
    }
    
    public void act() {
        super.act();
        if(drinkingCount == 0 && isDrinkingMilk) {
            player.getBuildingRows().get(Baby.class).getBuildings().remove(this);
            getWorld().removeObject(this);
        } else if (drinkingCount <= drinkingActs && isDrinkingMilk) {
            Effect.fade(drinkingSprite, drinkingCount, drinkingActs);
        } else {
            if (actCount == actMark) {
                eat();
                actMark = getNextActMark(1, 1);
            }
        }
        if(isDrinkingMilk) {
            setImage(drinkingSprite);
            drinkingCount --;
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
        drinkingSprite = new GreenfootImage("powerup-icns/baby-drinking-milk.png");
        drinkingSprite.scale(50, 50);
        setImage(drinkingSprite);
        isDrinkingMilk = true;
        drinkingCount = 120;
    }
    
    // /**
     // * Gradually fades out the baby and then removes it from the world.
     // */
    // public void fade() {
        // int curTransparency = getImage().getTransparency();
        // if (curTransparency == 0) {
            // getWorld().removeObject(this);
            // return;
        // }
        // int newTransparency = getImage().getTransparency() - 5;
        // if (actCount % 15 == 0) {
            // getImage().setTransparency(newTransparency);
        // }
    // }
}
