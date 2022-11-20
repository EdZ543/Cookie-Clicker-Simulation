import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Visual effect for the CookieUpgrade Powerup
 * 
 * @author Caden Chan
 * @version 2022.11.19
 */
public class Sparkle extends Effect
{
    private Cookie cookie;
    public Sparkle(int duration, Cookie cookie) {
        this.duration = duration;
        this.cookie = cookie;
        fadeLen = duration > 90 ? 90 : duration/2;  // i.e. fade after 90 acts OR [duration/2] acts
        image = new GreenfootImage("effect/sparkles/sparkles" + Greenfoot.getRandomNumber(4) + ".png");
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
            fade (duration, fadeLen);
        }
        duration--;
    }
    public int[] getRandomPos() {
        int[] pos = new int[2];
        int w = cookie.getImage().getWidth();
        int h = cookie.getImage().getHeight();
        pos[0] = cookie.getX() - w/2 + Greenfoot.getRandomNumber(w);  // x-val
        pos[1] = cookie.getY() - h/2 + Greenfoot.getRandomNumber(h);  // y-val
        return pos;
    }
}
