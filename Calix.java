import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Calix here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     * Act - do whatever the Calix wants to do. This method is called whenever
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
