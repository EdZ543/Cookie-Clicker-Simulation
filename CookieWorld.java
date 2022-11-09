import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Arrays;
import java.util.ArrayList;
/** 
 * Credits
 * - Images
 *   - Background image from the original Cookie Clicker by Orteil, provided by caveman at https://wallpapercave.com/cookie-clicker-wallpapers
 *   - Cursor image provided by Tobias Ahlin Bjerrome at https://tobiasahlin.com/blog/common-mac-os-x-lion-cursors/
 *   - Spinning wheel of death provided by howdytom at https://apple.stackexchange.com/questions/243675/location-of-the-resource-files-for-the-spinning-wait-cursor
 * 
 * @author Patrick Hu, Eddie Zhuang, Caden Chan, Jonathan Zhao
 * @version November 2022
 */
public class CookieWorld extends World
{
    // World variables
    private GreenfootImage background;
    
    // Game variables
    // select random index of buyButtons to add respective buidling/activate respective powerup
    private BuyButton[] buyBuildingButtons;
    private BuyButton[] buyPowerupButtons;
    
    // Player variables
    private Player p1, p2;
    
    // Master lists of Building/Powerup classes
    public static final Class[] BUILDING_CLASSES = new Class[]{AlchemyLab.class, Baby.class, Clicker.class, 
        Portal.class, CookieGod.class, Grandma.class, Printer3D.class};
    public static final Class[] POWERUP_CLASSES = new Class[] {CookieUpgrade.class, GingerbreadMan.class, 
        HandCream.class, LuckyClover.class, MilkBottles.class, ReverseDementia.class, CookieMonster.class, 
        GrandmaRevolution.class, Lag.class, StealShipment.class, YouthPotion.class};   
    
    public CookieWorld() throws MyException
    {   
        super(1200, 800, 1); 
        // Set world background
        background = new GreenfootImage("background0.png");
        setBackground(background);
        // Initialize BuyButton array
        // buyButtons = new BuyButton[19];  // one button for each building & powerup.
        buyBuildingButtons = initBuyButtons(BUILDING_CLASSES);
        buyPowerupButtons = initBuyButtons(POWERUP_CLASSES);
        
        // Initialize players
        p1 = new Player();
        p2 = new Player();
        addObject(p1, 0, 0);
        addObject(p2, 0, 0);
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
    
    /**
     * Method buys a random Buidling for [Player p], if the player can afford it.
     * 
     * @param p             The player that is buying the buidling
     */    
    public void buyBuilding(Player p) {  // can be modified to make some purchases more/less likely than others
        ArrayList<BuyButton> adjustedBuyButtons = (ArrayList<BuyButton>)Arrays.asList(buyBuildingButtons);
        adjustedBuyButtons.removeIf(b -> b.getCost() > p.getCookieCount());
        int rand = Greenfoot.getRandomNumber(adjustedBuyButtons.size());
        Class buildingClass = adjustedBuyButtons.get(rand).getMySubclass();
        // do things
    }
    /**
     * Method buys a random Powerup for [Player p], if the player can afford it.
     * 
     * @param p             The player that is buying the powerup
     */   
    public void buyPowerup(Player p) {// can be modified to make some purchases more/less likely than others
        ArrayList<BuyButton> adjustedBuyButtons = (ArrayList<BuyButton>)Arrays.asList(buyPowerupButtons);
        adjustedBuyButtons.removeIf(b -> b.getCost() > p.getCookieCount());
        int rand = Greenfoot.getRandomNumber(adjustedBuyButtons.size());
        Class powerupClass = adjustedBuyButtons.get(rand).getMySubclass();
        // do things
    }
    /**
     * Returns the cost of [Class itemClass] by retrieving its [public static int COST] field
     * Throws `MyException` if `COST` field does not exist in `itemClass`
     * 
     * @param itemClass         The subclass of Building or Powerup whose cost is being returned
     */
    public static int getItemCost(Class itemClass) throws MyException{
        try {
            int cost = (int) itemClass.getField("COST").get(itemClass);
            return cost;
        } catch (IllegalArgumentException| IllegalAccessException | NoSuchFieldException| SecurityException e) { // condense 4 exceptions into one; gets called when public static COST is not defined in [Class itemClass]
            throw new MyException(itemClass.getSimpleName() + " does not have `COST` variable, or its `COST` variable is not public & static");
        }
    }
    /**
     * Return an array of new `BuyButton`s, for each subclass in [Class[] itemClasses] (either `BUIDLING_CLASSES` or `POWERUP_CLASES`)
     * Throws `MyException` if `getItemCost(Class itemClass)` requirements aren't met.
     * 
     * @param itemClasses           Array containing subclasses of Building or Powerup
     */
    public static BuyButton[] initBuyButtons(Class[] itemClasses) throws MyException{
        BuyButton[] buttons = new BuyButton[itemClasses.length];
        for(int i=0;i<buttons.length;i++) {
            Class c = itemClasses[i];
            BuyButton btn = new BuyButton(c, getItemCost(c));
            buttons[i] = btn;
        }
        return buttons;
    }
}
