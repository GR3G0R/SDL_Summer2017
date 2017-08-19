//FILE NAME: PieChart.java
//Gregory Delpe
//CSc221
//Exercise#4: Class PieChart displays a graphical representation of the three
//most frequent letters in the provided text

package histogram;

import java.applet.Applet;
import java.util.Random;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.util.Scanner;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PieChart extends Applet {

    private Color color;
    private int probability;
    private int xCord;
    private int yCord;
    private int width;
    private int height;
    private int startAngle;
    private int arcAngle;
    private double prob1;
    private double prob2;
    private double prob3;
    private ArrayList<String> array;
    private int n;


    public PieChart(double prob1, double prob2, double prob3, ArrayList<String> array, int n)
    {
        this.prob1 = prob1;
        this.prob2 = prob2;
        this.prob3 = prob3;
        this.array = array;
        this.n = n;
    }

    public void paint(Graphics g)
    {
        Random rand = new Random();
        float red = rand.nextFloat();
        float green = rand.nextFloat();
        float blue = rand.nextFloat();
        Color randomColor = new Color(red, green, blue);
        double probArray[]  = new double[array.size()];
        double startArray[] = new double[probArray.length];
        Color colors[] = {Color.BLACK, Color.magenta, Color.GRAY, Color.GREEN, Color.RED};
        double probability[] = new double[array.size()];

        for(int i = array.size()-1; i > 0; --i)
        {
            probability[i] = Double.parseDouble(array.get(i));
        }

        for(int i = n-1; i >= 0; --i)
        {
            probArray[n-1-i] = 360 * Double.parseDouble(array.get(i));
        }

        for(int i = 0; i < n-1; i++)
        {
            startArray[1] = probArray[0];
            startArray[i + 1 + 1] = probArray[i] + startArray[i + 1];
        }

        double other = 360 - (prob1 + prob2 + prob3);

        String letterArray[] = {"e","t","a","o","n","i","s","h","r","d","l","m","k",
            "u","w","y","c","f","g","b","p","v","x","j","v","z"};

        for(int j = 0; j < n; j++)
        {
            g.setColor(colors[j]);
            g.fillArc(50, 50, 200, 200, 90-(int) startArray[j], (int)-probArray[j]);
        }

        g.setColor(Color.WHITE);
        g.fillArc(50,50, 200, 200,(int)(90-prob1-prob2-prob3),(int)-other);

        String s1 = letterArray[0] + ": " + array.get(0);
        String s2 = letterArray[1] + ": " + array.get(1);
        String s3 = letterArray[2] + ": " + array.get(2);
        String s4 = "All Other";

        String[] textArray = new String[array.size()];

        textArray[0] = s1;
        textArray[1] = s2;
        textArray[2] = s3;
        textArray[3] = s4;

        g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
        g.setColor(Color.BLACK);

        for(int i = 0; i < n; i++)
        {
            double x = 150 + Math.cos(Math.toRadians(startArray[i]+probArray[i]/2)) * 105;
            double y = 150 - Math.sin(Math.toRadians(startArray[i]+probArray[i]/2)) * 105;

            g.setColor(Color.BLACK);
            g.drawString(textArray[i], (int) x,(int) y);
        }

        g.setColor(Color.BLACK);
        g.drawString(s4,40, 80);
    }
}
