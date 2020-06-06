
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * The first time we see inside the cockpit of the Echo.
 * 
 * @author Millie Harrison 
 * @version 6/5/20
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
     * Constructor for objects of class OpeningScene1. Makes the world.
     * 
     */
    public OpeningScene()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        prepare();
    }
    
    /**
     * Adds in actors and plays the narration.
     */
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
    
    /**
     * Does what the world wants to do. Is called everytime the act button is pressed.
     */
    public void act()
    {
        setTime();
        firstChoice();
        playDrones();
        gunRoom();
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
     * When the timer reaches 110 seconds, it plays the drone narration, and animtes the trio accordingly.
     */
    public void playDrones()
    {
        if (time % 110 == 0)
        {
            drones.play();
        }
        
        if (!getObjects(Calix.class).isEmpty())
        {
            for (Object calix : getObjects(Calix.class))
            {
                if (time == 110)
                {
                    ((Calix) calix).setImage("Calix1.png");
                }
            }
        }
            
        if (!getObjects(Zyla.class).isEmpty())
        {
            for (Object zyla : getObjects(Zyla.class))
            {
                if (time == 110)
                {
                    ((Zyla) zyla).setImage("Zyla1.png");
                }
                    
                if (time == 151)
                {
                    ((Zyla) zyla).setImage("Zyla4.png");
                }
                    
                if (time == 166)
                {
                    ((Zyla) zyla).setImage("Zyla1.png");
                }
            }
        }
        
        if (!getObjects(Q.class).isEmpty())
        {
            for (Object q : getObjects(Q.class))
            {
                if (time == 110)
                {
                    ((Q) q).setImage("Q1.png");
                }
                    
                if (time == 126)
                {
                    ((Q) q).setImage("Q3.png");
                }
                    
                if (time == 132)
                {
                    ((Q) q).setImage("Q1.png");
                }
                    
                if (time == 143)
                {
                    ((Q) q).setImage("Q2.png");
                }
                    
                if (time == 167)
                {
                    ((Q) q).setImage("Q3.png");
                }
            }
        }
    }
    
    /**
     * When the timer reaches 181 seconds, it switches the world to the gun room.
     */
    public void gunRoom()
    {
        if (time % 181 == 0)
        {
            Greenfoot.setWorld(new GunRoom());
        }
    }
    
    /**
     * When the 3 button choices appear, when one of them is pressed, it deletes all three, plays the narration for the one that was pressed, 
     * and animates the trio for the button choice that was pressed.
     */
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
