import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.text.*;
import java.util.*;

//To get this code working, you should download JFreeChart and add to libraries of this project

public class LineGraph3 extends ApplicationFrame {

    public LineGraph3(String applicationTitle, String chartTitle) throws ParseException {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Month", "Power Generated",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);

        lineChart.getCategoryPlot().getRangeAxis().setRange(0,3000); //Set y axis range

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset() throws ParseException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        List<List<String>> data = CSV_parser_v1.getOutData();

        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-MM-dd hh:mm:ss");
        SimpleDateFormat dt1 = new SimpleDateFormat("hh:mm");


        int rec = 0;
        String label = "";
        Date date = dt.parse("0000-00-00 00:00:00");
        for (List<String> record : data) {
            int cell = 1;
            int sum = 0;
            for (String val : record) {
                if (cell > 4 && cell < 19 && rec == 1) {
                    sum += Integer.parseInt(val);
                }
                if (cell == 2 && rec == 1) {
                    label = val;
                    date = dt.parse(label);
                }
                if (cell == 8 && rec == 1) {
                    dataset.addValue(Integer.parseInt(val), "Wind", dt1.format(date));
                }
                if (cell == 13 && rec == 1) {
                    dataset.addValue(Integer.parseInt(val), "Pumped", dt1.format(date));
                }
                if (cell == 14 && rec == 1) {
                    dataset.addValue(Integer.parseInt(val), "Hydro", dt1.format(date));
                }
                if (cell == 17 && rec == 1) {
                    dataset.addValue(Integer.parseInt(val), "Other", dt1.format(date));
                }
                if (cell == 18 && rec == 1) {
                    dataset.addValue(Integer.parseInt(val), "Solar", dt1.format(date));
                }
                cell++;
            }
//            if(rec == 1) dataset.addValue(sum, "Produced", dt1.format(date));
            rec = 1;
        }

        return dataset;
    }

    public static void main(String[] args) throws ParseException {
        CSV_parser_v1.main(args);

        LineGraph3 chart = new LineGraph3(
                "Monthly renewable resources",
                "Monthly renewable resources");

        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);
    }
}