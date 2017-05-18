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
 * LineChart.java
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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Create a pie chart with the values ​​entered in input
 * 
 * @author Ivan Guerreschi
 * 
 */
public class LineChart extends JFrame {
		
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private DefaultCategoryDataset date;
	private JFreeChart graphic;

	/**
	 * constructor
	 * 
	 * @param title title chart
	 * @param value field
	 * @param name field
	 * @param xAxis field 
	 * @param yAxis field
	 * @param legend field
	 */
	public LineChart(String title, String xAxis, String yAxis, String legend,
			ArrayList<Double> value, ArrayList<String> name) {
		super("Line chart");
		setLocation(400, 200);
		setSize(767, 480);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		date = new DefaultCategoryDataset();
		for (int i = 0; i < value.size(); i++)
			date.addValue(value.get(i), legend, name.get(i));
		// create chart
		graphic = ChartFactory.createLineChart(title, xAxis, yAxis, date,
				PlotOrientation.VERTICAL, true, true, false);
		panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		ChartPanel chartPanel = new ChartPanel(graphic);
		panel.add(chartPanel, BorderLayout.NORTH);
		chartPanel.setLayout(new BorderLayout(0, 0));

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
