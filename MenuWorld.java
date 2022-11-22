import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class MenuWorld here.
 * 
 * @author Caden Chan, 
 * @version 2022.11.21
 */
public class MenuWorld extends World
{
    private int[] grandmas, clickers, cpsRates; // modifiable simulation parameters
    private GreenfootImage bg;
    private StartButton startButton;
    private MenuSetting p1_grandmaSetting, p1_clickerSetting, p1_cpsSetting, p2_grandmaSetting, p2_clickerSetting, p2_cpsSetting;
    private Label p1_title, p2_title;
    private ArrayList<PreviewClicker> p1_previewClickers, p2_previewClickers;
    private ArrayList<PreviewGrandma> p1_previewGrandmas, p2_previewGrandmas;
    private final int[] gMinMax = {0, 5};
    private final int[] cMinMax = {0, 5};
    private final int[] cpsMinMax = {1, 5};
    
    private final int[][] p1_previewGrandmaPos = getGrandmaPositions(400, 200, 1);
    private final int[][] p2_previewGrandmaPos = getGrandmaPositions(800, 200, -1);
    private final int[] p1_previewClickerPos = new int[]{450, 420};
    private final int[] p2_previewClickerPos = new int[]{750, 420};
    public MenuWorld()
    {    
        super(1200, 800, 1); 
        // Background
        bg = new GreenfootImage("menu-background.png");
        setBackground(bg);
        // Start button
        startButton = new StartButton();
        addObject(startButton, 600, 640);
        // Player 1 Settings
        p1_title = new Label("Player 1", 60);
        p1_title.setFillColor(Color.RED);
        p1_grandmaSetting = new MenuSetting(gMinMax[0], gMinMax[1], 200, 300, "Number of\nGrandmas", 0, 1);
        p1_clickerSetting = new MenuSetting(cMinMax[0], cMinMax[1], 200, 500, "Number of\nClickers", 1, 1);
        p1_cpsSetting = new MenuSetting(cpsMinMax[0], cpsMinMax[1], 200, 700, "Clicks Per Second\n(CPS)", 2, 1);
        addObject(p1_title, 200, 100);
        addObject(p1_grandmaSetting, 0, 0);
        addObject(p1_clickerSetting, 0, 0);
        addObject(p1_cpsSetting, 0, 0);
        // Player 2 Settings
        p2_title = new Label("Player 2", 60);
        p2_title.setFillColor(Color.BLUE);
        p2_grandmaSetting = new MenuSetting(gMinMax[0], gMinMax[1], 1000, 300, "Number of\nGrandmas", 0, 2);
        p2_clickerSetting = new MenuSetting(cMinMax[0], cMinMax[1], 1000, 500, "Number of\nClickers", 1, 2);
        p2_cpsSetting = new MenuSetting(cpsMinMax[0], cpsMinMax[1], 1000, 700, "Clicks Per Second\n(CPS)", 2, 2);
        addObject(p2_title, 1000, 100);
        addObject(p2_grandmaSetting, 0, 0);
        addObject(p2_clickerSetting, 0, 0);
        addObject(p2_cpsSetting, 0, 0);
        // add PreviewGrandmas
        p1_previewGrandmas = new ArrayList<PreviewGrandma>();
        p2_previewGrandmas = new ArrayList<PreviewGrandma>();
        for(int i=0;i<gMinMax[0];i++) {
            addPreviewGrandma(1);
            addPreviewGrandma(2);
        }
        // add PreviewClickers
        p1_previewClickers = new ArrayList<PreviewClicker>();
        p2_previewClickers = new ArrayList<PreviewClicker>();
        for(int i=0;i<cMinMax[0];i++) {
            addPreviewClicker(1);
            addPreviewClicker(2);
        }
    }
    public void start() {
        grandmas = new int[]{p1_grandmaSetting.getCount(), p2_grandmaSetting.getCount()};
        clickers = new int[]{p1_clickerSetting.getCount(), p2_clickerSetting.getCount()};
        cpsRates = new int[]{p1_cpsSetting.getCount(), p2_cpsSetting.getCount()};
        Greenfoot.setWorld(new CookieWorld(grandmas, clickers, cpsRates));
    }
    public void addPreviewGrandma(int player) {
        PreviewGrandma grandma = new PreviewGrandma();
        if(player == 1) {
            p1_previewGrandmas.add(grandma);
            int[] pos = p1_previewGrandmaPos[p1_previewGrandmas.size()-1];
            addObject(grandma, pos[0], pos[1]);
        } else {
            p2_previewGrandmas.add(grandma);
            int[] pos = p2_previewGrandmaPos[p2_previewGrandmas.size()-1];
            addObject(grandma, pos[0], pos[1]);
        }
    }
    public void removePreviewGrandma(int player) {
        PreviewGrandma grandma;
        int idx;
        if(player == 1) {
            idx = p1_previewGrandmas.size()-1;
            grandma = p1_previewGrandmas.get(idx);
            p1_previewGrandmas.remove(idx);
        } else {
            idx = p2_previewGrandmas.size()-1;
            grandma = p2_previewGrandmas.get(idx);
            p2_previewGrandmas.remove(idx);
        }
        removeObject(grandma);
    }
    public void addPreviewClicker(int player) {
        
        if(player == 1) {
            PreviewClicker clicker = new PreviewClicker(80, p1_clickerSetting.getCount()+2);
            p1_previewClickers.add(clicker);
            addObject(clicker, p1_previewClickerPos[0], p1_previewClickerPos[1]);
        } else {
            PreviewClicker clicker = new PreviewClicker(80, p2_clickerSetting.getCount()+2);
            p2_previewClickers.add(clicker);
            addObject(clicker, p2_previewClickerPos[0], p2_previewClickerPos[1]);
        }
    }
    public void removePreviewClicker(int player) {
        PreviewClicker clicker;
        int idx;
        if(player == 1) {
            idx = p1_previewClickers.size()-1;
            clicker = p1_previewClickers.get(idx);
            p1_previewClickers.remove(idx);
        } else {
            idx = p2_previewClickers.size()-1;
            clicker = p2_previewClickers.get(idx);
            p2_previewClickers.remove(idx);
        }
        removeObject(clicker);
    }
    public void editCps(int player, int newCps) {
        if(player == 1) {
            for(PreviewClicker clicker: p1_previewClickers) {
                clicker.setSpeed(2 + newCps);
            }
        } else {
            for(PreviewClicker clicker: p2_previewClickers) {
                clicker.setSpeed(2 + newCps);
            }
        }
    }
    private int[][] getGrandmaPositions(int startX, int startY, int d) {
        int[][] positions = new int[gMinMax[1]][];
        for(int i=0;i<gMinMax[1];i++) {
            int yOffset = i%2 == 1 ? 50 : 0;
            int[] pos = {startX + i*30*d, startY + yOffset};
            positions[i] = pos;
        }
        return positions;
    }
    // public PreviewClicker[] addPreviewClickers(int[][] pos) {
        // PreviewClicker[] clickers = new PreviewClicker[pos.length];
        // for(int i=0;i<pos.length;i++) {
            // clickers[i] = new PreviewClicker(80);
            // addObject(clickers[i], pos[i][0], pos[i][1]);
        // }
        // return clickers;
    // }
}
