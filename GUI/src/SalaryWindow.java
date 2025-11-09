import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SalaryWindow{

    private JTextField inputWage = new JTextField(); //Text field for inputting wage
    private JTextField inputWeeks = new JTextField();
    private JFrame window = new JFrame();
    private JLabel wageLabel = new JLabel("Enter your hourly wage."); //Label for user prompt 1
    private JLabel weekLabel = new JLabel("Enter hours per week"); //Label for user prompt 2
    private JButton calculateButton = new JButton("Calculate"); //Calculate button

    public void assembleWindow(){
        window.setSize(640, 360); //Set the size of the window
        window.setLayout(new GridLayout(1, 1,5, 5)); //Set layout
        //Add labels and JTextFields to the window
        window.add(wageLabel);
        inputWage.setEditable(true);
        window.add(inputWage);
        window.add(weekLabel);
        inputWeeks.setEditable(true);
        window.add(inputWeeks);
        //Give the calculation button the ability to determine yearly wage by parsing Doubles from the two JTextFields,
        //and multiplying them by each other and 52 to determine yearly wage, displaying the result in a new window
        calculateButton.addActionListener(e -> {
            double wage = Double.parseDouble(inputWage.getText());
            double hours = Double.parseDouble(inputWeeks.getText());
            JFrame outputWindow = new JFrame();
            double salary = wage * hours * 52;
            String wageStatement = (String.format("Your yearly wage is: $%.2f", salary));
            JLabel wageOutput = new JLabel(wageStatement);
            outputWindow.add(wageOutput);
            outputWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            outputWindow.pack();
            outputWindow.setVisible(true);

        });
        //Add the calculate button,pack, and show window
        window.add(calculateButton);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }

}
