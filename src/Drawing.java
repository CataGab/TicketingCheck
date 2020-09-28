import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import org.jfree.*;


class Graph1
{
    public static void main(String[] args)
    {
        Drawing plot = new Drawing();
        plot.setLayout(null);
        JFrame frame = new JFrame();

        frame.getContentPane().add(plot);
        plot.updateUI();
        frame.setSize(800,800);
        frame.setVisible(true);
    }
}



class Drawing extends JPanel {

    int [] testDataX = { };
    int [] testDataY =  {300, 250, 300, 450, 400, 150, 200, 200, 400, 300};
    int size = testDataX.length;

    String xLabel, yLabel, title;
    int xMax, xMin, yMax, yMin;

    public Drawing()
    {
        xLabel = ("Time");
        yLabel = ("Energy");
        title = ("Test");

        xMax = testDataX[0];
        xMin = testDataX[0];
        yMax = testDataY[0];
        yMin = testDataY[0];

        for (int i=0; i < size; i++){
            if (testDataX[i] > xMax) {
                xMax = testDataX[i];
            }
            if (testDataX[i] < xMin) {
                xMin = testDataX[i];
            }
            if (testDataY[i] > yMax) {
                yMax = testDataY[i];
            }
            if (testDataY[i] < yMin) {
                yMin = testDataY[i];
            }
        }



        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.white);

        g.drawLine(50, 50, 50, 500); //y axis
        g.drawLine (50, 500, 500, 500); //x axis

        g.drawString(xLabel, 250, 530); //x label
        g.drawString(yLabel, 10, 250); //y label

        for (int j = 0; j < size-1; j++)
        {
            g.drawLine(testDataX[j], testDataY[j], testDataX[j+1], testDataY[j+1]);
        }

    }
}