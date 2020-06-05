import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GunRoom2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GunRoom2 extends World
{
    private int time = 0;
    private int count;
    private GreenfootSound winScenario = new GreenfootSound("Win scenario.mp3");

    /**
     * Constructor for objects of class GunRoom2.
     * 
     */
    public GunRoom2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        prepare();
    }
    
    private void prepare()
    {
        winScenario.play();
    }
    
    public void act()
    {
        setTime();
        cockpit();
    }
    
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
    
    public void cockpit()
    {
        if (time % 37 == 0)
        {
            Greenfoot.setWorld(new ClosingScene());
        }
    }
}
