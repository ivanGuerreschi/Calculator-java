/* ===========================================================
 * Angry calculator : a free calculator for the Java(tm) platform
 * ===========================================================
 *
 * Project Info:  navicolt@gmail.com
 *
 * Copyright (C) 2015 Ivan Guerreschi
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
 * DownloadFileGUI.java
 * --------------------
 * Copyright (C) 2015 Ivan Guerreschi
 *
 * Original Author:  Ivan Guerreschi;
 * Contributor(s): 
 * 
 * Changes
 * -------
 * 
 */


package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

/**
 * Class to calculate the download file GUI
 * 
 * @author Ivan Guerreschi
 * 
 */
public class DownloadFileGUI {

	protected JFrame frame;
	
	private JTextField dimensionTxt;
	private JTextField speedTxt;
	private JTextField timeTxt;
	
	private JButton calculateBtn;
	private JButton cancelBtn;
	private JButton closeBtn;
	
	private double dimension = 0.0;
	private double speed = 0.0;
	
	/**
	 * method stamp error
	 */
	public void error() {
		JOptionPane.showMessageDialog(null,
				"Only whole numbers eg 14 or with point es: 12.4");
	}
	
	/**
	 * insert numbers for input
	 */
	public void InputNumbers() {
		
		try {
			dimension = Double.parseDouble(dimensionTxt.getText());
			speed = Double.parseDouble(speedTxt.getText());

		} catch (NumberFormatException numberFormatException) {
			error();
			dimensionTxt.setText("");
			speedTxt.setText("");
			dimensionTxt.requestFocusInWindow();
		}	
	}	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DownloadFileGUI window = new DownloadFileGUI();
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
	public DownloadFileGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setResizable(false);
		frame.setBackground(Color.GRAY);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setTitle("Calculate download file");
		frame.setBounds(100, 100, 344, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel dimensionLbl = new JLabel("Dimension file Mb");
		dimensionLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		dimensionLbl.setBounds(12, 12, 139, 30);
		frame.getContentPane().add(dimensionLbl);
		
		JLabel speedLbl = new JLabel("Speed Mb/s");
		speedLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		speedLbl.setBounds(12, 54, 139, 30);
		frame.getContentPane().add(speedLbl);
		
		JLabel timeLbl = new JLabel("Estimated  time");
		timeLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		timeLbl.setBounds(12, 98, 128, 30);
		frame.getContentPane().add(timeLbl);
		
		dimensionTxt = new JTextField();
		dimensionTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		dimensionTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		dimensionTxt.setBounds(169, 13, 150, 30);
		frame.getContentPane().add(dimensionTxt);
		dimensionTxt.setColumns(10);
		
		speedTxt = new JTextField();
		speedTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		speedTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		speedTxt.setBounds(169, 55, 150, 30);
		frame.getContentPane().add(speedTxt);
		speedTxt.setColumns(10);
		
		timeTxt = new JTextField();
		timeTxt.setEditable(false);
		timeTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		timeTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		timeTxt.setBounds(169, 99, 150, 30);
		frame.getContentPane().add(timeTxt);
		timeTxt.setColumns(10);
		
		calculateBtn = new JButton("Calculate time");
		calculateBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		calculateBtn.setFont(new Font("Dialog", Font.BOLD, 12));
		calculateBtn.addActionListener(new ActionListener() {
			/**
			 * calculate the estimated download time
			 */
			public void actionPerformed(ActionEvent e) {
				
				InputNumbers();
				
				DownloadFile downloadFile = new DownloadFile(dimension, speed);
				timeTxt.setText(downloadFile.time());
			}
		});
		calculateBtn.setBounds(12, 171, 139, 30);
		frame.getContentPane().add(calculateBtn);
		
		cancelBtn = new JButton("All Cancel");
		cancelBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		cancelBtn.addActionListener(new ActionListener() {
			
			/**
			 * all cancel result
			 */
			public void actionPerformed(ActionEvent e) {
				
				dimensionTxt.setText("");
				speedTxt.setText("");
				timeTxt.setText("");
			}
		});
		cancelBtn.setBounds(169, 174, 128, 30);
		frame.getContentPane().add(cancelBtn);
		
		closeBtn = new JButton("Close");
		closeBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		closeBtn.addActionListener(new ActionListener() {
			
			/**
			 * close the DownloadFileGUI
			 */
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		closeBtn.setBounds(12, 221, 139, 30);
		frame.getContentPane().add(closeBtn);
	}
}
