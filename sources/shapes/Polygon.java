//File Name: Polygon.java
//Gregory Delpe
//CSc221

package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Dimension;
import javax.swing.JApplet;
import javax.swing.JPanel;
import java.util.*;
import javax.swing.*;
import java.awt.geom.Area;

public class Polygon extends Shape
{
    private int N;
    private Point[] cords;
    private int newRadius;
    private int radius;
    private double[] xCord;
    private double[] yCord;

    public Polygon(Color color, int x_Cord , int y_Cord, int N, int radius)
    {
        super(color, x_Cord, y_Cord);

        this.N = N;
        this.radius = radius;
    }


    public double distance(double x1, double x2, double y1, double y2)
    {
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

    public double getArea() //Pentagon
    {
        double a = (2 * radius * Math.sin(Math.PI / N));
        return (1/4) * Math.sqrt(5 * (5 + (2 * Math.sqrt(5)))) * Math.pow(a,2);
    }

    public double getXCord(int index)
    {
        return this.xCord[index];
    }

    public double getYCord(int index)
    {
        return this.yCord[index];
    }

    public double getPerimeter()
    {
        double sum = 0.0;
        for(int i = 0; i < N; i++)
             sum = sum + distance(getXCord(i), getXCord(i+1),
                    getYCord(i), getYCord(i+1));
        return sum;
    }

    public double getAngle()
    {
        return (2 * Math.PI / N);

    }

    public double getSide()
    {
        return distance(cords[1].getX(), cords[2].getX(),
                cords[1].getY(), cords[2].getY());
    }


    @Override
    public void getPoint()
    {
        System.out.printf("(%s,%s)",getX(),getY());
    }

    @Override
    public double distanceTo(double x1, double x2, double y1, double y2)
    {
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

    @Override
    public Rectangle getBoundingBox()
    {
        int width = getWidth();
        int height = getHeight();

        Rectangle rect = new Rectangle(getColor(), getX(), getY(), width, height);
        return rect;
    }

    @Override
    public boolean doOverlap(java.awt.Shape shapeA, java.awt.Shape shapeB)
    {
        Area area = new Area(shapeA);
        area.intersect(new Area(shapeB));
        return !area.isEmpty();
    }

    @Override
    public String toString()
    {
        return String.format("%s: %s%n%s: %s", "Area", getArea(),
                "Angle", getAngle());
    }


    public Dimension getPreferredSize()
    {
        return new Dimension(400, 300);
    }

    public double midpoint(double p1, double p2)
    {
        return ((p1 + p2) / 2);
    }

    @Override
    public void draw(Graphics g)
    {

        int X, Y, rad, rad_1;
        double dist;
        int width = getWidth();
        int height = getHeight();
        xCord = new double[8];
        yCord = new double[8];

        if(width < height)
            rad = radius;
        else
            rad = radius;

        java.awt.Polygon p = new java.awt.Polygon();

        for (int i = 0; i < N; i++)
        {
            X = (int) (width/2 + (rad * Math.sin(i * 2 * Math.PI / N)));
            Y = (int) (width/2 - (rad * Math.cos(i * 2 * Math.PI / N)));
            p.addPoint(X,Y);
            xCord[i] = X;
            yCord[i] = Y;
       }

       dist = distance(midpoint(xCord[0],xCord[1]),(double)(width/2),midpoint(yCord[0],yCord[1]),(double)(height/2));
       rad_1 = (int) dist;
       setNewRadius(rad_1);

       Color color = new Color(0,255,0);
       setBackground(new Color(0,0,0,0));

       g.setColor(getColor());
       g.drawPolygon(p);
       g.fillPolygon(p);
       g.setColor(Color.BLACK);
       g.drawString(toString(), width/2 + rad, height/2);
    }

    public void setNewRadius(int newRadius)
    {
        this.newRadius = newRadius;
    }

    public int getNewRadius()
    {
        return this.newRadius;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }
}
