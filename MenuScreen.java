import greenfoot.*;
import java.util.Queue;
import java.util.LinkedList;

public class MenuScreen extends World {
    private Queue<GreenfootImage> avatars;
    private Avatar avatarActor;
    
    public MenuScreen() {    
        super(600, 400, 1);
    

        avatars = new LinkedList<>();
        avatars.add(new GreenfootImage("face_a.png"));
        avatars.add(new GreenfootImage("face_b.png"));
        avatars.add(new GreenfootImage("face_c.png"));

        avatarActor = new Avatar (avatars.peek());
        addObject(avatarActor, getWidth()/ 2, getHeight()/ 2); 
        
        addObject(new Button(this::goInstructions, "Instructions"), 300, 340);
        addObject(new Button(this::cycleAvatar, "Next Avatar"), 300, 300);
    }

    public void goInstructions() {
        Greenfoot.setWorld(new InstructionScreen(this));
    }

    public void cycleAvatar() {
        avatars.add(avatars.remove()); // Rotate the avatars in the queue
        avatarActor.setImage(avatars.peek());
    }
}
