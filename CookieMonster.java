import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CookieMonster here.
 * 
 * @author Caden Chan
 * @version 2022.11.02
 */
public class CookieMonster extends Sabotage
{
    private final int TAKEN_COOKIES = 200;
    public CookieMonster(Player origin) {
        super(origin);
    }
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        target.changeCookieCount(-TAKEN_COOKIES);
    }
    
    public void act() {
        actCount ++;
        animate();
        if(actCount == duration*60) {
            getWorld().removeObject(this);
        }
        
    }
    public void animate() {
        // show cookie monster walking past
    }
}
