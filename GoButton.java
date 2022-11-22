import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GoMenuButton here.
 * 
 * @author Caden Chan 
 * @version 2022.11.22
 */
public class GoButton extends MenuButton
{
    public GoButton() {
        // Load images
        image = new GreenfootImage("menu/button/gobutton.png");
        hoverImage = new GreenfootImage("menu/button/gobutton-hover.png");
        clickedImage = new GreenfootImage("menu/button/gobutton-clicked.png");
        setImage(image);
    }
    public void act()
    {
        super.act();
    }
    public void clicked() {
        // setImage();
        ((WelcomeWorld)getWorld()).goToMenu();
    }
    public void checkHover() {
        super.checkHover();
    }
}
