import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Yes, let's blow up your competition Echo!
 * 
 * @author Millie Harrison 
 * @version 6/5/20
 */
public class YesButton extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private String prefix;
    public GreenfootSound yes;
    private int time = 0;
    private int count;
    
    /**
     * Puts words on it.
     */
    public YesButton()
    {
        this("Yes");
    }
    
    /**
     * Makes a button with specific words on it.
     */
    public YesButton(String prefix)
    {
        background = getImage();  // get image from class
        this.prefix = prefix;
        updateImage();
        yes = new GreenfootSound("Yes.mp3");
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
     * Do whatever the yes button wants to do. Called whenever the act button is pressed.
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
        if (count++ % 60 == 0)
        {
            if (time >= 0)
            {
                time++;
            }
        }
    }
    
    /**
     * When the second timer reaches 31, full transparency!
     */
    public void show()
    {
        getImage().setTransparency(0);
        
        if (time  >= 31)
        {
            getImage().setTransparency(255);
        }
    }
}