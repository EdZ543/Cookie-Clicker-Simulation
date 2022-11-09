import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;

/**
 * Write a description of class Player here.
 * 
 * @author Patrick Hu
 * @version November 2022
 */
public class Player extends Actor
{
    private int numCookies;
    private BuildingCounter[] buildingCounters = new BuildingCounter[6];
    HashMap<String, Int> buildingCounts = new HashMap<String, Int>(); // buildingCounts["Grandma"]++;
    
    public Player() {
        numCookies = 0;
        
    }
    
    public void act() {
        
    }
    
    public void setCookieCount(int x) {
        numCookies = x;
    }
    
    public int getCookieCount() {
        return numCookies;
    }
}
