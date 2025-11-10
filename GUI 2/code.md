# Main
```
void main() {
    DistanceWindow newWindow = new DistanceWindow();
    newWindow.assembleWindow(); //Call DistanceWindow's assemble method
}
```
# DistanceWindow
```
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class DistanceWindow {

    private JFrame distanceThing; //JFrame for distance input
    private JFrame distanceResult; //JFrame for converted output
    private JLabel prompt; //Used for user prompting
    private JLabel resultKm; //Result in kilometers
    private JLabel resultMeter; //Result in meters
    private JLabel resultFeet; //Result in feet
    private JButton calculateButton; //Button for calculation
    private JFormattedTextField inputField; //Field for user input

    public void assembleWindow()
    {
        //Setup for JFrame
        distanceThing = new JFrame();
        distanceThing.setBounds(0,0,1280,720);
        distanceThing.setLayout(new GridLayout(3,3,5,5));
        //Label for prompt
        prompt = new JLabel("Input distance: ");
        //Prepare for user input
        inputField = new JFormattedTextField();
        inputField.setEditable(true);
        //Make calculation button that will parse the JFormattedTextField for integer value and convert to feet, km, and m, displaying a new window for the results
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(e -> {
            int distanceInput = Integer.parseInt(inputField.getText());
            int feet = distanceInput * 5280;
            double kilometer = distanceInput * 1.609;
            double meter = kilometer * 1000;
            String feetResult = "Distance in feet: " + feet;
            resultKm = new JLabel(String.format("Distance in kilometers: %.2f", kilometer));
            resultFeet = new JLabel(feetResult);
            resultMeter = new JLabel(String.format("Distance in meters: %.2f", meter));

            distanceResult = new JFrame();
            distanceResult.setBounds(0,0,400,300);
            distanceResult.setLayout(new GridLayout(1,3,2,2));
            distanceResult.add(resultKm, Component.TOP_ALIGNMENT);
            distanceResult.add(resultMeter, Component.CENTER_ALIGNMENT);
            distanceResult.add(resultFeet, Component.BOTTOM_ALIGNMENT);
            distanceResult.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            distanceResult.pack();
            distanceResult.setVisible(true);
        });
        //Add all components, pack, and show window
        distanceThing.add(prompt, Component.LEFT_ALIGNMENT);
        distanceThing.add(inputField, Component.CENTER_ALIGNMENT);
        distanceThing.add(calculateButton, Component.RIGHT_ALIGNMENT);
        distanceThing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        distanceThing.pack();
        distanceThing.setVisible(true);
    }
}
```
