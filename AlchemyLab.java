import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Every 5-10 seconds, the alchemy lab will produce 500-1000 cookies
 * 
 * @author Patrick Hu 
 * @version November 2022
 */
public class AlchemyLab extends Building
{
    public AlchemyLab(Player player) {
        super(player);
        
        setImage("./images/placeholder/alchemy-lab.png");
        
        // increase player's building count for alchemy lab
    }
    
    public void act() {
        super.act();
        if (actCount == actMark) {
            produceCookies();    
            actMark = getNextActMark(5, 10);
        }
    }
    
    public void produceCookies() {
        int produced = getRandomNumberInRange(500, 1000);    
        player.changeCookieCount(produced);
    }
    
    public void moveToRow() {
        // PSEUDO-CODE: determine x and y position of where each building should be on its respective row
        // y position is the building row's y position (this value can be hardcoded as building row y-positions are known)
        // y position needs to offset a bit to create a sense of depth. This offset alternates between up and down the middle of the row.
        // x position increases based on the where the last building was and the width of the building's png
            // this value may be stored inside BuildingRow (?) ex. `lastBuildingX`, 'lastBuildingY`
        // now that building's position on its row is determined, calculate x and y distance from buy button to this position
        // gradually move building to its position on building row
    }
}
