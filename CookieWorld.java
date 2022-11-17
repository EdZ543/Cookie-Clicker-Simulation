import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
/** 
 * Credits
 * - Images
 *   - Background image from the original Cookie Clicker by Orteil, provided by caveman at https://wallpapercave.com/cookie-clicker-wallpapers
 *   - Cursor image provided by Tobias Ahlin Bjerrome at https://tobiasahlin.com/blog/common-mac-os-x-lion-cursors/
 *   - Spinning wheel of death provided by howdytom at https://apple.stackexchange.com/questions/243675/location-of-the-resource-files-for-the-spinning-wait-cursor
 * - Code
 * 
 * @author Patrick Hu, Eddie Zhuang, Caden Chan, Jonathan Zhao
 * @version 2022.11.14
 */
public class CookieWorld extends World
{
    // Variable adjustments from menu (temporary, will be passed in from constructor)
    private int clickers1 = 3; 
    private int cps1 = 1;
    private int grandmas1 = 4;
    
    private int clickers2 = 2; 
    private int cps2 = 2;
    private int grandmas2 = 2;
    
    // World variables
    private GreenfootImage background;
    
    // Game variables
    // select random index of buyButtons to add respective building/activate respective powerup
    private BuyButton[] buyBuildingButtons, buyPowerupButtons, buySabotageButtons, cookieUpgradeButtons;
    
    private Label buildingTitle, powerupTitle, sabotageTitle;
    
    // Player variables
    private Player p1, p2;
    
    // Master lists of Building/Powerup classes
    private LinkedHashMap<Class, HashMap<String, Object>> buildingMap;
    private LinkedHashMap<Class, HashMap<String, Object>> powerupMap;
    /**
     * {
     *      AlchemyLab.class: {
     *          "name": "Alchemy Lab",
     *          "cost": 10
     *          }, 
     * }
     */
    
    public CookieWorld() throws MyException
    {   
        super(1200, 800, 1); 
        
        // Drawing Order of Classes
        setPaintOrder(Clicker.class, Building.class, Powerup.class, CooldownBar.class, BuyButton.class, Label.class, BuildingRow.class, Cookie.class);
        // Set world background
        background = new GreenfootImage("background0.png");
        setBackground(background);
        // - - - Prepare world data - - -
        // Initialize building hashmap
        buildingMap = new LinkedHashMap<Class, HashMap<String, Object>>();
        buildingMap.put(AlchemyLab.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Alchemy Lab", 100}));
        buildingMap.put(Baby.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Baby", 100}));
        buildingMap.put(CookieGod.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Cookie God", 100}));
        buildingMap.put(Grandma.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Grandma", 100}));
        buildingMap.put(Portal.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Portal", 100}));
        buildingMap.put(Printer3D.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"3D Printer", 100}));
        // Initialize powerup hashmap
        powerupMap = new LinkedHashMap<Class, HashMap<String, Object>>();
        powerupMap.put(CookieUpgrade.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Cookie Upgrade", 100}));
        powerupMap.put(GingerbreadMan.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Gingerbread Man", 100}));
        powerupMap.put(HandCream.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Hand Cream", 100}));
        powerupMap.put(LuckyClover.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Lucky Clover", 100}));
        powerupMap.put(MilkBottles.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Milk Bottles", 100}));
        powerupMap.put(ReverseDementia.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Reverse Dementia", 100}));
        powerupMap.put(CookieMonster.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Cookie Monster", 100}));
        powerupMap.put(GrandmaRevolution.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Grandma Revolution", 100}));
        powerupMap.put(Lag.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Lag", 100}));
        powerupMap.put(StealShipment.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Steal Shipment", 100}));
        
        // - - - Initialize BuyButton arrays - - -
        // Building Buttons
        buyBuildingButtons = initBuyButtons(getBuildingClasses());
        // Powerup Buttons
        ArrayList<Class> tempPowerups = getPowerupClasses(); // powerups omitting CookieUpgrade.class
        tempPowerups.removeIf(p -> Sabotage.class.isAssignableFrom(p)); // omit sabotages
        tempPowerups.removeIf(p -> p == CookieUpgrade.class);
        buyPowerupButtons = initBuyButtons(tempPowerups);  // omit CookieUpgrade class; dealt with separately in next line
        // Sabotage Buttons
        ArrayList<Class> tempSabotages = getPowerupClasses();
        tempSabotages.removeIf(p -> !Sabotage.class.isAssignableFrom(p));  // p is not an instance of Sabotage, remove
        buySabotageButtons = initBuyButtons(tempSabotages);
        // Cookie Upgrade Buttons
        cookieUpgradeButtons = initBuyButtons(new ArrayList<Class>(Arrays.asList(CookieUpgrade.class, CookieUpgrade.class)));  // two buttons for CookieUpgrade class (one for each player)
        
        // - - - Initialize players - - -
        p1 = new Player(400, getHeight(), clickers1, cps1, grandmas1, "Player 1", "red");
        p2 = new Player(400, getHeight(), clickers2, cps2, grandmas2, "Player 2", "blue");
        addObject(p1, 205, 400);
        addObject(p2, 990, 400);
        
        // - - - Draw Buttons - - -
        int btnX, btnY;
        for(int i=0;i<buyBuildingButtons.length;i++) {
            btnX = 495 + 100*(i%3);
            btnY = 110 + 84*(i/3);
            addObject(buyBuildingButtons[i], btnX, btnY);
        }
        for(int i=0;i<buyPowerupButtons.length;i++) {
            btnX = buyPowerupButtons.length - i < 3 ? 546 + 100*(i%2) : 495 + 100*(i%3);
            btnY = 350 + 84*(i/3);
            addObject(buyPowerupButtons[i], btnX, btnY);
        }
        for(int i=0;i<buySabotageButtons.length;i++) {
            btnX = 546 + 100*(i%2);
            btnY = 590 + 84*(i/2);
            addObject(buySabotageButtons[i], btnX, btnY);
        }
        for(int i=0;i<cookieUpgradeButtons.length;i++) {
            btnX = (cookieUpgradeButtons[i].getImage().getWidth()/2) + 360 + 780*i;
            btnY = 360;
            addObject(cookieUpgradeButtons[i], btnX, btnY);
        }
        // - - - Draw Subtitles for BuyButton Groups
        buildingTitle = new Label("Building shop", 30);
        powerupTitle = new Label("Powerup shop", 30);
        sabotageTitle = new Label("Sabotage shop", 30);
        addObject(buildingTitle, getWidth()/2, 30);
        addObject(powerupTitle, getWidth()/2, 270);
        addObject(sabotageTitle, getWidth()/2, 510);
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
     * Method buys a random Building for [Player p], if the player can afford it.
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
     * 
     * 
     * @param itemClass         The subclass of Building or Powerup whose cost is being returned
     * @return int              The cost in cookies, pertaining to the subclass `itemClass`
     */
    public int getItemCost(Class itemClass) {
        if(Building.class.isAssignableFrom(itemClass)) { // check if itemClass is a subclass of Building
            return (int)buildingMap.get(itemClass).get("cost");
        }
        if(Powerup.class.isAssignableFrom(itemClass)) { // check if itemClass is a subclass of Powerup
            return (int)powerupMap.get(itemClass).get("cost");
        }
        return -1;
    }
    /**
     * Returns the name of [Class itemClass] by retrieving its [public static int COST] field
     * 
     * 
     * @param itemClass         The subclass of Building or Powerup whose cost is being returned
     * @return String           The name pertaining to the subclass `itemClass`
     */
    public String getItemName(Class itemClass) {
        if(Building.class.isAssignableFrom(itemClass)) { // check if itemClass is a subclass of Building
            return (String)buildingMap.get(itemClass).get("name");
        }
        if(Powerup.class.isAssignableFrom(itemClass)) { // check if itemClass is a subclass of Powerup
            return (String)powerupMap.get(itemClass).get("name");
        }
        return null;
    }
    
    /**
     * Return an array of new `BuyButton`s, for each subclass in [Class[] itemClasses] (either `BUIDLING_CLASSES` or `POWERUP_CLASES`)
     * 
     * @param itemClasses           Array containing subclasses of Building or Powerup
     * @return BuyButton[]          Array of buttons for each subclass in `itemClasses`
     */
    public BuyButton[] initBuyButtons(ArrayList<Class> itemClasses) {
        BuyButton[] buttons = new BuyButton[itemClasses.size()];
        for(int i=0;i<buttons.length;i++) {
            Class c = itemClasses.get(i);
            BuyButton btn = new BuyButton(c, getItemName(c), getItemCost(c));
            buttons[i] = btn;
        }
        return buttons;
    }
    /**
     * Return ArrayList of Building subclasses from `buildingMap`
     * 
     * @return ArrayList<Class>     Subclasses of Building
     */
    public ArrayList<Class> getBuildingClasses() {
        return new ArrayList<Class>(buildingMap.keySet());
    }
    
    /**
     * Return ArrayList of Powerup subclasses from `powerupMap`
     * 
     * @return ArrayList<Class>     Subclasses of Powerup
     */
    public ArrayList<Class> getPowerupClasses() {
        return new ArrayList<Class>(powerupMap.keySet());
    }
    
    /**
     * Create a HashMap from an array of keys and values. The `keys` and `values` arrays must have the same lengths
     * 
     * @param keys                              Array of keys, as Strings (i.e. index names).
     * @param values                            Array of values
     * @return HashMap<String, Object>          HashMap comprised of the keys and values from the provided arrays
     */
    private HashMap<String, Object> createHashmap(String[] keys, Object[] values) throws MyException {
        if(keys.length != values.length) {
            throw new MyException("method: createHashmap\nproblem: keys & values arrays must be of equal length");
        }
        LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
        for(int i=0;i<keys.length;i++ ){
            map.put(keys[i], values[i]);
        }
        return map;
    }
    
}
