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
 * MiniEditor.java
 * --------------------
 * Copyright (C) 2014 Ivan Guerreschi
 *
 * Original Author:  Ivan Guerreschi;
 * Contributor(s): 
 * 
 * Changes
 * -------
 * Date changes 31/07/2014
 * Add print file function 
 */

package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultEditorKit;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

/**
 * Class of a mini-editor with basic functions
 * 
 * @author Ivan Guerreschi
 * 
 */
public class MiniEditor {

	private int size = 14; // size font

	protected JFrame frame;

	private JMenuBar menuBar;

	private JMenu backgoundMenu;
	private JMenu closeMenu;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu fontMenu;

	private JMenuItem saveMenuItem;
	private JMenuItem closeMenuItem;
	private JMenuItem openMenuItem;
	private JMenuItem deleteMenuItem;
	private JMenuItem blackBackMenuItem;
	private JMenuItem whiteBackMenuItem;
	private JMenuItem greenBackMenuItem;
	private JMenuItem copyMenuItem;
	private JMenuItem pasteMenuItem;
	private JMenuItem cutMenuItem;
	private JMenuItem plainMenuItem;
	private JMenuItem boldMenuItem;
	private JMenuItem italicMenuItem;
	private JMenuItem printMenuItem;

	private JFileChooser chooser;

	private FileWriter fileWriter;

	private FileInputStream fileRead;

	private BufferedReader bufferReader;

	private JScrollPane scrollPane;

	private JTextArea textArea;

	private JLabel nameFileLbl;
	private JLabel nameLbl;
	private JLabel fontSizeLbl;

	private TextTransferHandler th;

	private JPanel panel;

	private JSlider slider;

	public int openFile() {
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File(System.getProperty("user.home")));

		int result = chooser.showOpenDialog(null);

		if (result == JFileChooser.CANCEL_OPTION)
			chooser.setVisible(false);
		return result;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiniEditor window = new MiniEditor();
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
	public MiniEditor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.GRAY);
		frame.setTitle("Mini Editor");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		th = new TextTransferHandler(new JTextArea());

		textArea = new JTextArea();
		textArea.setFont(new Font("Serif", Font.PLAIN, size));
		textArea.setTransferHandler(th);
		textArea.setDragEnabled(true);

		scrollPane.setViewportView(textArea);

		panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);

		fontSizeLbl = new JLabel("Font size");
		panel.add(fontSizeLbl);

		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			/**
			 * slider to change the font size
			 */
			public void stateChanged(ChangeEvent e) {

				size = slider.getValue();
				textArea.setFont(new Font("Serif", Font.PLAIN, size));
			}
		});

		slider.setMaximum(60);
		slider.setValue(14);
		panel.add(slider);

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);

		saveMenuItem = new JMenuItem("Save file");
		saveMenuItem.setMnemonic(KeyEvent.VK_S);
		fileMenu.add(saveMenuItem);
		saveMenuItem.addActionListener(new ActionListener() {

			/**
			 * save a file
			 */
			public void actionPerformed(ActionEvent e) {

				if (openFile() == JFileChooser.APPROVE_OPTION) {

					try {

						fileWriter = new FileWriter(chooser.getSelectedFile(),
								true);
						fileWriter.write(textArea.getText());
						fileWriter.close();

					} catch (IOException ioException) {

						JOptionPane.showMessageDialog(null, "Not save file",
								"ERROR", JOptionPane.ERROR_MESSAGE);
						System.exit(1);

					} finally {

						try {

							fileWriter.close();
							nameFileLbl.setText(chooser.getSelectedFile()
									.getName());

						} catch (IOException e1) {

							JOptionPane.showMessageDialog(null,
									"Not close file", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							System.exit(1);
						}
					}
				}
			}
		});

		openMenuItem = new JMenuItem("Open file");
		openMenuItem.setMnemonic(KeyEvent.VK_O);
		fileMenu.add(openMenuItem);
		openMenuItem.addActionListener(new ActionListener() {

			/**
			 * open a file
			 */
			public void actionPerformed(ActionEvent e) {

				if (openFile() == JFileChooser.APPROVE_OPTION) {

					try {

						fileRead = new FileInputStream(chooser
								.getSelectedFile());

						bufferReader = new BufferedReader(
								new InputStreamReader(fileRead));

						String read;

						StringBuffer text = new StringBuffer();

						while ((read = bufferReader.readLine()) != null) {

							text.append(read).append("\n");
						}

						textArea.setText(text.toString());
					} catch (IOException exception) {

						JOptionPane.showMessageDialog(null, "Not open file",
								"ERROR", JOptionPane.INFORMATION_MESSAGE);
						System.exit(1);

					} finally {

						try {

							fileRead.close();
							nameFileLbl.setText(" "
									+ chooser.getSelectedFile().getName());

						} catch (IOException e1) {

							JOptionPane.showMessageDialog(null,
									"Not close file", "ERROR",
									JOptionPane.ERROR_MESSAGE);
							System.exit(1);
						}
					}
				}
			}
		});

		deleteMenuItem = new JMenuItem("Delete file");
		deleteMenuItem.setMnemonic(KeyEvent.VK_D);
		fileMenu.add(deleteMenuItem);

		printMenuItem = new JMenuItem("Print");
		printMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/**
				 * print a file
				 */

				if (!java.awt.Desktop.isDesktopSupported()) {
					JOptionPane.showMessageDialog(null,
							"Desktop functionality not supported", "ERROR",
							JOptionPane.INFORMATION_MESSAGE);
					System.exit(1);
				}

				try {
					boolean complete = textArea.print();
					if (complete)
						JOptionPane.showMessageDialog(null, "Done printing",
								"Information", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Printing",
								"Information", JOptionPane.INFORMATION_MESSAGE);
				} catch (PrinterException e1) {
					JOptionPane.showMessageDialog(null, "Error printing",
							"Error", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		printMenuItem.setMnemonic(KeyEvent.VK_P);
		fileMenu.add(printMenuItem);

		fontMenu = new JMenu("Font");
		fontMenu.setMnemonic(KeyEvent.VK_O);
		menuBar.add(fontMenu);

		boldMenuItem = new JMenuItem("Bold");
		boldMenuItem.addActionListener(new ActionListener() {

			/**
			 * change font
			 */
			public void actionPerformed(ActionEvent e) {

				textArea.setFont(new Font("Serif", Font.BOLD, size));
			}
		});

		boldMenuItem.setMnemonic(KeyEvent.VK_B);
		fontMenu.add(boldMenuItem);

		italicMenuItem = new JMenuItem("Italic");
		italicMenuItem.addActionListener(new ActionListener() {

			/**
			 * change font
			 */
			public void actionPerformed(ActionEvent e) {

				textArea.setFont(new Font("Serif", Font.ITALIC, size));
			}
		});

		italicMenuItem.setMnemonic(KeyEvent.VK_I);
		fontMenu.add(italicMenuItem);

		plainMenuItem = new JMenuItem("Plain");
		plainMenuItem.addActionListener(new ActionListener() {

			/**
			 * change font
			 */
			public void actionPerformed(ActionEvent e) {

				textArea.setFont(new Font("Serif", Font.PLAIN, size));
			}
		});

		plainMenuItem.setMnemonic(KeyEvent.VK_P);
		fontMenu.add(plainMenuItem);

		backgoundMenu = new JMenu("Background");
		backgoundMenu.setMnemonic(KeyEvent.VK_B);
		menuBar.add(backgoundMenu);

		blackBackMenuItem = new JMenuItem("Black background");
		blackBackMenuItem.setMnemonic(KeyEvent.VK_B);
		blackBackMenuItem.addActionListener(new ActionListener() {

			/**
			 * change background
			 */
			public void actionPerformed(ActionEvent e) {

				textArea.setBackground(Color.BLACK);
				textArea.setForeground(Color.WHITE);
			}
		});

		backgoundMenu.add(blackBackMenuItem);

		whiteBackMenuItem = new JMenuItem("White background");
		whiteBackMenuItem.setMnemonic(KeyEvent.VK_W);
		whiteBackMenuItem.addActionListener(new ActionListener() {

			/**
			 * change background
			 */
			public void actionPerformed(ActionEvent e) {

				textArea.setBackground(Color.WHITE);
				textArea.setForeground(Color.BLACK);
			}
		});

		backgoundMenu.add(whiteBackMenuItem);

		greenBackMenuItem = new JMenuItem("Green background");
		greenBackMenuItem.setMnemonic(KeyEvent.VK_G);
		greenBackMenuItem.addActionListener(new ActionListener() {

			/**
			 * change background
			 */
			public void actionPerformed(ActionEvent e) {

				textArea.setBackground(Color.GREEN);
				textArea.setForeground(Color.BLACK);
			}
		});

		backgoundMenu.add(greenBackMenuItem);

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

		closeMenu = new JMenu("Close ");
		closeMenu.setMnemonic(KeyEvent.VK_C);
		menuBar.add(closeMenu);

		closeMenuItem = new JMenuItem("Close mini editor");
		closeMenuItem.setMnemonic(KeyEvent.VK_C);
		closeMenuItem.addActionListener(new ActionListener() {

			/**
			 * close mini-editor
			 */
			public void actionPerformed(ActionEvent e) {

				if (textArea.getText().equals(""))
					frame.dispose();

				else {
					String conferma = JOptionPane
							.showInputDialog("Close not save file? [y/n]");

					if (conferma.equalsIgnoreCase("y"))
						frame.dispose();

					else
						saveMenuItem.doClick();
				}
			}
		});

		closeMenu.add(closeMenuItem);

		nameLbl = new JLabel("Name file:");
		menuBar.add(nameLbl);

		nameFileLbl = new JLabel("");
		nameFileLbl.setFont(new Font("Dialog", Font.BOLD, 12));
		menuBar.add(nameFileLbl);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { textArea }));

		deleteMenuItem.addActionListener(new ActionListener() {

			/**
			 * method for delete file
			 */
			public void actionPerformed(ActionEvent e) {

				try {

					if (openFile() == JFileChooser.APPROVE_OPTION) {

						File fileDelete = chooser.getSelectedFile();

						String conferma = JOptionPane
								.showInputDialog("Really delete the file: "
										+ fileDelete.getName() + " [Y/N]");

						if (conferma.equalsIgnoreCase("Y")) {

							if (fileDelete.delete()) {

								JOptionPane.showMessageDialog(
										null,
										fileDelete.getName() + " is eliminated",
										"Confirm file deletion",
										JOptionPane.PLAIN_MESSAGE);
							} else {

								JOptionPane.showMessageDialog(null,
										"I can not access the file", "ERROR",
										JOptionPane.ERROR_MESSAGE);
							}

						} else {

							JOptionPane.showMessageDialog(null,
									fileDelete.getName() + " not deleted",
									"Confirm File Deletion",
									JOptionPane.PLAIN_MESSAGE);
						}

					}

				} catch (Exception exception) {

					JOptionPane.showMessageDialog(null,
							"I can not access the file", "ERROR",
							JOptionPane.ERROR_MESSAGE);
					System.exit(1);
				}
			}

		});
	}
}
