import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Wow! You made it to the end! Next chapter of Nebula coming soon! ;)
 * 
 * @author Millie Harrison 
 * @version 6/5/20
 */
public class EndGameWin extends World
{
    /**
     * Constructor for objects of class EndGameWin. Makes the world.
     * 
     */
    public EndGameWin()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        GreenfootImage image = getBackground();
        image.setColor(Color.BLACK);
        image.fill();
        prepare();
    }

    /**
     * Adds the end game text.
     */
    private void prepare()
    {
        GameWin gameWin = new GameWin();
        addObject(gameWin,300,200);
    }
}
