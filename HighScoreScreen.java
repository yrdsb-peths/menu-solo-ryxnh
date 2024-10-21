import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Map;
import java.util.HashMap;

/**
 * Write a description of class HighScoreScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HighScoreScreen extends World
{
    private Map<String, Integer > highScores;
    
    
    /**
     * Constructor for objects of class HighScoreScreen.
     * 
     */
    public HighScoreScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        highScores = new HashMap<>();
        
        
        //add highscores for diff people
        highScores.put("Bob", 600);
        highScores.put("Terry", 700);
        highScores.put("Kevin", 100);
        
        int yPos = getHeight() / 2;
        int xPos = getWidth() / 2;
        
        //for each loop to display each name and their score.
        for(Map.Entry<String, Integer> entry : highScores.entrySet())
        {
            String playerName = entry.getKey();
            int score = entry.getValue();
            
            Label scoreLabel = new Label (playerName + ": " + score, 30);
            addObject(scoreLabel, xPos, yPos); 
            
            yPos += 50; 
            //moves down the y position for the next entry
        }
        
        
        addObject(new Button(this::goBackToMenu, "return to menu"), 300, 350); 
        
        
    }
    
    public void goBackToMenu() 
    {
        Greenfoot.setWorld(new MenuScreen());
    }
    
}
