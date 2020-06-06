import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Q here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     * Act - do whatever the Q wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setTime();
        animateScene1();
        firstChoice();
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
    
    private void firstChoice()
    {
        Actor engineerButton = null;
        Actor undecidedButton = null;
        Actor soldierButton = null;
        
        if (!getWorld().getObjects(EngineerButton.class).isEmpty() && !getWorld().getObjects(UndecidedButton.class).isEmpty() && !getWorld().getObjects(SoldierButton.class).isEmpty())
        {
            engineerButton = (Actor) getWorld().getObjects(EngineerButton.class).get(0);
            undecidedButton = (Actor) getWorld().getObjects(UndecidedButton.class).get(0);
            soldierButton = (Actor) getWorld().getObjects(SoldierButton.class).get(0);
            
            if (Greenfoot.mouseClicked(engineerButton))
            {
                time = 90;
            }
            
            if (Greenfoot.mouseClicked(soldierButton))
            {
                time = 97;
            }
            
            if (Greenfoot.mouseClicked(undecidedButton))
            {
               time = 83;
            }
        }
    }
}
