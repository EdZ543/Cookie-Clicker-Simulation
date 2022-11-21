import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Start the simulation!
 * 
 * @author Caden Chan 
 * @version 2022.11.21
 */
public class StartButton extends MenuButton
{
    public StartButton() {
        // Load images
        image = new GreenfootImage("menu/button/startbutton.png");
        hoverImage = new GreenfootImage("menu/button/startbutton-hover.png");
        clickedImage = new GreenfootImage("menu/button/startbutton-clicked.png");
        setImage(image);
    }
    public void act()
    {
        super.act();
    }
    public void clicked() {
        // setImage();
        Greenfoot.setWorld(new CookieWorld());
    }
    public void checkHover() {
        super.checkHover();
    }
}
