import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An image of a description for an item that will be displayed when the simulation 
 * viewer hovers over a buy button.
 * 
 * @author Patrick Hu
 * @version November 2022
 */
public class Description extends Clickable
{
    public Description(Class itemClass) {
        String s = itemClass.getSimpleName();
        switch (s) {
            case "Grandma":
                setImage("./images/descriptions/grandma.png");
                break;
        }
    }
    
    public void act() {
        
    }
}
