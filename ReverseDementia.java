import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * 
 * @author Jonathan Zhao
 * @version November 2022
 */
public class ReverseDementia extends Powerup
{
    private ArrayList<Grandma> myGrandmas;
    
    public ReverseDementia(Player origin) {
        super(origin);
        duration = (int)(60 * 3.5); // 3.5 seconds in acts
        myGrandmas = new ArrayList<Grandma>();
    }
    
    public void addedToWorld(World w) {
        // grab all grandmas that belong to player and upgrade them
        ArrayList<Grandma> allGrandmas = (ArrayList<Grandma>)getWorld().getObjects(Grandma.class);
        for (Grandma granny : allGrandmas) {
            if (granny.getPlayer() == origin) {
                myGrandmas.add(granny);
                granny.reverseDementia();
                // calm down any angry grannies
                if (granny.isAngry()) {
                    granny.setAngry(false);
                    // return grandma to its initial location before it started jumping
                    granny.setLocation(granny.getTargetX(), granny.getTargetY());
                }
            }
        }
    }
    
    public void act() {
        actCount++;
        if (actCount == duration) {
            for (Grandma granny : myGrandmas) {
                granny.undoReverseDementia();
            }
            
            getWorld().removeObject(this);
        }
    }
}
