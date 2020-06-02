import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OpeningScene1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OpeningScene1 extends World
{
    private GreenfootSound soldier = new GreenfootSound("Soldier.mp3");
    private GreenfootSound engineer = new GreenfootSound("Engineer.mp3");
    private GreenfootSound undecided = new GreenfootSound("undecided.mp3");

    /**
     * Constructor for objects of class OpeningScene1.
     * 
     */
    public OpeningScene1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        prepare();
    }
    
    private void prepare()
    {
        EngineerButton engineerButton = new EngineerButton();
        addObject(engineerButton,107,23);
        SoldierButton soldierButton = new SoldierButton();
        addObject(soldierButton,312,23);
        UndecidedButton undecidedButton = new UndecidedButton();
        addObject(undecidedButton,495,23);
    }
    
    public void act()
    {
        removeButtons();
    }
    
    public void removeButtons()
    {
        Actor engineerButton = null;
        Actor undecidedButton = null;
        Actor soldierButton = null;
        if (!getObjects(EngineerButton.class).isEmpty() && !getObjects(UndecidedButton.class).isEmpty() && !getObjects(SoldierButton.class).isEmpty())
        {
            engineerButton = (Actor) getObjects(EngineerButton.class).get(0);
            undecidedButton = (Actor) getObjects(UndecidedButton.class).get(0);
            soldierButton = (Actor) getObjects(SoldierButton.class).get(0);
            if (Greenfoot.mouseClicked(engineerButton))
            {
                engineer.play();
                removeObject(engineerButton);
                removeObject(soldierButton);
                removeObject(undecidedButton);
            }
            
            if (Greenfoot.mouseClicked(soldierButton))
            {
                soldier.play();
                removeObject(engineerButton);
                removeObject(soldierButton);
                removeObject(undecidedButton);
            }
            
            if (Greenfoot.mouseClicked(undecidedButton))
            {
                undecided.play();
                removeObject(engineerButton);
                removeObject(soldierButton);
                removeObject(undecidedButton);
            }
        }
    }
}
