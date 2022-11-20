import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cookie here.
 * 
 * @author Caden Chan
 * @version 2022.11.14
 */
public class Cookie extends Clickable
{
    private int level, cookiesPerClick, animateCount, originalSize;
    private final int maxLevel = 10;
    private final int ANIM_DURATION = 5; // how many acts the cookie is enlargened for
    private final int ANIM_FACTOR = 30; // increase image by how many pixels on click
    private GreenfootImage image;
    private Player player;
    private BuyButton myUpgradeBtn;
    public final String[] COOKIE_FILES = {"placeholder/cookie.png", "placeholder/cookie.png", "placeholder/cookie.png", 
        "placeholder/cookie.png", "placeholder/cookie.png", "placeholder/cookie.png", "placeholder/cookie.png", 
        "placeholder/cookie.png", "placeholder/cookie.png", "placeholder/cookie.png"};
    public final GreenfootImage[] COOKIE_SPRITES = getCookieImageArr();  // use level to index through array, and retrieve the corresponding image.
    
    /**
     * @param player            Player to whom this cookie belongs
     */
    public Cookie(Player player) {
        this.player = player;
        image = COOKIE_SPRITES[0];
        level = 1;
        originalSize = image.getWidth();
        animateCount = 0;
        cookiesPerClick = calculateCookieOutput();
        setImage(image);        
    }
    public void addedToWorld(World w) {
        myUpgradeBtn = ((CookieWorld)getWorld()).getPlayerUpgradeButton(player);
        myUpgradeBtn.setCost(getUpgradeCost()); // initialize cookie cost
    }
    public void act()
    {
        // !Uncomment for testing purposes
        // if(Greenfoot.mouseClicked(this)){
            // if(animateCount == 0) {
                // animateCount = ANIM_DURATION;
                // image.scale(originalSize + ANIM_FACTOR, originalSize + ANIM_FACTOR);
                // setImage(image);
            // }
        // }
        if(animateCount > 0) {
            animateCount --;
            if(animateCount == 0) {
                image.scale(originalSize, originalSize);
                setImage(image);
            }
        }
    }
    /**
     * Animate sprite when `Cookie` is "clicked" by a `Clicker`
     */
    public void click() {
        // if(animateCount == 0) {
        animateCount = ANIM_DURATION;
        image.scale(originalSize + ANIM_FACTOR, originalSize + ANIM_FACTOR);
        setImage(image);
        // }
        player.changeCookieCount(cookiesPerClick);
    }
    /**
     * Increase the `Cookie`'s level and calculate `cookiesPerClick` accordingly
     */
    public void levelUp() {
        if(level == maxLevel) {
            return;
        }
        level += 1;
        cookiesPerClick = calculateCookieOutput();
        updateImage();
        myUpgradeBtn.setCost(getUpgradeCost());
        if(level == maxLevel) {
            myUpgradeBtn.setMaxedOut(true);
        }
    }
    
    /**
     * @return int          Number of cookies per click, dependant on the Cookie's level
     */
    private int calculateCookieOutput() {
        return (int)Math.pow(level, 3)*4; // **TEMPORARY algorithm placeholder; must create balanced algorithm for deciding how many cookies each click will award the player, based on level.
    }
    
    /**
     * Update the Cookie's image, depending on its `level`
     */
    private void updateImage() {
        image = COOKIE_SPRITES[level-1];
        setImage(image);
    }
    // - - - - - GETTERS - - - - - 
    /**
     * @return int          Cookie's current level
     */
    public int getLevel() {
        return level;
    }
    
    /**
     * @return int          Number of cookies per click
     */
    public int getCookieOutput() {
        return cookiesPerClick;
    }
    
    public int getUpgradeCost() {
        return 100 * (int)Math.pow(1.8, level); // equation tbd
    }
    
    /**
     * @return GreenfootImage[]     Initialize an array of Cookie images
     */
    private GreenfootImage[] getCookieImageArr() {
        GreenfootImage[] images = new GreenfootImage[COOKIE_FILES.length];
        for(int i=0;i<images.length;i++) {
            images[i] = new GreenfootImage(COOKIE_FILES[i]);
        }
        return images;
    }
}
