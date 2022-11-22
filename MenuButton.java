import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuButton here.
 * 
 * @author Caden Chan 
 * @version 2022.11.21
 */
public abstract class MenuButton extends Actor
{
    protected GreenfootImage image, hoverImage, clickedImage, inactiveImage;
    protected int clickCount;
    protected boolean active = true;
    public abstract void clicked();
    public void act()
    {
        if (!active) {
            return;
        }
        if(clickCount > 0) {
            clickCount --;
            if(clickCount == 0) {
                setImage(hoverImage); //setImage(image)
            }
        }
        if(Greenfoot.mousePressed(this)){
            clickCount=15;
            setImage(clickedImage);
        }
        if(Greenfoot.mouseClicked(this)) {
            clicked();
        }
        if(clickCount == 0) {
            checkHover();
        }
    }
    public void checkHover() {
        if(Greenfoot.mouseMoved(this)) {
            setImage(hoverImage);
        } else if(Greenfoot.mouseMoved(null)){
            setImage(image);
        }
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean a) {
        active = a;
        if(a) {
            setImage(image);
        } else {
            setImage(inactiveImage);
        }
    }
}
