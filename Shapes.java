//Shapes.java
//Gregory Delpe
//CSc 221 1XD: Software Design Laboratory [Summer 2017]
//Exercise#1: Drawing a cascade of shapes based on the user’s choice.

import java.awt.Color;
import javax.swing.JApplet;
import java.awt.Polygon;
import java.lang.Object;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.*;

public class Shapes extends JPanel
{
    private int choice; //User's choice of which shape to draw
    private int red, green, blue;

    //Constructor sets the user's choice
    public Shapes(int userChoice)
    {
        choice = userChoice;
    }

    public double distance(double x1, double x2, double y1, double y2)
    {
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

    public double midpoint(double p1, double p2)
    {
        return ((p1 + p2) / 2);
    }

    //Draws a cascade of shapes starting from the top-left corner
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int rad, X, Y, rad_2, rad_3, rad_4;
        double dist, dist2, dist3;
        double[] xCord = new double[5];
        double[] yCord = new double[5];

        if(width < height)
            rad = width/2;
        else
            rad = height/2;

        Polygon p = new Polygon();
        Polygon new_p = new Polygon();
        Polygon new_p2 = new Polygon();

        //Construct pentagon 1
        for(int i = 0; i < 5; i++)
        {
            X = (int)(width/2 + (rad * Math.sin(i * 2 * Math.PI / 5)));
            Y = (int)(height/2 - (rad * Math.cos(i * 2 * Math.PI / 5)));
            p.addPoint(X,Y);
            xCord[i] = X;
            yCord[i] = Y;
        }

        //Determine radius of inner circle 1 & pentagon 2
        dist = distance(midpoint(xCord[0],xCord[1]),(double)(width/2),midpoint(yCord[0],yCord[1]),(double)(height/2));
        rad_2 = (int) dist;

        System.out.println(rad_2);

        //Construct pentagon 2
        for(int i = 0; i < 5; i++)
        {
            int newRad = rad_2;
            X = (int)(width/2 + (newRad * Math.sin(i * 2 * Math.PI / 5)));
            Y = (int)(height/2 - (newRad * Math.cos(i * 2 * Math.PI / 5)));
            new_p.addPoint(X,Y);
            xCord[i] = X;
            yCord[i] = Y;
        }

        //Determine radius of inner circle 2 & pentagon 3
        dist2 = distance(midpoint(xCord[0],xCord[1]),(double)(width/2),midpoint(yCord[0],yCord[1]),(double)(height/2));
        rad_3 = (int) dist2;

        //Construct pentagon 3
        for(int i = 0; i < 5; i++)
        {
            int newRad = rad_3;
            X = (int)(width/2 + (newRad * Math.sin(i * 2 * Math.PI / 5)));
            Y = (int)(height/2 - (newRad * Math.cos(i * 2 * Math.PI / 5)));
            new_p2.addPoint(X,Y);
            xCord[i] = X;
            yCord[i] = Y;
        }

        //Determine radius of inner circle 3
        dist3 = distance(midpoint(xCord[0],xCord[1]),(double)(width/2),midpoint(yCord[0],yCord[1]),(double)(height/2));
        rad_4 = (int) dist3;

        for (int i = 0; i < 10; i++)
        {
            Color myColor = new Color(red,green,blue);
            Random myRandom = new Random();

            red = myRandom.nextInt(255);
            green = myRandom.nextInt(255);
            blue = myRandom.nextInt(255);

            //Pick the shape based on the user's choice
            switch (choice)
            {
                case 1: //Draw a sequence of alternating concentric pentagons and circles
                    g.setColor(Color.PINK);
                    g.drawOval((width/2 - rad),(height/2 - rad), rad * 2, rad * 2);
                    g.fillOval((width/2 - rad),(height/2 - rad), rad * 2, rad * 2);

                    g.setColor(myColor);
                    g.drawPolygon(p);
                    g.fillPolygon(p);

                    g.setColor(Color.GREEN);
                    g.drawOval((width/2 - rad_2),(height/2 - rad_2), rad_2 * 2, rad_2 * 2);
                    g.fillOval((width/2 - rad_2),(height/2 - rad_2), rad_2 * 2, rad_2 * 2);

                    g.setColor(Color.ORANGE);
                    g.drawPolygon(new_p);
                    g.fillPolygon(new_p);

                    g.setColor(Color.MAGENTA);
                    g.drawOval((width/2 - rad_3),(height/2 - rad_3), rad_3 * 2, rad_3 * 2);
                    g.fillOval((width/2 - rad_3),(height/2 - rad_3), rad_3 * 2, rad_3 * 2);

                    g.setColor(Color.CYAN);
                    g.drawPolygon(new_p2);
                    g.fillPolygon(new_p2);

                    g.setColor(Color.WHITE);
                    g.drawOval((width/2 - rad_4),(height/2 - rad_4), rad_4 * 2, rad_4 * 2);
                    g.fillOval((width/2 - rad_4),(height/2 - rad_4), rad_4 * 2, rad_4 * 2);

                    g.setColor(Color.BLACK);
                    g.drawLine(0,0,width,height);
                    g.drawLine(0,height,width,0);
                    break;
                case 2: //Draw rectangles
                    g.setColor(myColor);
                    g.drawRect(10 + i * 10, 10 + i * 10,
                            50 + i * 10, 50 + i * 10);
                    g.fillRect(10 + i * 10, 10 + i * 10,
                            50 + i * 10, 50 + i * 10);
                    break;
                case 3: //Draw ovals
                    g.setColor(myColor);
                    g.drawOval(10 + i * 10, 10 + i * 10,
                            + i * 10, 50 + i * 10);
                    g.fillOval(10 + i * 10, 10 + i * 10,
                            + i * 10, 50 + i * 10);
                    break;
            }
        }
    }
 } // end class Shapes
