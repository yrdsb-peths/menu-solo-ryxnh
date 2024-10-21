import greenfoot.*;

public class InstructionScreen extends World {
    private Stack navigationStack; // stack for history 
    private MenuScreen menu; //reference to MenuScreen
    private String[] instructions; //array for instructiontext
    private int index;//index for instruction
    private Label instructionLabel; //label for instruction

    public InstructionScreen(MenuScreen menu) {
        super(600, 400, 1);
        this.menu = menu;
        this.navigationStack = new Stack();
        
        
        instructions = new String[]{
            "Use <Next Avatar> to cycle."," press <High Score Screen> to view high scores.","Press <Back to Menu> to exit."
        };
        
        index = 0; //first Instruction

        instructionLabel = new Label(instructions[index], 24);
        addObject(instructionLabel, 300, 200);
        
        //adding buttons for navigation
        addObject(new Button(this::nextInstruction, "Next"), 450, 350);
        addObject(new Button(this::previousInstruction, "Previous"), 150, 350);
        addObject(new Button(this::goBack, "Back to Menu"), 300, 350);
    }
    
    
    //method for next instruction
    public void nextInstruction() {
        if (index < instructions.length - 1) {
            index++;
            instructionLabel.setText(instructions[index]);
        }
    }
    
    //method for previous instruction
    public void previousInstruction() {
        if (index > 0) {
            index--;
            instructionLabel.setText(instructions[index]);
        }
    }
    
    
    //method for returning to MenuScreen
    public void goBack() {
        navigationStack.push("InstructionScreen");
        Greenfoot.setWorld(menu);
    }
}
