import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Building here.
 * 
 * @author Eddie Zhuang
 * @version November 2022
 */
public abstract class Building extends SuperSmoothMover
{
    protected Player player;
    protected BuildingRow buildingRow; // the building row this building belongs to
    protected int actCount = 0;
    protected int actMark = 10;
    
    public Building(Player player, BuildingRow buildingRow) {
        this.player = player;
        this.buildingRow = buildingRow;
    }
    
    public void act() {
        actCount++;
    }
    
    /**
     * Gets a random number in the range from `start` to `end` inclusive.
     */
    public int getRandomNumberInRange(int start, int end) {
       int a = Greenfoot.getRandomNumber(end - start + 1);
       return start + a;
    }
    
    /**
     * Gets the next act mark for when a building performs its action by calculating a random amount of seconds 
     * between a `start` and `end`.
     * 
     * @param start         The lower bound for the range of time.
     * @param end           The upper bound for the range of time.
     */
    public int getNextActMark(int start, int end) {
        int t = getRandomNumberInRange(start * 60, end * 60);
        return actCount + t;
    }
    
    /**
     * Moves the building to its respective player's row of buildings.
     * 1st row - Grandmas
     * 2nd row - Babies
     * 3rd row - Alchemy Labs
     * 4th row - 3D Printers
     * 5th row - Portals
     * 6th row - Cookie Gods
     */
    public void moveToPlayer() {
        // PSEUDO-CODE: determine x and y position of where each building should be on its respective row
        // y position is the building row's y position (this value can be hardcoded as building row y-positions are known)
        // y position needs to offset a bit to create a sense of depth. This offset alternates between up and down the middle of the row.
        // x position increases based on the where the last building was and the width of the building's png
            // this value may be stored inside BuildingRow (?) ex. `lastBuildingX`, 'lastBuildingY`
        // now that building's position on its row is determined, calculate x and y distance from buy button to this position
        // gradually move building to its position on building row
    }
}
