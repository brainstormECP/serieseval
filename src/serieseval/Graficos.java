/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serieseval;

import java.awt.Color;
import java.awt.Paint;
import java.awt.image.BufferedImage;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LayeredBarRenderer;
import org.jfree.data.KeyedObjects2D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultKeyedValues2DDataset;
import org.jfree.data.statistics.DefaultMultiValueCategoryDataset;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.TextAnchor;
import serieseval.model.Dmresult;

/**
 *
 * @author Laura
 */
public class Graficos {

    public BufferedImage TestGrafico(String titulo, ValorCalculado valor, List<Dmresult> data, Integer cantDatasource) {

        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        for (Dmresult result : data) {
            String alg = result.getAlgorithm().getName();
            String datasource = result.getDatasource().getName();
            Double valorAMostrar = 0.0;
            switch (valor) {
                case CorrelationCoefficient:
                    valorAMostrar = result.getCorrelationCoefficient();
                    break;
                case MeanAbsoluteError:
                    valorAMostrar = result.getMeanAbsoluteError();
                    break;
                case RelativeAbsoluteError:
                    valorAMostrar = result.getRelativeAbsoluteError();
                    break;
                case RootMeanSquaredError:
                    valorAMostrar = result.getRootMeanSquaredError();
                    break;
                case RootRelativeSquaredError:
                    valorAMostrar = result.getRootRelativeSquareError();
                    break;
            }

            dataSet.setValue(valorAMostrar, datasource.substring(0, datasource.lastIndexOf(".")), alg.substring(alg.lastIndexOf(".") + 1));
        }

        CategoryAxis categoryAxis = new CategoryAxis("Algoritmos");
        ValueAxis valueAxis = new NumberAxis("valor");

        CategoryPlot plot = new CategoryPlot(dataSet,
                categoryAxis,
                valueAxis,
                new LayeredBarRenderer());

        plot.setOrientation(PlotOrientation.VERTICAL);

        JFreeChart chart = new JFreeChart(
                titulo,
                JFreeChart.DEFAULT_TITLE_FONT,
                plot,
                true
        );

        chart.setBackgroundPaint(Color.lightGray);

        final LayeredBarRenderer renderer = (LayeredBarRenderer) plot.getRenderer();


        // we can set each series bar width individually or let the renderer manage a standard view.
        // the width is set in percentage, where 1.0 is the maximum (100%).
        Double ancho = 1.0 / cantDatasource;

        for (int i = 0; i < cantDatasource; i++) {
            renderer.setSeriesBarWidth(i, 1 - (ancho * i));
            //ancho -= ancho;
        }

        renderer.setItemMargin(0.01);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryMargin(0.25);
        domainAxis.setUpperMargin(0.05);
        domainAxis.setLowerMargin(0.05);

        return chart.createBufferedImage(980, 400);
    }

    public BufferedImage AnalisisGrafico(String titulo, Double[] data) {

        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

        for (int i = 0; i < data.length - 1; i++) {
            dataSet.setValue(data[i], "Meses", "Mes " + (i + 1));
        }
        
        dataSet.setValue(data[data.length - 1], "Meses", "Predicción");

        CategoryAxis categoryAxis = new CategoryAxis("Meses");
        ValueAxis valueAxis = new NumberAxis("valor");

        CategoryPlot plot = new CategoryPlot(dataSet,
                categoryAxis,
                valueAxis,
                new BarRenderer());

        plot.setOrientation(PlotOrientation.VERTICAL);

        JFreeChart chart = new JFreeChart(
                titulo,
                JFreeChart.DEFAULT_TITLE_FONT,
                plot,
                true
        );

        chart.setBackgroundPaint(Color.lightGray);

        //final BarRenderer renderer = (BarRenderer) plot.getRenderer();

        Paint[] colores = new Paint[data.length];
        for (int i = 0; i < data.length - 1; i++) {
            colores[i] = Color.RED;
        }
        colores[colores.length - 1] = Color.blue;
        final CategoryItemRenderer renderer = new CustomRenderer(colores);        
        
        plot.setRenderer(renderer);
       renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
//        renderer.setSeriesItemLabelGenerator(0, new StandardCategoryItemLabelGenerator("{2}", NumberFormat.getNumberInstance()));
        renderer.setBaseItemLabelsVisible( true);
        renderer.setSeriesPositiveItemLabelPosition(0,     
                    new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
        
        //renderer.setItemMargin(0.01);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryMargin(0.25);
        domainAxis.setUpperMargin(0.05);
        domainAxis.setLowerMargin(0.05);

        return chart.createBufferedImage(980, 400);
    }    
    
    class CustomRenderer extends BarRenderer {

        /** The colors. */
        private Paint[] colors;

        /**
         * Creates a new renderer.
         *
         * @param colors  the colors.
         */
        public CustomRenderer(final Paint[] colors) {
            this.colors = colors;
        }

        /**
         * Returns the paint for an item.  Overrides the default behaviour inherited from
         * AbstractSeriesRenderer.
         *
         * @param row  the series.
         * @param column  the category.
         *
         * @return The item color.
         */
        public Paint getItemPaint(final int row, final int column) {
            return this.colors[column % this.colors.length];
        }
    }
}
