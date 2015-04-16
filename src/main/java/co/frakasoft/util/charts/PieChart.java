package co.frakasoft.util.charts;

import co.frakasoft.util.beans.XYPair;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;

/**
 *
 * @author esalaza
 */
public class PieChart {

    private DefaultPieDataset dataset = null;
    private String title = "";
    JFreeChart chart = null;

    public PieChart(String title) {
        this.title = title;
    }

    public void setValues(ArrayList<XYPair> categoriesValues) {
        dataset = new DefaultPieDataset();
        for (XYPair xyPair : categoriesValues) {
            dataset.setValue(xyPair.getX(), Float.parseFloat(xyPair.getY()));
        }
        if (chart == null) {
            initializeChart();
        } else {
            updateChart();
        }
    }

    public JPanel getChartPanel() {
        if(chart != null) {
            ChartPanel panel = new ChartPanel(chart);
            return panel;
        }
        return null;
    }

    private void initializeChart() {
        chart = ChartFactory.createPieChart3D(
                title,
                dataset,
                true,
                true,
                false);
        chart.setBackgroundPaint(null);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setForegroundAlpha(0.5f);
        StandardPieSectionLabelGenerator labels = new StandardPieSectionLabelGenerator("{0}  [{1} = {2}]");
        plot.setLabelGenerator(labels);
        chart.setBackgroundPaint(null);
    }

    private void updateChart() {
        if (chart != null) {
            chart.fireChartChanged();
        }
    }

}
