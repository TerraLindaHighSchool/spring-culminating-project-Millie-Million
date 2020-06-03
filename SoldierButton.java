import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EngineerButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoldierButton extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private String prefix;
    private int time = 0;
    private int count;
    
    public SoldierButton()
    {
        this("To become a soldier");
    }

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
    
    public void act()
    {
        setTime();
        show();
    }
    
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
    
     public void show()
    {
        getImage().setTransparency(0);
        if (time >= 74)
        {
            getImage().setTransparency(255);
        }
    }
}