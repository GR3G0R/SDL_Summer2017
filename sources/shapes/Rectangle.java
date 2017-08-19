//File Name: Rectangle.java
//Gregory Delpe
//CSc221

package shapes;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.geom.Area;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.JApplet;
import java.awt.*;
import javax.swing.*;


public class Rectangle extends Shape
{
    private int recWidth;
    private int recHeight;

    public Rectangle(Color color, int xCord, int yCord, int recWidth, int recHeight)
    {
        super(color,xCord,yCord);

        this.recWidth = recWidth;
        this.recHeight = recHeight;
    }

    @Override
    public void getPoint()
    {
        System.out.printf("(%s,%s)",getX(),getY());
    }

    @Override
    public Rectangle getBoundingBox()
    {

        Rectangle rect = new Rectangle(getColor(), getX(), getY(), recWidth, recHeight);
        return rect;
    }

    @Override
    public boolean doOverlap(java.awt.Shape shapeA, java.awt.Shape shapeB)
    {
        Area area = new Area(shapeA);
        area.intersect(new Area(shapeB));
        return !area.isEmpty();

    }

    public Dimension getPreferredSize()
    {
        return new Dimension(600, 500);
    }

    @Override
    public double getArea()
    {
        return recWidth * recHeight;
    }

    @Override
    public double getPerimeter()
    {
        return recWidth + recWidth + recHeight + recHeight;
    }

    @Override
    public double distanceTo(double x1, double x2, double y1, double y2)
    {
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(getColor());
        setBackground(new Color(0,0,0,0));
        g.drawRect(getX(), getY(), recWidth, recHeight);
        g.fillRect(getX(), getY(), recWidth, recHeight);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }
}
