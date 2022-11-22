import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuWorld here.
 * 
 * @author Caden Chan, 
 * @version 2022.11.21
 */
public class MenuWorld extends World
{
    private int[] grandmas, clickers, cpsRates; // modifiable simulation parameters
    private StartButton startButton;
    private MenuSetting p1_grandmaSetting, p1_clickerSetting, p1_cpsSetting, p2_grandmaSetting, p2_clickerSetting, p2_cpsSetting;
    private Label p1_title, p2_title;
    private final int[] gMinMax = {1, 5};
    private final int[] cMinMax = {1, 5};
    private final int[] cpsMinMax = {1, 5};
    public MenuWorld()
    {    
        super(1200, 800, 1); 
        // Start button
        startButton = new StartButton();
        addObject(startButton, 600, 640);
        // Player 1 Settings
        p1_title = new Label("Player 1", 60);
        p1_title.setFillColor(Color.RED);
        p1_grandmaSetting = new MenuSetting(gMinMax[0], gMinMax[1], 200, 300, "Number of\nGrandmas");
        p1_clickerSetting = new MenuSetting(cMinMax[0], cMinMax[1], 200, 500, "Number of\nClickers");
        p1_cpsSetting = new MenuSetting(cpsMinMax[0], cpsMinMax[1], 200, 700, "Clicks Per Second\n(CPS)");
        addObject(p1_title, 200, 100);
        addObject(p1_grandmaSetting, 0, 0);
        addObject(p1_clickerSetting, 0, 0);
        addObject(p1_cpsSetting, 0, 0);
        // Player 2 Settings
        p2_title = new Label("Player 2", 60);
        p2_title.setFillColor(Color.BLUE);
        p2_grandmaSetting = new MenuSetting(gMinMax[0], gMinMax[1], 1000, 300, "Number of\nGrandmas");
        p2_clickerSetting = new MenuSetting(cMinMax[0], cMinMax[1], 1000, 500, "Number of\nClickers");
        p2_cpsSetting = new MenuSetting(cpsMinMax[0], cpsMinMax[1], 1000, 700, "Clicks Per Second\n(CPS)");
        addObject(p2_title, 1000, 100);
        addObject(p2_grandmaSetting, 0, 0);
        addObject(p2_clickerSetting, 0, 0);
        addObject(p2_cpsSetting, 0, 0);
    }
    public void start() {
        grandmas = new int[]{p1_grandmaSetting.getCount(), p2_grandmaSetting.getCount()};
        clickers = new int[]{p1_clickerSetting.getCount(), p2_clickerSetting.getCount()};
        cpsRates = new int[]{p1_cpsSetting.getCount(), p2_cpsSetting.getCount()};
        Greenfoot.setWorld(new CookieWorld(grandmas, clickers, cpsRates));
    }
}
