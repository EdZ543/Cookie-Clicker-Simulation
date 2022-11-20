import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Visual effect for the CookieUpgrade and LuckyClover Powerups
 * 
 * @author Caden Chan
 * @version 2022.11.19
 */
public class Sparkle extends Effect
{
    private Actor target;
    public Sparkle(int duration, Actor target) {
        this(duration, target, false);
    }
    public Sparkle(int duration, Actor target, boolean isLucky) {
        this.duration = duration;
        this.target = target;
        fadeLen = duration > 90 ? 90 : duration/2;  // i.e. fade after 90 acts OR [duration/2] acts
        String filePath = isLucky ? "effect/sparkles/luckysparkles" :"effect/sparkles/sparkles";
        image = new GreenfootImage(filePath + Greenfoot.getRandomNumber(4) + ".png");
        setImage(image);
    }
    public void addedToWorld(World w) {
        int[] pos = getRandomPos();
        setLocation(pos[0], pos[1]);
    }
    public void act()
    {
        if (duration == 0){
            getWorld().removeObject(this);
        } else if (duration <= fadeLen){
            fade (image, duration, fadeLen);
        }
        duration--;
    }
    public int[] getRandomPos() {
        int[] pos = new int[2];
        int w = target.getImage().getWidth();
        int h = target.getImage().getHeight();
        pos[0] = target.getX() - w/2 + Greenfoot.getRandomNumber(w);  // x-val
        pos[1] = target.getY() - h/2 + Greenfoot.getRandomNumber(h);  // y-val
        return pos;
    }
}
