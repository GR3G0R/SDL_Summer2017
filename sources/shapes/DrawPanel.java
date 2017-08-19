//File Name: DrawPanel.java
//Gregory Delpe
//CScc221

package shapes;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class DrawPanel extends JPanel
{
    private ArrayList<Shape> ShapeList = new ArrayList<Shape>();


    public void paintComponenet(Graphics g)
    {

        for(int i = 0; i < ShapeList.size(); i++)
        {

            ShapeList.get(i).draw(g);
        }
    }
}
