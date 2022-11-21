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
    private int grandmas1 = 1;
    
    private int clickers2 = 2; 
    private int cps2 = 2;
    private int grandmas2 = 3;
    
    // World variables
    private GreenfootImage background;
    
    // Game variables
    // select random index of buyButtons to add respective building/activate respective powerup
    private BuyButton[] buyBuildingButtons, buyPowerupButtons, buySabotageButtons, cookieUpgradeButtons;
    private WinButton winButton;
    private Label buildingTitle, powerupTitle, sabotageTitle;
    private final int WIN = 1000000; // player must reach this amount of cookies to win
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
     *          },  ...etc.
     * }
     */
    
    public CookieWorld() throws MyException
    {   
        super(1200, 800, 1); 
        // Drawing Order of Classes
        setPaintOrder(Lag.class, Clicker.class, HoverArea.class, Description.class, BottleOfMilk.class, Effect.class, Building.class, Powerup.class, CooldownBar.class, Label.class, BuyButton.class, BuildingRow.class, Cookie.class);
        // Set world background
        background = new GreenfootImage("background0.png");
        setBackground(background);
        // - - - Prepare world data - - -
        // Initialize building hashmap
        buildingMap = new LinkedHashMap<Class, HashMap<String, Object>>();
        buildingMap.put(Grandma.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Grandma", 100}));
        buildingMap.put(Baby.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Baby", 300}));
        buildingMap.put(AlchemyLab.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Alchemy Lab", 1000}));
        buildingMap.put(Printer3D.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"3D Printer", 3500}));
        buildingMap.put(Portal.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Portal", 7500}));
        buildingMap.put(CookieGod.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Cookie God", 15000}));
        
        // Initialize powerup hashmap
        powerupMap = new LinkedHashMap<Class, HashMap<String, Object>>();
        powerupMap.put(CookieUpgrade.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Cookie Upgrade", 100}));
        powerupMap.put(WarmMits.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Warm Mits", 200}));
        powerupMap.put(ReverseDementia.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Reverse Dementia", 750}));
        powerupMap.put(ExtraExpensiveFilament.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Extra Expensive Filament", 1500}));
        powerupMap.put(LuckyClover.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Lucky Clover", 5000}));
        
        // Sabotages
        powerupMap.put(CookieMonster.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Cookie Monster", 3500}));
        powerupMap.put(GrandmaRevolution.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Grandma Revolution", 500}));
        powerupMap.put(Lag.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Lag", 1000}));
        powerupMap.put(MilkBottles.class, createHashmap(new String[]{"name", "cost"}, new Object[]{"Milk Bottles", 100})); // cost is 100 * number of babies
        
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
        p1 = new Player(412, getHeight(), clickers1, cps1, grandmas1, "Player 1", "red");
        p2 = new Player(420, getHeight(), clickers2, cps2, grandmas2, "Player 2", "blue");
        addObject(p1, 205, 400);
        addObject(p2, 990, 400);
        
        // - - - Draw Buttons - - -
        int btnX, btnY;
        for(int i=0;i<buyBuildingButtons.length;i++) {
            btnX = 495 + 100*(i%3);
            btnY = 100 + 84*(i/3);
            addObject(buyBuildingButtons[i], btnX, btnY);
        }
        for(int i=0;i<buyPowerupButtons.length;i++) {
            btnX = 546 + 100*(i%2);
            btnY = 330 + 84*(i/2);
            addObject(buyPowerupButtons[i], btnX, btnY);
        }
        for(int i=0;i<buySabotageButtons.length;i++) {
            btnX = 546 + 100*(i%2);
            btnY = 550 + 84*(i/2);
            addObject(buySabotageButtons[i], btnX, btnY);
        }
        for(int i=0;i<cookieUpgradeButtons.length;i++) {
            btnX = (cookieUpgradeButtons[i].getImage().getWidth()/2) + 355 + 790*i;
            btnY = 360;
            addObject(cookieUpgradeButtons[i], btnX, btnY);
        }
        winButton = new WinButton(CookieRocket.class, "Cookie Rocket", WIN);
        addObject(winButton, getWidth()/2 + 10, 710);
        // - - - Draw Subtitles for BuyButton Groups
        buildingTitle = new Label("Building shop", 30);
        powerupTitle = new Label("Powerup shop", 30);
        sabotageTitle = new Label("Sabotage shop", 30);
        // Label winTitle = new Label("Blast Off!", 30);
        addObject(buildingTitle, getWidth()/2, 30);
        addObject(powerupTitle, getWidth()/2, 260);
        addObject(sabotageTitle, getWidth()/2, 480);
        // addObject(winTitle, getWidth()/2, 745);
    }
    public void act() {
        handleActiveStateButtons();
        
    }
    /**
     * Returns the player that is NOT [Player thisPlayer].
     * E.g.: if p1 is passed in, return p2, and vice versa.
     * 
     * @param thisPlayer           The reference Player.
     * @return Player               The other player
     */
    public Player getOtherPlayer(Player thisPlayer) { // Used to get the affected player in the event of a sabotage
        return thisPlayer == p1 ? p2 : p1;
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
     * Return a <code>BuyButton</code> with the class of <code>sabotageClass</code>
     * 
     * @param sabotageClass         The subclass associated with the desired BuyButton
     * @return      BuyButton       The BuyButton with the subclass of sabotageClass
     */
    public BuyButton getSabotageButton(Class sabotageClass) {
        for(BuyButton btn: buySabotageButtons) {
            if(btn.getMySubclass() == sabotageClass) {
                return btn;
            }
        }
        return null;
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
     * Return ArrayList of Powerup subclasses from the <code>powerupMap</code> HashMap
     * 
     * @return ArrayList<Class>     Subclasses of Powerup
     */
    public ArrayList<Class> getPowerupClasses() {
        return new ArrayList<Class>(powerupMap.keySet());
    }
    /**
     * Return the CookieUpgrade BuyButton associated with the player
     * 
     * @param       player              The player whose button is being returned
     * @return      BuyButton           The BuyButton that activates player's CookieUpgrade
     */
    public BuyButton getPlayerUpgradeButton(Player player) {
        if(player == p1) {
            return cookieUpgradeButtons[0];
        }
        return cookieUpgradeButtons[1];
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
    /**
     * Loop through all BuyButtons. If neither player can afford it, then set it to inactive
     */
    private void handleActiveStateButtons() {
        int maxCookies = Math.max(p1.getCookieCount(), p2.getCookieCount());
        toggleButtonArray(buyBuildingButtons, maxCookies);
        toggleButtonArray(buyPowerupButtons, maxCookies);
        toggleButtonArray(buySabotageButtons, maxCookies);
        toggleButton(winButton, maxCookies);
        // CookieUpgrade BuyButtons are only affected by their respective players' cookie counts
        toggleButton(cookieUpgradeButtons[0], p1.getCookieCount());
        toggleButton(cookieUpgradeButtons[1], p2.getCookieCount());
    }
    /**
     * 
     * @param btn               The BuyButton being checked
     * @param cookieCount       If cookieCount is less than the button's cost, set to inactive; otherwise, set to active
     */
    public void toggleButton(BuyButton btn, int cookieCount) {
        if(btn.getMySubclass() == MilkBottles.class) {
            toggleMilkBottlesButton();
            return;
        }
        boolean state = cookieCount > btn.getCost();
        if(!btn.isMaxedOut()) {
            btn.setActive(state);
        }
    }
    /**
     * Loop the toggleButton() method for an array of buttons
     * 
     * @param btns              The array of BuyButtons being checked
     * @param cookieCount       Compare the cost of each BuyButton to this amount of cookies
     */
    private void toggleButtonArray(BuyButton[] btns, int cookieCount) {
        for(BuyButton btn: btns) {
            toggleButton(btn, cookieCount);
        }
    }
    public void toggleMilkBottlesButton() {
        BuyButton btn = getSabotageButton(MilkBottles.class);
        if((p1.getCookieCount() > MilkBottles.p1Cost && MilkBottles.p1Cost != 0) || (p2.getCookieCount() > MilkBottles.p2Cost && MilkBottles.p2Cost != 0)) {
            btn.setActive(true);
        } else {
            btn.setActive(false);
        }
    }
    // used for testing
    public Player getP1() {
        return p1;
    }
    
}
