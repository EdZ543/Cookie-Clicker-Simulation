import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The title screen
 * 
 * @author Caden Chan,  
 * @version (a version number or a date)
 */
public class WelcomeWorld extends World
{
    private GreenfootImage bg;
    private GoButton nextButton;
    private Label tempTitle;
    private Label tempAuthors;
    private final String[] trackNames = {"menubg.mp3", "mainbg.mp3"};
    public GreenfootSound[] tracks = new GreenfootSound[2];
    /**
     * The first screen seen by the user
     */
    public WelcomeWorld()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        // Background
        bg = new GreenfootImage("welcome-background.png");
        setBackground(bg);
        // BG Music
        tracks[0] = initMusic(trackNames[0]);
        tracks[1] = initMusic(trackNames[1]);
        // Button brings user to the MenuWorld
        nextButton = new GoButton();
        addObject(nextButton, 600, 600);
        // Title
        tempTitle = new Label("Cookie Clicker Simulation!", 60);
        addObject(tempTitle, 600, 100);
        // Authors
        tempAuthors = new Label("By Patrick H., Jonathan Z., Eddie Z., Caden C.", 40);
        addObject(tempAuthors, 600, 160);
    }
    // Program started (via Greenfoot)
    public void started() {
        super.started();
        tracks[0].playLoop();
    }
    // Program stopped (via Greenfoot)
    public void stopped() {
        super.stopped();
        tracks[0].stop();
    }
    /**
     * Go to the menu screen, represented by <code>MenuWorld</code>
     */
    public void goToMenu() {
        Greenfoot.setWorld(new MenuWorld(tracks));
    }
    /**
     * Initialize background music
     */
    public GreenfootSound initMusic(String trackName) {
        GreenfootSound track = new GreenfootSound(trackName);
        track.setVolume(0);
        track.play();  // trick to preload music, to avoid long loading times later on
        track.stop();
        track.setVolume(40);
        return track;
    }
}
