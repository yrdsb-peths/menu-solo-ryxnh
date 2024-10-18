import greenfoot.*;

public class Button extends Actor {
    private Runnable action;
    private String text; 
    
    public Button(Runnable action, String text) {
        this.action = action;
        GreenfootImage image = new GreenfootImage("images/buttonLong_beige.png");
        setImage(image);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (action != null) {
                action.run();
            }
        }
    }
}
