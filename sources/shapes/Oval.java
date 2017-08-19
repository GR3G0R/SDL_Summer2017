//File Name: Oval.java
//Gregory Delpe
//CSc221

package shapes;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.geom.Area;
import java.util.*;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

public class Oval extends Shape
{
    private final double PI = Math.PI;

    private int radius;
    private int ovalWidth;
    private int ovalHeight;

    public Oval(Color color, int xCord, int yCord, int ovalWidth, int ovalHeight)
    {
        super(color,xCord,yCord);

        this.ovalWidth = ovalWidth;
        this.ovalHeight = ovalHeight;
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(600, 500);
    }

    @Override
    public double getPerimeter()
    {
        return (2 * PI * radius);
    }

    @Override
    public double getArea()
    {
        return (PI * (radius * radius));
    }

    @Override
    public Rectangle getBoundingBox()
    {
        int width = getWidth();
        int height = getHeight();

        Rectangle rect = new Rectangle(getColor(), getX(), getY(), ovalWidth, ovalHeight);
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
    public void draw(Graphics g)
    {
        int width = getWidth();
        int height = getHeight();
        int rad;

        g.setColor(getColor());
        setBackground(new Color(0,0,0,0));
        g.drawOval(getX(),getY(), ovalWidth, ovalHeight);
        g.fillOval(getX(), getY(), ovalWidth, ovalHeight);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }
}
