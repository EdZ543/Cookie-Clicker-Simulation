import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The rectangles in which the buildings will stay
 * 
 * @author Eddie Zhuang
 * @version (a version number or a date)
 */
public class BuildingRow extends Actor
{
    private Class buildingType;
    
    /**
     * @param buildingType The class of building that will live in this row
     * @param width The width of the row
     * @param height The height of the row
     * @param spacing How far apart each building will be
     */
    public BuildingRow(Class buildingType, int width, int height, int spacing) {
        this.buildingType = buildingType;
    }
    
    /**
     * Adds a building to this row
     */
    public void addBuilding() {}
}
