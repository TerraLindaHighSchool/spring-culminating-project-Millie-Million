import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Instantiates stars and draws them to the world
 * 
 * @author Bruce Gustin
 * @version 3/15/2020 v1
 */
public class Vortex extends World
{
    private Star[] stars = new Star[210];
    Color color1 = new Color(87,220,180);
    Color color2 = new Color(69,96,158);
    Color color3 = new Color(216,119,223);
    private GreenfootSound soldier = new GreenfootSound("Soldier.mp3");
    private GreenfootSound engineer = new GreenfootSound("Engineer.mp3");
    private GreenfootSound undecided = new GreenfootSound("undecided.mp3");

    /**
     * Constructor for objects of class Vortex.
     * 
     */
    public Vortex()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);

        GreenfootImage image = getBackground();
        image.setColor(Color.BLACK);
        image.fill();
        star();
        prepare();
    }

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

    public void act()
    {
        for(int i = 0; i < 210; i++)
        {
            if(stars[i] != null)
            {
                stars[i].move();
            }
        }
        removeButtons();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Echo echo = new Echo();
        addObject(echo,123,210);
        Button button = new Button();
        addObject(button,111,381);
        EngineerButton engineerButton = new EngineerButton();
        addObject(engineerButton,466,95);
        SoldierButton soldierButton = new SoldierButton();
        addObject(soldierButton,157,96);
        UndecidedButton undecidedButton = new UndecidedButton();
        addObject(undecidedButton,381,286);
    }
    
    public void removeButtons()
    {
        Actor engineerButton = null;
        Actor undecidedButton = null;
        Actor soldierButton = null;
        if (!getObjects(EngineerButton.class).isEmpty() && !getObjects(UndecidedButton.class).isEmpty() && !getObjects(SoldierButton.class).isEmpty())
        {
            engineerButton = (Actor) getObjects(EngineerButton.class).get(0);
            undecidedButton = (Actor) getObjects(UndecidedButton.class).get(0);
            soldierButton = (Actor) getObjects(SoldierButton.class).get(0);
            if (Greenfoot.mouseClicked(engineerButton))
            {
                engineer.play();
                removeObject(engineerButton);
                removeObject(soldierButton);
                removeObject(undecidedButton);
            }
            
            if (Greenfoot.mouseClicked(soldierButton))
            {
                soldier.play();
                removeObject(engineerButton);
                removeObject(soldierButton);
                removeObject(undecidedButton);
            }
            
            if (Greenfoot.mouseClicked(undecidedButton))
            {
                undecided.play();
                removeObject(engineerButton);
                removeObject(soldierButton);
                removeObject(undecidedButton);
            }
        }
    }
}