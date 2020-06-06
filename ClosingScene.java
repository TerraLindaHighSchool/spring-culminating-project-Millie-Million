import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ClosingScene here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClosingScene extends World
{
    private int time = 0;
    private int count;
    private GreenfootSound goodbye = new GreenfootSound("Win scenario2.mp3");

    /**
     * Constructor for objects of class ClosingScene.
     * 
     */
    public ClosingScene()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        prepare();
    }
    
    private void prepare()
    {
        goodbye.play();
        Q2 q2 = new Q2();
        addObject(q2,305,232);
        Calix2 calix2 = new Calix2();
        addObject(calix2,402,224);
        Zyla2 zyla2 = new Zyla2();
        addObject(zyla2,478,216);
    }
    
    public void act()
    {
        setTime();
        endsAreBeginnings();
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
    
    public void endsAreBeginnings()
    {
        if (time % 33 == 0)
        {
            Greenfoot.setWorld(new EndGameWin());
        }
    }
}
