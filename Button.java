import greenfoot.*;


public class Button extends Actor {
    private Runnable action;
    private String labelText;


    public Button(Runnable action, String labelText) {
        this.action = action;
        this.labelText = labelText;


        //Load the button image
        GreenfootImage buttonImage = new GreenfootImage("images/buttonLong_beige.png");


        //combine the button and the label
        GreenfootImage combinedImage = new GreenfootImage(buttonImage);


        combinedImage.setColor(Color.BLACK);
        combinedImage.setFont(new Font("Arial", true, false, 15)); // Adjust the font size


        //draw and center the combined image
        combinedImage.drawString(labelText, ( buttonImage.getWidth() / 2) - 40 , buttonImage.getHeight() / 2);


        // Set combined image as the actor's image
        setImage(combinedImage);
    }

    //check if user clicked on (this) obeject. 
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (action != null) {
                action.run();
            }
        }
    }
}
