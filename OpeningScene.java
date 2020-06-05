import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OpeningScene1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OpeningScene extends World
{
    private GreenfootSound soldier = new GreenfootSound("Soldier.mp3");
    private GreenfootSound engineer = new GreenfootSound("Engineer.mp3");
    private GreenfootSound undecided = new GreenfootSound("undecided.mp3");
    private GreenfootSound opening = new GreenfootSound("Opening Scene 1.mp3");
    private GreenfootSound drones = new GreenfootSound("Opening Scene 2.mp3");
    
    private int time = 0;
    private int count;

    /**
     * Constructor for objects of class OpeningScene1.
     * 
     */
    public OpeningScene()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        prepare();
    }
    
    private void prepare()
    {      
        EngineerButton engineerButton = new EngineerButton();
        addObject(engineerButton,112,23);
        SoldierButton soldierButton = new SoldierButton();
        addObject(soldierButton,312,23);
        UndecidedButton undecidedButton = new UndecidedButton();
        addObject(undecidedButton,495,23);
        opening.play();
    }
    
    public void act()
    {
        setTime();
        removeButtons();
        playDrones();
        gunRoom();
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
    
    public void playDrones()
    {
        if (time % 110 == 0)
        {
            drones.play();
        }
    }
    
    public void gunRoom()
    {
        if (time % 181 == 0)
        {
            Greenfoot.setWorld(new GunRoom());
        }
    }
    
    private void removeButtons()
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
                time = 90;
                removeObject(engineerButton);
                removeObject(soldierButton);
                removeObject(undecidedButton);
            }
            
            if (Greenfoot.mouseClicked(soldierButton))
            {
                soldier.play();
                time = 97;
                removeObject(engineerButton);
                removeObject(soldierButton);
                removeObject(undecidedButton);
            }
            
            if (Greenfoot.mouseClicked(undecidedButton))
            {
                undecided.play();
                time = 83;
                removeObject(engineerButton);
                removeObject(soldierButton);
                removeObject(undecidedButton);
            }
        }
    }
}
