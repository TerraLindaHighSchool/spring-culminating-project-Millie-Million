import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a parallax illusion of the star field.
 * 
 * That's cool, I don't think I changed this at all, but without the light of stars, 
 * the vortex wouldn't function, so I was forced to cpy it over.
 * 
 * @author Bruce Gustin 
 * @version 3/15/2020 v1
 */
public class Star extends Actor
{
    private int x, y, speed, size;
    private Color color;
    
    /**
     * New star with inputted speed, color, width, and height.
     */
    public Star(int speed, Color color, int worldWidth, int worldHeight)
    {
      size = 1 + Greenfoot.getRandomNumber(4);
      GreenfootImage image = new GreenfootImage (size, size);
      image.setColor (color);
      image.fillOval (0, 0, size, size); 
      setImage(image);
      this.speed = speed;
      
      x = Greenfoot.getRandomNumber(worldWidth);
      y = Greenfoot.getRandomNumber(worldHeight);
    
    }
    
    /**
     * Move in a direction.
     */
    public void move()
    {
       x = speed + x;
       setLocation(x + speed, y);
       if(x < 1)
       {
          x = getWorld().getWidth();
       }
       
    }
    
    /**
     * Return the current x coordinate.
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * Return the current y coordinate.
     */
    public int getY()
    {
        return y;
    }
}