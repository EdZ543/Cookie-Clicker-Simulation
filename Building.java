import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Building here.
 * 
 * @author Eddie Zhuang
 * @version November 2022
 */
public abstract class Building extends SuperSmoothMover
{
    protected Player player;
    protected int actCount = 0;
    protected int actMark = 0;
    
    public Building(Player player) {
        this.player = player;
    }
    
    public void act() {
        actCount++;
    }
    
    /**
     * Gets a random number in the range from `start` to `end` inclusive.
     */
    public int getRandomNumberInRange(int start, int end) {
       int a = Greenfoot.getRandomNumber(end - start + 1);
       return start + a;
    }
    
    /**
     * Gets the next act mark for when a building performs its action by calculating a random amount of seconds 
     * between a `start` and `end`.
     * 
     * @param start         The lower bound for the range of time.
     * @param end           The upper bound for the range of time.
     */
    public int getNextActMark(int start, int end) {
        int t = getRandomNumberInRange(start * 60, end * 60);
        return actCount + t;
    }
}
