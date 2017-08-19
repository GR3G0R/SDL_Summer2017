//ShapesTest.java
//Gregory Delpe
//CSc 221 1XD: Software Design Laboratory [Summer 2017]
//Exercise#1: Obtaining user input and creating a JFrame to display Shapes.

import javax.swing.*; //Handle the display
import javax.swing.JOptionPane;


public class ShapesTest
{
    public static void main(String[] args)
    {
        //Obtain user's choice
        String input = JOptionPane.showInputDialog(
                "Enter 1 to draw a sequence of alternating concentric pentagons and circles\n" +
                "Enter 2 to draw rectangles\n" +
                "Enter 3 to draw ovals");

        int choice = Integer.parseInt(input); //Convert input to int 16

        //Create the panel with the user's input
        Shapes panel = new Shapes(choice);

        JFrame application = new JFrame(); //Creates a new JFrame 21

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(400, 300); //Set size of frame
        application.setVisible(true);
    }
} //End class ShapesTest
