//FILE NAME: HistogramLetters.java
//Gregory Delpe
//CSc221
//Exercise#4: Class HistogramLetters calculates the frequency of each letter
//in the file "Emma.txt"

package histogram;

import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import java.util.HashMap;

public class HistogramLetters
{
    private static Scanner input, out, pOut;
    private static java.io.PrintStream output, probOutput;
    private static HashMap<String,Double> probMap = new HashMap<String, Double>();
    private double[] charArray;
    static String[] stringArray = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
        "n","o","p","q","r","s","t","u","v","w","x","y","z"};
    public static double charCount[] = new double[stringArray.length];

    public void setArray(double[] array)
    {
        this.charArray = Arrays.copyOf(array, array.length);
    }

    public double[] getArray()
    {
        return Arrays.copyOf(this.charArray, charArray.length);
    }


    // Open file clients.txt
    public static void openFile()
    {
        try
        {
            input = new Scanner(Paths.get("Emma.txt"));
            output = new java.io.PrintStream("output.txt");
            out = new Scanner(Paths.get("output.txt"));
            probOutput = new java.io.PrintStream("probOutput.txt");

        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
    }

    // Read record from file
    public static void readRecords()
    {
        String letter;
        String token;
        Pattern expression = Pattern.compile("[a-zA-Z]");
        ArrayList<String> list = new ArrayList<String>();
        HashMap<String, Double> map = new HashMap<String,Double>();
        String[] charMatch;

        double totalCount = 0;
        int count = 0;

        try
        {

            while (input.hasNext()) // Continue while there is more to read
            {

                token = input.next();
                token = token.trim();
                Matcher matcher = expression.matcher(token);

                while(matcher.find())
                {
                    output.println(matcher.group());
                }

            }

            while(out.hasNextLine())
            {
                totalCount++;
                list.add(out.nextLine().toLowerCase());
            }
            for(int i = 0; i < stringArray.length; i++)
            {
                count = 0;
                for(int j = 0; j < list.size(); j++)
                {
                    if(list.get(j).equals(stringArray[i]))
                    {
                        count++;
                    }
                    charCount[i] = (double) count/totalCount;
                }
            }

            for(int j = 0; j < charCount.length; j++)
            {
                System.out.printf("%s = ", stringArray[j]);
                System.out.printf("%.4f%n",charCount[j]);
                map.put(stringArray[j],charCount[j]);

            }
            Arrays.sort(charCount);
            for(int i = charCount.length-1; i > 0; --i)
            {
                probOutput.println(charCount[i]);

            }

        }
        catch(NoSuchElementException elementException)
        {
            System.err.println("File improperly formed. Terminating.");
        }
        catch (IllegalStateException stateException)
        {
            System.err.println("Error reading from file. Terminating.");
        }
    } // End method readRecords

    // Close file and terminate application
    public static void closeFile()
    {
        if (input != null)
            input.close();
    }

    public static void main(String[] args)
    {
        ArrayList<String> array = new ArrayList<String>();

        try {
            pOut = new Scanner(Paths.get("probOutput.txt"));
        }
        catch (IOException ioException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }

        while(pOut.hasNextLine())
        {
            array.add(pOut.nextLine());
        }

        int startAngle = 90;
        double arcAngle1 = 360 * .1257;
        double angle1 = 360 * .0792;
        double angle2 = 360 * .0867;
        double angle3 = 360 * .1257;

        PieChart chart = new PieChart(angle1, angle2, angle3, array, 3);
        openFile();
        readRecords();
        closeFile();

        JPanel panel = new JPanel();
        panel.add(chart);

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(375, 300);
        window.getContentPane().add(chart);
        window.setVisible(true);

    }
} // End class HistogramLetters
