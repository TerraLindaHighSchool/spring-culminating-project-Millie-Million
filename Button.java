import greenfoot.*;

/**
 * The button to top all buttons, the start button.
 * 
 * @author Millie Harrison
 * @version 6/5/20
 */
public class Button extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private String prefix;
    private GreenfootSound narration;
    private int time = 0;
    private int count;
    
    /**
     * Puts words on the button.
     */
    public Button()
    {
        this("Click to Begin Adventure");
    }

    /**
     * Create a button for later use to initialize the narration.
     */
    public Button(String prefix)
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
     * If it's clicked, it's gone.
     */
    public void hide()
    {
        if (Greenfoot.mouseClicked(this))
        {
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Does what the button wants to do. Is called everytime the act button is pressed.
     */
    public void act()
    {
        setTime();
        hide();
    }
}
