import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Type of BuyButton which is used only for the win condition (i.e. the Cookie Rocket).
 * Has a different visual appearance than other `BuyButton`'s
 * 
 * @author Caden Chan
 * @version 2022.11.14
 */
public class WinButton extends BuyButton
{
    public WinButton(Class mySubclass, String name, int cost) {
        super(mySubclass, name, cost);
    }
    public void addedToWorld(World w) {
        // set up button images
        activeImage = new GreenfootImage("buybutton-icns/win-btn.png");
        inactiveImage = new GreenfootImage("buybutton-icns/win-btn-off.png");
        setImage(activeImage);
        // add HoverArea object
        getWorld().addObject(hover, getX(), getY());
    }
    public void act()
    {
        if(active) {
            // do something to make it obvious that it's special
        }
    }
}
