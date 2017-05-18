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
 * Graphic.java
 * --------------------
 * Copyright (C) 2014 Ivan Guerreschi
 *
 * Original Author:  Ivan Guerreschi;
 * Contributor(s): 
 * 
 * Changes
 * -------
 * Date changes 17/06/2014
 * Added the JTextField to enter the name of the data
 * Edit constructor of method enter
 * Edit method cancel
 * 
 * Date changes 14/10/2014
 * general improvement in code
 * inserting multiple values
 * 
 * Date changes 27/10/2014
 * added the JTextField to x axis name data
 * added the JTextField to y axis name data
 * added the JTextField to legend name data
 * added the JRadioButton to LineChart
 * added the JRadioButton to LineChart3D
 * added the JButton for new function
 * edit constructor for LineChart
 * method to insert values ​​from the keypad
 */

package calculator;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.event.KeyAdapter;

/**
 * Class to create pie charts
 * 
 * @author Ivan Guerreschi
 * 
 */
public class Graphic {

	private String nameGraphic = "";
	private String xAxis = "";
	private String yAxis = "";
	private String legend = "";

	private int rdButSlc = 1; // type graphics selected

	private ArrayList<Double> dataValue = new ArrayList<Double>();
	private ArrayList<String> nameValue = new ArrayList<String>();
	private ArrayList<Double> x = new ArrayList<Double>();
	private ArrayList<Double> y = new ArrayList<Double>();
	private ArrayList<Double> sizeBubble = new ArrayList<Double>();

	protected JFrame frame;

	private JTextField nameGraphicTxt;
	private JTextField dataTxt;
	private JTextField nameDataTxt;
	private JTextField xAxisTxt;
	private JTextField yAxisTxt;
	private JTextField legendTxt;
	private JTextField sizeBubbleTxt;

	private JLabel nameGraphicLbl;
	private JLabel dataLbl;
	private JLabel nameDataLbl;
	private JLabel nameXLbl;
	private JLabel nameYLbl;
	private JLabel legendLbl;

	private JButton allCancelBtn;
	private JButton closeBtn;
	private JButton addBtn;
	private JButton enterBtn;
	private JButton cancelBtn;
	private JButton newBtn;

	private JMenuBar menuBar;

	private JMenu operationMenu;
	private JMenu closeMenu;

	private JMenuItem enterMenuItem;
	private JMenuItem cancelMenuItem;
	private JMenuItem closeMenuItem;
	private JMenuItem addMenuItem;
	private JMenuItem allCancelMenuItem;
	private JMenuItem mntmNew;

	private JRadioButton pieChartRdbtn;
	private JRadioButton pieChart3DRdbtn;
	private JRadioButton ringChartRdbtn;
	private JRadioButton lineChartRdbtn;
	private JRadioButton bubbleChartRdbtn;
	private JRadioButton lineChart3DRdbtn;

	private JScrollPane dataScrlPan;

	private JTextArea areaDataTxtArea;

	
	/**
	 * sends data to the constructor
	 */
	public void enter() {

		switch (rdButSlc) {
		case 1:
			PieChart chart = new PieChart(nameGraphic, dataValue, nameValue);
			chart.setVisible(true);
			break;
		case 2:
			PieChart3D chart3d = new PieChart3D(nameGraphic, dataValue,
					nameValue);
			chart3d.setVisible(true);
			break;
		case 3:
			RingChart ringChart = new RingChart(nameGraphic, dataValue,
					nameValue);
			ringChart.setVisible(true);
			break;
		case 4:
			LineChart lineChart = new LineChart(nameGraphic, xAxis, yAxis,
					legend, dataValue, nameValue);
			lineChart.setVisible(true);
			break;
		case 5:
			LineChart3D lineChart3d = new LineChart3D(nameGraphic, xAxis,
					yAxis, legend, dataValue, nameValue);
			lineChart3d.setVisible(true);
			break;
		case 6:
			BubbleChart bubbleChart = new BubbleChart(nameGraphic, xAxis, yAxis, legend, x, y, sizeBubble);
			bubbleChart.setVisible(true);
			break;	
		}

	}

	/**
	 * add
	 */
	public void add() {
		
		if (rdButSlc == 6){
			
			try {			
				x.add(Double.valueOf(String.valueOf(dataTxt.getText())));
				y.add(Double.valueOf(String.valueOf(nameDataTxt.getText())));
				sizeBubble.add(Double.valueOf(String.valueOf(sizeBubbleTxt.getText())));
				areaDataTxtArea.append(dataTxt.getText() + " "
						+ nameDataTxt.getText() + " " + sizeBubbleTxt.getText() + "\n");
	
			} catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(frame,
						"Only whole numbers eg 14 or with point es: 12.4");
				dataTxt.setText("");
				nameDataTxt.setText("");
				sizeBubbleTxt.setText("");
				dataTxt.requestFocusInWindow();
			}
	
			nameGraphic = nameGraphicTxt.getText();
			xAxis = xAxisTxt.getText();
			yAxis = yAxisTxt.getText();
			legend = legendTxt.getText();
			dataTxt.setText("");
			nameDataTxt.setText("");
			sizeBubbleTxt.setText("");
			dataTxt.requestFocusInWindow();
			
		} else {

			try {			
				dataValue.add(Double.parseDouble(dataTxt.getText()));
				areaDataTxtArea.append(dataTxt.getText() + " "
						+ nameDataTxt.getText() + "\n");
	
			} catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(frame,
						"Only whole numbers eg 14 or with point es: 12.4");
				dataTxt.setText("");
				dataTxt.requestFocusInWindow();
			}
	
			nameGraphic = nameGraphicTxt.getText();
			nameValue.add(nameDataTxt.getText());
			xAxis = xAxisTxt.getText();
			yAxis = yAxisTxt.getText();
			legend = legendTxt.getText();
			dataTxt.setText("");
			nameDataTxt.setText("");
			dataTxt.requestFocusInWindow();
		}
	}	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graphic window = new Graphic();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Graphic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Graphic");
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBackground(Color.GRAY);
		frame.setBounds(100, 100, 475, 540);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		nameGraphicLbl = new JLabel("Graphic Name");
		nameGraphicLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		nameGraphicLbl.setBounds(10, 10, 132, 30);
		frame.getContentPane().add(nameGraphicLbl);

		nameGraphicTxt = new JTextField();
		nameGraphicTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		nameGraphicTxt.setToolTipText("Name graphic");
		nameGraphicTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		nameGraphicTxt.setBounds(132, 10, 128, 30);
		frame.getContentPane().add(nameGraphicTxt);
		nameGraphicTxt.setColumns(10);

		dataLbl = new JLabel("Data");
		dataLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		dataLbl.setBounds(10, 45, 77, 30);
		frame.getContentPane().add(dataLbl);

		dataTxt = new JTextField();
		dataTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		dataTxt.setToolTipText("Insert data value");
		dataTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		dataTxt.setBounds(132, 45, 128, 30);
		frame.getContentPane().add(dataTxt);
		dataTxt.setColumns(10);

		nameDataLbl = new JLabel("Name data");
		nameDataLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		nameDataLbl.setBounds(10, 80, 98, 30);
		frame.getContentPane().add(nameDataLbl);

		nameDataTxt = new JTextField();
		nameDataTxt.addKeyListener(new KeyAdapter() {
			@Override
			/**
			 * add
			 */
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					add();
			}

		});
		nameDataTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		nameDataTxt.setToolTipText("Insert name data value");
		nameDataTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		nameDataTxt.setBounds(132, 80, 128, 30);
		frame.getContentPane().add(nameDataTxt);
		nameDataTxt.setColumns(10);

		allCancelBtn = new JButton("AllCanc");
		allCancelBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		allCancelBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		allCancelBtn.setBounds(10, 415, 98, 30);
		allCancelBtn.addActionListener(new ActionListener() {

			// clear the input
			public void actionPerformed(ActionEvent e) {

				nameGraphicTxt.setText("");
				nameDataTxt.setText("");
				dataTxt.setText("");
				xAxisTxt.setText("");
				yAxisTxt.setText("");
				legendTxt.setText("");
				areaDataTxtArea.setText("");
				nameGraphicTxt.requestFocusInWindow();

			}
		});

		enterBtn = new JButton("Enter");
		enterBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		enterBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		enterBtn.setBounds(10, 310, 98, 30);
		enterBtn.addActionListener(new ActionListener() {

			/**
			 * enter
			 */
			public void actionPerformed(ActionEvent e) {

				enter();
			}
		});
		frame.getContentPane().add(enterBtn);
		frame.getContentPane().add(allCancelBtn);

		closeBtn = new JButton("Close");
		closeBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		closeBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		closeBtn.addActionListener(new ActionListener() {

			/**
			 * close
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		closeBtn.setBounds(10, 450, 98, 30);
		frame.getContentPane().add(closeBtn);

		pieChartRdbtn = new JRadioButton("Pie Chart");
		pieChartRdbtn.setBorderPainted(true);
		pieChartRdbtn.setSelected(true);
		pieChartRdbtn.addActionListener(new ActionListener() {

			/**
			 * pie chart
			 */
			public void actionPerformed(ActionEvent e) {

				rdButSlc = 1;
				ringChartRdbtn.setSelected(false);
				pieChart3DRdbtn.setSelected(false);
				lineChartRdbtn.setSelected(false);
				lineChart3DRdbtn.setSelected(false);
				bubbleChartRdbtn.setSelected(false);
				xAxisTxt.setEditable(false);
				yAxisTxt.setEditable(false);
				legendTxt.setEditable(false);
				xAxisTxt.setText("");
				yAxisTxt.setText("");
				legendTxt.setText("");
				nameGraphicTxt.requestFocusInWindow();
			}
		});
		pieChartRdbtn.setFont(new Font("Dialog", Font.BOLD, 14));
		pieChartRdbtn.setBounds(132, 275, 128, 23);
		frame.getContentPane().add(pieChartRdbtn);

		pieChart3DRdbtn = new JRadioButton("Pie Chart 3D");
		pieChart3DRdbtn.setBorderPainted(true);
		pieChart3DRdbtn.addActionListener(new ActionListener() {

			/**
			 * pie chart 3D
			 */
			public void actionPerformed(ActionEvent e) {

				rdButSlc = 2;
				pieChartRdbtn.setSelected(false);
				ringChartRdbtn.setSelected(false);
				lineChartRdbtn.setSelected(false);
				lineChart3DRdbtn.setSelected(false);
				bubbleChartRdbtn.setSelected(false);
				xAxisTxt.setEditable(false);
				yAxisTxt.setEditable(false);
				legendTxt.setEditable(false);
				xAxisTxt.setText("");
				yAxisTxt.setText("");
				legendTxt.setText("");
				nameGraphicTxt.requestFocusInWindow();

			}
		});
		pieChart3DRdbtn.setFont(new Font("Dialog", Font.BOLD, 14));
		pieChart3DRdbtn.setBounds(132, 310, 128, 23);
		frame.getContentPane().add(pieChart3DRdbtn);

		ringChartRdbtn = new JRadioButton("Ring Chart");
		ringChartRdbtn.setBorderPainted(true);
		ringChartRdbtn.addActionListener(new ActionListener() {

			/**
			 * ring chart
			 */
			public void actionPerformed(ActionEvent e) {

				rdButSlc = 3;
				pieChartRdbtn.setSelected(false);
				pieChart3DRdbtn.setSelected(false);
				lineChartRdbtn.setSelected(false);
				lineChart3DRdbtn.setSelected(false);
				bubbleChartRdbtn.setSelected(false);
				xAxisTxt.setEditable(false);
				yAxisTxt.setEditable(false);
				legendTxt.setEditable(false);
				xAxisTxt.setText("");
				yAxisTxt.setText("");
				legendTxt.setText("");
				nameGraphicTxt.requestFocusInWindow();
			}
		});
		ringChartRdbtn.setFont(new Font("Dialog", Font.BOLD, 14));
		ringChartRdbtn.setBounds(132, 345, 128, 23);
		frame.getContentPane().add(ringChartRdbtn);

		lineChartRdbtn = new JRadioButton("Line Chart");
		lineChartRdbtn.addActionListener(new ActionListener() {

			/**
			 * line chart
			 */
			public void actionPerformed(ActionEvent e) {

				rdButSlc = 4;
				pieChartRdbtn.setSelected(false);
				ringChartRdbtn.setSelected(false);
				ringChartRdbtn.setSelected(false);
				lineChart3DRdbtn.setSelected(false);
				bubbleChartRdbtn.setSelected(false);
				xAxisTxt.setEditable(true);
				yAxisTxt.setEditable(true);
				legendTxt.setEditable(true);
				nameGraphicTxt.requestFocusInWindow();
			}
		});
		lineChartRdbtn.setFont(new Font("Dialog", Font.BOLD, 14));
		lineChartRdbtn.setBorderPainted(true);
		lineChartRdbtn.setBounds(281, 275, 128, 23);
		frame.getContentPane().add(lineChartRdbtn);

		lineChart3DRdbtn = new JRadioButton("Line Chart 3D");
		lineChart3DRdbtn.addActionListener(new ActionListener() {

			/**
			 * line chart 3d
			 */
			public void actionPerformed(ActionEvent e) {

				rdButSlc = 5;
				pieChartRdbtn.setSelected(false);
				ringChartRdbtn.setSelected(false);
				ringChartRdbtn.setSelected(false);
				lineChartRdbtn.setSelected(false);
				bubbleChartRdbtn.setSelected(false);
				xAxisTxt.setEditable(true);
				yAxisTxt.setEditable(true);
				legendTxt.setEditable(true);
				nameGraphicTxt.requestFocusInWindow();
			}
		});
		lineChart3DRdbtn.setFont(new Font("Dialog", Font.BOLD, 14));
		lineChart3DRdbtn.setBorderPainted(true);
		lineChart3DRdbtn.setBounds(281, 310, 128, 23);
		frame.getContentPane().add(lineChart3DRdbtn);
		
		bubbleChartRdbtn = new JRadioButton("Bubble Chart");
		bubbleChartRdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdButSlc = 6;
				pieChartRdbtn.setSelected(false);
				pieChart3DRdbtn.setSelected(false);
				ringChartRdbtn.setSelected(false);
				ringChartRdbtn.setSelected(false);
				lineChartRdbtn.setSelected(false);
				lineChart3DRdbtn.setSelected(false);
				xAxisTxt.setEditable(true);
				yAxisTxt.setEditable(true);
				legendTxt.setEditable(true);
				sizeBubbleTxt.setEditable(true);
				nameDataLbl.setText("x value");
				dataLbl.setText("y value");
				
				nameGraphicTxt.requestFocusInWindow();
			}
		});
		bubbleChartRdbtn.setFont(new Font("Dialog", Font.BOLD, 14));
		bubbleChartRdbtn.setBounds(281, 345, 128, 23);
		frame.getContentPane().add(bubbleChartRdbtn);

		addBtn = new JButton("Add");
		addBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		addBtn.addActionListener(new ActionListener() {

			/**
			 * add
			 */
			public void actionPerformed(ActionEvent e) {

				add();
			}
		});
		addBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		addBtn.setBounds(10, 275, 98, 30);
		frame.getContentPane().add(addBtn);

		dataScrlPan = new JScrollPane();
		dataScrlPan.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		dataScrlPan.setBounds(281, 10, 180, 240);
		frame.getContentPane().add(dataScrlPan);

		areaDataTxtArea = new JTextArea();
		areaDataTxtArea.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		areaDataTxtArea.setForeground(Color.BLUE);
		areaDataTxtArea.setEditable(false);
		areaDataTxtArea.setFont(new Font("Dialog", Font.PLAIN, 14));
		areaDataTxtArea.setToolTipText("Displays data");
		dataScrlPan.setViewportView(areaDataTxtArea);

		cancelBtn = new JButton("Cancel");
		cancelBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		cancelBtn.addActionListener(new ActionListener() {

			/**
			 * cancel
			 */
			public void actionPerformed(ActionEvent e) {

				dataTxt.setText("");
				nameDataTxt.setText("");
				sizeBubbleTxt.setText("");
				dataTxt.requestFocusInWindow();
			}
		});
		cancelBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		cancelBtn.setBounds(10, 380, 98, 30);
		frame.getContentPane().add(cancelBtn);

		xAxisTxt = new JTextField();
		xAxisTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		xAxisTxt.setEditable(false);
		xAxisTxt.setToolTipText("Name x axis");
		xAxisTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		xAxisTxt.setColumns(10);
		xAxisTxt.setBounds(132, 150, 128, 30);
		frame.getContentPane().add(xAxisTxt);

		yAxisTxt = new JTextField();
		yAxisTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		yAxisTxt.setEditable(false);
		yAxisTxt.setToolTipText("Name y axis");
		yAxisTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		yAxisTxt.setColumns(10);
		yAxisTxt.setBounds(132, 185, 128, 30);
		frame.getContentPane().add(yAxisTxt);

		nameXLbl = new JLabel("Name X axis");
		nameXLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		nameXLbl.setBounds(10, 150, 98, 30);
		frame.getContentPane().add(nameXLbl);

		nameYLbl = new JLabel("Name Y axixs");
		nameYLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		nameYLbl.setBounds(10, 185, 98, 30);
		frame.getContentPane().add(nameYLbl);

		legendLbl = new JLabel("Name legend");
		legendLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		legendLbl.setBounds(10, 220, 98, 30);
		frame.getContentPane().add(legendLbl);

		legendTxt = new JTextField();
		legendTxt.setToolTipText("Name legend ");
		legendTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		legendTxt.setEditable(false);
		legendTxt.setColumns(10);
		legendTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		legendTxt.setBounds(132, 220, 128, 30);
		frame.getContentPane().add(legendTxt);

		newBtn = new JButton("New");
		newBtn.addActionListener(new ActionListener() {

			/**
			 * new
			 */
			public void actionPerformed(ActionEvent e) {

				dataValue.clear();
				nameValue.clear();
				x.clear();
				y.clear();
				sizeBubble.clear();
				nameGraphic = "";
				xAxis = "";
				yAxis = "";
				legend = "";
				nameGraphicTxt.setText("");
				nameDataTxt.setText("");
				dataTxt.setText("");
				areaDataTxtArea.append("\n");
				xAxisTxt.setText("");
				yAxisTxt.setText("");
				legendTxt.setText("");
				nameGraphicTxt.requestFocusInWindow();
			}
		});
		newBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		newBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		newBtn.setBounds(10, 345, 98, 30);
		frame.getContentPane().add(newBtn);
		
		JLabel sizeBubbleLbl = new JLabel("Size bubble");
		sizeBubbleLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		sizeBubbleLbl.setBounds(10, 115, 98, 30);
		frame.getContentPane().add(sizeBubbleLbl);
		
		sizeBubbleTxt = new JTextField();
		sizeBubbleTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					add();
			}
		});
		sizeBubbleTxt.setToolTipText("Name legend ");
		sizeBubbleTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		sizeBubbleTxt.setEditable(false);
		sizeBubbleTxt.setColumns(10);
		sizeBubbleTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
						null, null));
		sizeBubbleTxt.setBounds(132, 115, 128, 30);
		frame.getContentPane().add(sizeBubbleTxt);

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		operationMenu = new JMenu("Operation");
		operationMenu.setMnemonic(KeyEvent.VK_O);
		menuBar.add(operationMenu);

		addMenuItem = new JMenuItem("Add");
		addMenuItem.setMnemonic(KeyEvent.VK_A);
		operationMenu.add(addMenuItem);
		addMenuItem.addActionListener(new ActionListener() {

			/**
			 * add
			 */
			public void actionPerformed(ActionEvent e) {

				add();

			}
		});

		allCancelMenuItem = new JMenuItem("AllCanc");
		allCancelMenuItem.setMnemonic(KeyEvent.VK_L);
		operationMenu.add(allCancelMenuItem);
		allCancelMenuItem.addActionListener(new ActionListener() {

			/**
			 * all cancel
			 */
			public void actionPerformed(ActionEvent e) {

				nameGraphicTxt.setText("");
				nameDataTxt.setText("");
				dataTxt.setText("");
				xAxisTxt.setText("");
				yAxisTxt.setText("");
				legendTxt.setText("");
				nameGraphicTxt.requestFocusInWindow();

			}
		});

		cancelMenuItem = new JMenuItem("Cancel");
		cancelMenuItem.setMnemonic(KeyEvent.VK_C);
		operationMenu.add(cancelMenuItem);
		cancelMenuItem.addActionListener(new ActionListener() {

			/**
			 * cancel
			 */
			public void actionPerformed(ActionEvent e) {

				nameDataTxt.setText("");
				dataTxt.setText("");
				nameDataTxt.requestFocusInWindow();

			}
		});

		enterMenuItem = new JMenuItem("Enter");
		enterMenuItem.setMnemonic(KeyEvent.VK_E);
		operationMenu.add(enterMenuItem);

		mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {

			/**
			 * new
			 */
			public void actionPerformed(ActionEvent e) {

				dataValue.clear();
				nameValue.clear();
				nameGraphic = "";
				xAxis = "";
				yAxis = "";
				legend = "";
				nameGraphicTxt.setText("");
				nameDataTxt.setText("");
				dataTxt.setText("");
				areaDataTxtArea.append("\n");
				xAxisTxt.setText("");
				yAxisTxt.setText("");
				legendTxt.setText("");
				nameGraphicTxt.requestFocusInWindow();
			}
		});
		mntmNew.setMnemonic(KeyEvent.VK_N);
		operationMenu.add(mntmNew);
		enterMenuItem.addActionListener(new ActionListener() {

			/**
			 * enter
			 */
			public void actionPerformed(ActionEvent e) {

				enter();
			}
		});

		closeMenu = new JMenu("Close");
		closeMenu.setMnemonic(KeyEvent.VK_C);
		menuBar.add(closeMenu);

		closeMenuItem = new JMenuItem("Close graphic");
		closeMenuItem.setMnemonic(KeyEvent.VK_C);
		closeMenu.add(closeMenuItem);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{nameGraphicTxt, dataTxt, nameDataTxt, sizeBubbleTxt}));
		closeMenuItem.addActionListener(new ActionListener() {

			/**
			 * close graphic
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
	}
}
