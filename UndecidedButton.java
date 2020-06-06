import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The undecided choice. Not much of a future in education for you, maybe the academy has room for you in their elite squadron of fighter pilots.
 * Hint hint.
 * 
 * @author Millie Harrison 
 * @version 6/5/20
 */
public class UndecidedButton extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private String prefix;
    private int time = 0;
    private int count;
    
    /**
     * Put words on it.
     */
    public UndecidedButton()
    {
        this("I don't know yet...");
    }
    
    /**
     * Make a button with specific words on it.
     */
    public UndecidedButton(String prefix)
    {
        background = getImage();  // get image from class
        this.prefix = prefix;
        updateImage();
    }
    
    /**
     * Update the image on screen to show the current value.
     */
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(background);
        GreenfootImage text = new GreenfootImage(prefix, 22, Color.BLACK, transparent);
        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }
        
        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
                        (image.getHeight()-text.getHeight())/2);
        setImage(image);
    }
    
    /**
     * Do whatever the undecided button wants to do. Called whenever the act button is pressed.
     */
    public void act()
    {
        setTime();
        show();
    }
    
    /**
     * Sets the second timer. Very important for helping with the continuity of the voiceover.
     */
    public void setTime()
    {
        if (count++ %60 == 0)
        {
            if (time >= 0)
            {
                time++;
            }
        }
    }
    
    /**
     * Whe the second timer reaches 74, full transparency!
     */
     public void show()
    {
        getImage().setTransparency(0);
        
        if (time >= 74)
        {
            getImage().setTransparency(255);
        }
    }
}