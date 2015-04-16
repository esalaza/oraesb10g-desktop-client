package co.frakasoft.util.charts;

import co.frakasoft.util.beans.HourlyTimeSerieValue;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author esalaza
 */
public class HourlyTimeSerieChart {

    TimeSeriesCollection dataset = null;
    private String title = "";
    private String timeSerieTitle = "";
    private String xAxisLabel = "";
    private String yAxisLabel = "";
    private Color serieColor = Color.BLUE;
    JFreeChart chart = null;

    public HourlyTimeSerieChart(String title, String timeSerieTitle, String xAxisLabel, String yAxisLabel) {
        this.title = title;
        this.timeSerieTitle = timeSerieTitle;
        this.xAxisLabel = xAxisLabel;
        this.yAxisLabel = yAxisLabel;
    }

    public void setValues(ArrayList<HourlyTimeSerieValue> values) {
        TimeSeries timeSerie = new TimeSeries(timeSerieTitle, Hour.class);
        for(HourlyTimeSerieValue value : values) {
            Hour hour = new Hour(value.getHour(), value.getDay(), value.getMonth(), value.getYear());
            timeSerie.add(hour, value.getValue());
        }
        dataset = new TimeSeriesCollection();
        dataset.addSeries(timeSerie);
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
        chart = ChartFactory.createTimeSeriesChart(
                title, // title
                xAxisLabel, // x-axis label
                yAxisLabel, // y-axis label
                dataset, // data
                true, // create legend?
                true, // generate tooltips?
                false // generate URLs?
                );
        chart.setBackgroundPaint(null);
        XYPlot plot = (XYPlot) chart.getPlot();
        XYItemRenderer r = plot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
            renderer.setBaseShapesVisible(true);
            renderer.setBaseShapesFilled(true);
            renderer.setSeriesPaint(0, serieColor);
        }
        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("dd-MMM-yy"));
        ValueAxis valueAxis = (ValueAxis) plot.getDomainAxis();
        valueAxis.setVerticalTickLabels(true);
    }

    private void updateChart() {
        if (chart != null) {
            chart.fireChartChanged();
        }
    }

    public void setSerieColor(Color serieColor) {
        this.serieColor = serieColor;
    }

}
