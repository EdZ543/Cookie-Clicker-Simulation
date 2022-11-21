import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class ExtraExpensiveFilament here.
 * 
 * @author Jonathan Zhao
 * @version November 2022
 */
public class ExtraExpensiveFilament extends Powerup
{
    private ArrayList<Printer3D> myPrinters;
    
    public ExtraExpensiveFilament(Player origin) {
        super(origin);
        duration = (int)(60 * 3.5); // 3.5 seconds in acts
        myPrinters = new ArrayList<Printer3D>();
    }
    
    public void addedToWorld(World w) {
        // grab all 3d printers that belong to player and upgrade them
        ArrayList<Printer3D> allPrinters = (ArrayList<Printer3D>)getWorld().getObjects(Printer3D.class);
        for (Printer3D printer : allPrinters) {
            if (printer.getPlayer() == origin) {
                myPrinters.add(printer);
                printer.upgradeFilament();
            }
        }
    }
    
    public void act() {
        actCount++;
        if (actCount == duration) {
            for (Printer3D printer : myPrinters) {
                printer.removeUpgradedFilament();
            }
            getWorld().removeObject(this);
        }
    }
}
