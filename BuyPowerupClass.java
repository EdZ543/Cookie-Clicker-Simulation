import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/**
 * Write a description of class BuyBuildingButton here.
 * 
 * @author Caden Chan
 * @version 2022.11.02
 */
public class BuyPowerupClass extends BuyButton
{
    private Class powerupClass;
    public BuyPowerupClass(Class<Powerup> powerupClass) {
        this.powerupClass = powerupClass;
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
    
    public Powerup getPowerupInstance(Player p, Player target) {
        if(powerupClass == CookieUpgrade.class) {
            
        } else if(powerupClass == GingerbreadMan.class){
            
        } else if(powerupClass == HandCream.class) {
            
        } else if(powerupClass == LuckyClover.class) {
            
        } else if(powerupClass == MilkBottles.class) {
            
        } else if(powerupClass == ReverseDementia.class) {
            
        } else if(powerupClass == CookieMonster.class) {
            
        } else if (powerupClass == GrandmaRevolution.class) {
            
        } else if (powerupClass == Lag.class) {
            
        } else if (powerupClass == StealShipment.class) {
            
        } else if (powerupClass == YouthPotion.class) {
            
        }
        return null;
    }
}
