import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ending animation when a player wins
 * 
 * @author Eddie Zhuang
 * @version (a version number or a date)
 */
public class EndWorld extends World
{
    private GreenfootImage canvas;
    private Font font = new Font(20);

    /**
     * Constructor for objects of class EndWorld.
     * 
     * @param player The player who won
     */
    public EndWorld(Player player)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        // Draw scene
        canvas = new GreenfootImage(getWidth(), getHeight());
        canvas.drawString(player.getName() + "wins!", 300, 100);
        setBackground(canvas);
    }
}
