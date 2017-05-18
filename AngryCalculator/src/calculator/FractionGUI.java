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
 * FractionGUI.java
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

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

/**
 * Class GUI for calculating fractions
 * 
 * @author ivan
 * 
 */
public class FractionGUI {

	private static double num1 = 0.0;
	private static double den1 = 1.0;
	private static double num2 = 0.0;
	private static double den2 = 1.0;

	protected JFrame frame;

	private static JTextField num1Txt;
	private static JTextField den1Txt;
	private static JTextField num2Txt;
	private static JTextField den2Txt;
	private JTextField numRisTxt;
	private JTextField denRisTxt;

	private JLabel separatorLbl;
	private JLabel separator2Lbl;
	private JLabel separator3Lbl;

	private JButton cancelBtn;
	private JButton closeBtn;
	private JButton sumBtn;
	private JButton multiplicationBtn;
	private JButton divisionBtn;
	private JButton subtractionBtn;

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
			num1 = Integer.parseInt(num1Txt.getText());

		} catch (NumberFormatException numberFormatException) {
			error();
			num1Txt.setText("");
			num1Txt.requestFocusInWindow();
		}

		try {
			num2 = Integer.parseInt(num2Txt.getText());

		} catch (NumberFormatException numberFormatException) {
			error();
			num2Txt.setText("");
			num2Txt.requestFocusInWindow();
		}

		try {
			den1 = Integer.parseInt(den1Txt.getText());

		} catch (NumberFormatException numberFormatException) {
			error();
			den1Txt.setText("");
			den1Txt.requestFocusInWindow();
		}

		try {
			den2 = Integer.parseInt(den2Txt.getText());

		} catch (NumberFormatException numberFormatException) {
			error();
			den2Txt.setText("");
			den2Txt.requestFocusInWindow();
		}

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FractionGUI window = new FractionGUI();
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
	public FractionGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBackground(Color.GRAY);
		frame.setTitle("Fraction");
		frame.setResizable(false);
		frame.setBounds(100, 100, 360, 255);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		num1Txt = new JTextField();
		num1Txt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		num1Txt.setFont(new Font("Dialog", Font.PLAIN, 14));
		num1Txt.setBounds(12, 12, 100, 30);
		frame.getContentPane().add(num1Txt);
		num1Txt.setColumns(10);

		den1Txt = new JTextField();
		den1Txt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		den1Txt.setFont(new Font("Dialog", Font.PLAIN, 14));
		den1Txt.setBounds(12, 88, 100, 30);
		frame.getContentPane().add(den1Txt);
		den1Txt.setColumns(10);

		separatorLbl = new JLabel("-------------------");
		separatorLbl.setBounds(12, 50, 100, 28);
		frame.getContentPane().add(separatorLbl);

		num2Txt = new JTextField();
		num2Txt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		num2Txt.setFont(new Font("Dialog", Font.PLAIN, 14));
		num2Txt.setColumns(10);
		num2Txt.setBounds(124, 12, 100, 30);
		frame.getContentPane().add(num2Txt);

		separator2Lbl = new JLabel("-------------------");
		separator2Lbl.setBounds(124, 50, 100, 28);
		frame.getContentPane().add(separator2Lbl);

		den2Txt = new JTextField();
		den2Txt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		den2Txt.setFont(new Font("Dialog", Font.PLAIN, 14));
		den2Txt.setColumns(10);
		den2Txt.setBounds(124, 88, 100, 30);
		frame.getContentPane().add(den2Txt);

		numRisTxt = new JTextField();
		numRisTxt.setForeground(Color.BLUE);
		numRisTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		numRisTxt.setEditable(false);
		numRisTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		numRisTxt.setColumns(10);
		numRisTxt.setBounds(246, 12, 100, 30);
		frame.getContentPane().add(numRisTxt);

		separator3Lbl = new JLabel("-------------------");
		separator3Lbl.setBounds(246, 50, 100, 28);
		frame.getContentPane().add(separator3Lbl);

		denRisTxt = new JTextField();
		denRisTxt.setForeground(Color.BLUE);
		denRisTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		denRisTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		denRisTxt.setEditable(false);
		denRisTxt.setColumns(10);
		denRisTxt.setBounds(246, 88, 100, 30);
		frame.getContentPane().add(denRisTxt);

		cancelBtn = new JButton("Cancel");
		cancelBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		cancelBtn.addActionListener(new ActionListener() {
			/**
			 * all cancel
			 */
			public void actionPerformed(ActionEvent e) {

				num1Txt.setText("");
				num2Txt.setText("");
				numRisTxt.setText("");
				den1Txt.setText("");
				den2Txt.setText("");
				denRisTxt.setText("");
				num1Txt.requestFocusInWindow();

			}
		});
		cancelBtn.setBounds(12, 138, 100, 30);
		frame.getContentPane().add(cancelBtn);

		closeBtn = new JButton("Close");
		closeBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		closeBtn.setBounds(12, 180, 100, 30);
		frame.getContentPane().add(closeBtn);

		sumBtn = new JButton("+");
		sumBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		sumBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		sumBtn.addActionListener(new ActionListener() {
			/**
			 * sum fraction
			 */
			public void actionPerformed(ActionEvent e) {

				InputNumbers();

				Fraction fraction = new Fraction(num1, den1);

				Fraction fractionSum = fraction.sum(new Fraction(num2, den2));

				numRisTxt.setText(String.valueOf(fractionSum.getNum()));
				denRisTxt.setText(String.valueOf(fractionSum.getDen()));
			}
		});
		sumBtn.setBounds(124, 138, 100, 30);
		frame.getContentPane().add(sumBtn);

		subtractionBtn = new JButton("-");
		subtractionBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		subtractionBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		subtractionBtn.addActionListener(new ActionListener() {
			/**
			 * subtraction fraction
			 */
			public void actionPerformed(ActionEvent e) {

				InputNumbers();

				Fraction fraction = new Fraction(num1, den1);

				Fraction fractionSum = fraction.soct(new Fraction(num2, den2));

				numRisTxt.setText(String.valueOf(fractionSum.getNum()));
				denRisTxt.setText(String.valueOf(fractionSum.getDen()));
			}
		});
		subtractionBtn.setBounds(124, 180, 100, 30);
		frame.getContentPane().add(subtractionBtn);

		multiplicationBtn = new JButton("x");
		multiplicationBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		multiplicationBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		multiplicationBtn.addActionListener(new ActionListener() {
			/**
			 * multiplication fraction
			 */
			public void actionPerformed(ActionEvent e) {

				InputNumbers();

				Fraction fraction = new Fraction(num1, den1);

				Fraction fractionSum = fraction.mult(new Fraction(num2, den2));

				numRisTxt.setText(String.valueOf(fractionSum.getNum()));
				denRisTxt.setText(String.valueOf(fractionSum.getDen()));
			}
		});
		multiplicationBtn.setBounds(246, 138, 100, 30);
		frame.getContentPane().add(multiplicationBtn);

		divisionBtn = new JButton("/");
		divisionBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		divisionBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		divisionBtn.addActionListener(new ActionListener() {
			/**
			 * division fraction
			 */
			public void actionPerformed(ActionEvent e) {

				InputNumbers();

				Fraction fraction = new Fraction(num1, den1);

				Fraction fractionSum = fraction.div(new Fraction(num2, den2));

				numRisTxt.setText(String.valueOf(fractionSum.getNum()));
				denRisTxt.setText(String.valueOf(fractionSum.getDen()));
			}
		});
		divisionBtn.setBounds(246, 180, 100, 30);
		frame.getContentPane().add(divisionBtn);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { num1Txt, den1Txt, num2Txt, den2Txt }));
	}
}
