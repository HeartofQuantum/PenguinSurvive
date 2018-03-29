import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Penguin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Penguin extends Actor

{
    /**
     * Act - do whatever the Penguin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private GreenfootImage penguin = new GreenfootImage("penguin.png");
    private GreenfootSound yum = new GreenfootSound("yum.wav");
    private int pSpeed = 3;
    private int tShrimp = 0;

    public void act() 
    {
        checkKeys();
        eatShrimp();
        slow();
        //speedUp();
    }
    
    private void checkKeys() 
    {
        if (Greenfoot.isKeyDown("left"))
        {
            turn(-pSpeed);
        }
        
        if (Greenfoot.isKeyDown("right"))
        {
            turn(pSpeed);
        }
        
        if (Greenfoot.isKeyDown("up"))
        {
            move(pSpeed);
        }
        
        if (Greenfoot.isKeyDown("down"))
        {
            move(-pSpeed);
        }
    }
    
    public int getShrimp(){
        return tShrimp;
    } 
    
    public void setShrimp(int tShrimp){
        this.tShrimp = tShrimp;
    }
    
    
    private void slow()
    {
        if (isTouching(Iceberg.class))
        {
            pSpeed = 1;
            if (tShrimp > 10)
            {
            pSpeed = 4; 
            }
        }
        else
        { 
            pSpeed = 3;
        }
    }
    
    public void speedUp()
    {
//        if (tShrimp > 10)
//        {
 //           pSpeed = 4; 
  //      }
  //      if (tShrimp > 20)
  //      {
  //          pSpeed = 5;
  //      }
    }
    
    
    public void eatShrimp()
    {
        if (isTouching(Shrimp.class))
        {
            removeTouching(Shrimp.class);
            yum.play();
            tShrimp += 1;
        }
    }
    
    public boolean isEating()
    {
        if (isTouching(Shrimp.class))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    public boolean isFull(int tShrimps){
        if (tShrimp >= 5){
           return true;
        }
        else
        {
           return false;
        }
    }
}
