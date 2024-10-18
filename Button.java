import greenfoot.*;


public class Button extends Actor {
    private Runnable action;
    private String labelText;


    public Button(Runnable action, String labelText) {
        this.action = action;
        this.labelText = labelText;


        // Load the button image
        GreenfootImage buttonImage = new GreenfootImage("images/buttonLong_beige.png");


        // Create a new image to combine the button and the label
        GreenfootImage combinedImage = new GreenfootImage(buttonImage);


        // Set text properties: color, font size
        combinedImage.setColor(Color.BLACK);
        combinedImage.setFont(new Font("Arial", true, false, 15)); // Adjust the font size


        // Draw the label text on top of the button image (centered)
        combinedImage.drawString(labelText, ( buttonImage.getWidth() / 2) - 40 , buttonImage.getHeight() / 2);


        // Set the combined image as the actor's image
        setImage(combinedImage);
    }


    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (action != null) {
                action.run();
            }
        }
    }
}
