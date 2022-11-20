import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Send <code>BottleOfMilk</code>'s to the opponent's babies, neutralizing them
 * 
 * @author Caden Chan
 * @version 2022.11.19
 */
public class MilkBottles extends Sabotage
{
    private int startX, startY;     // MilkBottles are launched from (startX, startY)
    /**
     * @param origin            The Player who activated the MilkBottles sabotage        
     */
    public MilkBottles(Player origin) {
        super(origin);
    }
    /**
     * Instantiate one BottleOfMilk object for each of the opponent's Baby objects
     * 
     * @param w
     */
    public void addedToWorld(World w) {
        CookieWorld cw = ((CookieWorld)getWorld());
        BuyButton btn = cw.getSabotageButton(MilkBottles.class); // The BuyButton that activates the MilkBottles Sabotage
        // All BottleOfMilk instances start at the BuyButton
        startX = btn.getX();
        startY = btn.getY();
        // Get the opponnent's babies. target = opponent
        HashMap<Class, BuildingRow> buildingRows = target.getBuildingRows();
        BuildingRow babyBuildingRow = buildingRows.get(Baby.class);
        ArrayList<Baby> babyBuildings = (ArrayList<Baby>)(ArrayList<?>)babyBuildingRow.getBuildings();
        for(Baby b: babyBuildings) {
            sendMilkBottle(b); // milk bottles are thrown to each baby.
        }
    }
    
    public void act() {
        getWorld().removeObject(this);
    }
    /**
     * @param b             The Baby that the BottleOfMilk is being thrown towards
     */
    private void sendMilkBottle(Baby b) {
        // BottleOfMilk movement is handled in its act method. 
        BottleOfMilk boM = new BottleOfMilk(startX, startY, b);
        getWorld().addObject(boM, startX, startY);
    }
}
