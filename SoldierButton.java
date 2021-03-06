import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The soldier choice. An edcuation path that is really a war path. Hey, those hologuns are dangerous!
 * 
 * @author Millie Harrison 
 * @version 6/5/20
 */
public class SoldierButton extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private String prefix;
    private int time = 0;
    private int count;
    
    /**
     * Puts words on it.
     */
    public SoldierButton()
    {
        this("To become a soldier");
    }
    
    /**
     * Makes a button with specific words on it.
     */
    public SoldierButton(String prefix)
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
     * Do whatever the soldier button wants to do. Called whenever the act button is pressed.
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
     * When the second tiemr reaches 74, full transparency!
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