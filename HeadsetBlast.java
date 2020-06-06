import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Get blinded by light and color.
 * 
 * @author Millie Harrison
 * @version 6/5/20
 */
public class HeadsetBlast extends Actor
{
    /** How many images should be used in the animation of the explostion of color*/
    private final static int IMAGE_COUNT= 12;
    
    /** 
     * The images in the explosion of color. This is static so the images are not
     * recreated for every object (improves performance significantly).
     */
    private static GreenfootImage[] images;
    
    /** Current size of the explosion of color*/
    private int imageNo = 0;
    
    /** How much do we increment the index in the explosion of color animation. */
    private int increment=1;
    
    /**
     * Create a new explosion of color.
     */
    public HeadsetBlast() 
    {
        initializeImages();
        setImage(images[0]);
    }    
    
    /** 
     * Create the images for explosion of color.
     */
    public synchronized static void initializeImages() 
    {
        if(images == null) 
        {
            GreenfootImage baseImage = new GreenfootImage("HeadsetBlast.png");
            images = new GreenfootImage[IMAGE_COUNT];
            for (int i = 0; i < IMAGE_COUNT; i++)
            {
                int size = (i+1) * ( baseImage.getWidth() / IMAGE_COUNT );
                images[i] = new GreenfootImage(baseImage);
                images[i].scale(size, size);
            }
        }
    }
    
    /**
     * Explosion of color!
     */
    public void act()
    { 
        setImage(images[imageNo]);

        imageNo += increment;
        if(imageNo >= IMAGE_COUNT) 
        {
            increment = -increment;
            imageNo += increment;
        }
        
        if(imageNo < 0) 
        {
            getWorld().removeObject(this);
        }
    }
}
