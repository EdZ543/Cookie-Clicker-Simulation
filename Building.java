import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Building here.
 * 
 * @author Patrick Hu
 * @version November 2022
 */
public abstract class Building extends SuperSmoothMover
{
    protected static boolean LUCKY = false;
    
    protected int animationSize;
    protected int animationIndex;
    protected double scale; // scale of each image in the building's gif animation
    protected Player player;
    protected int actCount;
    protected int actMark;
    
    public Building(Player player) {
        this.player = player;
        actCount = 0;
        actMark = 1;
        animationIndex = 1;
    }
    
    public void act() {
        super.act();
        actCount++;
    }
    
    /**
     * Changes player's cookie count by amount this building will produce.
     * If lucky clover powerup is active, will produce upper bound of range specified.
     * 
     * @param start     lower bound of the range of production
     * @param end       upper bound of the range of production
     */
    public void produce(int start, int end) {
        int amount;
        if (Building.LUCKY) {
            amount = end;
        }
        else {
            amount = getRandomNumberInRange(start, end);
        }
        
        player.changeCookieCount(amount);
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
    
    public void animate() {
        String className = this.getClass().getSimpleName();
        if (actCount % 11 == 0 || actCount < 11) {
            setImage("./gifs/" + className + "/" + animationIndex + ".png");
            getImage().scale((int)(getImage().getWidth() * scale), (int)(getImage().getHeight() * scale));
        }
        animationIndex++;
        animationIndex %= animationSize;
    }
}
