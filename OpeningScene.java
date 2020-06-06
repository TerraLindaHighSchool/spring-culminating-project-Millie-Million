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
    
    private boolean engineerChoice = false;
    private boolean soldierChoice = false;
    private boolean undecidedChoice = false;

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
        Q q = new Q();
        addObject(q,305,232);
        Zyla zyla = new Zyla();
        addObject(zyla,228,218);
        Calix calix = new Calix();
        addObject(calix,152,225);
    }
    
    public void act()
    {
        setTime();
        firstChoice();
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
    
    public void addDrones()
    {
        if (time % 130 == 0)
        {
            addObject(new Drone(), 300, 200);
            addObject(new Drone(), 300, 200);
            addObject(new Drone(), 300, 200);
        }
    }
    
    public void gunRoom()
    {
        if (time % 181 == 0)
        {
            Greenfoot.setWorld(new GunRoom());
        }
    }
    
    private void firstChoice()
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
                engineerChoice = true;
                removeObject(engineerButton);
                removeObject(soldierButton);
                removeObject(undecidedButton);
            }
            
            if (Greenfoot.mouseClicked(soldierButton))
            {
                soldier.play();
                time = 97;
                soldierChoice = true;
                removeObject(engineerButton);
                removeObject(soldierButton);
                removeObject(undecidedButton);
            }
            
            if (Greenfoot.mouseClicked(undecidedButton))
            {
                undecided.play();
                time = 83;
                undecidedChoice = true;
                removeObject(engineerButton);
                removeObject(soldierButton);
                removeObject(undecidedButton);
            }
            
            if (!getObjects(Zyla.class).isEmpty())
            {
                for (Object zyla : getObjects(Zyla.class))
                {
                    if (time == 102 && engineerChoice == true)
                    {
                        ((Zyla) zyla).setImage("Zyla1.png");
                    }
                    
                    if (time == 103 && undecidedChoice == true)
                    {
                        ((Zyla) zyla).setImage("Zyla4.png");
                    }
                }
            }
        }
        
        if (!getObjects(Calix.class).isEmpty())
        {
            for (Object calix : getObjects(Calix.class))
            {
                if (time == 104 && engineerChoice == true)
                {
                    ((Calix) calix).setImage("Calix4.png");
                }
                        
                if (time == 106 && engineerChoice == true)
                {
                    ((Calix) calix).setImage("Calix3.png");
                }
                        
                if (time == 98 && undecidedChoice == true)
                {
                    ((Calix) calix).setImage("Calix4.png");
                }
                        
                if (time == 107 && soldierChoice == true)
                {
                    ((Calix) calix).setImage("Calix1.png");
                } 
            }
        }
            
        if (!getObjects(Zyla.class).isEmpty())
        {
            for (Object zyla : getObjects(Zyla.class))
            {
                if (time == 102 && engineerChoice == true)
                {
                    ((Zyla) zyla).setImage("Zyla1.png");
                }
                    
                if (time == 105 && undecidedChoice == true)
                {
                    ((Zyla) zyla).setImage("Zyla4.png");
                }
            }
        }
    }
}
