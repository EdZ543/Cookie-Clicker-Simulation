import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PreviewClicker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PreviewClicker extends PreviewActor
{
    private int speed;
    private int[] targetPosition;
    private boolean glidingOrClicking;
    private int clickingAnimationTimer, actCount, startX, startY, radius;
    private GreenfootImage image;
    public PreviewClicker(int radius, int speed) {
        this.radius = radius;
        image = new GreenfootImage("cursor.png");
        image.scale(30, 40);
        setImage(image);
        actCount = 0;
        this.speed = speed;
    }
    public void addedToWorld(World w) {
        startX = getX();
        startY = getY();
    }
    public void act()
    {
        if (gliding) {
            moveTowards(targetPosition[0], targetPosition[1], glideSpeed);
        
            // If it's close enough to the target, stop gliding
            if (distanceTo(targetPosition[0], targetPosition[1]) <= glideSpeed) {
                setLocation(targetPosition[0], targetPosition[1]);
                gliding = false;
            }
        }
        else if (glidingOrClicking) {
            clickingAnimationTimer++;
            
            if (clickingAnimationTimer == 60/speed) { // Shrink cursor, and click
                image.scale(20, 30);
                setImage(image);
                
            } else if (clickingAnimationTimer >= 120/speed) { // Unshrink cursor
                image.scale(30, 40);
                setImage(image);
                clickingAnimationTimer = 0;
                glidingOrClicking = false;
            }
        } 
        else if (actCount %60 == 0)  {
            glideAndClick();
        }
    }
    /**
     * Makes cursor glide to a actor and then click
     */
    public void glideAndClick() {
        targetPosition = getRandomPoint();
        startGlidingTo(targetPosition[0], targetPosition[1], speed);
        glidingOrClicking = true;
    }
    private int[] getRandomPoint() {
        
        double direction = Math.random() * (2 * Math.PI);
        int x = (int)(startX + Math.cos(direction) * radius);
        int y = (int)(startY + Math.sin(direction) * radius);
        int[] ret = {x, y};
        
        return ret;
    }
    public void setSpeed(int x) {
        speed = x;
    }
}
