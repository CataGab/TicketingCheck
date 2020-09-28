/**
 * Created by wo16675 on 01/02/2018.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {

    public void gui() {
        JFrame f= new JFrame();
        JPanel p=new JPanel();
        JPanel p2=new JPanel();
        JPanel p3=new JPanel();
        JPanel p4=new JPanel();
        JButton b1 =new JButton("Monthly power generated");
        JButton b2 =new JButton("Yearly power generated");
        JButton b3=new JButton("Monthly renewable resources");
        JButton b4=new JButton("Yearly renewable resources");
        JButton b5=new JButton("Monthly non-renewable resources");
        JButton b6=new JButton("Yearly non-renewable resources");
        JButton b7=new JButton("Monthly foreign resources");
        JButton b8=new JButton("Yearly foreign resources");



        JButton b9=new JButton("PDF EXPORT");
//        JButton b10=new JButton("Button4");
//        JLabel label=new JLabel("Graphs to show weekly and monthly Demand for resources");
//        JLabel label2=new JLabel("Graph to show weekly and monthly Frequency of use of resources");

//        p.setBackground(Color.GRAY);
//        p2.setBackground(Color.black);
        p3.setPreferredSize(new Dimension(600,400));
        f.add(p,BorderLayout.CENTER);
        f.add(p2,BorderLayout.PAGE_END);
        f.add(p3,BorderLayout.EAST);
        f.add(p4,BorderLayout.PAGE_START);
        p4.add(b9);
        p2.add(b1);p2.add(b2);p2.add(b3);p2.add(b4);p2.add(b5);p2.add(b6);p2.add(b7);p2.add(b8);
//        p.add(label);p3.add(label2);

//        ImageIcon i=new ImageIcon(getClass().getResource("graph.png"));
        b9.addActionListener(new ActionListener()
                             {public void actionPerformed(ActionEvent e){
                                 p2.setBackground(Color.BLACK);
                             }

                             }

        );


        f.setVisible(true);
        f.setSize(1750,1000);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Gui");
        f.setResizable(false);

    }

    public static void main(String[]args) {
        Gui g=new Gui();
        g.gui();

        PDF_Export p=new PDF_Export();
        p.screenshot();
        p.pdfOutput();
    }

}