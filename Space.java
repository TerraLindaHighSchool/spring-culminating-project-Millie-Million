import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Ah, Space. Where you can get blown up by flying drone ships.
 * 
 * @author Millie Harrison 
 * @version 6/5/20
 */
public class Space extends World
{
    private Star[] stars = new Star[210];
    Color color1 = new Color(229,227,246);
    Color color2 = new Color(226,240,238);
    Color color3 = new Color(241,226,242);

    /**
     * Constructor for objects of class Space. Makes the world.
     * 
     */
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        GreenfootImage image = getBackground();
        image.setColor(Color.BLACK);
        image.fill();
        star();
        prepare();
    }
    
    /**
     * Adds tiny little random stars. Twinkle twinkle.
     */
    private void star()
    {
        for(int i = 0; i < 210; i++)
        {
            Star star;
            int deltaSpeed = Greenfoot.getRandomNumber(2);
            
            if(i < 70)
            {
                star = new Star(-1 - deltaSpeed, color1, getWidth(), getHeight());
                addObject(star, star.getX(), star.getY());
                stars[i] = star;
            }

            if(i >= 70 && i < 140)
            {
                star = new Star(-3 - deltaSpeed, color2, getWidth(), getHeight());
                addObject(star, star.getX(), star.getY());
                stars[i] = star;
            }

            if(i >= 140)
            {
                star = new Star(-5 - deltaSpeed, color3, getWidth(), getHeight());
                addObject(star, star.getX(), star.getY());
                stars[i] = star;
            }
        }
    }
    
    /**
     * Does what the world wants to do. Is called everytime the act button is pressed.
     */
    public void act()
    {
        List drones = getObjects(Drone.class);
        if (drones.size() == 0)
        {
            Greenfoot.setWorld(new GunRoom2());
        }
    }
    
    /**
     * Adds in the Echo and 3 drone ships. How'd this method get way down here? Nobody knows.
     */
    private void prepare()
    {
        Echo echo = new Echo();
        addObject(echo,123,210);
        Drone drone = new Drone();
        addObject(drone,479,157);
        Drone drone2 = new Drone();
        addObject(drone2,427,206);
        Drone drone3 = new Drone();
        addObject(drone3,479,255);
    }
}