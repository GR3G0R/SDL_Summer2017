//File Name: Circle.java
//Gregory Delpe
//CSc221

package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.*;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Area;


public class Circle extends Oval
{
    private final double PI = Math.PI;

    private int radius;

    public Circle(Color color, int xCord, int yCord, int ovalWidth, int ovalHeight, int radius)
    {
        super(color, xCord, yCord, ovalWidth, ovalHeight);

        this.radius = radius;
    }

    public double getArea()
    {
        return (int) (PI * (radius * radius));
    }

    public double getPerimeter()
    {
        return (2 * PI * radius);
    }

    public int getRadius()
    {
        return radius;
    }

    public void setRadius(int radius)
    {
       this.radius = radius;
    }


    public Dimension getPreferredSize()
    {
        return new Dimension(400, 300);
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
    public void draw(Graphics g)
    {

        int width = getWidth();
        int height = getHeight();
        int rad;

        if(width < height)
            rad = radius;
        else
            rad = radius;

        Color color = new Color(0,0,255);

        g.setColor(getColor());
        setBackground(new Color(0,0,0,0));
        g.drawOval((width/2 - rad),(height/2 - rad), rad *2, rad * 2);
        g.fillOval((width/2 - rad),(height/2 - rad), rad *2, rad * 2);

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }

}
