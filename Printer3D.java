import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Every 4 seconds prints 1800 - 2400 cookies.
 * 
 * @author Patrick Hu
 * @version November 2022
 */
public class Printer3D extends Building
{
    public Printer3D(Player player) {
        super(player);
        
        setImage("./images/placeholder/alchemy-lab.png");
    }
    
    public void act() {
        super.act();
        if (actCount == actMark) {
            printCookies();
            getNextActMark(4, 4);
        }
    }
    
    public void printCookies() {
        int amount = getRandomNumberInRange(1800, 2400);    
        player.changeCookieCount(amount);
    }
}
