import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EngineerButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EngineerButton extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private GreenfootImage background;
    private String prefix;
    private GreenfootSound engineer;
    private boolean moveOn = false;
    private GreenfootSound drones;
    
    public EngineerButton()
    {
        this("To become an Engineer");
    }

    public EngineerButton(String prefix)
    {
        background = getImage();  // get image from class
        this.prefix = prefix;
        updateImage();
        engineer = new GreenfootSound("Engineer.mp3");
        drones = new GreenfootSound("Opening Scene 2.mp3");
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
     * Act - do whatever the EngineerButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this) && !engineer.isPlaying())
        {
            engineer.play();
            moveOn = true;
            getWorld().removeObject(this);
        }
        
        if(!engineer.isPlaying() && moveOn == true)
        {
            drones.play();
        }
    }    
}
