import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mode of intergalacctic travel, very trippy.
 * 
 * @author Millie Harrison
 * @version 6/5/20
 */
public class Vortex extends World
{
    private Star[] stars = new Star[210];
    Color color1 = new Color(87,220,180);
    Color color2 = new Color(69,96,158);
    Color color3 = new Color(216,119,223);
    
    private GreenfootSound narration;
    private boolean nextWorld = false;
    
    private int time = 0;
    private int count;
    
    /**
     * Constructor for objects of class Vortex. Makes the world.
     * 
     */
    public Vortex()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        narration = new GreenfootSound("Beginning.mp3");

        GreenfootImage image = getBackground();
        image.setColor(Color.BLACK);
        image.fill();
        star();
        prepare();
    }
    
    /**
     * Adds in all the colorful flashes of light. NO, they are not stars, they are vortex points.
     */
    private void star()
    {
        for(int i = 0; i < 210; i++)
        {
            Star star;
            int deltaSpeed = Greenfoot.getRandomNumber(20);

            if(i < 70)
            {
                star = new Star(-1 - deltaSpeed, color1, getWidth(), getHeight());
                addObject(star, star.getX(), star.getY());
                stars[i] = star;
            }

            if(i >= 70 && i < 140)
            {
                star = new Star(-3 - deltaSpeed, color2, getWidth(), getHeight());
                addObject(star, star.getX(), star.getY());
                stars[i] = star;
            }

            if(i >= 140)
            {
                star = new Star(-5 - deltaSpeed, color3, getWidth(), getHeight());
                addObject(star, star.getX(), star.getY());
                stars[i] = star;
            }
        }
    }
    
    /**
     * Does what the world wants to do. Is called everytime the act button is pressed.
     */
    public void act()
    {
        for(int i = 0; i < 210; i++)
        {
            if(stars[i] != null)
            {
                stars[i].move();
            }
        }
        setTime();
        nextWorld();
        checkButtonClick();
    }

    /**
     * Adds in the echo, and the start button.
     */
    private void prepare()
    {
        Echo echo = new Echo();
        addObject(echo,123,210);
        Button button = new Button();
        addObject(button,111,381);
    }
    
    /**
     * Sets the second timer. Very important for helping with the continuity of the voiceover.
     */
    private void setTime()
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
     * Checks if the start button has been pressed.
     */
    private void checkButtonClick()
    {
        Actor button = null;
        
        if (!getObjects(Button.class).isEmpty())
        {
            button = (Actor) getObjects(Button.class).get(0);
            
            if (Greenfoot.mouseClicked(button))
            {
                narration.play();
                time = 0;
                nextWorld = true;
            }
        }
    }
    
    /**
     * If the button has been pushed and the narration is over, swutch the world to the opening scene.
     */
    public void nextWorld()
    {
        if (nextWorld == true && !narration.isPlaying())
        {
            Greenfoot.setWorld(new OpeningScene());
        }
    }
}