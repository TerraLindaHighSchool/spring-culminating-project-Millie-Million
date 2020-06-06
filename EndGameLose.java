import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * You died to crappy drone AIs. Boo hoo.
 * 
 * @author Millie Harrison 
 * @version 6/5/20
 */
public class EndGameLose extends World
{
    /**
     * Constructor for objects of class EndGameLose. Makes the world.
     * 
     */
    public EndGameLose()
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
        GameLose gameLose = new GameLose();
        addObject(gameLose,300,200);
    }
}
