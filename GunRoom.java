import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Pew pew. You enter the gun room.
 * 
 * @author Millie Harrison 
 * @version 6/5/20
 */
public class GunRoom extends World
{
    private GreenfootSound yes = new GreenfootSound("Yes.mp3");
    private GreenfootSound maybe = new GreenfootSound("maybe.mp3");
    private GreenfootSound no = new GreenfootSound("no.mp3");
    private GreenfootSound drones2 = new GreenfootSound("Opening Scene 3.mp3");
    private GreenfootSound explode = new GreenfootSound("don't explode.mp3");
    
    private int time = 0;
    private int count;

    /**
     * Constructor for objects of class GunRoom. Makes the world.
     * 
     */
    public GunRoom()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        prepare();
    }
    
    /**
     * Plays the narrative, adds in invisible buttons, and a headset, sets the paint order.
     */
    private void prepare()
    {      
        drones2.play();
        YesButton yesButton = new YesButton();
        addObject(yesButton,181,23);
        NoButton noButton = new NoButton();
        addObject(noButton,417,23);
        MaybeButton maybeButton = new MaybeButton();
        addObject(maybeButton,300,23);
        Headset headset = new Headset();
        addObject(headset, 300, 200);
        
        setPaintOrder(YesButton.class, NoButton.class, MaybeButton.class, HeadsetBlast.class, Headset.class);
    }
    
    /**
     * Does what the world wants to do. Is called everytime the act button is pressed.
     */
    public void act()
    {
        setTime();
        removeButtons();
        playExplode();
        space();
        brightColors();
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
     * Plays Echo's reassuring narrative when teh second timer reaches 110.
     */
    public void playExplode()
    {
        if (time % 110 == 0)
        {
            explode.play();
        }
    }
    
    /**
     * Blinds you with a headset flash when the second timer reaches 117.
     */
    public void brightColors()
    {
        if (time % 117 == 0)
        {
            addObject(new HeadsetBlast(), 300, 200);
        }
    }
    
    /**
     * Switches the world to space when the second timer reaches 121.
     */
    public void space()
    {
        if (time % 121 == 0)
        {
            Greenfoot.setWorld(new Space());
        }
    }
    
    /**
     * Gets rid of the choice buttons when one of them is pressed. Plays the narratio of the selected button.
     */
    private void removeButtons()
    {
        Actor yesButton = null;
        Actor maybeButton = null;
        Actor noButton = null;
        
        if (!getObjects(YesButton.class).isEmpty() && !getObjects(MaybeButton.class).isEmpty() && !getObjects(NoButton.class).isEmpty())
        {
            yesButton = (Actor) getObjects(YesButton.class).get(0);
            maybeButton = (Actor) getObjects(MaybeButton.class).get(0);
            noButton = (Actor) getObjects(NoButton.class).get(0);
            
            if (Greenfoot.mouseClicked(yesButton))
            {
                yes.play();
                time = 107;
                removeObject(yesButton);
                removeObject(maybeButton);
                removeObject(noButton);
            }
            
            if (Greenfoot.mouseClicked(maybeButton))
            {
                maybe.play();
                time = 105;
                removeObject(yesButton);
                removeObject(maybeButton);
                removeObject(noButton);
            }
            
            if (Greenfoot.mouseClicked(noButton))
            {
                no.play();
                time = 106;
                removeObject(yesButton);
                removeObject(maybeButton);
                removeObject(noButton);
            }
        }
    }
}