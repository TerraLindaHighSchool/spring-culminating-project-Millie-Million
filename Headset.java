import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Headset here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Headset extends Actor
{
    private int time = 0;
    private int count;
    
    /**
     * Act - do whatever the Headset wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setTime();
        show();
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
    
    public void show()
    {
        getImage().setTransparency(0);
        if (time  >= 18)
        {
            getImage().setTransparency(255);
        }
    }
}
