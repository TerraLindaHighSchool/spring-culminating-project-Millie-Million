import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OpeningScene1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     * Constructor for objects of class OpeningScene1.
     * 
     */
    public GunRoom()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        prepare();
    }
    
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
    
    public void act()
    {
        setTime();
        removeButtons();
        playExplode();
        space();
        brightColors();
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
    
    public void playExplode()
    {
        if (time % 110 == 0)
        {
            explode.play();
        }
    }
    
    public void brightColors()
    {
        if (time % 117 == 0)
        {
            addObject(new HeadsetBlast(), 300, 200);
        }
    }
    
    public void space()
    {
        if (time % 121 == 0)
        {
            Greenfoot.setWorld(new Space());
        }
    }
    
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