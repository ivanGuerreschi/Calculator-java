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
 * ConvertorGUI.java
 * --------------------
 * Copyright (C) 2015 Ivan Guerreschi
 *
 * Original Author:  Ivan Guerreschi;
 * Contributor(s): 
 * 
 * Changes
 * ------- 
 */

package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Formatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import java.awt.Color;

/**
 * Class GUI for convertor
 * 
 * @author Ivan Guerreschi
 *
 */
public class ConvertorGUI {
	
	private double input = 0.0;	
	private String[] comboBox = new String[] {"Byte", "Kilobyte", "Megabyte", "Gigabyte", "Terabyte"};
	
	protected JFrame frame;
	
	private JTextField inputTxt;
	private JTextField resultTxt;
	
	private JComboBox<String> inputComBox;
	private JComboBox<String> resultComBox;
	
	private JButton converseBtn;
	private JButton cancBtn;
	private JButton closeBtn;
	
	private Formatter formatter;
	
	/**
	 * method stamp error
	 */
	public void error() {
		JOptionPane.showMessageDialog(null,
				"Only whole numbers eg 14 or with point es: 12.4");
	}	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConvertorGUI window = new ConvertorGUI();
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
	public ConvertorGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBackground(Color.GRAY);
		frame.setTitle("Convertor");
		frame.setResizable(false);
		frame.setBounds(100, 100, 301, 185);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		inputTxt = new JTextField();
		inputTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		inputTxt.setBounds(12, 12, 114, 25);
		frame.getContentPane().add(inputTxt);
		inputTxt.setColumns(10);
		
		resultTxt = new JTextField();
		resultTxt.setEditable(false);
		resultTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		resultTxt.setBounds(164, 12, 114, 25);
		frame.getContentPane().add(resultTxt);
		resultTxt.setColumns(10);
		
		inputComBox = new JComboBox<String>();
		inputComBox.setModel(new DefaultComboBoxModel<String>(comboBox));
		inputComBox.setBounds(12, 43, 114, 24);
		frame.getContentPane().add(inputComBox);
		
		resultComBox = new JComboBox<String>();
		resultComBox.setModel(new DefaultComboBoxModel<String>(comboBox));
		resultComBox.setBounds(164, 43, 114, 24);
		frame.getContentPane().add(resultComBox);
		
		converseBtn = new JButton("Converse");
		converseBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		converseBtn.addActionListener(new ActionListener() {
			/**
			 * calculate conversion
			 */
			public void actionPerformed(ActionEvent e) {
				
				try {					
					input = Double.parseDouble(inputTxt.getText());
					
				} catch (NumberFormatException numberFormatException) {
					error();
					inputTxt.setText("");
					inputTxt.requestFocusInWindow();
				}
				
				Convertor convertor = new Convertor(input,
						inputComBox.getSelectedIndex(),
						resultComBox.getSelectedIndex());
								
				formatter = new Formatter();
				formatter.format("%.5f", convertor.calcConvertor());
				
				resultTxt.setText(formatter.toString());				
			}
		});
		converseBtn.setBounds(12, 79, 114, 25);
		frame.getContentPane().add(converseBtn);
		
		cancBtn = new JButton("Cancel");
		cancBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		cancBtn.addActionListener(new ActionListener() {
			/**
			 * cancel input result
			 */
			public void actionPerformed(ActionEvent e) {
				
				inputTxt.setText("");
				resultTxt.setText("");
			}
		});
		cancBtn.setBounds(164, 79, 114, 25);
		frame.getContentPane().add(cancBtn);
		
		closeBtn = new JButton("Close");
		closeBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		closeBtn.addActionListener(new ActionListener() {
			/**
			 * close ConvertorGUI
			 */
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		closeBtn.setBounds(12, 116, 114, 25);
		frame.getContentPane().add(closeBtn);
	}

}
