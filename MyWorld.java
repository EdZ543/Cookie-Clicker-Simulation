import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * Credits
 * - Images
 *   - Background image from the original Cookie Clicker by Orteil, provided by caveman at https://wallpapercave.com/cookie-clicker-wallpapers
 *   - Cursor image provided by Tobias Ahlin Bjerrome at https://tobiasahlin.com/blog/common-mac-os-x-lion-cursors/
 *   - Spinning wheel of death provided by howdytom at https://apple.stackexchange.com/questions/243675/location-of-the-resource-files-for-the-spinning-wait-cursor
 * 
 * @author Patrick Hu, Eddie Zhuang, Caden Chan, Jonathan Zhao
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    // World variables
    GreenfootImage background;
    public MyWorld()
    {    
        super(1200, 800, 1); 
        // Set world background
        background = new GreenfootImage("background0.png");
        setBackground(background);
    }
}
