import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuyBuildingButton here.
 * 
 * @author Caden Chan
 * @version 2022.11.02
 */
public class BuyBuildingButton extends BuyButton
{
    private Building building;
    public BuyBuildingButton(Building building) {
        this.building = building;
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
}
