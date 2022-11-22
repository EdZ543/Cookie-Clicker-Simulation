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
    private BuildingRow printerRow;
    public ExtraExpensiveFilament(Player origin) {
        super(origin);
        duration = (int)(60 * 3.5); // 3.5 seconds in acts
        myPrinters = new ArrayList<Printer3D>();
        printerRow = origin.getBuildingRows().get(Printer3D.class);
        getImage().clear(); // empty image
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
        actCount = duration;
    }
    
    public void act() {
        actCount--;
        if(actCount%20 == 0) {
            addSparkle();
        }
        if (actCount == 0) {
            for (Printer3D printer : myPrinters) {
                printer.removeUpgradedFilament();
            }
            getWorld().removeObject(this);
        }
    }
    public void addSparkle() {  // sparkle effect on top of cookie
        Sparkle sparkle = new Sparkle(Greenfoot.getRandomNumber(60) + 90, printerRow, ExtraExpensiveFilament.class);
        // int[] pos = getRandomPos();
        // System.out.println(pos);
        getWorld().addObject(sparkle, 0, 0);
    }
    // public int[] getRandomPos() { // get random position to place sparkle
        // int[] pos = new int[2];
        // int w = printerRow.getImage().getWidth();
        // int h = printerRow.getImage().getHeight();
        // pos[0] = (printerRow.getX() - w/2) + Greenfoot.getRandomNumber(w);
        // pos[1] = (printerRow.getY() - h/2) + Greenfoot.getRandomNumber(h);
        // return pos;
    // }
}
