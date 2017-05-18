/* ===========================================================
 * Angry calculator : a free calculator for the Java(tm) platform
 * ===========================================================
 *
 * Project Info:  navicolt@gmail.com
 *
 * Copyright (C) 2014 Ivan Guerreschi
 * 
 * This program is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABI-
 * LITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see http://www.gnu.org/licenses/.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 * 
 * --------------------
 * BubbleChart.java
 * --------------------
 * Copyright (C) 2014 Ivan Guerreschi
 *
 * Original Author:  Ivan Guerreschi;
 * Contributor(s): 
 * 
 * Changes
 * -------
 * 
 */

package calculator;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultXYZDataset;

/**
 * Create a pie chart with the values ​​entered in input
 * 
 * @author Ivan Guerreschi
 * 
 */
public class BubbleChart extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private DefaultXYZDataset date;  
	private JFreeChart graphic;
	
	/**
	 * constructor
	 * 
	 * @param title title the chart
 	 * @param xAxis field
	 * @param yAxis field
	 * @param legend field
	 * @param valueX field 
	 * @param valueY field
	 * @param bubbleSize field
	 */
	public BubbleChart(String title, String xAxis, String yAxis, String legend,
			ArrayList<Double> valueX, ArrayList<Double> valueY, ArrayList<Double> bubbleSize) {
		super("Bubble chart");
		setLocation(400, 200);
		setSize(767, 480);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		date = new DefaultXYZDataset();
		double[] x = new double[valueX.size()];
		double[] y = new double[valueX.size()];
		double[] z = new double[valueX.size()];	
		for (int i = 0; i < valueX.size(); i++){
			x[i] = valueX.get(i);
			y[i] = valueY.get(i); 
			z[i] = bubbleSize.get(i);
		}		
		double[][] xyzData = {x, y, z};		
		date.addSeries(legend, xyzData);
		// create chart
		graphic = ChartFactory.createBubbleChart(title, xAxis, yAxis, date,
				PlotOrientation.HORIZONTAL, true, true, false);
		panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		ChartPanel chartPanel = new ChartPanel(graphic);
		panel.add(chartPanel, BorderLayout.NORTH);
		chartPanel.setLayout(new BorderLayout(0, 0));
		XYPlot xyplot = ( XYPlot )graphic.getPlot( );                 
	    xyplot.setForegroundAlpha( 0.65F );                 
		NumberAxis numberaxis = ( NumberAxis )xyplot.getDomainAxis( );                 
	    numberaxis.setLowerMargin( 0.2 );                 
	    numberaxis.setUpperMargin( 0.5 );                 
	    NumberAxis numberaxis1 = ( NumberAxis )xyplot.getRangeAxis( );                 
	    numberaxis1.setLowerMargin( 0.8 );                 
	    numberaxis1.setUpperMargin( 0.9 );

		JButton closeBtn = new JButton("Close");
		closeBtn.addActionListener(new ActionListener() {

			/**
			 * close
			 */
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(closeBtn, BorderLayout.SOUTH);

	}

}
