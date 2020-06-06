import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zyla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     * Act - do whatever the Zyla wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setTime();
        animateScene1();
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
