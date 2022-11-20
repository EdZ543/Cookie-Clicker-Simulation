import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * <p>
 * Superclass for all actors with an animated sprite cycle.
 * <br>
 * Animator should be set up as follows, in each subclass that needs gif-like animation:
 * <p>
 * <ol>
 * <li>Call <code>setAnimationCycle([params])</code> in constructor (or <code>addedToWorld</code> method)</li>
 * <li>Add super.act() to act method</li>
 * </ol>
 * 
 * 
 * @author Caden Chan
 * @version 2022.11.19
 */
public abstract class Animator extends SuperSmoothMover
{
    private int index, startIndex, spriteCount, frameRate, frameCount;
    private String prefix, suffix;
    private boolean animate = false;
    
    /**
     * Initialize variables. MUST be called by subclasses to use the Animator class. 
     * Set prefix, suffix and maxIndex based on sprite file names.
     * 
     * ***
     * 
     * How to use (example):
     * 
     * Lets say the "images" folder contains the following files:
     * - ball1.png
     * - ball2.png
     * - ball3.png
     * - ball4.png
     * Then, the parameters should be as follows:
     * prefix = "ball" (or "./images/ball")
     * suffix = ".png"
     * startIndex = 1 (first image is ball1.png --> 1)
     * spriteCount = 4
     * 
     * Note: images MUST have consecutive index numbers; none can be missing from the folder
     * 
     * @param prefix            File path before its index counter
     * @param suffix            File path after its index counter
     * @param startIndex        Min index counter value (e.g. if first file is ball0.png, then set to 0)
     * @param spriteCount       Number of files with the given prefixes and suffixes
     * @param frameRate         Animation frame rate, in acts. Ex: if frameRate = 30, then change the sprite every 30 acts
     */
    public void setAnimationCycle(String prefix, String suffix, int startIndex, int spriteCount, int frameRate) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.startIndex = startIndex;
        this.spriteCount = spriteCount;
        this.frameRate = frameRate;
        index = startIndex;
        frameCount = 0;
        animate = true;
    }
    /**
     * Go to next sprite in the animation cycle
     * Examples:
     * - If current image is set to "ball1.png", change to "ball2.png".
     * - If current image is set to "ball4.png", and it is last in the cycle, change back to ballX.png, where X = startIndex
     */
    public void cycleSprite() {
        index = (index+1)%spriteCount;
        int i = index+spriteCount;
        String a = prefix + i + suffix;
        setImage(a);
    }
    public void act() {
        super.act();
        if(animate && frameCount % frameRate == 0) {
            cycleSprite();
        }
        frameCount ++;
    }
    // Setters
    public void setPrefix(String s) {
        prefix = s;
    }
    public void setSuffix(String s) {
        suffix = s;
    }
}
