import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Create a group of actors which work together to manage a setting. Includes:
 * - Arrow buttons (increase/decrease value of simulation setting)
 * - Counter (Text showing the value of the simulation setting)
 * - Title (What is the name of the setting?)
 * 
 * @author Caden Chan
 * @version 2022.11.22
 */
public class MenuSetting extends Actor
{
    private ArrowButton leftArrow, rightArrow;
    private Label counter, titleLabel;
    private int count, minVal, maxVal, x, y, player;
    private final int fontSize = 60;
    private final int spacing = 20;
    private int settingID;  // 0 = # of grandmas, 1 = # of clickers, 2 = cps
    /**
     * 
     * Note: The overall MenuSetting is centered on the <code>Label counter</code>.
     */
    public MenuSetting(int minVal, int maxVal, int x, int y, String title, int settingID, int player) {
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.x = x;
        this.y = y;
        this.settingID = settingID;
        this.player = player;
        count = minVal;
        leftArrow = new ArrowButton(true, this);
        leftArrow.setActive(false); // start as inactive, since initialized with count = minVal
        rightArrow = new ArrowButton(false, this);
        counter = new Label(count, fontSize);
        titleLabel = new Label(title, 40);
        setImage(new GreenfootImage(10,10));
    }
    public void addedToWorld(World w) {
        w.addObject(this, x, y);
        w.addObject(counter, x, y);
        w.addObject(titleLabel, x, y-100);
        w.addObject(leftArrow, x-leftArrow.getImage().getWidth() - spacing, y);
        w.addObject(rightArrow, x+rightArrow.getImage().getWidth() + spacing, y);
    }
    public int getCount() {
        return count;
    }
    public void incrCount() {
        count ++;
        if(count == maxVal) {
            rightArrow.setActive(false);
        }
        if(count == minVal+1) {
            leftArrow.setActive(true);
        }
        if(settingID == 0) {
            ((MenuWorld)getWorld()).addPreviewGrandma(this.player);
        } else if(settingID == 1) {
            ((MenuWorld)getWorld()).addPreviewClicker(this.player);
        } else if(settingID == 2) {
            ((MenuWorld)getWorld()).editSpeed(this.player, count);
        }
        counter.setValue(Math.min(count, maxVal));  // Math.min just to be safe, cant be greater than maxVal :b
    }
    public void decrCount() {
        count--;
        if(count == minVal) {
            leftArrow.setActive(false);
        }
        if(count == maxVal-1) {
            rightArrow.setActive(true);
        }
        if(settingID == 0) {
            ((MenuWorld)getWorld()).removePreviewGrandma(this.player);
        } else if(settingID == 1) {
            ((MenuWorld)getWorld()).removePreviewClicker(this.player);
        } else if(settingID == 2) {
            ((MenuWorld)getWorld()).editSpeed(this.player, count);
        }
        counter.setValue(Math.max(count, minVal));  // Math.max just to be safe, cant be less than minVal :b
    }
}
