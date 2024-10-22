import greenfoot.*;

public class MenuScreen extends World {
    private Queue<GreenfootImage> avatars; 
    private Avatar avatarActor;
    
    public MenuScreen() {    
        super(600, 400, 1);
    
        //linked list for the images of the avatar
        avatars = new Queue<>();
        avatars.enqueue(new GreenfootImage("face_a.png"));
        avatars.enqueue(new GreenfootImage("face_b.png"));
        avatars.enqueue(new GreenfootImage("face_c.png"));
        
        //create avatar object with first image in queue
        if (!avatars.isEmpty()) {
            avatarActor = new Avatar(avatars.dequeue()); 
            addObject(avatarActor, getWidth() / 2, getHeight() / 2); 
        }
        addObject(new Button(this::goHighScore, "High score screen"), 300, 380);
        addObject(new Button(this::goInstructions, "Instructions"), 300, 340);
        addObject(new Button(this::cycleAvatar, "Next Avatar"), 300, 300);
    }
    
    
    //method to switch to InstructionScreen
    public void goInstructions() {
        Greenfoot.setWorld(new InstructionScreen(this));
    }
    
    //method to swithc to HighScoreScreen
    public void goHighScore()
    {
        Greenfoot.setWorld(new HighScoreScreen());
    }
    
    // cycle through the avatars in the queue
    public void cycleAvatar() {
        avatars.enqueue(avatarActor.getImage()); //set current avatar in queue
        avatarActor.setImage(avatars.dequeue()); //set to next avatar
    }
}
