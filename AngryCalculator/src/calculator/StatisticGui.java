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
 * StatisticGui.java
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
import java.awt.event.KeyEvent;

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
 * Class for graphical display of statistics
 * 
 * @author Ivan Guerreschi
 * 
 */
public class StatisticGui {

	private Statistics statistics = new Statistics();

	protected JFrame frame;

	private JTextField numberInsTxt;
	private JTextField searchTxt;

	private JLabel numbersLbl;
	private JLabel searchLbl;

	private JButton addBtn;
	private JButton calcBtn;
	private JButton newBtn;
	private JButton closeBtn;
	private JButton allCancBtn;
	private JButton searchBtn;

	private JScrollPane numberAddScrlPan;
	private JScrollPane resultScrlPan;

	private JTextArea numberAddTxtArea;
	private JTextArea resultTxtArea;

	private JMenuBar menuBar;

	private JMenu editMenu;
	private JMenu operationMenu;
	private JMenu closeMenu;

	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenuItem pasteMenuItem;
	private JMenuItem addMenuItem;
	private JMenuItem allcancelMenuItem;
	private JMenuItem calculateMenuItem;
	private JMenuItem newMenuItem;
	private JMenuItem closeMenuItem;

	private TextTransferHandler th;	

	/**
	 * add
	 */
	public void add() {

		double number = 0;

		try {
			number = Double.parseDouble(numberInsTxt.getText());
		} catch (NumberFormatException exception) {

			JOptionPane.showMessageDialog(frame, "Only whole numbers");
			numberInsTxt.setText("");
			numberInsTxt.requestFocusInWindow();
		}

		statistics.enterNumber(number);
		numberAddTxtArea.append(Double.toString(number) + "\n");
		numberInsTxt.setText("");
		numberInsTxt.requestFocusInWindow();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatisticGui window = new StatisticGui();
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
	public StatisticGui() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBackground(Color.GRAY);
		frame.setTitle("Statistic ");
		frame.setBounds(100, 100, 365, 490);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		numbersLbl = new JLabel("Numbers");
		numbersLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		numbersLbl.setBounds(12, 12, 114, 15);
		frame.getContentPane().add(numbersLbl);

		numberInsTxt = new JTextField();
		numberInsTxt.addKeyListener(new KeyAdapter() {
			/**
			 * enter numbers
			 */
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					add();
			}
		});
		numberInsTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		numberInsTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		numberInsTxt.setBounds(12, 40, 100, 30);
		numberInsTxt.setToolTipText("Enter number");
		frame.getContentPane().add(numberInsTxt);
		numberInsTxt.setColumns(10);

		addBtn = new JButton("Add");
		addBtn.setToolTipText("Add numbers");
		addBtn.addActionListener(new ActionListener() {
			/**
			 * enter numbers
			 */
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		addBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		addBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		addBtn.setBounds(12, 200, 100, 30);
		frame.getContentPane().add(addBtn);

		calcBtn = new JButton("Calc");
		calcBtn.setToolTipText("Calculate");
		calcBtn.addActionListener(new ActionListener() {
			/**
			 * result statistic
			 */
			public void actionPerformed(ActionEvent e) {

				resultTxtArea.append("Numbers of the values: "
						+ String.valueOf(statistics.numbersValues())
						+ "\n"
						+ "Sum the numbers: "
						+ String.valueOf(statistics.sum())
						+ "\n"
						+ "Average value: "
						+ String.valueOf(statistics.average() + "\n"
								+ "Maximum value: "
								+ String.valueOf(statistics.maximum()) + "\n"
								+ "Minimum value: "
								+ String.valueOf(statistics.minimum()) + "\n"
								+ "Difference values: "
								+ String.valueOf(statistics.difference())
								+ "\n" + "Duplicate values: "
								+ String.valueOf(statistics.valDou()) + " ["
								+ String.valueOf(statistics.numDou()) + "]"
								+ "\n" + "Standard deviation: "
								+ String.valueOf(statistics.strdDev()) + "\n"
								+ "Sum of the squares: "
								+ String.valueOf(statistics.sumSquares())
								+ "\n\n"));
			}
		});
		calcBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		calcBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		calcBtn.setBounds(12, 250, 100, 30);
		frame.getContentPane().add(calcBtn);

		newBtn = new JButton("New");
		newBtn.setToolTipText("New statistic");
		newBtn.addActionListener(new ActionListener() {
			/**
			 * reset
			 */
			public void actionPerformed(ActionEvent e) {

				numberInsTxt.setText("");
				numberInsTxt.requestFocusInWindow();
				statistics.reset();
				numberAddTxtArea.append("\n");

			}
		});
		newBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		newBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		newBtn.setBounds(12, 300, 100, 30);
		frame.getContentPane().add(newBtn);

		closeBtn = new JButton("Close");
		closeBtn.setToolTipText("Close program");
		closeBtn.addActionListener(new ActionListener() {
			/**
			 * close statistic
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		closeBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		closeBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		closeBtn.setBounds(12, 400, 100, 30);
		frame.getContentPane().add(closeBtn);

		numberAddScrlPan = new JScrollPane();
		numberAddScrlPan.setBounds(150, 12, 200, 100);
		frame.getContentPane().add(numberAddScrlPan);

		th = new TextTransferHandler(new JTextArea());

		numberAddTxtArea = new JTextArea();
		numberAddTxtArea.setToolTipText("Numbers entered");
		numberAddTxtArea.setDragEnabled(true);
		numberAddTxtArea.setFont(new Font("Dialog", Font.PLAIN, 14));
		numberAddTxtArea.setForeground(Color.RED);
		numberAddTxtArea.setTransferHandler(th);
		numberAddScrlPan.setViewportView(numberAddTxtArea);

		resultScrlPan = new JScrollPane();
		resultScrlPan.setBounds(150, 137, 200, 243);
		frame.getContentPane().add(resultScrlPan);

		resultTxtArea = new JTextArea();
		resultTxtArea.setToolTipText("Result statistic");
		resultTxtArea.setDragEnabled(true);
		resultTxtArea.setFont(new Font("Dialog", Font.PLAIN, 14));
		resultTxtArea.setForeground(Color.BLUE);
		resultTxtArea.setTransferHandler(th);
		resultScrlPan.setViewportView(resultTxtArea);

		allCancBtn = new JButton("AllCanc");
		allCancBtn.setToolTipText("All cancel");
		allCancBtn.addActionListener(new ActionListener() {
			/**
			 * all cancel
			 */
			public void actionPerformed(ActionEvent e) {

				numberInsTxt.setText("");
				numberAddTxtArea.setText("");
				resultTxtArea.setText("");
				numberInsTxt.requestFocusInWindow();
				statistics.reset();
			}
		});
		allCancBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		allCancBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		allCancBtn.setBounds(12, 350, 100, 30);
		frame.getContentPane().add(allCancBtn);
		
		searchTxt = new JTextField();
		searchTxt.setToolTipText("Find the amount of a specified number");
		searchTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		searchTxt.setColumns(10);
		searchTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
						null, null));
		searchTxt.setBounds(12, 100, 100, 30);
		frame.getContentPane().add(searchTxt);
		
		searchBtn = new JButton("Search  num");
		searchBtn.setToolTipText("Find the amount of a specified number");
		searchBtn.addActionListener(new ActionListener() {
			/**
			 * search quantity number
			 */
			public void actionPerformed(ActionEvent e) {
				resultTxtArea.append("Number " + searchTxt.getText() + " present "  
						+ String.valueOf(statistics.numberSearch(Double.valueOf(searchTxt.getText())) + " twice" + "\n\n"));
			}
		});
		searchBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		searchBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
						null));
		searchBtn.setBounds(12, 150, 100, 30);
		frame.getContentPane().add(searchBtn);
		
		searchLbl = new JLabel("Search number");
		searchLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		searchLbl.setBounds(12, 82, 130, 15);
		frame.getContentPane().add(searchLbl);

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
		operationMenu.setMnemonic(KeyEvent.VK_P);
		menuBar.add(operationMenu);

		addMenuItem = new JMenuItem("Add");
		addMenuItem.addActionListener(new ActionListener() {
			/**
			 * enter number
			 */
			public void actionPerformed(ActionEvent e) {

				add();
			}
		});
		addMenuItem.setMnemonic(KeyEvent.VK_A);
		operationMenu.add(addMenuItem);

		allcancelMenuItem = new JMenuItem("AllCancel");
		allcancelMenuItem.addActionListener(new ActionListener() {
			/**
			 * all cancel
			 */
			public void actionPerformed(ActionEvent e) {

				numberInsTxt.setText("");
				numberAddTxtArea.setText("");
				resultTxtArea.setText("");
				numberInsTxt.requestFocusInWindow();
				statistics.reset();
			}
		});
		allcancelMenuItem.setMnemonic(KeyEvent.VK_L);
		operationMenu.add(allcancelMenuItem);

		calculateMenuItem = new JMenuItem("Calculate");
		calculateMenuItem.addActionListener(new ActionListener() {
			/**
			 * calculate
			 */
			public void actionPerformed(ActionEvent e) {

				resultTxtArea.append("Numbers of the values: "
						+ String.valueOf(statistics.numbersValues())
						+ "\n"
						+ "Sum the numbers: "
						+ String.valueOf(statistics.sum())
						+ "\n"
						+ "Average value: "
						+ String.valueOf(statistics.average() + "\n"
								+ "Maximum value: "
								+ String.valueOf(statistics.maximum()) + "\n"
								+ "Minimum value: "
								+ String.valueOf(statistics.minimum()) + "\n"
								+ "Difference values: "
								+ String.valueOf(statistics.difference())
								+ "\n" + "Duplicate values: "
								+ String.valueOf(statistics.valDou()) + " ["
								+ String.valueOf(statistics.numDou()) + "]"
								+ "\n" + "Standard deviation: "
								+ String.valueOf(statistics.strdDev()) + "\n"
								+ "Sum of the squares: "
								+ String.valueOf(statistics.sumSquares())
								+ "\n\n"));
			}
		});
		calculateMenuItem.setMnemonic(KeyEvent.VK_C);
		operationMenu.add(calculateMenuItem);

		newMenuItem = new JMenuItem("New");
		newMenuItem.addActionListener(new ActionListener() {
			/**
			 * reset
			 */
			public void actionPerformed(ActionEvent e) {

				numberInsTxt.setText("");
				numberInsTxt.requestFocusInWindow();
				statistics.reset();
				numberAddTxtArea.append("\n");
			}
		});
		newMenuItem.setMnemonic(KeyEvent.VK_N);
		operationMenu.add(newMenuItem);

		closeMenu = new JMenu("Close");
		closeMenu.setMnemonic(KeyEvent.VK_C);
		menuBar.add(closeMenu);

		closeMenuItem = new JMenuItem("Close statistics");
		closeMenuItem.setMnemonic(KeyEvent.VK_C);
		closeMenuItem.addActionListener(new ActionListener() {
			/**
			 * close statistic
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		closeMenu.add(closeMenuItem);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { numberInsTxt }));
	}
}
