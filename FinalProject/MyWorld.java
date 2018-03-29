import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    private Penguin myPenguin = new Penguin();
    private int gTime;
    
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addSealions(1);
        addShrimps(Greenfoot.getRandomNumber(6));
        addIcebergs(Greenfoot.getRandomNumber(10));
        addObject(myPenguin, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));        
        gTime = 3000; 
    }
   
    public void act()
    {   
        
        if (Greenfoot.getRandomNumber(100) < 5)
        {
            addShrimps(Greenfoot.getRandomNumber(2));
        }
        
        if (myPenguin.isFull(myPenguin.getShrimp()) == true && gTime == 2000)
        {
            addSealions(1);
        }
        
        if (myPenguin.isFull(myPenguin.getShrimp()) == true && gTime == 1000)
        {
            addSealions(1);
        }
        
        if (myPenguin.isFull(myPenguin.getShrimp()) == true && gTime == 500)
        {
            addSealions(2);
        }        

       // if ()
        
        gameTimer();
    }
    
    private void gameTimer()
    {
        gTime--;
        displayTime();
        if (gTime == 0)
        {
            showText("Shrimp caught: " + myPenguin.getShrimp(), 300, 200);
            Greenfoot.stop();            
        }
    }
    
    private void displayTime()
    {
        showText("Time: " + gTime, 500, 50);
    }
    
    
    private void addShrimps(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getHeight()/2);
            addObject(new Shrimp(), x, y);
        }
    }
    
    private void addSealions(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getHeight()/2);            
            addObject(new Sealion(), x, y);
        }
    }
    
    private void addIcebergs(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(new Iceberg(), x, y);
        }
    }
    
}
