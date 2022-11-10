import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuyButton here.
 * 
 * @author Caden Chan
 * @version 2022.11.02
 */
public class BuyButton extends Actor
{
    private int cooldown;  // if cooldown > 0, cannot activate button.
    private int highlightClick;  // highlightClick tracks how many acts the button needs to be highlighted for, after being clicked by a player
    private boolean active;  // if neither player can afford the upgrade, grey-out the button
    // info that will be displayed: cost, subclass name, icon
    private int cost;
    private Class mySubclass;  // the subclass associated with the button (either a subclass of Builidng or a subclass of Powerup)
    private String name;
    // Button Attributes
    private final int WIDTH = 100, HEIGHT = 100;
    private String icnFile;
    private GreenfootImage icn;
    private GreenfootImage image;
    private Font nameFont, costFont;
    private Color bgColor, textColor;
    public BuyButton(Class mySubclass, String name, int cost) {
        this.mySubclass = mySubclass;
        this.name = name;
        this.cost = cost;
        nameFont = new Font(CookieWorld.FONT_NAME, 20);
        costFont = new Font(CookieWorld.FONT_NAME, 16);
        bgColor = new Color(117, 83, 61); // temp --> will be replaced by png background image for buttons
        textColor = Color.WHITE;
        // set up button image
        image = new GreenfootImage("buybutton-icns/btn-bg.png");
        icnFile = "buybutton-icns/" + mySubclass.getSimpleName().toLowerCase() + ".png";
        icn = new GreenfootImage(icnFile);
        image.drawImage(icn, 10, 10);
        // image.setColor(bgColor);
        // image.fill();
        setImage(image);
        setText(name, nameFont, 80, nameFont.getSize()+10);
        setText("Cost: " + cost, costFont, 80, nameFont.getSize() + costFont.getSize()+20);
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
    public void act() {
        if(cooldown > 0) {
            cooldown --;
        }
    }
    public Class getMySubclass() {
        return mySubclass;
    }
    
    public int getCost() {
        return cost;    
    }
    public void setText(String text, Font font) {
        setText(text, font, 0, font.getSize());
    }
    public void setText(String text, Font font, int x, int y) {
        image.setFont(font);
        image.setColor(textColor);
        image.drawString(text, x, y);
    }
}
