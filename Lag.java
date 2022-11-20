import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Player's wifi becomes destabilized, and their clickers become debilitated for 3-5 seconds
 * 
 * @author Caden Chan
 * @version 2022.11.02
 */
public class Lag extends Sabotage
{
    private int blinkCount, blinkDuration;
    private GreenfootImage image;
    public Lag(Player origin) {
        super(origin);
        duration = Greenfoot.getRandomNumber(3) + 3; // 3-5 seconds
        image = new GreenfootImage("effect/lag0.png");
        setImage(image);
        blinkCount = 0;
        blinkDuration = 20;
        actCount = blinkDuration;
    }
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        target.lagClickers(duration);
        setLocation(target.getCookie().getX(), target.getCookie().getY()-20);
        // setLocation(target.getCookie().getX()+120, target.getCookie().getY()-100); --> will use this if i decide on lag1.png
    }
    public void act() {
        actCount++;
        if(actCount % 50 == 0) {
            blinkCount = blinkDuration;
            image.setTransparency(0);
        }
        if(blinkCount > 0) {
            blinkCount --;
            if(blinkCount == 0) {
                image.setTransparency(255);
            }
        }
        if(actCount == duration*60 + (duration*60)%50) { // add (duration*60)%50 to time removal of Lag object with blinking
            getWorld().removeObject(this);
        }
    }
}
