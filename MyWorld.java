import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * Credits
 * - Images
 *   - Background image from the original Cookie Clicker by Orteil, provided by caveman at https://wallpapercave.com/cookie-clicker-wallpapers
 *   - Cursor image provided by Tobias Ahlin Bjerrome at https://tobiasahlin.com/blog/common-mac-os-x-lion-cursors/
 *   - Spinning wheel of death provided by howdytom at https://apple.stackexchange.com/questions/243675/location-of-the-resource-files-for-the-spinning-wait-cursor
 * 
 * @author Patrick Hu, Eddie Zhuang, Caden Chan, Jonathan Zhao
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    // World variables
    GreenfootImage background;
    
    // Game variables
    BuyButton[] buyButtons;  // select random index of buyButtons to add respective buidling/activate respective powerup
    
    // Player variables
    Player p1, p2;
    public MyWorld()
    {    
        super(1200, 800, 1); 
        // Set world background
        background = new GreenfootImage("background0.png");
        setBackground(background);
        // Initialize BuyButton array
        buyButtons = new BuyButton[19];  // one button for each building & powerup.
    }
    /**
     * Returns the player that is NOT [Player thisPlayer].
     * E.g.: if p1 is passed in, return p2, and vice versa.
     * 
     * @param thisPlayer           The reference Player.
     */
    public Player getOtherPlayer(Player thisPlayer) { // Used to get the affected player in the event of a sabotage
        return thisPlayer == p1 ? p2 : p1;
    }
}
