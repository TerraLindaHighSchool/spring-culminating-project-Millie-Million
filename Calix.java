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
    
    private boolean engineer = false;
    private boolean soldier = false;
    private boolean undecided = false;
    
    /**
     * Act - do whatever the Calix wants to do. This method is called whenever
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
        if (time == 19)
        {
            setImage(calixRight);
        }
        
        if (time == 69)
        {
            setImage(calixBack);
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
        if (time == 102 && engineer == true)
        {
            setImage(calixRight);
        }
                
        if (time == 104 && engineer == true)
        {
            setImage(calixBack);
        }
        
        if (time == 107 && soldier == true)
        {
            setImage(calixBack);
        }
        
        if (time == 96 && undecided == true)
        {
            setImage(calixRight);
        }
    }
}
