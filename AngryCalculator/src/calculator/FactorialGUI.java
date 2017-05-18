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
 * FactorialGUI.java
 * --------------------
 * Copyright (C) 2014 Ivan Guerreschi
 *
 * Original Author:  Ivan Guerreschi;
 * Contributor(s): 
 * 
 * Changes
 * -------
 * Date changes 16/10/2014
 * Separate class factorial calculation from GUI
 * Date changes 21/11/2014
 * Add multithreading  
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
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
 * Class to calculate the factorial
 * 
 * @author Ivan Guerreschi
 * 
 */
public class FactorialGUI {

	private JTextField numeroInsTxt;

	protected JFrame frame;

	private JButton calcBtn;
	private JButton allCancBtn;
	private JButton cancelBtn;
	private JButton closeBtn;

	private JTextArea resultTxtArea;

	private JLabel numberLbl;

	private JScrollPane resultScrlPan;

	private JMenuBar menuBar;

	private JMenu editMenu;
	private JMenu operationMenu;
	private JMenu closeMenu;

	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenuItem pasteMenuItem;
	private JMenuItem calculateMenuItem;
	private JMenuItem cancelMenuItem;
	private JMenuItem allCancMenuItem;
	private JMenuItem closeMenuItem;

	private TextTransferHandler th;

	/**
	 * calculate factorial
	 */
	public void calculate() {

		int number = 0;

		try {
			number = Integer.parseInt(numeroInsTxt.getText());
		} catch (NumberFormatException exception) {

			JOptionPane.showMessageDialog(frame, "Only whole numbers");
			numeroInsTxt.setText("");
			numeroInsTxt.requestFocusInWindow();
		}

		Thread thread = new Thread(new Factorial(resultTxtArea, number));
		thread.start();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FactorialGUI window = new FactorialGUI();
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
	public FactorialGUI() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBackground(Color.GRAY);
		frame.setTitle("Factorial");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(new Dimension(370, 420));
		frame.getContentPane().setLayout(null);

		numberLbl = new JLabel("Enter number");
		numberLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		numberLbl.setBounds(15, 18, 118, 30);
		frame.getContentPane().add(numberLbl);

		numeroInsTxt = new JTextField("");
		numeroInsTxt.addKeyListener(new KeyAdapter() {
			@Override
			/**
			 * calculate factorial
			 */
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					calculate();

			}
		});
		numeroInsTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		numeroInsTxt.setBounds(15, 60, 100, 30);
		numeroInsTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		numeroInsTxt.setToolTipText("Enter number");
		frame.getContentPane().add(numeroInsTxt);

		calcBtn = new JButton("Calculate");
		calcBtn.addActionListener(new ActionListener() {
			/**
			 * calculate the factorial
			 */
			public void actionPerformed(ActionEvent e) {

				calculate();
			}

		});
		calcBtn.setBounds(15, 120, 100, 30);
		calcBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		calcBtn.setToolTipText("Calculates the factorial of the number");
		frame.getContentPane().add(calcBtn);

		allCancBtn = new JButton("AllCanc");
		allCancBtn.addActionListener(new ActionListener() {
			/**
			 * all cancel
			 */
			public void actionPerformed(ActionEvent e) {

				numeroInsTxt.setText("");
				resultTxtArea.setText("");
				numeroInsTxt.requestFocusInWindow();
			}
		});
		allCancBtn.setBounds(15, 220, 100, 30);
		allCancBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		allCancBtn.setToolTipText("Clear the entered number and results");
		frame.getContentPane().add(allCancBtn);

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
		cancelBtn.setBounds(15, 170, 100, 30);
		cancelBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		cancelBtn.setToolTipText("Deletes only the entered number");
		cancelBtn.setMnemonic(KeyEvent.VK_0);
		frame.getContentPane().add(cancelBtn);

		closeBtn = new JButton("Close");
		closeBtn.addActionListener(new ActionListener() {
			/**
			 * close the factorial
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		closeBtn.setBounds(15, 270, 100, 30);
		closeBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		closeBtn.setToolTipText("Close the program");
		frame.getContentPane().add(closeBtn);

		resultScrlPan = new JScrollPane();
		resultScrlPan.setBounds(151, 23, 205, 322);
		frame.getContentPane().add(resultScrlPan);

		th = new TextTransferHandler(new JTextArea());

		resultTxtArea = new JTextArea();
		resultTxtArea.setLineWrap(true);
		resultTxtArea.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		resultTxtArea.setFont(new Font("Dialog", Font.PLAIN, 14));
		resultTxtArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				resultTxtArea.setFocusable(true);
			}
		});

		resultTxtArea.setDragEnabled(true);
		resultTxtArea.setForeground(Color.BLUE);
		resultTxtArea.setToolTipText("Result");
		resultTxtArea.setTransferHandler(th);
		resultScrlPan.setViewportView(resultTxtArea);

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
				resultTxtArea.setText("");
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

		closeMenuItem = new JMenuItem("Close factorial");
		closeMenuItem.setMnemonic(KeyEvent.VK_C);
		closeMenu.add(closeMenuItem);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { numeroInsTxt }));
		closeMenuItem.addActionListener(new ActionListener() {

			/**
			 * close factorial
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();

			}
		});

	}
}
