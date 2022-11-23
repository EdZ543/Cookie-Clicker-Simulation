import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The title screen of the simulation.
 * The cookie clicker simulation simulates two players fighting to bake the most
 * amount of cookies possible! The winner gets to go to the moon with the president.
 * There are 6 buildings that can be purchased along with 4 powerups and sabotages to be
 * used against the opposing player. AI-controlled mouse movement clicks buy buttons to 
 * purchase these item in order to increase their cookie production. The first to 
 * 1,000,000 cookies wins!
 * 
 * @author Caden Chan, Patrick Hu
 * @version November 2022
 */
public class WelcomeWorld extends World
{
    private GreenfootImage bg;
    private GoButton nextButton;
    private Label tempTitle;
    private Label tempAuthors;
    private final String[] trackNames = {"menubg.mp3", "mainbg.mp3"};
    protected static GreenfootSound[] tracks = new GreenfootSound[2];
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
        tracks[0].pause();
    }
    /**
     * Go to the story screen, represented by <code>StoryWorld</code>
     */
    public void goToStory() {
        Greenfoot.setWorld(new StoryWorld());
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
