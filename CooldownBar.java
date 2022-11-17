import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Used exclusively by BuyButton.
 * 
 * @author Caden Chan 
 * @version 2022.11.15
 */
public class CooldownBar extends Actor
{
    private int width, height;
    private double percent, rate;
    private final int TRNP = 100; // transparency
    private GreenfootImage image;
    private Color colour;
    /**
     * @param width         width of the cooldown bar
     * @param height        height of the cooldown bar 
     * @param colour        cooldown bar colour overlay
     * @param duration      how long the cooldown effect is, in seconds
     */
    public CooldownBar(int width, int height, Color colour, double duration) {
        this.width = width;
        this.height = height;
        rate = 100.0/(duration*60);
        this.colour = colour;
        image = new GreenfootImage(width, height);
    }
    public void addedToWorld(World w) {
        percent = 100.0;
        drawBar();
    }
    public void act()
    {
        if(percent < 0) {
            getWorld().removeObject(this);
            return;
        }
        drawBar();
        percent -= rate;
        
    }
    /**
     * Draw bar based on value of `percent`
     */
    public void drawBar() {
        image = new GreenfootImage(width, height);
        image.setTransparency(TRNP);
        image.setColor(colour);
        int newH = height * (int)percent / 100;
        image.fillRect(0, 0+ height-newH, width, newH);
        setImage(image);
    }
    /**
     * @param d         Set duration to `d` seconds
     */
    public void setDuration(int d) {
        rate = 100.0/(d*60);
    }
}
