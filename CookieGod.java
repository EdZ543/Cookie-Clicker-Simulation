import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The heavens bless the player with 100,000 cookies per 10 seconds
 * 
 * @author Patrick Hu
 * @version November 2022
 */
public class CookieGod extends Building
{
    public CookieGod(Player player, BuildingRow buildingRow) {
        super(player, buildingRow);
        
        setImage("./images/placeholder/cookie-god.png");
    }
    
    public void act()
    {
        super.act();
        if (actCount == actMark) {
            bless();
            actMark = getNextActMark(10, 10);
        }
    }
    
    public void bless() {
        player.changeCookieCount(100000);
    }
}
