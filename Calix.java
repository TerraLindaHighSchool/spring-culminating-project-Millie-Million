import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Calix Eno: the engineer genius. Based off of Akira.
 * 
 * @author Millie Harrison 
 * @version 6/5/20
 */
public class Calix extends Actor
{
    private int time = 0;
    private int count;
    
    private GreenfootImage calixLeft = new GreenfootImage("Calix2.png");
    private GreenfootImage calixBack = new GreenfootImage("Calix3.png");
    private GreenfootImage calixRight = new GreenfootImage("Calix4.png");
    private GreenfootImage calixFront = new GreenfootImage("Calix1.png");
    
    /**
     * Do whatever Calix wants to do. Called whenever the act button is pressed.
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
     * Animates Calix's movements before the choice in the opening scene.
     */
    public void animateScene1()
    {
        if (time == 21)
        {
            setImage(calixRight);
        }
        
        if (time == 69)
        {
            setImage(calixBack);
        }
    }
}
