import greenfoot.*;

/**
 * A Counter class that allows you to display a numerical value on screen.
 * 
 * The Counter is an actor, so you will need to create it, and then add it to
 * the world in Greenfoot.  If you keep a reference to the Counter then you
 * can adjust its value.
 * 
 * @author Neil Brown and Michael Kölling 
 * @version 1.1
 */
public class Button extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private String prefix;
    private GreenfootSound narration;
    private int time = 0;
    private int count;
    
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
    
    public void hide()
    {
        if (Greenfoot.mouseClicked(this))
        {
            getWorld().removeObject(this);
        }
    }
    
    public void act()
    {
        setTime();
        hide();
    }
}
