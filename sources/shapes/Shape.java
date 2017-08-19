//File Name: Shape.java
//Gregory Delpe
//CSc221

package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.*;

public abstract class Shape extends JPanel implements ShapePositionInterface
{
    private Color color;
    private int xCord;
    private int yCord;

    public Shape(Color color, int xCord, int yCord)
    {
        this.color = color;
        this.xCord= xCord;
        this.yCord = yCord;

        int width = getWidth();
    }

    public int getX()
    {
        return xCord;
    }

    public int getY()
    {
        return yCord;
    }

    public Color getColor()
    {
        return color;
    }

    public void setX(int x)
    {
        this.xCord = x;
    }

    public void setY(int y)
    {
        this.yCord = y;
    }

    public void setColor(Color rbg)
    {
        this.color = rbg;
    }

    @Override
    public void moveTo(int xOffset, int yOffset)
    {
        this.xCord = xCord + xOffset;
        this.yCord = yCord + yOffset;
    }

    public abstract void draw(Graphics g);

}
