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
 * TrigonometryTri.java
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
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Formatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

/**
 * Class for elementary trigonometry on triangles
 * 
 * @author Ivan Guerreschi
 * 
 */
public class TrigonometryTri {

	private JTextField bTxt;
	private JTextField aTxt;
	private JTextField cTxt;
	private JTextField ATxt;
	private JTextField BTxt;

	private JButton cancelBtn;
	private JButton closeBtn;
	private JButton calcolaBtn;

	protected JFrame frame;

	private JMenuBar menuBar;

	private JMenu operationMenu;
	private JMenu closeMenu;

	private JMenuItem calculateMenuItem;
	private JMenuItem cancelMenuItem;
	private JMenuItem closeMenuItem;

	private JLabel imageNameLbl;
	private JLabel aLbl;
	private JLabel bLbl;
	private JLabel cLbl;
	private JLabel _ALbl;
	private JLabel _Blbl;

	/**
	 * method for calculate
	 */
	public void calculate() {

		String a = bTxt.getText();
		String b = aTxt.getText();
		String c = cTxt.getText();
		String _A = ATxt.getText();
		String _B = BTxt.getText();

		double aN = 0.0;
		double bN = 0.0;
		double cN = 0.0;
		double _AN = 0.0;
		double _BN = 0.0;

		// controls the input values

		if (a.trim().length() != 0) {

			try {
				aN = Double.parseDouble(a);
			} catch (NumberFormatException ea) {

				JOptionPane.showMessageDialog(frame, "Only whole numbers");
				bTxt.setText("");
				bTxt.requestFocusInWindow();
			}

		}

		if (b.trim().length() != 0) {

			try {

				bN = Double.parseDouble(b);
			} catch (NumberFormatException eb) {

				JOptionPane.showMessageDialog(frame, "Only whole numbers");
				aTxt.setText("");
				aTxt.requestFocusInWindow();
			}

		}

		if (c.trim().length() != 0) {

			try {
				cN = Double.parseDouble(c);
			} catch (NumberFormatException ec) {

				JOptionPane.showMessageDialog(frame, "Only whole numbers");
				cTxt.setText("");
				cTxt.requestFocusInWindow();
			}

		}

		if (_A.trim().length() != 0) {

			try {
				_AN = Double.parseDouble(_A);
			} catch (NumberFormatException eA) {

				JOptionPane.showMessageDialog(frame, "Only whole numbers");
				ATxt.setText("");
				ATxt.requestFocusInWindow();
			}

		}

		if (_B.trim().length() != 0) {

			try {
				_BN = Double.parseDouble(_B);
			} catch (NumberFormatException eB) {

				JOptionPane.showMessageDialog(frame, "Only whole numbers");
				BTxt.setText("");
				BTxt.requestFocusInWindow();
			}

		}

		// i know c e B

		if (((cN > 0) && (_BN > 0)) && (((aN == 0) && (bN == 0)) && (_AN == 0))) {
			double ris_a = Math.sin(Math.toRadians(_BN)) * cN;
			Formatter formatter1 = new Formatter();
			formatter1.format("%.5f", ris_a);
			bTxt.setText(formatter1.toString());
			formatter1.close();

			double ris_b = Math.cos(Math.toRadians(_BN)) * cN;
			Formatter formatter2 = new Formatter();
			formatter2.format("%.5f", ris_b);
			aTxt.setText(formatter2.toString());
			formatter2.close();

			double risA = 90 - _BN;
			ATxt.setText(String.valueOf(risA));
		}

		// i know c e A

		if (((cN > 0) && (_AN > 0)) && (((aN == 0) && (bN == 0)) && (_BN == 0))) {
			double ris_a = Math.cos(Math.toRadians(_AN)) * cN;
			Formatter formatter1 = new Formatter();
			formatter1.format("%.5f", ris_a);
			bTxt.setText(formatter1.toString());
			formatter1.close();

			double ris_b = Math.sin(Math.toRadians(_AN)) * cN;
			Formatter formatter2 = new Formatter();
			formatter2.format("%.5f", ris_b);
			aTxt.setText(formatter2.toString());
			formatter2.close();

			double risB = 90 - _AN;
			BTxt.setText(String.valueOf(risB));
		}

		// i know b e B

		if (((bN > 0) && (_BN > 0)) && (((aN == 0) && (cN == 0)) && (_AN == 0))) {
			double ris_a = Math.tan(Math.toRadians(_BN)) * bN;
			Formatter formatter1 = new Formatter();
			formatter1.format("%.5f", ris_a);
			bTxt.setText(formatter1.toString());
			formatter1.close();

			double ris_c = bN / Math.cos(Math.toRadians(_BN));
			Formatter formatter2 = new Formatter();
			formatter2.format("%.5f", ris_c);
			cTxt.setText(formatter2.toString());
			formatter2.close();

			double risA = 90 - _BN;
			ATxt.setText(String.valueOf(risA));
		}

		// i know b e A

		if (((bN > 0) && (_AN > 0)) && (((aN == 0) && (cN == 0)) && (_BN == 0))) {
			double ris_a = (1 / Math.tan(Math.toRadians(_AN))) * bN;
			Formatter formatter1 = new Formatter();
			formatter1.format("%.5f", ris_a);
			bTxt.setText(formatter1.toString());
			formatter1.close();

			double ris_c = bN / Math.sin(Math.toRadians(_AN));
			Formatter formatter2 = new Formatter();
			formatter2.format("%.5f", ris_c);
			cTxt.setText(formatter2.toString());
			formatter2.close();

			double risB = 90 - _AN;
			BTxt.setText(String.valueOf(risB));
		}

		// i know a e A

		if (((aN > 0) && (_AN > 0)) && (((bN == 0) && (cN == 0)) && (_BN == 0))) {
			double ris_b = Math.tan(Math.toRadians(_AN)) * aN;
			Formatter formatter1 = new Formatter();
			formatter1.format("%.5f", ris_b);
			aTxt.setText(formatter1.toString());
			formatter1.close();

			double ris_c = aN / Math.cos(Math.toRadians(_AN));
			Formatter formatter2 = new Formatter();
			formatter2.format("%.5f", ris_c);
			cTxt.setText(formatter2.toString());
			formatter2.close();

			double risB = 90 - _AN;
			BTxt.setText(String.valueOf(risB));
		}

		// i know a e B

		if (((aN > 0) && (_BN > 0)) && (((bN == 0) && (cN == 0)) && (_AN == 0))) {
			double ris_b = (1 / Math.tan(Math.toRadians(_BN))) * aN;
			Formatter formatter1 = new Formatter();
			formatter1.format("%.5f", ris_b);
			aTxt.setText(formatter1.toString());
			formatter1.close();

			double ris_c = aN / Math.sin(Math.toRadians(_BN));
			Formatter formatter2 = new Formatter();
			formatter2.format("%.5f", ris_c);
			cTxt.setText(formatter2.toString());
			formatter2.close();

			double risA = 90 - _BN;
			ATxt.setText(String.valueOf(risA));
		}

		// i know a e c

		if (((aN > 0) && (cN > 0)) && (((bN == 0) && (_AN == 0)) && (_BN == 0))) {
			double K = aN / cN;
			double risA = Math.toDegrees(Math.acos(K));
			double risB = Math.toDegrees(Math.asin(K));
			double ris_b = Math.sin(Math.toRadians(risB)) * cN;
			Formatter formatter1 = new Formatter();
			formatter1.format("%.5f", ris_b);
			aTxt.setText(formatter1.toString());
			formatter1.close();

			Formatter formatter2 = new Formatter();
			formatter2.format("%.5f", risB);
			BTxt.setText(formatter2.toString());
			formatter2.close();
			Formatter formatter3 = new Formatter();
			formatter3.format("%.5f", risA);
			ATxt.setText(formatter3.toString());
			formatter3.close();
		}

		// i know a e b

		if (((aN > 0) && (bN > 0)) && (((cN == 0) && (_AN == 0)) && (_BN == 0))) {
			double K = aN / bN;
			double K2 = bN / aN;
			double risB = Math.toDegrees(Math.atan(K));
			double risA = Math.toDegrees(Math.atan(K2));
			double ris_c = aN / Math.sin(Math.toRadians(risB));
			Formatter formatter1 = new Formatter();
			formatter1.format("%.5f", ris_c);
			cTxt.setText(formatter1.toString());
			formatter1.close();

			Formatter formatter2 = new Formatter();
			formatter2.format("%.5f", risB);
			BTxt.setText(formatter2.toString());
			formatter2.close();
			Formatter formatter3 = new Formatter();
			formatter3.format("%.5f", risA);
			ATxt.setText(formatter3.toString());
			formatter3.close();
		}

		// i know b e c

		if (((bN > 0) && (cN > 0)) && (((aN == 0) && (_AN == 0)) && (_BN == 0))) {
			double K = bN / cN;
			double risB = Math.toDegrees(Math.acos(K));
			double risA = Math.toDegrees(Math.asin(K));
			double ris_a = Math.sin(Math.toRadians(risB)) * cN;
			Formatter formatter1 = new Formatter();
			formatter1.format("%.5f", ris_a);
			bTxt.setText(formatter1.toString());
			formatter1.close();

			Formatter formatter2 = new Formatter();
			formatter2.format("%.5f", risB);
			BTxt.setText(formatter2.toString());
			formatter2.close();
			Formatter formatter3 = new Formatter();
			formatter3.format("%.5f", risA);
			ATxt.setText(formatter3.toString());
			formatter3.close();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrigonometryTri window = new TrigonometryTri();
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
	public TrigonometryTri() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 14));
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBackground(Color.GRAY);
		frame.setTitle("Resolution triangles");
		frame.setBounds(100, 100, 370, 345);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		imageNameLbl = new JLabel("Triangle rectangle");
		imageNameLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		imageNameLbl.setBounds(10, 10, 348, 113);
		imageNameLbl.setBorder(new LineBorder(new Color(0, 0, 0)));
		imageNameLbl.setIcon(new ImageIcon(TrigonometryTri.class
				.getResource("/calculator/img/triangle.png")));
		frame.getContentPane().add(imageNameLbl);

		aLbl = new JLabel("b");
		aLbl.setBounds(10, 141, 9, 17);
		aLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(aLbl);

		bTxt = new JTextField();
		bTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		bTxt.setBounds(36, 139, 114, 30);
		bTxt.setToolTipText("Cathetus");
		bTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		frame.getContentPane().add(bTxt);
		bTxt.setColumns(10);

		bLbl = new JLabel("a");
		bLbl.setBounds(10, 179, 10, 17);
		bLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(bLbl);

		aTxt = new JTextField();
		aTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		aTxt.setBounds(36, 177, 114, 30);
		aTxt.setToolTipText("Cathetus");
		aTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		frame.getContentPane().add(aTxt);
		aTxt.setColumns(10);

		cLbl = new JLabel("c");
		cLbl.setBounds(10, 216, 9, 17);
		cLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(cLbl);

		cTxt = new JTextField();
		cTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		cTxt.setBounds(36, 214, 114, 30);
		cTxt.setToolTipText("Cathetus");
		cTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		frame.getContentPane().add(cTxt);
		cTxt.setColumns(10);

		_ALbl = new JLabel("A");
		_ALbl.setBounds(172, 141, 11, 17);
		_ALbl.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(_ALbl);

		ATxt = new JTextField();
		ATxt.setBounds(198, 139, 114, 30);
		ATxt.setToolTipText("Angle");
		ATxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		frame.getContentPane().add(ATxt);
		ATxt.setColumns(10);

		_Blbl = new JLabel("B");
		_Blbl.setBounds(173, 179, 10, 17);
		_Blbl.setFont(new Font("Dialog", Font.BOLD, 14));
		frame.getContentPane().add(_Blbl);

		BTxt = new JTextField();
		BTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		BTxt.setBounds(198, 179, 114, 30);
		BTxt.setToolTipText("Angle");
		BTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		frame.getContentPane().add(BTxt);
		BTxt.setColumns(10);

		calcolaBtn = new JButton("Calculate");
		calcolaBtn.setBounds(36, 253, 114, 30);
		calcolaBtn.setToolTipText("Calculate the values ​​entered");
		calcolaBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		calcolaBtn.addActionListener(new ActionListener() {
			/**
			 * calculate
			 */
			public void actionPerformed(ActionEvent e) {

				calculate();

			}
		});
		frame.getContentPane().add(calcolaBtn);

		cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(198, 253, 114, 30);
		cancelBtn.setToolTipText("Clear Values");
		cancelBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		cancelBtn.addActionListener(new ActionListener() {
			/**
			 * all cancel
			 */
			public void actionPerformed(ActionEvent e) {

				bTxt.setText("");
				aTxt.setText("");
				cTxt.setText("");
				ATxt.setText("");
				BTxt.setText("");
				bTxt.requestFocusInWindow();
			}
		});
		frame.getContentPane().add(cancelBtn);

		closeBtn = new JButton("Close");
		closeBtn.setBounds(198, 216, 114, 30);
		closeBtn.setToolTipText("Close the program");
		closeBtn.addActionListener(new ActionListener() {
			/**
			 * close TrigonometryTri
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
		closeBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
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

		cancelMenuItem = new JMenuItem("Cancel");
		cancelMenuItem.setMnemonic(KeyEvent.VK_C);
		operationMenu.add(cancelMenuItem);
		cancelMenuItem.addActionListener(new ActionListener() {

			/**
			 * cancel
			 */
			public void actionPerformed(ActionEvent e) {

				bTxt.setText("");
				aTxt.setText("");
				cTxt.setText("");
				ATxt.setText("");
				BTxt.setText("");
				bTxt.requestFocusInWindow();
			}
		});

		closeMenu = new JMenu("Close");
		closeMenu.setMnemonic(KeyEvent.VK_C);
		menuBar.add(closeMenu);

		closeMenuItem = new JMenuItem("Close resolution triangles");
		closeMenuItem.setMnemonic(KeyEvent.VK_C);
		closeMenu.add(closeMenuItem);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { bTxt, aTxt, cTxt, ATxt, BTxt }));
		closeMenuItem.addActionListener(new ActionListener() {

			/**
			 * close TrigonomeryTri
			 */
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});
	}
}
