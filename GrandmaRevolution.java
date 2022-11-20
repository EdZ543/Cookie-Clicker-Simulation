import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
import java.util.ArrayList;
/**
 * Write a description of class GrandmaRevolution here.
 * 
 * @author Caden Chan
 * @version 2022.11.17
 */
public class GrandmaRevolution extends Sabotage
{
    private double percent;
    public GrandmaRevolution(Player origin) {
        super(origin);
    }
    public void addedToWorld(World w) {
        super.addedToWorld(w);
        percent = getRandomNumberInRange(40, 60); // 40-60% of grandmas get angered
        angerGrandmas();
    }
    
    public void act() {
        actCount++;
        if(actCount == duration*60) {
            getWorld().removeObject(this);
            return;
        }
    }
    
    private void angerGrandmas() {
        ArrayList<Grandma> grandmaBuildings = getGrandmaBuildings();
        grandmaBuildings.removeIf(g -> g.isAngry());
        if(grandmaBuildings.size() == 0) {
            return;
        }
        int angerCount = (int)(grandmaBuildings.size() * (percent / 100.0));
        angerCount = angerCount == 0 ? 1 : angerCount;  // at least 1 grandma will be angered
        for(int i=0;i<angerCount;i++) {
            int idx = Greenfoot.getRandomNumber(grandmaBuildings.size());
            grandmaBuildings.get(idx).setAngry(true);
            grandmaBuildings.remove(idx);
        }
    }
    private ArrayList<Grandma> getGrandmaBuildings() {
        HashMap<Class, BuildingRow> buildingRows = target.getBuildingRows();
        BuildingRow grandmaBuildingRow = buildingRows.get(Grandma.class);
        return (ArrayList<Grandma>)(ArrayList<?>)grandmaBuildingRow.getBuildings();
    }
}