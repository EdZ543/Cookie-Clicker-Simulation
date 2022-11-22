import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ArrowButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrowButton extends MenuButton
{
    private boolean isLeft;
    private MenuSetting menuSetting;
    public ArrowButton(boolean isLeft, MenuSetting menuSetting) {
        this.isLeft = isLeft;
        this.menuSetting = menuSetting;
        String path = isLeft ? "leftarrow" : "rightarrow";
        image = new GreenfootImage("menu/button/" + path + ".png");
        hoverImage = new GreenfootImage("menu/button/" + path + "-hover.png");
        clickedImage = new GreenfootImage("menu/button/" + path + "-clicked.png");
        inactiveImage = new GreenfootImage("menu/button/" + path + "-off.png");
        setImage(image);
    }
    public void act()
    {
        super.act();
    }
    public void clicked() {
        if(isLeft) {
            menuSetting.decrCount();
        } else {
            menuSetting.incrCount();
        }
    }
    public void checkHover() {
        super.checkHover();
    }
    
}
