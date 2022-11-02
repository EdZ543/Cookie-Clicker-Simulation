import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Takes other player's cookies.
 * Every 10-20 seconds, eats away 20-40 cookies.
 * 
 * @author Patrick Hu
 * @version November 2022
 */
public class Baby extends Building
{    
    public Baby(Player player) {
        super(player);
        actMark = 0 + getRandomNumberInRange(10 * 60, 20 * 60); // initial value between 10-20 seconds
    }
    
    public void act() {
        actCount++; // 60 acts = 1 second
        if (actCount == actMark) {
            eat();
            getNextActMark(actCount, 10, 20);
        }
    }
    
    /**
     * Eats (takes) 20-40 cookies from the other player.
     */
    public void eat() {
        int amountToEat = getRandomNumberInRange(20, 40);
        // take away this amount of cookies from enemy player
    }
}
