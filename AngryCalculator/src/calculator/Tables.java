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
 * Tables.java
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
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.text.DefaultEditorKit;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.event.KeyAdapter;

/**
 * 
 * Class that calculates the multiplication tables
 * 
 * @author Ivan Guerreschi
 * 
 */

public class Tables {

	private int nfc = 0; // numbers for cycle
	private int[] numbers = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

	private JTextField numeroInsTxt;

	private JButton calcBtn;
	private JButton allCancBtn;
	private JButton cancelBtn;
	private JButton closeBtn;

	private JLabel numberInsLbl;
	private JLabel numberForCycleLbl;

	private JComboBox<String> numberForCycles;

	private JTextArea resultTextArea;

	private JScrollPane scrollPane;

	private TextTransferHandler th;

	protected JFrame frame;

	private JMenuBar menuBar;

	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenuItem pasteMenuItem;
	private JMenuItem calculateMenuItem;
	private JMenuItem cancelMenuItem;
	private JMenuItem allCancMenuItem;
	private JMenuItem closeMenuItem;

	private JMenu operationMenu;
	private JMenu closeMenu;
	private JMenu editMenu;

	public void calculate() {

		double number = 0;

		try {
			number = Double.parseDouble(numeroInsTxt.getText());
		} catch (NumberFormatException exception) {

			JOptionPane.showMessageDialog(frame,
					"Only whole numbers or point es: 12.4");
			numeroInsTxt.setText("");
			numeroInsTxt.requestFocusInWindow();
		}

		// calculates the number entered in the input table of ten
		// multiplications with a for loop and an array

		nfc = numbers[numberForCycles.getSelectedIndex()] + 1;

		for (int i = 1; i < nfc; i++)
			resultTextArea.append(" " + numeroInsTxt.getText() + " X " + i
					+ " = " + number * i + "\n");

		resultTextArea.append("\n");
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tables window = new Tables();
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
	public Tables() {

		Components();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void Components() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBackground(Color.GRAY);
		frame.setTitle("Tables");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(new Dimension(370, 440));
		frame.getContentPane().setLayout(null);

		numberInsLbl = new JLabel("Enter number");
		numberInsLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		numberInsLbl.setBounds(15, 10, 120, 30);
		frame.getContentPane().add(numberInsLbl);

		numeroInsTxt = new JTextField("");
		numeroInsTxt.addKeyListener(new KeyAdapter() {

			/**
			 * calcolate
			 */
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					calculate();
			}
		});
		numeroInsTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		numeroInsTxt.setBounds(15, 50, 100, 30);
		numeroInsTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		numeroInsTxt.setToolTipText("Enter the number you want to multiply");
		numeroInsTxt.setEditable(true);
		frame.getContentPane().add(numeroInsTxt);

		numberForCycleLbl = new JLabel("Number molt");
		numberForCycleLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		numberForCycleLbl.setBounds(15, 100, 120, 30);
		frame.getContentPane().add(numberForCycleLbl);

		numberForCycles = new JComboBox<String>();
		numberForCycles.setModel(new DefaultComboBoxModel<String>(new String[] {
				"10", "20", "30", "40", "50", "60", "70", "80", "90", "100" }));
		numberForCycles.setFont(new Font("Dialog", Font.BOLD, 14));
		numberForCycles.setBounds(15, 140, 100, 30);
		numberForCycles.setMaximumRowCount(3);
		numberForCycles.setToolTipText("Number for moltiplication");
		frame.getContentPane().add(numberForCycles);

		calcBtn = new JButton("Calculate");
		calcBtn.addActionListener(new ActionListener() {
			/**
			 * calculate the tables
			 */
			public void actionPerformed(ActionEvent e) {

				calculate();
			}
		});
		calcBtn.setBounds(15, 190, 100, 30);
		calcBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		calcBtn.setToolTipText("10 Performs multiplication of the number entered");
		frame.getContentPane().add(calcBtn);

		cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			/**
			 * cancel input
			 */
			public void actionPerformed(ActionEvent e) {

				numeroInsTxt.setText("");
				numeroInsTxt.requestFocusInWindow();
			}
		});
		cancelBtn.setBounds(15, 240, 100, 30);
		cancelBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		cancelBtn.setToolTipText("Deletes only the entered number");
		frame.getContentPane().add(cancelBtn);

		allCancBtn = new JButton("AllCanc");
		allCancBtn.addActionListener(new ActionListener() {
			/**
			 * all cancel
			 */
			public void actionPerformed(ActionEvent e) {

				numeroInsTxt.setText("");
				resultTextArea.setText("");
				numeroInsTxt.requestFocusInWindow();
			}
		});
		allCancBtn.setBounds(15, 290, 100, 30);
		allCancBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		allCancBtn.setToolTipText("Clear the entered number and results");
		frame.getContentPane().add(allCancBtn);

		closeBtn = new JButton("Close");
		closeBtn.addActionListener(new ActionListener() {
			/**
			 * close tables
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		closeBtn.setBounds(15, 340, 100, 30);
		closeBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		closeBtn.setToolTipText("Close program");
		frame.getContentPane().add(closeBtn);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(151, 23, 205, 342);
		frame.getContentPane().add(scrollPane);

		th = new TextTransferHandler(new JTextArea());

		resultTextArea = new JTextArea();
		resultTextArea.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		resultTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
		resultTextArea.setDragEnabled(true);
		resultTextArea.setForeground(Color.BLUE);
		resultTextArea.setToolTipText("Result of multiplication");
		resultTextArea.setTransferHandler(th);
		scrollPane.setViewportView(resultTextArea);

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		editMenu = new JMenu("Edit");
		editMenu.setMnemonic(KeyEvent.VK_E);
		menuBar.add(editMenu);

		copyMenuItem = new JMenuItem(new DefaultEditorKit.CopyAction());
		copyMenuItem.setText("Copy");
		copyMenuItem.setMnemonic(KeyEvent.VK_C);
		editMenu.add(copyMenuItem);

		cutMenuItem = new JMenuItem(new DefaultEditorKit.CutAction());
		cutMenuItem.setText("Cut");
		cutMenuItem.setMnemonic(KeyEvent.VK_T);
		editMenu.add(cutMenuItem);

		pasteMenuItem = new JMenuItem(new DefaultEditorKit.PasteAction());
		pasteMenuItem.setText("Paste");
		pasteMenuItem.setMnemonic(KeyEvent.VK_P);
		editMenu.add(pasteMenuItem);

		operationMenu = new JMenu("Operation");
		operationMenu.setMnemonic(KeyEvent.VK_O);
		menuBar.add(operationMenu);

		allCancMenuItem = new JMenuItem("AllCanc");
		allCancMenuItem.setMnemonic(KeyEvent.VK_A);
		operationMenu.add(allCancMenuItem);
		allCancMenuItem.addActionListener(new ActionListener() {
			/**
			 * all cancel result
			 */
			public void actionPerformed(ActionEvent e) {

				numeroInsTxt.setText("");
				resultTextArea.setText("");
				numeroInsTxt.requestFocusInWindow();

			}
		});

		calculateMenuItem = new JMenuItem("Calculate");
		calculateMenuItem.setMnemonic(KeyEvent.VK_C);
		operationMenu.add(calculateMenuItem);
		calculateMenuItem.addActionListener(new ActionListener() {

			/**
			 * calculate
			 */
			public void actionPerformed(ActionEvent e) {

				calculate();
			}
		});

		cancelMenuItem = new JMenuItem("Cancel");
		cancelMenuItem.setMnemonic(KeyEvent.VK_N);
		operationMenu.add(cancelMenuItem);
		cancelMenuItem.addActionListener(new ActionListener() {

			/**
			 * cancel result
			 */
			public void actionPerformed(ActionEvent e) {

				numeroInsTxt.setText("");
				numeroInsTxt.requestFocusInWindow();

			}
		});

		closeMenu = new JMenu("Close");
		closeMenu.setMnemonic(KeyEvent.VK_C);
		menuBar.add(closeMenu);

		closeMenuItem = new JMenuItem("Close tables");
		closeMenuItem.setMnemonic(KeyEvent.VK_C);
		closeMenu.add(closeMenuItem);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { numeroInsTxt, numberForCycles }));
		closeMenuItem.addActionListener(new ActionListener() {

			/**
			 * close tables
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();

			}
		});

	}

}
