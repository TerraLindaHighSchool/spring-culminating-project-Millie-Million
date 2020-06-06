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
    
    private boolean engineer = false;
    private boolean soldier = false;
    private boolean undecided = false;
    
    /**
     * Act - do whatever the Zyla wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setTime();
        animateScene1();
        firstChoice();
        firstChoiceAnimation();
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
        if (time == 13)
        {
            setImage(zylaRight);
        }
        
        if (time == 27)
        {
            setImage(zylaLeft);
        }
        
        if (time == 33)
        {
            setImage(zylaRight);
        }
        
        if (time == 44)
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
                engineer = true;
            }
            
            if (Greenfoot.mouseClicked(soldierButton))
            {
                time = 97;
                soldier = true;
            }
            
            if (Greenfoot.mouseClicked(undecidedButton))
            {
               time = 83;
               undecided = true;
            }
        }
    }
    
    private void firstChoiceAnimation()
    {
        if (time == 103 && undecided == true)
        {
            setImage(zylaRight);
        }
        
        if (time == 100 && engineer == true)
        {
            setImage(zylaFront);
        } 
    }
}
