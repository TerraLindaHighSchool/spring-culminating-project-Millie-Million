import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Q2: the electric boogaloo.
 * 
 * @author Millie Harrison 
 * @version 6/5/20
 */
public class Q2 extends Actor
{
    private int time = 0;
    private int count;
    
    private GreenfootImage qLeft = new GreenfootImage("Q2.png");
    private GreenfootImage qBack = new GreenfootImage("Q3.png");
    private GreenfootImage qRight = new GreenfootImage("Q4.png");
    private GreenfootImage qFront = new GreenfootImage("Q1.png");
    
    /**
     * Do whatever Q2 wants to do. This method is called whenever
     * the act button gets pressed.
     */
    public void act() 
    {
        setTime();
        end();
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
     * Q turns to the controls and flips the vortex drive lever as the second counter hits 18.
     */
    public void end()
    {
        if (time == 18)
        {
            setImage("Q1.png");
        }
    }
}
