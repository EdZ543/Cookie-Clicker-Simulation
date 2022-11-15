import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Every 10 - 20 seconds produces 30-50 cookies.
 * They must be clicked by the player to collect the cookies (they are old and cannot carry them by themselves.
 * 
 * @author Eddie Zhuang
 * @version November 2022
 */
public class Grandma extends Building
{
    public Grandma(Player player, BuildingRow buildingRow) {
        super(player, buildingRow);
        
        setImage("./images/placeholder/grandma.png");
    }
    
    public void act()
    {
        super.act();
        if (actCount == actMark) {
            player.changeCookieCount(getRandomNumberInRange(30, 50));
            actMark = getNextActMark(2, 2);
        }
    }
}
