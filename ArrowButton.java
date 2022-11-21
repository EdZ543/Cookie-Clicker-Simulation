import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ArrowButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrowButton extends MenuButton
{
    public ArrowButton(boolean isLeft) {
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
        
    }
    public void checkHover() {
        super.checkHover();
    }
    
}
