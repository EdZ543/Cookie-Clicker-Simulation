import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cookie here.
 * 
 * @author Caden Chan
 * @version 2022.11.02
 */
public class Cookie extends Actor
{
    private int level;
    private int cookiesPerClick;
    private int animateCount;
    private final int ANIMATE_DURATION = 30; // how many acts the cookie is enlargened for
    private GreenfootImage image;
    public final String[] COOKIE_FILES = {"placeholder/cookie.png"};
    public final GreenfootImage[] COOKIE_SPRITES = getCookieImageArr();  // use level to index through array, and retrieve the corresponding image.
    
    public Cookie() {
        image = COOKIE_SPRITES[0];
        level = 1;
        animateCount = 0;
        cookiesPerClick = calculateCookieOutput();
        setImage(image);
    }
    
    public void act()
    {
        if(animateCount > 0) {
            
        }
    }
    /**
     * Animate sprite when `Cookie` is "clicked" by a `Clicker`
     */
    public void animateClick() {
        if(animateCount == 0) {
            animateCount = ANIMATE_DURATION;
        }
    }
    /**
     * Update the `Cookie`'s level to `int level` and calculate `cookiesPerClick` accordingly
     * @param level           The cookie's new level
     */
    public void updateLevel(int level) {
        this.level = level;
        cookiesPerClick = calculateCookieOutput();
        updateImage();
    }
    
    public int getLevel() {
        return level;
    }
    
    public int getCookieOutput() {
        return cookiesPerClick;
    }
    
    private int calculateCookieOutput() {
        return level * 5; // **TEMPORARY algorithm placeholder; must create balanced algorithm for deciding how many cookies each click will award the player, based on level.
    }
    
    private void updateImage() {
        this.image = COOKIE_SPRITES[level-1];
        // do things to update image visually
    }
    
    private GreenfootImage[] getCookieImageArr() {
        GreenfootImage[] images = new GreenfootImage[COOKIE_FILES.length];
        for(int i=0;i<images.length;i++) {
            images[i] = new GreenfootImage(COOKIE_FILES[i]);
        }
        return images;
    }
}
