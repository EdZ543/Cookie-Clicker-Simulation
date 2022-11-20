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
    private int startX, startY;
    private Player otherPlayer;
    public MilkBottles(Player origin) {
        super(origin);
    }
    public void addedToWorld(World w) {
        CookieWorld cw = ((CookieWorld)getWorld());
        otherPlayer = cw.getOtherPlayer(origin);
        BuyButton btn = cw.getSabotageButton(MilkBottles.class);
        startX = btn.getX();
        startY = btn.getY();
        
        HashMap<Class, BuildingRow> buildingRows = otherPlayer.getBuildingRows();
        BuildingRow babyBuildingRow = buildingRows.get(Baby.class);
        ArrayList<Baby> babyBuildings = (ArrayList<Baby>)(ArrayList<?>)babyBuildingRow.getBuildings();
        for(Baby b: babyBuildings) {
            sendMilkBottle(b); // milk bottles drop to each baby.
        }
    }
    
    public void act() {
        getWorld().removeObject(this);
    }
    private void sendMilkBottle(Baby b) {
        BottleOfMilk boM = new BottleOfMilk(startX, startY, b);
        getWorld().addObject(boM, startX, startY);
    }
}
