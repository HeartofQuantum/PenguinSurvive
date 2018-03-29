import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sealion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sealion extends Actor
{
    /**
     * Act - do whatever the Sealion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private GreenfootImage sealion = new GreenfootImage("sealion.png");
    private int lionSpeed = 4;
    private GreenfootSound shucks = new GreenfootSound("shucks.wav");
    
    public Sealion(){}

    public Sealion(int lionSpeed){
        this.sealion = sealion;
        this.lionSpeed = lionSpeed;
    }
    
    public void act() 
    {
        turnAtEdge();
        randomTurn();
        move(lionSpeed);
        adjustSpeed();
        eatPenguin();
    }
    
    public int getLionSpeed(){
        return lionSpeed;
    }
    
    public void setLionSpeed(int lionSpeed){
        this.lionSpeed = lionSpeed;
    }
    
    public void turnAtEdge()
    {
        if ( isAtEdge() ) 
        {
            turn(17);
        }
    }
    
    private void adjustSpeed()
    {
        if (isTouching(Iceberg.class))
        {
            lionSpeed = 1;
        }
        else
        {
            lionSpeed = 3;
        }
    }
    
    public void randomTurn()
    {
        if (Greenfoot.getRandomNumber(100) > 90) 
        {
            turn(Greenfoot.getRandomNumber(90)-45);
        }
    }
    
    public void eatPenguin()
    {
        if (isTouching(Penguin.class))
        {
            removeTouching(Penguin.class);
            shucks.play();        

            Greenfoot.stop();
        }
    }
    
    public boolean isEatingPenguin()
    {
        if (isTouching(Penguin.class))
        {
            return true;
        }
        else return false;
    }   
    
}
