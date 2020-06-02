import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EngineerButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextButton2 extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private String prefix;
    private boolean next = false;
    public GreenfootSound end;
    
    public NextButton2()
    {
        this("Next");
    }

    public NextButton2(String prefix)
    {
        background = getImage();  // get image from class
        this.prefix = prefix;
        updateImage();
        end = new GreenfootSound("Win scenario.mp3");
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
    
    public void act()
    {
            if (Greenfoot.mouseClicked(this) && !end.isPlaying())
            {
                end.play();
                getWorld().removeObject(this);
            }
    }
}