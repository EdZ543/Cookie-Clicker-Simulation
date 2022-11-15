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
    private final int TRNP = 60; // transparency
    private GreenfootImage image;
    private Color colour;
    public CooldownBar(int width, int height, int duration) {
        this.width = width;
        this.height = height;
        rate = 100.0/(duration*60);
        String c = "red";//p.getColour();
        if(c == "red") {
            colour = Color.RED;
        } else if(c == "red") {
            colour = Color.BLUE;
        }
        image = new GreenfootImage(width, height);
    }
    public void addedToWorld(World w) {
        percent = 100;
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
    public void drawBar() {
        image = new GreenfootImage(width, height);
        image.setTransparency(TRNP);
        image.setColor(colour);
        int newH = height * (int)percent / 100;
        image.fillRect(0, 0+ height-newH, width, newH);
        setImage(image);
    }
}