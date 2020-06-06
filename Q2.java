import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Q2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     * Act - do whatever the Q2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setTime();
        end();
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
    
    public void end()
    {
        if (time == 18)
        {
            setImage("Q1.png");
        }
    }
}
