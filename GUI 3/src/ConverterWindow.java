import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class ConverterWindow {
    private JFrame convertFrame; //JFrame for containing all elements
    private JLabel prompt; //Label for prompting user
    private JLabel result; //Labell for result of user input
    private JSpinner distance; //JSpinner for value input
    private JButton calculate; //JButton for calculation
    private GridBagConstraints layoutStuff; //Layout parameters that will be used for the JFrame and all elements inside

    public void assembleWindow()
    {
        convertFrame = new JFrame();
        convertFrame.setLayout(new GridBagLayout());
        convertFrame.setBounds(0,0,600,480); //Set bounds

        prompt = new JLabel("Select mile distance:"); //Make prompt

        SpinnerNumberModel mileRange = new SpinnerNumberModel(0,0,999,1); //Make a range of numbers for the JSpinner
        distance = new JSpinner(mileRange); //Make the JSpinner
        //The button will create a new window that will display the converted value from miles to kilometers
        calculate = new JButton("Calculate");
        calculate.addActionListener(e -> {
            JFrame resultFrame = new JFrame();
            int miles = (Integer) distance.getValue();
            double converted = miles * 1.609;
            result = new JLabel(String.format("Distance in km: %.4f", converted));
            resultFrame.add(result);
            resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            resultFrame.pack();
            resultFrame.setVisible(true);
        });
        //Set the layout of the window and add the prompt, JSpinner, and button
        layoutStuff = new GridBagConstraints();
        layoutStuff.insets = new Insets(10,10,10,10);
        layoutStuff.gridx = 0;
        layoutStuff.gridy = 1;
        convertFrame.add(prompt, layoutStuff);

        layoutStuff = new GridBagConstraints();
        layoutStuff.gridx = 0;
        layoutStuff.gridy = 0;
        layoutStuff.insets = new Insets(10,10,10,10);
        convertFrame.add(distance, layoutStuff);

        layoutStuff = new GridBagConstraints();
        layoutStuff.gridx = 0;
        layoutStuff.gridy = -1;
        layoutStuff.insets = new Insets(10,10,10,10);
        convertFrame.add(calculate);
        //Put the window together
        convertFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        convertFrame.pack();
        convertFrame.setVisible(true);

    }
}
