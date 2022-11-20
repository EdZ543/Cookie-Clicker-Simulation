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
    private double scale = 1; // can set to a smaller value to scale down image, however quality drastically reduces
    
    public Description(Class itemClass) {
        String s = itemClass.getSimpleName();
        switch (s) {
            case "Grandma":
                setImage("./images/descriptions/grandma.png");
                break;
            case "Baby":
                setImage("./images/descriptions/baby.png");
                break;
            case "AlchemyLab":
                setImage("./images/descriptions/alchemy-lab.png");
                break;
            case "Printer3D":
                setImage("./images/descriptions/printer3D.png");
                break;
            case "Portal":
                setImage("./images/descriptions/portal.png");
                break;
            case "CookieGod":
                setImage("./images/descriptions/cookie-god.png");
                break;
        }
        
        getImage().scale((int)(getImage().getWidth() * scale), (int)(getImage().getHeight() * scale));
    }
}

/*
 * Colours used in the description:
 * Blue: #4086fa
 * Green: #1b9902
 * Pink: #f0129a
 * Purple: #    
 */
