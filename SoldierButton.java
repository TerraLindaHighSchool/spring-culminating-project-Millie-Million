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
    public GreenfootSound soldier;
    private boolean next = false;
    private GreenfootSound drones;
    
    public SoldierButton()
    {
        this("To become a soldier");
    }

    public SoldierButton(String prefix)
    {
        background = getImage();  // get image from class
        this.prefix = prefix;
        updateImage();
        soldier = new GreenfootSound("Soldier.mp3");
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
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this) && !soldier.isPlaying())
        {
            soldier.play();
            getWorld().removeObject(this);
        }
        
        if (Greenfoot.mouseClicked(EngineerButton.class) || Greenfoot.mouseClicked(UndecidedButton.class))
        {
            getWorld().removeObject(this);
        }
    }
}