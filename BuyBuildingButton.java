import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/**
 * Write a description of class BuyBuildingButton here.
 * 
 * @author Caden Chan
 * @version 2022.11.02
 */
public class BuyBuildingButton extends BuyButton
{
    private Class buildingClass;
    public BuyBuildingButton(Class<Building> buildingClass) {
        this.buildingClass = buildingClass;
    }
    public void act()
    {
        super.act();
    }
    /**
     * Highlight button & add building to [Player p]'s collection
     * - For when the Player who activates the button is the Player that receives the building
     * @param p        The Player instance that has activated this button
     */
    public void click(Player p) {
        click(p, p);
    }
    /**
     * Highlight button & add building to [target p]'s collection
     * @param p         The Player instance that has activated this button
     * @param target    The Player instance that receives the building
     */
    public void click(Player p, Player target) {
        // highlight button with player colour
        // add buidling to target's collection
    }
    
    public Building getBuildingInstance(Player p, Player target) {
        if(buildingClass == AlchemyLab.class) {
            
        } else if(buildingClass == Baby.class){
            
        } else if(buildingClass == Clicker.class) {
            
        } else if(buildingClass == CookieFactory.class) {
            
        } else if(buildingClass == CookieGod.class) {
            
        } else if(buildingClass == CookieRocket.class) {
            
        } else if(buildingClass == Grandma.class) {
            
        } else if (buildingClass == Printer3D.class) {
            
        }
        return null;
    }
}
