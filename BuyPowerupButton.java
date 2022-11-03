import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuyPowerupButton here.
 * 
 * @author Caden
 * @version Nov 2, 2022
 */
public class BuyPowerupButton extends BuyButton
{
    private Powerup powerup;
    public BuyPowerupButton(Powerup powerup) {
        this.powerup = powerup;
    }
    public void act()
    {
        super.act();
    }
    /**
     * Highlight button & activate powerup for [Player p]
     * - For when the Player activating the butotn is the Player who receives the powerup
     * @param p        The Player instance that has activated this button
     */
    public void click(Player p) {
        click(p, p);
    }
    /**
     * Highlight button & add building to [target p]'s collection
     * @param p         The Player instance that has activated this button
     * @param target    The Player instance that receives the powerup
     */
    public void click(Player p, Player target) {
        // highlight button with player colour
        // add buidling to target's collection
    }
}
