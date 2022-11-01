import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Takes other player's cookies.
 * Every 10-20 seconds, “eats” away 20-40 cookies.
 * 
 * @author Patrick Hu
 * @version November 2022
 */
public class Baby extends Building
{
    private int actMark;
    
    public Baby() {
        actMark = 0 + getRandomNumberInRange(10 * 60, 20 * 60); // initial value between 10-20 seconds
    }
    
    public void act() {
        actCount++; // 60 acts = 1 second
        if (actCount == actMark) {
            eat();
        }
    }
    
    /**
     * Eats (takes) 20-40 cookies from the other player.
     */
    public void eat() {
        // eat 20-40 cookies from the other player
        
        // get a random amount of time between 10-20 seconds
        int t = getRandomNumberInRange(10 * 60, 20 * 60);
        actMark = actCount + t;
    }
}
