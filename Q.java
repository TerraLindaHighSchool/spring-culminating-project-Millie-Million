import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Q(uill Andar): top of her class of Nebula Pilots from the Nova Academy on Mika. Inspired by Han Solo.
 * 
 * @author Millie Harrison 
 * @version 6/5/20
 */
public class Q extends Actor
{
    private int time = 0;
    private int count;
    
    private GreenfootImage qLeft = new GreenfootImage("Q2.png");
    private GreenfootImage qBack = new GreenfootImage("Q3.png");
    private GreenfootImage qRight = new GreenfootImage("Q4.png");
    private GreenfootImage qFront = new GreenfootImage("Q1.png");
    
    /**
     * Do whatever Q wants to do. This method is called whenever
     * the act button gets pressed.
     */
    public void act() 
    {
        setTime();
        animateScene1();
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
     * Animates Q for the opening scene.
     */
    public void animateScene1()
    {
        if ( time == 8)
        {
            setImage(qLeft);
        }
        
        if (time == 42)
        {
            setImage(qFront);
        }
        
        if (time == 74)
        {
            setImage(qBack);
        }
    }
}
