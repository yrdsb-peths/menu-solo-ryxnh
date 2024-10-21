import greenfoot.*;
import java.util.Queue;
import java.util.LinkedList;

public class MenuScreen extends World {
    private Queue<GreenfootImage> avatars;
    private Avatar avatarActor;
    
    public MenuScreen() {    
        super(600, 400, 1);
    
        //linked list for the images of the avatar
        avatars = new LinkedList<>();
        avatars.add(new GreenfootImage("face_a.png"));
        avatars.add(new GreenfootImage("face_b.png"));
        avatars.add(new GreenfootImage("face_c.png"));
        
        //create avatar object with first image in queue
        avatarActor = new Avatar (avatars.peek());
        addObject(avatarActor, getWidth()/ 2, getHeight()/ 2); 
        
        addObject(new Button(this::goInstructions, "Instructions"), 300, 340);
        addObject(new Button(this::cycleAvatar, "Next Avatar"), 300, 300);
    }
    
    
    //method to switch to InstructionScreen
    public void goInstructions() {
        Greenfoot.setWorld(new InstructionScreen(this));
    }
    
    
    // cycle through the avatars in the queue
    public void cycleAvatar() {
        avatars.add(avatars.remove()); 
        avatarActor.setImage(avatars.peek());
    }
}
