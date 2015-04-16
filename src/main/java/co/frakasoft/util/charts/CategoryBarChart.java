package co.frakasoft.util.charts;

import co.frakasoft.util.beans.XYPair;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author esalaza
 */
public class CategoryBarChart {

    private DefaultCategoryDataset dataset = null;
    private String title = "";
    private String categoryAxisLabel = "";
    private String valueAxisLabel = "";
    private Color barsColor = Color.GREEN;
    JFreeChart chart = null;

    public CategoryBarChart(String title, String categoryAxisLabel, String valueAxisLabel) {
        this.title = title;
        this.categoryAxisLabel = categoryAxisLabel;
        this.valueAxisLabel = valueAxisLabel;
    }

    public void setValues(ArrayList<XYPair> categoriesValues) {
        dataset = new DefaultCategoryDataset();
        for(XYPair xyPair : categoriesValues) {
            dataset.addValue(Float.parseFloat(xyPair.getY()), "Occurrences", xyPair.getX());
        }
        if(chart == null) {
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

    private void updateChart() {
        if(chart != null) {
            chart.fireChartChanged();
        }
    }

    private void initializeChart() {
        chart = ChartFactory.createBarChart3D(
                title,
                categoryAxisLabel,
                valueAxisLabel,
                dataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        chart.setBackgroundPaint(null);
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, barsColor);
        renderer.setDrawBarOutline(false);
        CategoryAxis xAxis = (CategoryAxis) plot.getDomainAxis();
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
    }

    public void setBarsColor(Color barsColor) {
        this.barsColor = barsColor;
    }
    
}
