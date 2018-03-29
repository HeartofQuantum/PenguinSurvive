import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shrimp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shrimp extends Actor
{
    /**
     * Act - do whatever the Shrimp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private GreenfootImage shrimp = new GreenfootImage("shrimp.png");
    
    public Shrimp(){
    }
    
    public Shrimp(GreenfootImage shrimp){
        this.shrimp = shrimp;
    }
    
    public GreenfootImage getShrimpImg(){
        return shrimp;
    }
    
    public void setShrimpImg(GreenfootImage shrimp){
        this.shrimp = shrimp;
    }

    
    public void act() 
    {
        move(3);
        randomTurn();
        turnAtEdge();
    }
    
    public void turnAtEdge()
    {
        if ( isAtEdge() ) 
        {
            turn(17);
        }
    }
    
    public void randomTurn()
    {
        if (Greenfoot.getRandomNumber(100) > 90) 
        {
            turn(Greenfoot.getRandomNumber(90)-45);
        }
    }
}
