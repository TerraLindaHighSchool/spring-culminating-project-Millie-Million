import greenfoot.*;

/**
 * A blue bullet that can hit drones.
 * 
 * @author Millie Harrison
 * @version 6/5/20
 */
public class Bullet extends SmoothMover
{
    /** The damage this bullet will deal */
    private static final int damage = 16;
    
    /** A bullet looses one life each act, and will disappear when life = 0 */
    private int life = 30;
    
    /**
     * Default constructor for testing.
     */
    public Bullet()
    {
    }
    
    /**
     * Create a bullet with given speed and direction of movement.
     */
    public Bullet(Vector speed, int rotation)
    {
        super(speed);
        setRotation(rotation);
        addToVelocity(new Vector(rotation, 15));
        //Greenfoot.playSound("EnergyGun.wav");
    }
    
    /**
     * The bullet will damage drones if it hits them.
     */
    public void act()
    {
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else {
            life--;
            move();
            checkDroneHit();
        }
    }
    
    /**
     * Check whether we have hit an drone.
     */
    private void checkDroneHit()
    {
        Drone drone = (Drone) getOneIntersectingObject(Drone.class);
        if (drone != null)
        {
            getWorld().removeObject(this);
            drone.hit(damage);
        }
    }
}