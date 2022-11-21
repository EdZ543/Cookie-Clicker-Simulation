import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Every 4 seconds prints 1800 - 2400 cookies.
 * 
 * @author Patrick Hu
 * @version November 2022
 */
public class Printer3D extends Building
{
    private boolean hasExtraExpensiveFilament;
    
    public Printer3D(Player player) {
        super(player);
        animationSize = 8;
        scale = 0.5;
        hasExtraExpensiveFilament = false;
    }
    
    public void act() {
        super.act();
        if (actCount == actMark) {
            produce(650, 900);
            actMark = getNextActMark(2, 3);
        }
    }
    
    public void upgradeFilament() {
        hasExtraExpensiveFilament = true;
    }
    
    public void removeUpgradedFilament() {
        hasExtraExpensiveFilament = false;
    }
}
