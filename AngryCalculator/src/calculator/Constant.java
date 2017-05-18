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
 * Constant.java
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
 * Class to create and display constants
 * 
 * @author Ivan Guerreschi
 * 
 */
public class Constant {

	protected JFrame frame;

	private JTextField numeroInsTxt;
	private JTextField costanteInsTxt;

	private JLabel numberLbl;
	private JLabel nameLbl;

	private JButton enterBtn;
	private JButton cancelBtn;
	private JButton openBtn;
	private JButton cancelFileBtn;
	private JButton closeBtn;

	private JScrollPane resultScrlPan;

	private JTextArea resultTextArea;

	private JMenuBar menuBar;

	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu closeMenu;

	private JMenuItem openMenuItem;
	private JMenuItem cancelFileMenuItem;
	private JMenuItem cancelMenuItem;
	private JMenuItem closeMenuItem;

	private AbstractButton copyMenuItem;
	private AbstractButton cutMenuItem;
	private AbstractButton pasteMenuItem;
	private AbstractButton operationMenu;
	private AbstractButton enterMenuItem;

	public Scanner input;

	private Formatter output;

	private TextTransferHandler th;

	/**
	 * adds a new directory if it does not exist
	 */
	public static void newDirectory() {

		try {
			String folderName = System.getProperty("user.home") + "/Constant";

			File folder = new File(folderName);

			if (!folder.isDirectory())
				folder.mkdir();

		} catch (SecurityException securityException) {

			JOptionPane.showMessageDialog(null, "Directory access denied",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}

	/**
	 * provides a simple mechanism for the user to choose a file
	 * 
	 * @return the file name
	 */
	public String getFile() {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		int result = fileChooser.showOpenDialog(null);

		if (result == JFileChooser.CANCEL_OPTION)
			fileChooser.setVisible(false);

		File fileName = fileChooser.getSelectedFile();

		// displays an error if it is not valid
		if ((fileName == null) || (fileName.getName().equals(""))) {
			JOptionPane.showMessageDialog(null, "Invalid file name", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}

		return fileName.toString();

	}

	/**
	 * delete file
	 */
	public void delete() {
		try {

			File file = new File(getFile());

			String conferma = JOptionPane
					.showInputDialog("Really delete the file: "
							+ file.getName() + " [Y/N]");

			if (conferma.equalsIgnoreCase("Y")) {

				if (file.delete()) {

					JOptionPane.showMessageDialog(null, file.getName()
							+ " is eliminated", "Confirm file deletion",
							JOptionPane.PLAIN_MESSAGE);
				} else {

					JOptionPane.showMessageDialog(null,
							"I can not access the file", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {

				JOptionPane.showMessageDialog(null, file.getName()
						+ " not deleted", "Confirm File Deletion",
						JOptionPane.PLAIN_MESSAGE);
			}

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "I can not access the file",
					"ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(1);

		}
	}

	/**
	 * creates a new directory and a new file
	 */
	public void openFile() {

		try {

			newDirectory();
			output = new Formatter(new FileOutputStream(
					System.getProperty("user.home") + "/Constant/fileK.txt",
					true));

		} catch (FileNotFoundException fileNotFoundException) {

			try {

				output = new Formatter(new FileOutputStream(
						System.getProperty("user.home") + "/fileK.txt", true));

			} catch (FileNotFoundException filesNotFoundException) {

				JOptionPane.showMessageDialog(null, "Error creating the file",
						"ERROR", JOptionPane.ERROR_MESSAGE);
				System.exit(1);

			} catch (SecurityException securityException) {

				JOptionPane.showMessageDialog(null,
						"I can not access the file", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
		}
	}

	/**
	 * added to the file input
	 */
	public void addRecords() {

		FileRecord record = new FileRecord();

		try {

			record.setConstant(numeroInsTxt.getText());
			record.setNameConstant(costanteInsTxt.getText());
			if (!record.getConstant().equals("")) {

				output.format("%s %s\n", record.getNameConstant(),
						record.getConstant());
			}
		} catch (FormatterClosedException formatterCloseException) {

			JOptionPane.showMessageDialog(null, "Error writing to file",
					"ERROR", JOptionPane.ERROR_MESSAGE);

		} catch (NoSuchElementException elementException) {

			JOptionPane.showMessageDialog(null,
					"Invalid input. Enter the data again please", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			numeroInsTxt.setText("");
		}

	}

	/**
	 * close the file
	 */
	public void closeFile() {
		if (output != null)
			output.close();
	}

	/**
	 * open file
	 */
	public void openFileRead() {

		// reads the contents of the file
		try {
			input = new Scanner(new FileInputStream(
					System.getProperty("user.home") + "/Constant/fileK.txt"));

		} catch (FileNotFoundException fileNotFoundException) {

			try {

				input = new Scanner(new FileInputStream(
						System.getProperty("user.home") + "/fileK.txt"));

			} catch (FileNotFoundException _fileNotFoundException) {

				JOptionPane.showMessageDialog(null,
						"Error opening file, the file exist?", "ERROR",
						JOptionPane.ERROR_MESSAGE);

			} catch (Exception e) {

				System.exit(1);
			}

		}
	}

	/**
	 * read file
	 */
	public void readRecords() {

		FileRecord record = new FileRecord();

		try {

			while (input.hasNext()) {

				record.setNameConstant(input.next());
				record.setConstant(input.next());

				resultTextArea.append(record.getNameConstant() + " "
						+ record.getConstant() + "\n");

			}
		} catch (IllegalStateException stateException) {

			JOptionPane.showMessageDialog(null, "Error reading file", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}

	/**
	 * close the file
	 */
	public void closeFileRead() {
		if (input != null)
			input.close();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Constant window = new Constant();
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
	public Constant() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBackground(Color.GRAY);
		frame.setTitle("Constant");
		frame.setBounds(100, 100, 371, 491);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		numberLbl = new JLabel("Enter Number");
		numberLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		numberLbl.setBounds(15, 10, 119, 30);
		frame.getContentPane().add(numberLbl);

		numeroInsTxt = new JTextField();
		numeroInsTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		numeroInsTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		numeroInsTxt.setBounds(15, 40, 119, 30);
		frame.getContentPane().add(numeroInsTxt);
		numeroInsTxt.setColumns(10);

		nameLbl = new JLabel("Enter Name");
		nameLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		nameLbl.setBounds(15, 90, 119, 30);
		frame.getContentPane().add(nameLbl);

		costanteInsTxt = new JTextField();
		costanteInsTxt.addKeyListener(new KeyAdapter() {
			@Override
			/**
			 * enter
			 */
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					openFile();
				addRecords();
				closeFile();
			}
		});
		costanteInsTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		costanteInsTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		costanteInsTxt.setBounds(15, 120, 119, 30);
		frame.getContentPane().add(costanteInsTxt);
		costanteInsTxt.setColumns(10);

		enterBtn = new JButton("Enter");
		enterBtn.addActionListener(new ActionListener() {
			/**
			 * input
			 */
			public void actionPerformed(ActionEvent e) {

				openFile();
				addRecords();
				closeFile();

			}
		});
		enterBtn.setBounds(15, 180, 119, 30);
		frame.getContentPane().add(enterBtn);

		cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			/**
			 * cancel input
			 */
			public void actionPerformed(ActionEvent e) {

				costanteInsTxt.setText("");
				numeroInsTxt.setText("");
				numeroInsTxt.requestFocusInWindow();
			}
		});
		cancelBtn.setBounds(15, 230, 119, 30);
		frame.getContentPane().add(cancelBtn);

		openBtn = new JButton("Open");
		openBtn.addActionListener(new ActionListener() {
			/**
			 * open file
			 */
			public void actionPerformed(ActionEvent e) {

				openFileRead();
				readRecords();
				closeFileRead();
			}
		});
		openBtn.setBounds(15, 280, 119, 30);
		frame.getContentPane().add(openBtn);

		cancelFileBtn = new JButton("Cancel File");
		cancelFileBtn.addActionListener(new ActionListener() {
			/**
			 * cancel file
			 */
			public void actionPerformed(ActionEvent e) {

				delete();
			}
		});
		cancelFileBtn.setBounds(15, 330, 119, 30);
		frame.getContentPane().add(cancelFileBtn);

		closeBtn = new JButton("Close");
		closeBtn.addActionListener(new ActionListener() {
			/**
			 * close the constant
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		closeBtn.setBounds(15, 380, 119, 30);
		frame.getContentPane().add(closeBtn);

		resultScrlPan = new JScrollPane();
		resultScrlPan.setBounds(150, 23, 205, 400);
		frame.getContentPane().add(resultScrlPan);

		th = new TextTransferHandler(new JTextArea());

		resultTextArea = new JTextArea();
		resultTextArea.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		resultTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
		resultTextArea.setDragEnabled(true);
		resultTextArea.setForeground(Color.BLUE);
		resultTextArea.setToolTipText("Result of multiplication");
		resultTextArea.setTransferHandler(th);
		resultScrlPan.setViewportView(resultTextArea);
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);

		cancelFileMenuItem = new JMenuItem("Cancel File");
		cancelFileMenuItem.setMnemonic(KeyEvent.VK_C);
		fileMenu.add(cancelFileMenuItem);
		cancelFileMenuItem.addActionListener(new ActionListener() {

			/**
			 * cancel file
			 */
			public void actionPerformed(ActionEvent e) {

				delete();
			}
		});

		openMenuItem = new JMenuItem("Open");
		openMenuItem.setMnemonic(KeyEvent.VK_O);
		fileMenu.add(openMenuItem);
		openMenuItem.addActionListener(new ActionListener() {

			/**
			 * open file
			 */
			public void actionPerformed(ActionEvent e) {

				openFileRead();
				readRecords();
				closeFileRead();
			}
		});

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

		cancelMenuItem = new JMenuItem("Cancel");
		cancelMenuItem.setMnemonic(KeyEvent.VK_N);
		operationMenu.add(cancelMenuItem);
		cancelMenuItem.addActionListener(new ActionListener() {

			/**
			 * cancel result
			 */
			public void actionPerformed(ActionEvent e) {

				costanteInsTxt.setText("");
				numeroInsTxt.setText("");
				numeroInsTxt.requestFocusInWindow();

			}
		});

		enterMenuItem = new JMenuItem("Enter");
		enterMenuItem.setMnemonic(KeyEvent.VK_E);
		operationMenu.add(enterMenuItem);
		enterMenuItem.addActionListener(new ActionListener() {

			/**
			 * enter
			 */
			public void actionPerformed(ActionEvent e) {

				openFile();
				addRecords();
				closeFile();

			}
		});

		closeMenu = new JMenu("Close");
		closeMenu.setMnemonic(KeyEvent.VK_C);
		menuBar.add(closeMenu);

		closeMenuItem = new JMenuItem("Close constant");
		closeMenuItem.setMnemonic(KeyEvent.VK_C);
		closeMenu.add(closeMenuItem);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { numeroInsTxt, costanteInsTxt }));
		closeMenuItem.addActionListener(new ActionListener() {

			/**
			 * close constant
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();

			}
		});

	}
}