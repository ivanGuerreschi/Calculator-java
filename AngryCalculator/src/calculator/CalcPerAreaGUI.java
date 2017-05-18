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
 * CalcPerAreaGUI.java
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

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import java.awt.Font;
import java.awt.Color;
import java.util.Formatter;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

/**
 * Calculate perimeter and area figures geometric 
 * 
 * @author Ivan Guerreschi
 *
 */
public class CalcPerAreaGUI {

	private CalcPerArea calcPerArea = new CalcPerArea();
	
	private double a = 0.0;
	private double b = 0.0;
	private double c = 0.0;
	private double d = 0.0;
	private double e = 0.0;

	private figures select = null;

	protected JFrame frame;

	private JTextField aTxt;
	private JTextField bTxt;
	private JTextField perTxt;
	private JTextField areaTxt;
	private JTextField dTxt;
	private JTextField cTxt;
	private JTextField eTxt;

	private JLabel imgLbl;
	private JLabel cLbl;
	private JLabel dLbl;
	private JLabel aLbl;
	private JLabel bLbl;
	private JLabel perimetroAreaLbl;
	private JLabel PLbl;
	private JLabel ALbl;
	private JLabel eLbl;

	private JRadioButton squareRdbtn;
	private JRadioButton rectangleRdbtn;
	private JRadioButton triangleRdbtn;
	private JRadioButton parallRdbtn;
	private JRadioButton rhombusRdbtn;
	private JRadioButton trapezoidRdbtn;
	private JRadioButton circleRdbtn;

	private JButton cancelBtn;
	private JButton closeBtn;
	private JButton pBtn;
	
	/**
	 * enumeration for selected figures
	 */
	private enum figures {
		square, retta, tria, parall, rhomb, trapz, circle
	}

	/**
	 * method stamp error
	 */
	public void error() {
		JOptionPane.showMessageDialog(null,
				"Only whole numbers eg 14 or with point es: 12.4");
	}

	/**
	 * input number a
	 */
	public void a() {
		try {
			a = Double.parseDouble(aTxt.getText());

		} catch (NumberFormatException numberFormatException) {
			error();
			aTxt.setText("");
			aTxt.requestFocusInWindow();
		}
	}

	/**
	 * input number b
	 */
	public void b() {
		try {
			b = Double.parseDouble(bTxt.getText());

		} catch (NumberFormatException numberFormatException) {
			error();
			bTxt.setText("");
			bTxt.requestFocusInWindow();
		}
	}

	/**
	 * input number c
	 */
	public void c() {
		try {
			c = Double.parseDouble(cTxt.getText());

		} catch (NumberFormatException numberFormatException) {
			error();
			cTxt.setText("");
			cTxt.requestFocusInWindow();
		}
	}

	/**
	 * input number d
	 */
	public void d() {
		try {
			d = Double.parseDouble(dTxt.getText());

		} catch (NumberFormatException numberFormatException) {
			error();
			dTxt.setText("");
			dTxt.requestFocusInWindow();
		}
	}

	/**
	 * input number e
	 */
	public void e() {
		try {
			e = Double.parseDouble(eTxt.getText());

		} catch (NumberFormatException numberFormatException) {
			error();
			eTxt.setText("");
			eTxt.requestFocusInWindow();
		}
	}

	/**
	 * insert numbers for input
	 * @param f figures
	 */
	public void InputNumbers(figures f) {

		switch (f) {
		case square:
			a();
			break;

		case retta:
			a();
			b();
			break;

		case tria:
			a();
			b();
			c();
			d();
			break;

		case parall:
			a();
			b();
			c();
			break;

		case rhomb:
			a();
			b();
			c();
			break;

		case trapz:
			a();
			b();
			c();
			d();
			e();
			break;

		case circle:
			a();
			break;
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcPerAreaGUI window = new CalcPerAreaGUI();
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
	public CalcPerAreaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setTitle("Perimeter Area Calc");
		frame.setBounds(100, 100, 341, 571);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		aLbl = new JLabel("a");
		aLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		aLbl.setBounds(15, 15, 100, 15);
		frame.getContentPane().add(aLbl);

		aTxt = new JTextField();
		aTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		aTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		aTxt.setEditable(false);
		aTxt.setBounds(15, 35, 100, 30);
		frame.getContentPane().add(aTxt);

		bLbl = new JLabel("b");
		bLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		bLbl.setBounds(15, 75, 100, 15);
		frame.getContentPane().add(bLbl);

		bTxt = new JTextField();
		bTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		bTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		bTxt.setEditable(false);
		bTxt.setBounds(15, 95, 100, 30);
		frame.getContentPane().add(bTxt);
		bTxt.setColumns(10);

		perTxt = new JTextField();
		perTxt.setToolTipText("Result perimeter");
		perTxt.setForeground(Color.BLUE);
		perTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		perTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		perTxt.setBounds(203, 187, 114, 30);
		frame.getContentPane().add(perTxt);
		perTxt.setColumns(10);

		areaTxt = new JTextField();
		areaTxt.setToolTipText("Result area");
		areaTxt.setForeground(Color.RED);
		areaTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		areaTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		areaTxt.setBounds(203, 229, 114, 30);
		frame.getContentPane().add(areaTxt);
		areaTxt.setColumns(10);

		squareRdbtn = new JRadioButton("Squre");
		squareRdbtn.setFont(new Font("Dialog", Font.BOLD, 14));
		squareRdbtn.addActionListener(new ActionListener() {
			/**
			 * square
			 */
			public void actionPerformed(ActionEvent e) {
				imgLbl.setIcon(new ImageIcon(CalcPerAreaGUI.class
						.getResource("/calculator/img/Quadrato.gif")));
				aTxt.setEditable(true);
				aTxt.requestFocusInWindow();
				bLbl.setVisible(false);
				bTxt.setVisible(false);
				cLbl.setVisible(false);
				cTxt.setVisible(false);
				dLbl.setVisible(false);
				dTxt.setVisible(false);
				eLbl.setVisible(false);
				eTxt.setVisible(false);
				eTxt.setEditable(false);
				aLbl.setText("l");
				rectangleRdbtn.setSelected(false);
				triangleRdbtn.setSelected(false);
				parallRdbtn.setSelected(false);
				rhombusRdbtn.setSelected(false);
				trapezoidRdbtn.setSelected(false);
				circleRdbtn.setSelected(false);
				select = figures.square;
				aTxt.setText("");
				bTxt.setText("");
				cTxt.setText("");
				dTxt.setText("");
				eTxt.setText("");
			}
		});
		squareRdbtn.setBounds(15, 343, 132, 23);
		frame.getContentPane().add(squareRdbtn);

		rectangleRdbtn = new JRadioButton("Rectangle");
		rectangleRdbtn.setFont(new Font("Dialog", Font.BOLD, 14));
		rectangleRdbtn.addActionListener(new ActionListener() {
			/**
			 * rectangle
			 */
			public void actionPerformed(ActionEvent e) {
				imgLbl.setIcon(new ImageIcon(CalcPerAreaGUI.class
						.getResource("/calculator/img/Rettangolo.gif")));
				aTxt.setEditable(true);
				aTxt.requestFocusInWindow();
				bLbl.setVisible(true);
				bTxt.setVisible(true);
				bTxt.setEditable(true);
				cLbl.setVisible(false);
				cTxt.setVisible(false);
				dLbl.setVisible(false);
				dTxt.setVisible(false);
				eLbl.setVisible(false);
				eTxt.setVisible(false);
				eTxt.setEditable(false);
				aLbl.setText("a");
				bLbl.setText("b");
				squareRdbtn.setSelected(false);
				triangleRdbtn.setSelected(false);
				parallRdbtn.setSelected(false);
				rhombusRdbtn.setSelected(false);
				trapezoidRdbtn.setSelected(false);
				circleRdbtn.setSelected(false);
				select = figures.retta;
				aTxt.setText("");
				bTxt.setText("");
				cTxt.setText("");
				dTxt.setText("");
				eTxt.setText("");
			}
		});
		rectangleRdbtn.setBounds(15, 370, 132, 23);
		frame.getContentPane().add(rectangleRdbtn);

		triangleRdbtn = new JRadioButton("Triangle");
		triangleRdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * triangle
				 */
				imgLbl.setIcon(new ImageIcon(CalcPerAreaGUI.class
						.getResource("/calculator/img/Triangolo.gif")));
				aTxt.setEditable(true);
				aTxt.requestFocusInWindow();
				bLbl.setVisible(true);
				bTxt.setVisible(true);
				bTxt.setEditable(true);
				cLbl.setVisible(true);
				cTxt.setVisible(true);
				cTxt.setEditable(true);
				dLbl.setVisible(true);
				dTxt.setVisible(true);
				dTxt.setEditable(true);
				eLbl.setVisible(false);
				eTxt.setVisible(false);
				eTxt.setEditable(false);
				aLbl.setText("a");
				bLbl.setText("b");
				cLbl.setText("c");
				dLbl.setText("d");
				squareRdbtn.setSelected(false);
				rectangleRdbtn.setSelected(false);
				parallRdbtn.setSelected(false);
				rhombusRdbtn.setSelected(false);
				trapezoidRdbtn.setSelected(false);
				circleRdbtn.setSelected(false);
				select = figures.tria;
				aTxt.setText("");
				bTxt.setText("");
				cTxt.setText("");
				dTxt.setText("");
				eTxt.setText("");
			}
		});
		triangleRdbtn.setFont(new Font("Dialog", Font.BOLD, 14));
		triangleRdbtn.setBounds(15, 397, 132, 23);
		frame.getContentPane().add(triangleRdbtn);

		parallRdbtn = new JRadioButton("Parallelogram");
		parallRdbtn.addActionListener(new ActionListener() {
			/**
			 * parallelogram
			 */
			public void actionPerformed(ActionEvent e) {
				imgLbl.setIcon(new ImageIcon(CalcPerAreaGUI.class
						.getResource("/calculator/img/Parallelogramma.gif")));
				aTxt.setEditable(true);
				aTxt.requestFocusInWindow();
				bLbl.setVisible(true);
				bTxt.setVisible(true);
				bTxt.setEditable(true);
				cLbl.setVisible(true);
				cTxt.setVisible(true);
				cTxt.setEditable(true);
				dLbl.setVisible(false);
				dTxt.setVisible(false);
				eLbl.setVisible(false);
				eTxt.setVisible(false);
				eTxt.setEditable(false);
				aLbl.setText("a");
				bLbl.setText("b");
				cLbl.setText("c");
				squareRdbtn.setSelected(false);
				rectangleRdbtn.setSelected(false);
				triangleRdbtn.setSelected(false);
				rhombusRdbtn.setSelected(false);
				trapezoidRdbtn.setSelected(false);
				circleRdbtn.setSelected(false);
				select = figures.parall;
				aTxt.setText("");
				bTxt.setText("");
				cTxt.setText("");
				dTxt.setText("");
				eTxt.setText("");
			}
		});
		parallRdbtn.setFont(new Font("Dialog", Font.BOLD, 14));
		parallRdbtn.setBounds(15, 424, 132, 23);
		frame.getContentPane().add(parallRdbtn);

		rhombusRdbtn = new JRadioButton("Rhombus");
		rhombusRdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * rhombus
				 */
				imgLbl.setIcon(new ImageIcon(CalcPerAreaGUI.class
						.getResource("/calculator/img/Rombo.gif")));
				aTxt.setEditable(true);
				aTxt.requestFocusInWindow();
				bLbl.setVisible(true);
				bTxt.setVisible(true);
				bTxt.setEditable(true);
				cLbl.setVisible(true);
				cTxt.setVisible(true);
				dLbl.setVisible(false);
				dTxt.setVisible(false);
				eLbl.setVisible(false);
				eTxt.setVisible(false);
				eTxt.setEditable(false);
				aLbl.setText("l");
				bLbl.setText("d");
				cLbl.setText("D");
				squareRdbtn.setSelected(false);
				rectangleRdbtn.setSelected(false);
				triangleRdbtn.setSelected(false);
				parallRdbtn.setSelected(false);
				trapezoidRdbtn.setSelected(false);
				circleRdbtn.setSelected(false);
				select = figures.rhomb;
				aTxt.setText("");
				bTxt.setText("");
				cTxt.setText("");
				dTxt.setText("");
				eTxt.setText("");
			}
		});
		rhombusRdbtn.setFont(new Font("Dialog", Font.BOLD, 14));
		rhombusRdbtn.setBounds(164, 343, 132, 23);
		frame.getContentPane().add(rhombusRdbtn);

		trapezoidRdbtn = new JRadioButton("Trapezoid");
		trapezoidRdbtn.addActionListener(new ActionListener() {
			/**
			 * trapezoid
			 */
			public void actionPerformed(ActionEvent e) {
				imgLbl.setIcon(new ImageIcon(CalcPerAreaGUI.class
						.getResource("/calculator/img/Trapezio.gif")));
				aTxt.setEditable(true);
				aTxt.requestFocusInWindow();
				bLbl.setVisible(true);
				bTxt.setVisible(true);
				bTxt.setEditable(true);
				cLbl.setVisible(true);
				cTxt.setVisible(true);
				cTxt.setEditable(true);
				dLbl.setVisible(true);
				dTxt.setVisible(true);
				dTxt.setEditable(true);
				eLbl.setVisible(true);
				eTxt.setVisible(true);
				eTxt.setEditable(true);
				aLbl.setText("a");
				bLbl.setText("b");
				cLbl.setText("B");
				dLbl.setText("c");
				eLbl.setText("d");
				squareRdbtn.setSelected(false);
				rectangleRdbtn.setSelected(false);
				triangleRdbtn.setSelected(false);
				parallRdbtn.setSelected(false);
				rhombusRdbtn.setSelected(false);
				circleRdbtn.setSelected(false);
				select = figures.trapz;
				aTxt.setText("");
				bTxt.setText("");
				cTxt.setText("");
				dTxt.setText("");
				eTxt.setText("");
			}
		});
		trapezoidRdbtn.setFont(new Font("Dialog", Font.BOLD, 14));
		trapezoidRdbtn.setBounds(164, 370, 132, 23);
		frame.getContentPane().add(trapezoidRdbtn);

		circleRdbtn = new JRadioButton("Circle");
		circleRdbtn.addActionListener(new ActionListener() {
			/**
			 * circle
			 */
			public void actionPerformed(ActionEvent e) {
				imgLbl.setIcon(new ImageIcon(CalcPerAreaGUI.class
						.getResource("/calculator/img/Cerchio.gif")));
				aTxt.setEditable(true);
				aTxt.requestFocusInWindow();
				bLbl.setVisible(false);
				bTxt.setVisible(false);
				bTxt.setEditable(false);
				cLbl.setVisible(false);
				cTxt.setVisible(false);
				dLbl.setVisible(false);
				dTxt.setVisible(false);
				eLbl.setVisible(false);
				eTxt.setVisible(false);
				eTxt.setEditable(false);
				aLbl.setText("r");
				squareRdbtn.setSelected(false);
				rectangleRdbtn.setSelected(false);
				triangleRdbtn.setSelected(false);
				parallRdbtn.setSelected(false);
				rhombusRdbtn.setSelected(false);
				trapezoidRdbtn.setSelected(false);
				select = figures.circle;
				aTxt.setText("");
				bTxt.setText("");
				cTxt.setText("");
				dTxt.setText("");
				eTxt.setText("");
			}
		});
		circleRdbtn.setFont(new Font("Dialog", Font.BOLD, 14));
		circleRdbtn.setBounds(164, 397, 132, 23);
		frame.getContentPane().add(circleRdbtn);

		imgLbl = new JLabel("");
		imgLbl.setIcon(new ImageIcon(CalcPerAreaGUI.class
				.getResource("/calculator/img/Default.gif")));
		imgLbl.setToolTipText("Images");
		imgLbl.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		imgLbl.setBounds(161, 12, 156, 163);
		frame.getContentPane().add(imgLbl);

		perimetroAreaLbl = new JLabel("Perimeter Area");
		perimetroAreaLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		perimetroAreaLbl.setBounds(99, 317, 114, 15);
		frame.getContentPane().add(perimetroAreaLbl);

		cLbl = new JLabel("c");
		cLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		cLbl.setBounds(15, 135, 105, 15);
		frame.getContentPane().add(cLbl);

		dTxt = new JTextField();
		dTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		dTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		dTxt.setEditable(false);
		dTxt.setColumns(10);
		dTxt.setBounds(15, 215, 100, 30);
		frame.getContentPane().add(dTxt);

		cTxt = new JTextField();
		cTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		cTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		cTxt.setEditable(false);
		cTxt.setColumns(10);
		cTxt.setBounds(15, 155, 100, 30);
		frame.getContentPane().add(cTxt);

		dLbl = new JLabel("d");
		dLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		dLbl.setBounds(15, 195, 54, 15);
		frame.getContentPane().add(dLbl);

		PLbl = new JLabel("Per");
		PLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		PLbl.setBounds(161, 193, 41, 17);
		frame.getContentPane().add(PLbl);

		pBtn = new JButton("Calc ");
		pBtn.setToolTipText("Calculate");
		pBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		pBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		pBtn.addActionListener(new ActionListener() {
			/**
			 * calculate
			 */
			public void actionPerformed(ActionEvent event) {
				switch (select) {
				case square:
					InputNumbers(figures.square);
					perTxt.setText(String.valueOf(calcPerArea.perSqaere(a)));
					areaTxt.setText(String.valueOf(calcPerArea.areaSquare(a)));
					break;

				case retta:
					InputNumbers(figures.retta);
					perTxt.setText(String.valueOf(calcPerArea
							.perRectangle(a, b)));
					areaTxt.setText(String.valueOf(calcPerArea.areaRectangle(a,
							b)));
					break;

				case tria:
					InputNumbers(figures.tria);
					perTxt.setText(String.valueOf(calcPerArea.perTriangle(b, c,
							d)));
					areaTxt.setText(String.valueOf(calcPerArea.areaTriangle(a,
							b)));
					break;

				case parall:
					InputNumbers(figures.parall);
					perTxt.setText(String.valueOf(calcPerArea.perParallelogram(
							b, c)));
					areaTxt.setText(String.valueOf(calcPerArea
							.areaParallelogram(a, b)));
					break;
					
				case rhomb:
					InputNumbers(figures.rhomb);
					perTxt.setText(String.valueOf(calcPerArea.perRhombus(a)));
					areaTxt.setText(String.valueOf(calcPerArea
							.areaRhombus(b, c)));
					break;

				case trapz:
					InputNumbers(figures.trapz);
					perTxt.setText(String.valueOf(calcPerArea.perTrapezoid(b,
							c, d, e)));
					areaTxt.setText(String.valueOf(calcPerArea.areaTrapezoid(a,
							b, c)));
					break;

				case circle:
					InputNumbers(figures.circle);
					Formatter formatterPer = new Formatter();
					Formatter formatterArea = new Formatter();
					formatterPer.format("%.7f", calcPerArea.perCircle(a));
					formatterArea.format("%.7f", calcPerArea.areaCircle(a));
					perTxt.setText(formatterPer.toString());
					areaTxt.setText(formatterArea.toString());
					break;
				}
			}
		});
		pBtn.setBounds(15, 455, 114, 30);
		frame.getContentPane().add(pBtn);

		cancelBtn = new JButton("Cancel");
		cancelBtn.setToolTipText("Cancel ");
		cancelBtn.addActionListener(new ActionListener() {
			/**
			 * all cancel
			 */
			public void actionPerformed(ActionEvent e) {
				aTxt.setText("");
				bTxt.setText("");
				cTxt.setText("");
				dTxt.setText("");
				eTxt.setText("");
				perTxt.setText("");
				areaTxt.setText("");
			}
		});
		cancelBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		cancelBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		cancelBtn.setBounds(164, 455, 114, 30);
		frame.getContentPane().add(cancelBtn);

		ALbl = new JLabel("Area");
		ALbl.setFont(new Font("Dialog", Font.BOLD, 14));
		ALbl.setBounds(161, 238, 41, 15);
		frame.getContentPane().add(ALbl);

		closeBtn = new JButton("Close");
		closeBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		closeBtn.setToolTipText("Close application");
		closeBtn.addActionListener(new ActionListener() {
			/**
			 * close application
			 */
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		closeBtn.setFont(new Font("Dialog", Font.BOLD, 14));
		closeBtn.setBounds(164, 497, 114, 30);
		frame.getContentPane().add(closeBtn);

		eLbl = new JLabel("e");
		eLbl.setFont(new Font("Dialog", Font.BOLD, 14));
		eLbl.setBounds(15, 255, 54, 15);
		frame.getContentPane().add(eLbl);

		eTxt = new JTextField();
		eTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		eTxt.setEditable(false);
		eTxt.setColumns(10);
		eTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null,
				null));
		eTxt.setBounds(15, 275, 100, 30);
		frame.getContentPane().add(eTxt);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { aTxt, bTxt, cTxt, dTxt, eTxt }));
	}
}
