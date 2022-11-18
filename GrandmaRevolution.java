import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
import java.util.ArrayList;
/**
 * Write a description of class GrandmaRevolution here.
 * 
 * @author Caden Chan
 * @version 2022.11.02
 */
public class GrandmaRevolution extends Sabotage
{
    private double percent;
    public GrandmaRevolution(Player origin) {
        super(origin);
    }
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        percent = Greenfoot.getRandomNumber(10) + 20; // 20-30% of grandmas get angered
        angerGrandmas();
    }
    
    public void act() {
        actCount ++;
        animate();
        if(actCount == duration*60) {
            getWorld().removeObject(this);
            return;
        }
    }
    
    private void angerGrandmas() {
        HashMap<Class, BuildingRow> buildingRows = target.getBuildingRows();
        BuildingRow grandmaBuildingRow = buildingRows.get(Grandma.class);
        ArrayList<Grandma> grandmaBuildings = (ArrayList<Grandma>)(ArrayList<?>)grandmaBuildingRow.getBuildings();
        // grandmaBuildings.removeIf(g -> g.isAngry());
        if(grandmaBuildings.size() == 0) {
            return;
        }
        int angerCount = (int)(grandmaBuildings.size() * percent / 100.0);
        angerCount = angerCount == 0 ? 1 : angerCount;  // at least 1 grandma will be angered
        for(int i=0;i<angerCount;i++) {
            int idx = Greenfoot.getRandomNumber(grandmaBuildings.size());
            // grandmaBuildings.get(idx).setAngry(true);
            grandmaBuildings.remove(idx);
        }
    }
    private void animate() {
        // show icon to indicate that some grandmas have been angered --> fade over time. change grandma sprites as well?
    }
}
