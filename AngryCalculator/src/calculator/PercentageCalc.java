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
 * PercentageCalc.java
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

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Formatter;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.border.BevelBorder;

import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

/**
 * Class for the calculation of percentages
 * 
 * @author Ivan Guerreschi
 * 
 */
public class PercentageCalc {

	protected JFrame frame;

	private JTextField numberTxt;
	private JTextField percTxt;
	private JTextField resultPosTxt;
	private JTextField resultNegTxt;

	private JButton cancelBtn;
	private JButton cancelCifResBtn;
	private JButton closeBtn;

	private JMenuBar menuBar;

	private JMenu operationMenu;
	private JMenu closeMenu;

	private JMenuItem calculateMenuItem;
	private JMenuItem cancelMenuItem;
	private JMenuItem closeMenuItem;
	private JMenuItem cancelTotMenuItem;

	private JButton calculateBtn;

	private JLabel numberLbl;
	private JLabel numberPercLbl;
	private JLabel resultLbl;
	private JLabel plusLbl;
	private JLabel lessLbl;

	/**
	 * method for calculate the percentage
	 */
	public void calculate() {

		double number = 0.0;
		double percentage = 0.0;

		boolean control = false;

		do {
			try {
				number = Double.parseDouble(numberTxt.getText());
				percentage = Double.parseDouble(percTxt.getText());
				control = true;
			} catch (NumberFormatException exception) {

				JOptionPane.showMessageDialog(frame, "Enter only numbers");
				numberTxt.setText("0");
				percTxt.setText("0");

			} catch (Exception exception) {

				JOptionPane.showMessageDialog(frame, "System error", "Error",
						JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}

		} while (!control);

		Formatter formatterPos = new Formatter();
		Formatter formatterNeg = new Formatter();

		double ris = (number * percentage) / 100;

		double risPos = number + ris;
		double risNeg = number - ris;

		resultPosTxt
				.setText(String.valueOf(formatterPos.format("%.2f", risPos)));
		resultNegTxt
				.setText(String.valueOf(formatterNeg.format("%.2f", risNeg)));
		formatterPos.close();
		formatterNeg.close();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PercentageCalc window = new PercentageCalc();
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
	public PercentageCalc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Percentage calculation");
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBackground(Color.GRAY);
		frame.setResizable(false);
		frame.setBounds(100, 100, 402, 337);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		numberLbl = new JLabel("Number");
		numberLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		numberLbl.setBackground(Color.GRAY);
		numberLbl.setBounds(12, 12, 70, 30);
		frame.getContentPane().add(numberLbl);

		numberTxt = new JTextField();
		numberTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		numberTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		numberTxt.setToolTipText("Enter number to be calculated");
		numberTxt.setBounds(119, 10, 100, 30);
		frame.getContentPane().add(numberTxt);
		numberTxt.setColumns(10);

		numberPercLbl = new JLabel("Number%");
		numberPercLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		numberPercLbl.setBounds(12, 64, 70, 30);
		frame.getContentPane().add(numberPercLbl);

		percTxt = new JTextField();
		percTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		percTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		percTxt.setToolTipText("Enter number percentage");
		percTxt.setBounds(119, 64, 100, 30);
		frame.getContentPane().add(percTxt);
		percTxt.setColumns(10);

		calculateBtn = new JButton("Calculate");
		calculateBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		calculateBtn.setToolTipText("Calculate percentage");
		calculateBtn.addActionListener(new ActionListener() {
			/**
			 * calculate
			 */
			public void actionPerformed(ActionEvent e) {

				calculate();
			}
		});

		calculateBtn.setBounds(12, 190, 117, 30);
		frame.getContentPane().add(calculateBtn);

		resultLbl = new JLabel("Result");
		resultLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		resultLbl.setBounds(12, 138, 70, 30);
		frame.getContentPane().add(resultLbl);

		resultPosTxt = new JTextField();
		resultPosTxt.setForeground(Color.BLUE);
		resultPosTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		resultPosTxt.setToolTipText("Positive result");
		resultPosTxt.setEditable(false);
		resultPosTxt.setBounds(119, 136, 114, 30);
		frame.getContentPane().add(resultPosTxt);
		resultPosTxt.setColumns(10);

		cancelBtn = new JButton("AllCanc");
		cancelBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		cancelBtn.setToolTipText("Reset total");
		cancelBtn.addActionListener(new ActionListener() {
			/**
			 * all cancel
			 */
			public void actionPerformed(ActionEvent e) {

				numberTxt.setText("");
				percTxt.setText("");
				resultPosTxt.setText("");
				resultNegTxt.setText("");
				numberTxt.requestFocusInWindow();

			}
		});

		cancelBtn.setBounds(157, 239, 130, 30);
		frame.getContentPane().add(cancelBtn);

		resultNegTxt = new JTextField();
		resultNegTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		resultNegTxt.setForeground(Color.BLUE);
		resultNegTxt.setToolTipText("Negative result");
		resultNegTxt.setEditable(false);
		resultNegTxt.setBounds(259, 136, 114, 30);
		frame.getContentPane().add(resultNegTxt);
		resultNegTxt.setColumns(10);

		cancelCifResBtn = new JButton("Cancel cal/res");
		cancelCifResBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		cancelCifResBtn.setToolTipText("Reset number calculated and results");
		cancelCifResBtn.addActionListener(new ActionListener() {
			/**
			 * cancel result
			 */
			public void actionPerformed(ActionEvent e) {

				numberTxt.setText("");
				resultPosTxt.setText("");
				resultNegTxt.setText("");
				numberTxt.requestFocusInWindow();

			}
		});

		cancelCifResBtn.setBounds(157, 190, 130, 30);
		frame.getContentPane().add(cancelCifResBtn);

		plusLbl = new JLabel("+%");
		plusLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		plusLbl.setBounds(159, 109, 26, 15);
		frame.getContentPane().add(plusLbl);

		lessLbl = new JLabel("-%");
		lessLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		lessLbl.setBounds(301, 109, 26, 15);
		frame.getContentPane().add(lessLbl);

		closeBtn = new JButton("Close");
		closeBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		closeBtn.setToolTipText("Close the program");
		closeBtn.addActionListener(new ActionListener() {
			/**
			 * close the program
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});

		closeBtn.setBounds(12, 239, 117, 30);
		frame.getContentPane().add(closeBtn);

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		operationMenu = new JMenu("Operation");
		operationMenu.setMnemonic(KeyEvent.VK_O);
		menuBar.add(operationMenu);

		calculateMenuItem = new JMenuItem("Calculate");
		calculateMenuItem.setMnemonic(KeyEvent.VK_A);
		operationMenu.add(calculateMenuItem);
		calculateMenuItem.addActionListener(new ActionListener() {

			/**
			 * calculate
			 */
			public void actionPerformed(ActionEvent e) {

				calculate();

			}
		});

		cancelMenuItem = new JMenuItem("Cancel cal/canc");
		operationMenu.add(cancelMenuItem);
		cancelMenuItem.setMnemonic(KeyEvent.VK_C);
		cancelMenuItem.addActionListener(new ActionListener() {

			/**
			 * reset
			 */
			public void actionPerformed(ActionEvent e) {

				numberTxt.setText("");
				resultPosTxt.setText("");
				resultNegTxt.setText("");
				numberTxt.requestFocusInWindow();
			}
		});

		cancelTotMenuItem = new JMenuItem("Cancel tot");
		cancelTotMenuItem.setMnemonic(KeyEvent.VK_T);
		operationMenu.add(cancelTotMenuItem);
		cancelTotMenuItem.addActionListener(new ActionListener() {

			/**
			 * reset total
			 */
			public void actionPerformed(ActionEvent e) {

				numberTxt.setText("");
				percTxt.setText("");
				resultPosTxt.setText("");
				resultNegTxt.setText("");
				numberTxt.requestFocusInWindow();
			}
		});

		closeMenu = new JMenu("Close");
		closeMenu.setMnemonic(KeyEvent.VK_C);
		menuBar.add(closeMenu);

		closeMenuItem = new JMenuItem("Close percentage");
		closeMenuItem.setMnemonic(KeyEvent.VK_C);
		closeMenu.add(closeMenuItem);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { numberTxt, percTxt }));
		closeMenuItem.addActionListener(new ActionListener() {

			/**
			 * close percentage
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();

			}
		});
	}
}
