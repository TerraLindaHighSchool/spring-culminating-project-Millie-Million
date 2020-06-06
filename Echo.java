import greenfoot.*;

/**
 * The one and only.
 * 
 * @author Millie Harrison
 * @version 6/5/20
 */
public class Echo extends SmoothMover
{
    private static final int gunReloadTime = 5;         // The minimum delay between firing the gun.
    private int reloadDelayCount;               // How long ago we fired the gun the last time.
    
    private GreenfootImage echo = new GreenfootImage("Slipstream.png");
    private GreenfootImage echoWithThrust = new GreenfootImage("EchoThrust.png");
    
    /**
     * Initialise the Echo.
     */
    public Echo()
    {
        reloadDelayCount = 5;
    }

    /**
     * Do what the Echo's gotta do. (Which is: mostly flying about, and turning,
     * accelerating and shooting when the right keys are pressed.)
     */
    public void act()
    {
        checkKeys();
        reloadDelayCount++;
        move();
        checkCollision();
    }
    
    /**
     * Check whether there are any key pressed and react to them.
     */
    private void checkKeys() 
    {
        ignite(Greenfoot.isKeyDown("up"));
        
        if (Greenfoot.isKeyDown("space")) 
        {
            fire();
        }
        
        if (Greenfoot.isKeyDown("left"))
        {
            turn(-5);
        }
        
        if (Greenfoot.isKeyDown("right"))
        {
            turn(5);
        }
        
    }
    
    /**
     * if the booster is activated, move forward and active the bright blue thrusters.
     */
    private void ignite(boolean boosterOn) 
    {
        if (boosterOn) 
        {
            setImage(echoWithThrust);
            addToVelocity(new Vector(getRotation(), 0.5));
            move();
        }
        else
        {
            setImage(echo);        
        }
    }
    
    /**
     * If you collide with a drone you lose.
     */
    private void checkCollision()
    {
        Drone a = (Drone) getOneIntersectingObject(Drone.class);
        if (a != null)
        {
            endGameLose();
            getWorld().removeObject(this);
        }
    }
    
    /**
     * You lose even more.
     */
    private void endGameLose()
    {
        Greenfoot.setWorld(new EndGameLose());
    }
    
    /**
     * Fire a bullet if the gun is ready.
     */
    private void fire() 
    {
        if (reloadDelayCount >= gunReloadTime) 
        {
           Bullet bullet = new Bullet (getVelocity(), getRotation());
           getWorld().addObject (bullet, getX(), getY());
           bullet.move ();
           reloadDelayCount = 0;
        }
    }
}