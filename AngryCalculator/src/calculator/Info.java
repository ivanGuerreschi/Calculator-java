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
 * Info.java
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

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.ImageIcon;

/**
 * Class that displays license information
 * 
 * @author ivan
 * 
 */

public class Info {

	protected JFrame frame;

	private JButton closeBtn;
	private JButton linkBtn;

	private JTabbedPane tabbedPane;
	private JEditorPane licenseEditorPane;

	private JEditorPane infoEditorPane;

	private JScrollPane infoScrlPan;
	private JScrollPane licenseScrlPan;

	private JLabel nameLbl;

	public void messageBox() {
		JOptionPane.showMessageDialog(null, "Failed to show URI");
	}

	public void messageBox2() {
		JOptionPane.showMessageDialog(null,
				"Illegal character in query at index");
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Info window = new Info();
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
	public Info() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("About");
		frame.setBounds(100, 100, 477, 377);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		closeBtn = new JButton("Close");
		closeBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		closeBtn.addActionListener(new ActionListener() {
			/**
			 * close info
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});

		closeBtn.setBounds(346, 302, 117, 35);
		frame.getContentPane().add(closeBtn);

		nameLbl = new JLabel("Angry calculator");
		nameLbl.setForeground(Color.GRAY);
		nameLbl.setBounds(22, 312, 129, 15);
		frame.getContentPane().add(nameLbl);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 12, 451, 283);
		frame.getContentPane().add(tabbedPane);

		infoScrlPan = new JScrollPane();
		tabbedPane.addTab("Info", null, infoScrlPan, null);

		infoEditorPane = new JEditorPane();
		infoEditorPane.setEditable(false);
		infoScrlPan.setViewportView(infoEditorPane);

		// retrieves html file info
		try {
			infoEditorPane.setPage(getClass().getResource("html/info.html"));

		} catch (IOException e1) {
			infoEditorPane.setText("Not open file");
		}

		licenseScrlPan = new JScrollPane();
		tabbedPane.addTab("License", null, licenseScrlPan, null);

		licenseEditorPane = new JEditorPane();
		licenseEditorPane.setEditable(false);
		licenseScrlPan.setViewportView(licenseEditorPane);

		// retrieves html file license
		try {
			licenseEditorPane.setPage(getClass().getResource(
					"html/license.html"));

			linkBtn = new JButton("");
			linkBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
					null, null));
			linkBtn.setIcon(new ImageIcon(Info.class
					.getResource("/calculator/img/gplv3-88x31.png")));
			linkBtn.addActionListener(new ActionListener() {
				/**
				 * open the link GNU license
				 */
				public void actionPerformed(ActionEvent e) {

					final String strTarget = "http://www.gnu.org/licenses/gpl-3.0.txt";

					Desktop desktop = Desktop.getDesktop();

					try {
						if (desktop.isSupported(Desktop.Action.BROWSE)) { // control
																			// support

							URI uri = new URI(strTarget);

							desktop.browse(uri); // open page

						}

					}

					catch (URISyntaxException syntaxException) {

						messageBox2();

					}

					catch (IOException ioException) {

						messageBox();

					}
				}
			});
			linkBtn.setBounds(224, 302, 117, 35);
			frame.getContentPane().add(linkBtn);

		} catch (IOException e1) {
			licenseEditorPane.setText("Not open file");
		}

	}

}
