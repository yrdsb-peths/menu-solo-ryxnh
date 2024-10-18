import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionScreen extends World
{
    
    private String [] instructions; 
    private int index;
    private MenuScreen menu; 
    private Label instructionLabel; 
    
    
    
    /**
     * Constructor for objects of class InstructionScreen.
     * 
     */
    public InstructionScreen(MenuScreen menu)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        this.menu = menu;
        instructions = new String[]{
            
            "Welcome.",
            "Press the arrow keys to move.",
            "Press <SPACE> to jump."
        }; 
        
        index = 0;
        instructionLabel = new Label(instructions[index], 24);
        addObject(instructionLabel, 300, 200);
        
        addObject(new Button(this::nextInstruction, "Next"), 450, 350);
        addObject(new Button(this::previousInstruction, "Previous"), 150, 350);
        addObject(new Button(this::goBack, "Back to Menu"), 300, 350);

    }
    
    
    public void nextInstruction()
    {
        if (index < instructions.length - 1)
        {
            index++;
            instructionLabel.setText(instructions[index]);
        }
    }

    public void previousInstruction()
    {
        if (index > 0)
        {
            index--;
            instructionLabel.setText(instructions[index]);
            
    
        }
        
    }
    
    
    public void goBack()
    {
        Greenfoot.setWorld(menu);
    }
    
    
}
