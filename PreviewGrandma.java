import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PreviewGrandma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PreviewGrandma extends PreviewActor
{
    int animationIndex, animationSize, actCount;
    double scale;
    public PreviewGrandma() {
        animationSize = 5;
        scale = 1;
        actCount = 0;
        animate();
    }
    public void act()
    {
        animate();
        actCount ++;
    }
    public void animate() {
        if (actCount % 20 == 0) {
            setImage("./gifs/grandma/" + animationIndex + ".png");
            getImage().scale((int)(getImage().getWidth() * scale), (int)(getImage().getHeight() * scale));
            animationIndex++;
            animationIndex %= animationSize;
        }
    }
}
