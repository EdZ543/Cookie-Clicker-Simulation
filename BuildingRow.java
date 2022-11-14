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
    private int spacing;
    private Player player;
    
    /**
     * @param buildingType The class of building that will live in this row
     * @param width The width of the row
     * @param height The height of the row
     * @param spacing How far apart each building will be
     */
    public BuildingRow(Player player, Class buildingType, int width, int height, int spacing) {
        this.player = player;
        this.buildingType = buildingType;
        this.spacing = spacing;
        
        setImage(drawBuildingRow(width, height));
    }
    
    /**
     * Adds a building to this row
     */
    public void addBuilding() {
        
    }
    
    private GreenfootImage drawBuildingRow(int width, int height) {
        GreenfootImage ret = new GreenfootImage(width, height);
        
        // Draw inside
        ret.setColor(new Color(247, 242, 213));
        ret.fillRect(0, 0, width, height);
        
        // Draw border
        ret.setColor(new Color(38, 20, 8));
        ret.drawRect(0, 0, width, height);
        
        return ret;
    }
}
