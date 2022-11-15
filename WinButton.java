import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Type of BuyButton which is used only for the win condition (i.e. the Cookie Rocket).
 * Has a different visual appearance than other `BuyButton`'s
 * 
 * @author (Caden Chan) 
 * @version (2022.11.14)
 */
public class WinButton extends BuyButton
{
    public WinButton(Class mySubclass, String name, int cost) {
        super(mySubclass, name, cost);
    }
    public void addedToWorld(World w) {
        // set up button image
        image = new GreenfootImage("buybutton-icns/btn-bg.png");
        icnFile = "buybutton-icns/" + mySubclass.getSimpleName().toLowerCase() + ".png";
        icn = new GreenfootImage(icnFile);
        image.drawImage(icn, (image.getWidth()-icn.getWidth())/2, (image.getHeight()-icn.getHeight())/2);
        setImage(image);
    }
    public void act()
    {
        // Add your action code here.
    }
}
