//File Name: ShapesTest.java
//Gregory Delpe
//CSc 221 1XD: Software Design Laboratory [Summer 2017]
//Exercise#3: Obtaining user input and creating a JFrame to display Shapes.

package shapes;

import javax.swing.*; //Handle the display
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Point;
import java.awt.*;
import java.util.*;


public class ShapesTest
{
    public static void main(String[] args)
    {

        int width = 400;
        int height = 300;
        int offset = 20;

        Oval oval = new Oval(Color.GREEN, 48, 36, 350, 250);
        Rectangle rect = new Rectangle(Color.YELLOW, 48, 36, 350, 250);
        double newx = 200 - ((350/2)/Math.sqrt(2));
        double newy = 150 - ((270/2)/Math.sqrt(2));
        double newwidth = 370 - (370/2)/Math.sqrt(2);
        double newheight = 270 - (250/2)/Math.sqrt(2);
        Oval oval2 = new Oval(Color.RED, (int) newx, (int) newy, (int) newwidth, (int) newheight);
        Rectangle rect2 = new Rectangle(Color.CYAN, (int) newx, (int) newy, (int) newwidth, (int) newheight);
        double newx2 = 400/2 - ((newwidth + offset)/2)/Math.sqrt(2);
        double newy2 = 300/2 - ((newheight)/2)/Math.sqrt(2);
        double newwidth2 = (newwidth + offset) - ((newwidth)/2)/Math.sqrt(2);
        double newheight2 = (newheight) - ((newheight)/2)/Math.sqrt(2);
        Oval oval3 = new Oval(Color.ORANGE, (int) newx2 - 16, (int) newy2 - 16, (int) newwidth2, (int) newheight2);
        Rectangle rect3 = new Rectangle(Color.BLUE, (int) newx2 - 16, (int) newy2 - 16, (int) newwidth2, (int) newheight2);
        DrawPanel shapeArray = new DrawPanel();



        shapeArray.add(oval3);
        shapeArray.add(rect3);
        shapeArray.add(oval2);
        shapeArray.add(rect2);
        shapeArray.add(oval);
        shapeArray.add(rect);

        JFrame application = new JFrame("Gregory Delpe: Polymorphic Shape Implementation"); //Creates a new JFrame

        application.setPreferredSize(new Dimension(400,300));

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(400, 300); //Set size of frame

        application.add(shapeArray);

        application.setVisible(true);

    }
} //End class ShapesTest
