import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Zyla Raylan: femme fatale with a sense of humor, and an excellent sniper.
 * 
 * @author Millie Harrison 
 * @version 6/5/20
 */
public class Zyla extends Actor
{
    private int time = 0;
    private int count;
    
    private GreenfootImage zylaLeft = new GreenfootImage("Zyla2.png");
    private GreenfootImage zylaBack = new GreenfootImage("Zyla3.png");
    private GreenfootImage zylaRight = new GreenfootImage("Zyla4.png");
    private GreenfootImage zylaFront = new GreenfootImage("Zyla1.png");
    
    /**
     * Do whatever Zyla wants to do. Called whenever
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
     * Animates Zyla for the opening scene.
     */
    public void animateScene1()
    {
        if (time == 15)
        {
            setImage(zylaRight);
        }
        
        if (time == 29)
        {
            setImage(zylaLeft);
        }
        
        if (time == 34)
        {
            setImage(zylaRight);
        }
        
        if (time == 43)
        {
            setImage(zylaBack);
        }
        
        if (time == 58)
        {
            setImage(zylaLeft);
        }
        
        if (time == 74)
        {
            setImage(zylaBack);
        }
    }
}
