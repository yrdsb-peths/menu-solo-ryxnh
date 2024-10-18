import greenfoot.*;
import java.util.Queue;
import java.util.LinkedList;

public class MenuScreen extends World {
    private Queue<GreenfootImage> avatars;
    private GreenfootImage currentAvatar;

    public MenuScreen() {    
        super(600, 400, 1);
        addObject(new Button(this::goInstructions, "Instructions"), 300, 340);

       
        avatars = new LinkedList<>();
        avatars.add(new GreenfootImage("face_a.png"));
        avatars.add(new GreenfootImage("face_b.png"));
        avatars.add(new GreenfootImage("face_c.png"));

        currentAvatar = avatars.peek();
        setBackground(currentAvatar);

        addObject(new Button(this::cycleAvatar, "Next Avatar"), 300, 300);
    }

    public void goInstructions() {
        Greenfoot.setWorld(new InstructionScreen(this));
    }

    public void cycleAvatar() {
        avatars.add(avatars.remove()); // Rotate the avatar in queue
        currentAvatar = avatars.peek();
        setBackground(currentAvatar);  //change bg to current avatar
    }
}
