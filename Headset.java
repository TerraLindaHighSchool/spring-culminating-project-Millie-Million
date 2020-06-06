import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Blackness. Complete darkness. Oh wait, you're just wearing a bad had.
 * 
 * @author Millie Harrison 
 * @version 6/5/20
 */
public class Headset extends Actor
{
    private int time = 0;
    private int count;
    
    /**
     * Do whatever the Headset wants to do. This method is called whenever
     * the act button gets pressed.
     */
    public void act() 
    {
        setTime();
        show();
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
     * Whent the second timer gets to 18, full transparency!
     */
    public void show()
    {
        getImage().setTransparency(0);
        
        if (time  >= 18)
        {
            getImage().setTransparency(255);
        }
    }
}
