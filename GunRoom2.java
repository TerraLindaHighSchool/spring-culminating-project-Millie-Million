import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * You survived! Calix and Zyla, your new friends, welcome you back!
 * 
 * @author Millie Harrison 
 * @version 6/5/20
 */
public class GunRoom2 extends World
{
    private int time = 0;
    private int count;
    private GreenfootSound winScenario = new GreenfootSound("Win scenario.mp3");

    /**
     * Constructor for objects of class GunRoom2. Makes the world.
     * 
     */
    public GunRoom2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        prepare();
    }
    
    /**
     * Plays the narration and adds in Calix and Zyla.
     */
    private void prepare()
    {
        winScenario.play();
        Calix2 calix2 = new Calix2();
        addObject(calix2,254,224);
        Zyla2 zyla2 = new Zyla2();
        addObject(zyla2,331,215);
    }
    
    /**
     * Does what the world wants to do. Is called everytime the act button is pressed.
     */
    public void act()
    {
        setTime();
        cockpit();
    }
    
    /**
     * Sets the second timer. Very important for helping with the continuity of the voiceover.
     */
    public void setTime()
    {
        if (count++ % 60 == 0)
        {
            if (time >= 0)
            {
                time++;
            }
        }
    }
    
    /**
     * When the second timer reaches 37 it switches the world to closing scene.
     */
    public void cockpit()
    {
        if (time % 37 == 0)
        {
            Greenfoot.setWorld(new ClosingScene());
        }
    }
}
