import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BottleOfMilk here.
 * 
 * @author Caden Chan
 * @version 2022.11.19
 */
public class BottleOfMilk extends Effect
{
    private int startX, startY, endX, endY;
    private Baby baby;
    private GreenfootImage image;
    // Variables for movement calculations
    private double dx, dy, vix, viy, ay, t;
    private double x, y;
    public BottleOfMilk(int startX, int startY, Baby baby) {
        this.startX = startX;
        this.startY = startY;
        this.baby = baby;
        this.endX = baby.getX();
        this.endY = baby.getY();
        x = startX;
        y = startY;
        dx = endX - startX;
        dy = endY - startY;
        ay = 30.0/60;
        t = 1.2*60;
        /**
         * projectile motion equations 
         * dy = viy * t + (1/2)a * t^2
         * viy = (dy-(1/2a)*t^2)/t
         * 
         * dx = vix * t
         * vix = dx/t
         */
        viy = (dy - 0.5*ay*t*t)/t;
        vix = dx/t;
        image = new GreenfootImage("placeholder/bottleofmilk.png");
        setImage(image);
    }
    public void addedToWorld(World w) {
        setLocation(startX,startY);
    }
    public void act()
    {
        setLocation((int)x, (int)y);
        y += viy;
        x += vix;
        viy += ay;
        if(baby.getWorld() == null || y > baby.getY()) {
            // baby.giveMilk();
            getWorld().removeObject(this);
            return;
        }
    }
}
