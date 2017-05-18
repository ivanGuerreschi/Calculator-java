/* ===========================================================
 * Angry calculator : a free calculator for the Java(tm) platform
 * ===========================================================
 *
 * Project Info:  navicolt@gmail.com
 *
 * Copyright (C) 2014-2017 Ivan Guerreschi
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
 * Calculator.java
 * --------------------
 * Copyright (C) 2014-2016 Ivan Guerreschi
 *
 * Original Author:  Ivan Guerreschi;
 * Contributor(s): 
 * 
 * Changes
 * -------
 * Date changes 17/06/2014
 * Change label version 1.1
 * Date changes 19/06/2014
 * Added button function to calculate the fraction
 * Data changes 6/10/2014
 * Added function statistic
 * Data changes 14/10/2014
 * Change label version 1.2
 * Data changes 3/11/2014
 * Change label version 1.3
 * Data changes 1/12/2014
 * Change label version 1.4
 * Added function for calculate perimeter area
 * Data changes 29/03/2015
 * Change label version 1.5
 * Added convertor 
 * Data changes 07/09/2015
 * Change label version 1.6
 * Added download file  
 * Data changes 03/12/2015
 * Change label version 1.6.1
 * Added function leap year
 * Data changes 19/04/2016
 * Change label version 1.7
 * Added function Armstrong number
 * Added function disarium nuber
 * Added function neon number
 * Added function prime number
 * Added function happy number
 * Added function perfect number 
 * Data changes 15/07/2016
 * Change label version 1.7.1
 * Added function ConvertColorGUI
 * Data changes 10/03/2017
 * Change label version 1.7.2
 * Added function ConvertTemperature
 */

package calculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Formatter;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.text.DefaultEditorKit;

/**
 * The base class of the calculator
 * 
 * @author Ivan Guerreschi
 * 
 */
public class Calculator {

	private double number = 0.0;
	private enum Operator {SUB, SUM, DIV, MUL, POW, PER};
	private Operator operator;
	private double memory = 0.0;
	private Locale locale  = new Locale("en", "UK");
	private final String pattern = "###.##########";
	private final String versionLabel = "Version 1.7.2";
	private final String[] listComboBox = {"Other", "About", "Random six numbers", "Mini editor", 
			"Statistics", "Perimeter Area", "Convertor", "CalcDownFile", "LeapYear", "Armstrong number",
			"Disarium number", "Prime number", "Perfect number", "Happy number", "Neon number",
			"Color convert"};
	
	private JFrame frame;

	private JTextField resultTxt;
	private JTextField memoryTxt;

	private JComboBox<String> comboBox;

	private JButton fourBtn;
	private JButton oneBtn;
	private JButton zeroBtn;
	private JButton eightBtn;
	private JButton fiveBtn;
	private JButton twoBtn;
	private JButton pointBtn;
	private JButton nineBtn;
	private JButton sixBtn;
	private JButton threeBtn;
	private JButton acBtn;
	private JButton equalsBtn;
	private JButton moltBtn;
	private JButton divBtn;
	private JButton plusBtn;
	private JButton minusBtn;
	private JButton radiceBtn;
	private JButton tablesBtn;
	private JButton expBtn;
	private JButton randBtn;
	private JButton decBinBtn;
	private JButton binDecBtn;
	private JButton decHexBtn;
	private JButton hexDecBtn;
	private JButton factorialBtn;
	private JButton trigoRectBtn;
	private JButton constantBtn;
	private JButton fastPercBtn;
	private JButton sevenBrn;
	private JButton cancSingBtn;
	private JButton sinBtn;
	private JButton cosBtn;
	private JButton tanBtn;
	private JButton percBtn;
	private JButton pigreBtn;
	private JButton asinBtn;
	private JButton acosBtn;
	private JButton atanBtn;
	private JButton lnBtn;
	private JButton logBtn;
	private JButton fibonacciBtn;
	private JButton memoryBtn;
	private JButton memoryRBtn;
	private JButton memoryCBtn;
	private JButton powBtn;
	private JButton btnGraf;
	private JButton fractionBtn;
	private JButton convertTmp;

	private JMenuBar menuBar;

	private JMenu editMenu;

	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenuItem pasteMenuItem;

	private TextTransferHandler th;

	private JLabel versionLbl;

	/**
	 * method that performs the calculations made
	 * 
	 * @param operator operator for the calculation
	 * @return value of the calculation
	 */
	public double calculate(Operator operator) {

		double resultSum = 0.0;
		double resultSub = 0.0;
		double resultDiv = 0.0;
		double resultMult = 0.0;
		double resultPow = 0.0;
		double resultPerc = 0.0;

		switch (operator) {

		// subtraction
		case SUB:
			try {
				resultSub = number - Double.parseDouble(resultTxt.getText());
			} catch (NumberFormatException numberFormatException) {
				messageBox();
			}

			return resultSub;

			// sum
		case SUM:
			try {
				resultSum = number + Double.parseDouble(resultTxt.getText());
			} catch (NumberFormatException numberFormatException) {
				messageBox();
			}

			return resultSum;

			// division
		case DIV:
			try {
				resultDiv = number / Double.parseDouble(resultTxt.getText());
			} catch (NumberFormatException numberFormatException) {
				messageBox();
			}

			return resultDiv;

			// multiplication
		case MUL:
			try {
				resultMult = number * Double.parseDouble(resultTxt.getText());
			} catch (NumberFormatException numberFormatException) {
				messageBox();
			}
			return resultMult;

			// power
		case POW:
			try {
				resultPow = Math.pow(number,
						Double.parseDouble(resultTxt.getText()));
			} catch (NumberFormatException numberFormatException) {
				messageBox();
			}

			return resultPow;

			// percentage
		case PER:
			try {
				resultPerc = (number * Double.parseDouble(resultTxt.getText())) / 100;
			} catch (NumberFormatException numberFormatException) {
				messageBox();
			}

			return resultPerc;

		}
		return -1;
	}

	// message info

	public void messageBox() {
		JOptionPane.showMessageDialog(null,
				"Only whole numbers eg 14 or with point es: 12.4");
	}

	public void messageBox2() {
		JOptionPane.showMessageDialog(null, "Only whole numbers");
	}

	public void messageBox3() {
		JOptionPane.showMessageDialog(null, "Enter only binary numbers 1,0");
	}

	public void messageBox4() {
		JOptionPane
				.showMessageDialog(
						null,
						"Enter only hexadecimal numbers from 0 to 9 for the first ten digits, and then the letters A to F");
	}

	public void messageBox5() {
		JOptionPane.showMessageDialog(null,
				"There are more numbers to be deleted");
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
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
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Calculator.class.getResource("/calculator/img/icona.png")));
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBackground(Color.GRAY);
		frame.getContentPane().setPreferredSize(new Dimension(25, 200));
		frame.setTitle("Angry Calculator");
		frame.setBounds(100, 100, 757, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		th = new TextTransferHandler(new JTextField());

		resultTxt = new JTextField();
		resultTxt.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_SUBTRACT) {
					if (number != 0) {
						try {
							number = Double.parseDouble(resultTxt.getText()
									.substring(0,
											resultTxt.getText().length() - 1));
						} catch (NumberFormatException numberFormatException) {
							messageBox();
						}

						operator = Operator.SUB;
						resultTxt.setText("");

					} else {
						try {
							number = Double.parseDouble(resultTxt.getText());
						} catch (NumberFormatException numberFormatException) {
							messageBox();
						}

						operator = Operator.SUB;
						resultTxt.setText("");
					}
				}

				else if (e.getKeyCode() == KeyEvent.VK_ADD) {
					if (number != 0) {
						try {
							number = Double.parseDouble(resultTxt.getText()
									.substring(0,
											resultTxt.getText().length() - 1));
						} catch (NumberFormatException numberFormatException) {
							messageBox();
						}

						operator = Operator.SUM;
						resultTxt.setText("");

					} else {
						try {
							number = Double.parseDouble(resultTxt.getText());
						} catch (NumberFormatException numberFormatException) {
							messageBox();
						}

						operator = Operator.SUM;
						resultTxt.setText("");
					}

				}

				else if (e.getKeyCode() == KeyEvent.VK_DIVIDE) {
					if (number != 0) {
						try {
							number = Double.parseDouble(resultTxt.getText()
									.substring(0,
											resultTxt.getText().length() - 1));
						} catch (NumberFormatException numberFormatException) {
							messageBox();
						}

						operator = Operator.DIV;
						resultTxt.setText("");

					} else {
						try {
							number = Double.parseDouble(resultTxt.getText());
						} catch (NumberFormatException numberFormatException) {
							messageBox();
						}

						operator = Operator.DIV;
						resultTxt.setText("");
					}

				}

				else if (e.getKeyCode() == KeyEvent.VK_MULTIPLY) {
					if (number != 0) {
						try {
							number = Double.parseDouble(resultTxt.getText()
									.substring(0,
											resultTxt.getText().length() - 1));
						} catch (NumberFormatException numberFormatException) {
							messageBox();
						}

						operator = Operator.MUL;
						resultTxt.setText("");

					} else {
						try {
							number = Double.parseDouble(resultTxt.getText());
						} catch (NumberFormatException numberFormatException) {
							messageBox();
						}

						operator = Operator.MUL;
						resultTxt.setText("");
					}

				}

				else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					resultTxt.setText("");
					number = 0;

				}

				else if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					switch (operator) {

					// subtraction
					case SUB:
						try {
							number = number
									- Double.parseDouble(resultTxt.getText()
											.substring(
													1,
													resultTxt.getText()
															.length()));
						} catch (NumberFormatException numberFormatException) {
							messageBox();
						}

						resultTxt.setText(String.valueOf(number));
						break;

					// sum
					case SUM:
						try {
							number = number
									+ Double.parseDouble(resultTxt.getText()
											.substring(
													1,
													resultTxt.getText()
															.length()));
						} catch (NumberFormatException numberFormatException) {
							messageBox();
						}

						resultTxt.setText(String.valueOf(number));
						break;

					// division
					case DIV:
						try {
							number = number
									/ Double.parseDouble(resultTxt.getText()
											.substring(
													1,
													resultTxt.getText()
															.length()));
						} catch (NumberFormatException numberFormatException) {
							messageBox();
						}

						resultTxt.setText(String.valueOf(number));
						break;

					// multiplication
					case MUL:
						try {
							number = number
									* Double.parseDouble(resultTxt.getText()
											.substring(
													1,
													resultTxt.getText()
															.length()));
						} catch (NumberFormatException numberFormatException) {
							messageBox();
						}

						resultTxt.setText(String.valueOf(number));
						break;
					default:
						resultTxt.setText("Error");
						break;														
					}
				}
			}
		});

		resultTxt.setFont(new Font("Dialog", Font.BOLD, 16));
		resultTxt.setBounds(26, 10, 200, 25);
		resultTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		resultTxt.setPreferredSize(new Dimension(200, 25));
		resultTxt.setTransferHandler(th);
		frame.getContentPane().add(resultTxt);
		resultTxt.setColumns(10);

		memoryTxt = new JTextField();
		memoryTxt.setForeground(UIManager
				.getColor("OptionPane.questionDialog.titlePane.shadow"));
		memoryTxt.setFont(new Font("Dialog", Font.PLAIN, 16));
		memoryTxt.setVisible(false);
		memoryTxt.setEditable(false);
		memoryTxt.setBounds(262, 12, 76, 25);
		frame.getContentPane().add(memoryTxt);
		memoryTxt.setColumns(10);

		sevenBrn = new JButton("7");
		sevenBrn.addActionListener(new ActionListener() {

			/**
			 * enter number 7
			 */
			public void actionPerformed(ActionEvent e) {

				resultTxt.setText(resultTxt.getText() + "7");
			}
		});
		sevenBrn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		sevenBrn.setBounds(10, 60, 75, 35);
		sevenBrn.setFont(new Font("Dialog", Font.BOLD, 16));
		sevenBrn.setPreferredSize(new Dimension(0, 0));
		frame.getContentPane().add(sevenBrn);

		fourBtn = new JButton("4");
		fourBtn.addActionListener(new ActionListener() {

			/**
			 * enter number 4
			 */
			public void actionPerformed(ActionEvent e) {

				resultTxt.setText(resultTxt.getText() + "4");
			}
		});
		fourBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		fourBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		fourBtn.setBounds(10, 110, 75, 35);
		frame.getContentPane().add(fourBtn);

		oneBtn = new JButton("1");
		oneBtn.addActionListener(new ActionListener() {

			/**
			 * enter number 1
			 */
			public void actionPerformed(ActionEvent e) {

				resultTxt.setText(resultTxt.getText() + "1");
			}
		});
		oneBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		oneBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		oneBtn.setBounds(10, 160, 75, 35);
		frame.getContentPane().add(oneBtn);

		zeroBtn = new JButton("0");
		zeroBtn.addActionListener(new ActionListener() {

			/**
			 * enter number 0
			 */
			public void actionPerformed(ActionEvent e) {

				resultTxt.setText(resultTxt.getText() + "0");
			}
		});
		zeroBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		zeroBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		zeroBtn.setBounds(9, 210, 75, 35);
		frame.getContentPane().add(zeroBtn);

		eightBtn = new JButton("8");
		eightBtn.addActionListener(new ActionListener() {

			/**
			 * enter number 8
			 */
			public void actionPerformed(ActionEvent e) {

				resultTxt.setText(resultTxt.getText() + "8");
			}
		});
		eightBtn.setPreferredSize(new Dimension(0, 0));
		eightBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		eightBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		eightBtn.setBounds(90, 60, 75, 35);
		frame.getContentPane().add(eightBtn);

		fiveBtn = new JButton("5");
		fiveBtn.addActionListener(new ActionListener() {

			/**
			 * enter number 5
			 */
			public void actionPerformed(ActionEvent e) {

				resultTxt.setText(resultTxt.getText() + "5");
			}
		});
		fiveBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		fiveBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		fiveBtn.setBounds(90, 110, 75, 35);
		frame.getContentPane().add(fiveBtn);

		twoBtn = new JButton("2");
		twoBtn.addActionListener(new ActionListener() {

			/**
			 * enter number 2
			 */
			public void actionPerformed(ActionEvent e) {

				resultTxt.setText(resultTxt.getText() + "2");
			}
		});
		twoBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		twoBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		twoBtn.setBounds(90, 160, 75, 35);
		frame.getContentPane().add(twoBtn);

		pointBtn = new JButton(".");
		pointBtn.addActionListener(new ActionListener() {

			/**
			 * enter point
			 */
			public void actionPerformed(ActionEvent e) {

				resultTxt.setText(resultTxt.getText() + ".");
			}
		});
		pointBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		pointBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		pointBtn.setBounds(90, 210, 75, 35);
		frame.getContentPane().add(pointBtn);

		nineBtn = new JButton("9");
		nineBtn.addActionListener(new ActionListener() {

			/**
			 * enter number 9
			 */
			public void actionPerformed(ActionEvent e) {

				resultTxt.setText(resultTxt.getText() + "9");
			}
		});
		nineBtn.setPreferredSize(new Dimension(0, 0));
		nineBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		nineBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		nineBtn.setBounds(170, 60, 75, 35);
		frame.getContentPane().add(nineBtn);

		sixBtn = new JButton("6");
		sixBtn.addActionListener(new ActionListener() {

			/**
			 * enter number 6
			 */
			public void actionPerformed(ActionEvent e) {

				resultTxt.setText(resultTxt.getText() + "6");
			}
		});
		sixBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		sixBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		sixBtn.setBounds(170, 110, 75, 35);
		frame.getContentPane().add(sixBtn);

		threeBtn = new JButton("3");
		threeBtn.addActionListener(new ActionListener() {

			/**
			 * enter number 3
			 */
			public void actionPerformed(ActionEvent e) {

				resultTxt.setText(resultTxt.getText() + "3");
			}
		});
		threeBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		threeBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		threeBtn.setBounds(170, 160, 75, 35);
		frame.getContentPane().add(threeBtn);

		acBtn = new JButton("AC");
		acBtn.addActionListener(new ActionListener() {

			/**
			 * select function all cancel
			 */
			public void actionPerformed(ActionEvent e) {

				resultTxt.setText("");
				resultTxt.requestFocusInWindow();
			}
		});
		acBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		acBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		acBtn.setBounds(170, 210, 75, 35);
		frame.getContentPane().add(acBtn);

		equalsBtn = new JButton("=");
		equalsBtn.addActionListener(new ActionListener() {

			/**
			 * select function equals
			 */
			public void actionPerformed(ActionEvent e) {

				if (calculate(operator) == -1)
					resultTxt.setText("Error");
				else{
					// formats decimal numbers
					DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
					// apply the given pattern to this Format object
					decimalFormat.applyPattern(pattern);
					resultTxt.setText(decimalFormat.format(calculate(operator)));
				}
			}
		});
		equalsBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		equalsBtn.setFont(new Font("Dialog", Font.BOLD, 20));
		equalsBtn.setBounds(10, 266, 236, 60);
		frame.getContentPane().add(equalsBtn);

		moltBtn = new JButton("x");
		moltBtn.addActionListener(new ActionListener() {

			/**
			 * select function multiplication
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					number = Double.parseDouble(resultTxt.getText());
				} catch (NumberFormatException numberFormatException) {
					messageBox();
				}

				resultTxt.setText("");
				resultTxt.requestFocusInWindow();
				operator = Operator.MUL;
			}
		});
		moltBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		moltBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		moltBtn.setBounds(263, 50, 75, 25);
		frame.getContentPane().add(moltBtn);

		divBtn = new JButton("/");
		divBtn.addActionListener(new ActionListener() {

			/**
			 * select function division
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					number = Double.parseDouble(resultTxt.getText());
				} catch (NumberFormatException numberFormatException) {
					messageBox();
				}

				resultTxt.setText("");
				resultTxt.requestFocusInWindow();
				operator = Operator.DIV;
			}
		});
		divBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		divBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		divBtn.setActionCommand("divBtn");
		divBtn.setBounds(263, 100, 75, 25);
		frame.getContentPane().add(divBtn);

		plusBtn = new JButton("+");
		plusBtn.addActionListener(new ActionListener() {

			/**
			 * select function plus
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					number = Double.parseDouble(resultTxt.getText());
				} catch (NumberFormatException numberFormatException) {
					messageBox();
				}

				resultTxt.setText("");
				resultTxt.requestFocusInWindow();
				operator = Operator.SUM;
			}
		});
		plusBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		plusBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		plusBtn.setBounds(263, 150, 75, 25);
		frame.getContentPane().add(plusBtn);

		minusBtn = new JButton("-");
		minusBtn.addActionListener(new ActionListener() {

			/**
			 * select function minus
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					number = Double.parseDouble(resultTxt.getText());
				} catch (NumberFormatException numberFormatException) {
					messageBox();
				}

				resultTxt.setText("");
				resultTxt.requestFocusInWindow();
				operator = Operator.SUB;
			}
		});
		minusBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		minusBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		minusBtn.setBounds(263, 200, 75, 25);
		frame.getContentPane().add(minusBtn);

		cancSingBtn = new JButton("C");
		cancSingBtn.addActionListener(new ActionListener() {

			/**
			 * select function single cancel
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					String input = resultTxt.getText();
					// has a length value and subtracts one
					int a = input.length() - 1;
					// returns a new string that is a substring of this string
					String output = input.substring(0, a);
					resultTxt.setText(output);
				} catch (IndexOutOfBoundsException exception) {
					messageBox5();
					resultTxt.setText("");
				}
			}
		});
		cancSingBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		cancSingBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		cancSingBtn.setBounds(263, 295, 75, 25);
		frame.getContentPane().add(cancSingBtn);

		radiceBtn = new JButton("√");
		radiceBtn.addActionListener(new ActionListener() {

			/**
			 * select function square
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					double risultatoS = Math.sqrt(Double.parseDouble(resultTxt
							.getText()));
					resultTxt.setText(String.valueOf(risultatoS));
				} catch (NumberFormatException exception) {
					messageBox();
					resultTxt.setText("");
					resultTxt.requestFocusInWindow();
				}
			}
		});
		radiceBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		radiceBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		radiceBtn.setBounds(263, 250, 75, 25);
		frame.getContentPane().add(radiceBtn);

		sinBtn = new JButton("sin");
		sinBtn.addActionListener(new ActionListener() {

			/**
			 * select function sine
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					double risultatoSin = Math.sin(Math.toRadians(Double
							.parseDouble(resultTxt.getText())));
					resultTxt.setText(String.valueOf(risultatoSin));
				} catch (NumberFormatException exception) {
					messageBox();
					resultTxt.setText("");
					resultTxt.requestFocusInWindow();
				}
			}
		});
		sinBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		sinBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		sinBtn.setBounds(344, 50, 75, 25);
		frame.getContentPane().add(sinBtn);

		cosBtn = new JButton("cos");
		cosBtn.addActionListener(new ActionListener() {

			/**
			 * select function cosine
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					double risultatoCos = Math.cos(Math.toRadians(Double
							.parseDouble(resultTxt.getText())));
					resultTxt.setText(String.valueOf(risultatoCos));
				} catch (NumberFormatException exception) {
					messageBox();
					resultTxt.setText("");
					resultTxt.requestFocusInWindow();
				}
			}
		});
		cosBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		cosBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		cosBtn.setActionCommand("divBtn");
		cosBtn.setBounds(344, 100, 75, 25);
		frame.getContentPane().add(cosBtn);

		tanBtn = new JButton("tan");
		tanBtn.addActionListener(new ActionListener() {

			/**
			 * select function tangent
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					double risultatoTan = Math.tan(Math.toRadians(Double
							.parseDouble(resultTxt.getText())));
					resultTxt.setText(String.valueOf(risultatoTan));
				} catch (NumberFormatException exception) {
					messageBox();
					resultTxt.setText("");
					resultTxt.requestFocusInWindow();
				}
			}
		});
		tanBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		tanBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		tanBtn.setBounds(344, 150, 75, 25);
		frame.getContentPane().add(tanBtn);

		percBtn = new JButton("%");
		percBtn.addActionListener(new ActionListener() {

			/**
			 * select function percentage
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					number = Double.parseDouble(resultTxt.getText());
				} catch (NumberFormatException exception) {
					messageBox();
					resultTxt.requestFocusInWindow();
				}
				resultTxt.setText("");
				operator = Operator.PER;
			}
		});
		percBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		percBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		percBtn.setBounds(344, 200, 75, 25);
		frame.getContentPane().add(percBtn);

		pigreBtn = new JButton("π");
		pigreBtn.addActionListener(new ActionListener() {

			/**
			 * select function pi greek
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					if (resultTxt.getText().equals("")) {
						resultTxt.setText(String.valueOf(Math.PI));
					} else {
						double risultatoP = Double.parseDouble(resultTxt
								.getText()) * Math.PI;
						resultTxt.setText(String.valueOf(risultatoP));
					}
				} catch (NumberFormatException exception) {
					messageBox();
					resultTxt.setText("");
					resultTxt.requestFocusInWindow();

				}
			}
		});
		pigreBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		pigreBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		pigreBtn.setBounds(344, 250, 75, 25);
		frame.getContentPane().add(pigreBtn);

		expBtn = new JButton("exp");
		expBtn.addActionListener(new ActionListener() {

			/**
			 * select function exponent
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					double exp = Double.parseDouble(resultTxt.getText());
					resultTxt.setText(String.valueOf(Math.exp(exp)));
				} catch (NumberFormatException exception) {
					messageBox();
					resultTxt.setText("");
					resultTxt.requestFocusInWindow();
				}
			}
		});
		expBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		expBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		expBtn.setBounds(344, 295, 75, 25);
		frame.getContentPane().add(expBtn);

		asinBtn = new JButton("asin");
		asinBtn.addActionListener(new ActionListener() {

			/**
			 * select function arc sin
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					double risultatoASin = Math.toDegrees(Math.asin(Double
							.parseDouble(resultTxt.getText())));
					resultTxt.setText(String.valueOf(risultatoASin));
				} catch (NumberFormatException exception) {
					messageBox();
					resultTxt.setText("");
					resultTxt.requestFocusInWindow();
				}
			}
		});
		asinBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		asinBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		asinBtn.setBounds(425, 50, 75, 25);
		frame.getContentPane().add(asinBtn);

		acosBtn = new JButton("acos");
		acosBtn.addActionListener(new ActionListener() {

			/**
			 * select function cosine
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					double risultatoACos = Math.toDegrees(Math.acos(Double
							.parseDouble(resultTxt.getText())));
					resultTxt.setText(String.valueOf(risultatoACos));
				} catch (NumberFormatException exception) {
					messageBox();
					resultTxt.setText("");
					resultTxt.requestFocusInWindow();
				}
			}
		});
		acosBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		acosBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		acosBtn.setActionCommand("divBtn");
		acosBtn.setBounds(425, 100, 75, 25);
		frame.getContentPane().add(acosBtn);

		atanBtn = new JButton("atan");
		atanBtn.addActionListener(new ActionListener() {

			/**
			 * select function cotangent
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					double risultatoATan = Math.toDegrees(Math.atan(Double
							.parseDouble(resultTxt.getText())));
					resultTxt.setText(String.valueOf(risultatoATan));
				} catch (NumberFormatException exception) {
					messageBox();
					resultTxt.setText("");
					resultTxt.requestFocusInWindow();
				}
			}
		});
		atanBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		atanBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		atanBtn.setBounds(425, 150, 75, 25);
		frame.getContentPane().add(atanBtn);

		lnBtn = new JButton("ln");
		lnBtn.addActionListener(new ActionListener() {

			/**
			 * select function natural logarithm
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					double risultatoLn = Math.log(Double.parseDouble(resultTxt
							.getText()));
					resultTxt.setText(String.valueOf(risultatoLn));
				} catch (NumberFormatException exception) {
					messageBox();
					resultTxt.setText("");
					resultTxt.requestFocusInWindow();
				}
			}
		});
		lnBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		lnBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		lnBtn.setBounds(425, 200, 75, 25);
		frame.getContentPane().add(lnBtn);

		logBtn = new JButton("log");
		logBtn.addActionListener(new ActionListener() {

			/**
			 * select function logarithm
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					double risultatoLog = Math.log10(Double
							.parseDouble(resultTxt.getText()));
					resultTxt.setText(String.valueOf(risultatoLog));
				} catch (NumberFormatException exception) {
					messageBox();
					resultTxt.setText("");
					resultTxt.requestFocusInWindow();
				}
			}
		});
		logBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		logBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		logBtn.setBounds(425, 250, 75, 25);
		frame.getContentPane().add(logBtn);

		fibonacciBtn = new JButton("fibon");
		fibonacciBtn.addActionListener(new ActionListener() {

			/**
			 * select class Fibonacci
			 */
			public void actionPerformed(ActionEvent e) {

				FibonacciGUI fibonacci = new FibonacciGUI();
				fibonacci.frame.setVisible(true);
			}
		});
		fibonacciBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		fibonacciBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		fibonacciBtn.setBounds(425, 295, 75, 25);
		frame.getContentPane().add(fibonacciBtn);

		memoryBtn = new JButton("M");
		memoryBtn.addActionListener(new ActionListener() {

			/**
			 * select function memory
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					memory = Double.parseDouble(resultTxt.getText());
					// set memory text with the number entered
					memoryTxt.setText(String.valueOf(memory));
					// visible memory text
					memoryTxt.setVisible(true);
					resultTxt.setText("");
					resultTxt.requestFocusInWindow();
					// set color green button
					memoryBtn.setForeground(Color.GREEN);
				} catch (NumberFormatException exception) {
					messageBox();
					resultTxt.setText("");
					resultTxt.requestFocusInWindow();
				}
			}
		});
		memoryBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		memoryBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		memoryBtn.setBounds(506, 50, 75, 25);
		frame.getContentPane().add(memoryBtn);

		memoryRBtn = new JButton("MR");
		memoryRBtn.addActionListener(new ActionListener() {

			/**
			 * select memory recalls
			 */
			public void actionPerformed(ActionEvent e) {

				resultTxt.setText(String.valueOf(memory));
			}
		});
		memoryRBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		memoryRBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		memoryRBtn.setActionCommand("divBtn");
		memoryRBtn.setBounds(506, 100, 75, 25);
		frame.getContentPane().add(memoryRBtn);

		memoryCBtn = new JButton("MC");
		memoryCBtn.addActionListener(new ActionListener() {

			/**
			 * select function memory cancel
			 */
			public void actionPerformed(ActionEvent e) {

				memory = 0;
				memoryTxt.setText("");
				memoryTxt.setVisible(false);
				memoryBtn.setForeground(Color.BLACK);
			}
		});
		memoryCBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		memoryCBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		memoryCBtn.setBounds(506, 150, 75, 25);
		frame.getContentPane().add(memoryCBtn);

		powBtn = new JButton("pow");
		powBtn.addActionListener(new ActionListener() {

			/**
			 * select function power
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					number = Double.parseDouble(resultTxt.getText());
				} catch (NumberFormatException exception) {
					messageBox();
					resultTxt.requestFocusInWindow();
				}
				resultTxt.setText("");
				operator = Operator.POW;
			}
		});
		powBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		powBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		powBtn.setBounds(506, 200, 75, 25);
		frame.getContentPane().add(powBtn);

		expBtn = new JButton("X\u00B2");
		expBtn.addActionListener(new ActionListener() {

			/**
			 * select function power to the second
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					number = Double.parseDouble(resultTxt.getText());
					resultTxt.setText(String.valueOf(Math.pow(number, 2)));
				} catch (NumberFormatException exception) {
					messageBox();
					resultTxt.setText("");
					resultTxt.requestFocusInWindow();
				}
			}
		});
		expBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		expBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		expBtn.setBounds(506, 250, 75, 25);
		frame.getContentPane().add(expBtn);

		tablesBtn = new JButton("tables");
		tablesBtn.addActionListener(new ActionListener() {

			/**
			 * select class Tables
			 */
			public void actionPerformed(ActionEvent e) {

				Tables tabelline = new Tables();
				tabelline.frame.setVisible(true);
			}
		});
		tablesBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		tablesBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		tablesBtn.setBounds(506, 295, 75, 25);
		frame.getContentPane().add(tablesBtn);

		randBtn = new JButton("rand");
		randBtn.addActionListener(new ActionListener() {

			/**
			 * select random function
			 */
			public void actionPerformed(ActionEvent e) {

				resultTxt.setText(String.valueOf(Math.random()));
			}
		});
		randBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		randBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		randBtn.setBounds(587, 50, 75, 25);
		frame.getContentPane().add(randBtn);

		decBinBtn = new JButton("dec/bin");
		decBinBtn.addActionListener(new ActionListener() {

			/**
			 * convert decimal binary
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					String risultatoDecBin = Integer.toBinaryString(Integer
							.parseInt(resultTxt.getText()));
					resultTxt.setText(risultatoDecBin);
				} catch (NumberFormatException exception) {
					messageBox2();
					resultTxt.setText("");
					resultTxt.requestFocusInWindow();
				}
			}
		});
		decBinBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		decBinBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		decBinBtn.setActionCommand("divBtn");
		decBinBtn.setBounds(587, 100, 75, 25);
		frame.getContentPane().add(decBinBtn);

		binDecBtn = new JButton("bin/dec");
		binDecBtn.addActionListener(new ActionListener() {

			/**
			 * convert binary decimal
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					int risultatoBinDec = Integer.parseInt(resultTxt.getText(),
							2);
					resultTxt.setText(String.valueOf(risultatoBinDec));
				} catch (NumberFormatException exception) {
					messageBox3();
					resultTxt.setText("");
					resultTxt.requestFocusInWindow();
				}
			}
		});
		binDecBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		binDecBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		binDecBtn.setBounds(587, 150, 75, 25);
		frame.getContentPane().add(binDecBtn);

		decHexBtn = new JButton("dec/hex");
		decHexBtn.addActionListener(new ActionListener() {

			/**
			 * convert decimal hex
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					String risultatoDecHex = Integer.toHexString(Integer
							.parseInt(resultTxt.getText()));
					resultTxt.setText(risultatoDecHex);
				} catch (NumberFormatException exception) {
					messageBox2();
					resultTxt.setText("");
					resultTxt.requestFocusInWindow();
				}
			}
		});
		decHexBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		decHexBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		decHexBtn.setBounds(587, 200, 75, 25);
		frame.getContentPane().add(decHexBtn);

		hexDecBtn = new JButton("hex/dec");
		hexDecBtn.addActionListener(new ActionListener() {

			/**
			 * convert hex decimal
			 */
			public void actionPerformed(ActionEvent e) {

				try {
					int risultatoDecHex = Integer.parseInt(resultTxt.getText(),
							16);
					resultTxt.setText(String.valueOf(risultatoDecHex));
				} catch (NumberFormatException exception) {
					messageBox4();
					resultTxt.setText("");
					resultTxt.requestFocusInWindow();
				}
			}
		});
		hexDecBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		hexDecBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		hexDecBtn.setBounds(587, 250, 75, 25);
		frame.getContentPane().add(hexDecBtn);

		factorialBtn = new JButton("fatt");
		factorialBtn.addActionListener(new ActionListener() {

			/**
			 * select class Factorial
			 */
			public void actionPerformed(ActionEvent e) {

				FactorialGUI fattoriale = new FactorialGUI();
				fattoriale.frame.setVisible(true);
			}
		});
		factorialBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		factorialBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		factorialBtn.setBounds(587, 295, 75, 25);
		frame.getContentPane().add(factorialBtn);

		trigoRectBtn = new JButton("trigTriRect");
		trigoRectBtn.addActionListener(new ActionListener() {

			/**
			 * select class TrigonometryTri
			 */
			public void actionPerformed(ActionEvent e) {

				TrigonometryTri trigonometria = new TrigonometryTri();
				trigonometria.frame.setVisible(true);
			}
		});
		trigoRectBtn.setFont(new Font("Dialog", Font.BOLD, 11));
		trigoRectBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		trigoRectBtn.setBounds(668, 50, 75, 25);
		frame.getContentPane().add(trigoRectBtn);

		constantBtn = new JButton("const");
		constantBtn.addActionListener(new ActionListener() {

			/**
			 * select class ReadingFile
			 */
			public void actionPerformed(ActionEvent e) {

				Constant file = new Constant();
				file.frame.setVisible(true);
			}
		});
		constantBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		constantBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		constantBtn.setActionCommand("divBtn");
		constantBtn.setBounds(668, 100, 75, 25);
		frame.getContentPane().add(constantBtn);

		fastPercBtn = new JButton("fast%");
		fastPercBtn.addActionListener(new ActionListener() {

			/**
			 * select class PercentageCalc
			 */
			public void actionPerformed(ActionEvent e) {

				PercentageCalc calcPerc = new PercentageCalc();
				calcPerc.frame.setVisible(true);
			}
		});
		fastPercBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		fastPercBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		fastPercBtn.setBounds(668, 150, 75, 25);
		frame.getContentPane().add(fastPercBtn);

		btnGraf = new JButton("grap");
		btnGraf.addActionListener(new ActionListener() {

			/**
			 * select class Graphic
			 */
			public void actionPerformed(ActionEvent e) {

				Graphic grafico = new Graphic();
				grafico.frame.setVisible(true);
			}
		});
		btnGraf.setFont(new Font("Dialog", Font.BOLD, 16));
		btnGraf.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null,
				null));
		btnGraf.setBounds(668, 201, 75, 25);
		frame.getContentPane().add(btnGraf);

		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(listComboBox));
		comboBox.addItemListener(new ItemListener() {

			/**
			 * selection item combobox
			 */
			public void itemStateChanged(ItemEvent e) {

				// select class Info
				if (e.getStateChange() == ItemEvent.SELECTED)
					if (comboBox.getSelectedIndex() == 1) {
						Info info = new Info();
						info.frame.setVisible(true);
						comboBox.setSelectedIndex(0);
					}

				// select class RandomSixNumbers
				if (e.getStateChange() == ItemEvent.SELECTED)
					if (comboBox.getSelectedIndex() == 2) {
						RandomSixNumbers random = new RandomSixNumbers();
						random.numbers();
						comboBox.setSelectedIndex(0);
					}

				// select class MiniEditor
				if (e.getStateChange() == ItemEvent.SELECTED)
					if (comboBox.getSelectedIndex() == 3) {
						MiniEditor miniEditor = new MiniEditor();
						miniEditor.frame.setVisible(true);
						comboBox.setSelectedIndex(0);
					}

				// select class StatisticsGUI
				if (e.getStateChange() == ItemEvent.SELECTED)
					if (comboBox.getSelectedIndex() == 4) {
						StatisticGui statisticGui = new StatisticGui();
						statisticGui.frame.setVisible(true);
						comboBox.setSelectedIndex(0);
					}
				
				// select class CalcPerAreaGUI
				if (e.getStateChange() == ItemEvent.SELECTED)
					if (comboBox.getSelectedIndex() == 5) {
						CalcPerAreaGUI calcPerAreaGui = new CalcPerAreaGUI();
						calcPerAreaGui.frame.setVisible(true);
						comboBox.setSelectedIndex(0);
					}
				
				// select class ConvertorGUI
				if (e.getStateChange() == ItemEvent.SELECTED)
					if (comboBox.getSelectedIndex() == 6) {
						ConvertorGUI convertorGUI = new ConvertorGUI();
						convertorGUI.frame.setVisible(true);
						comboBox.setSelectedIndex(0);
					}
				
				// select class DownloadFileGUI
				if (e.getStateChange() == ItemEvent.SELECTED)
					if (comboBox.getSelectedIndex() == 7) {
						DownloadFileGUI downloadFileGUI = new DownloadFileGUI();
						downloadFileGUI.frame.setVisible(true);
						comboBox.setSelectedIndex(0);
					}
				
				// select class LeapYear
				if (e.getStateChange() == ItemEvent.SELECTED)
					if (comboBox.getSelectedIndex() == 8) {
						int years;
						try {
							years = Integer.valueOf(resultTxt.getText());						
							LeapYear leapYear = new LeapYear(years);
							if (leapYear.isLeapYear())
								resultTxt.setText("True: " + years);
							else
								resultTxt.setText("False: " + years);
							comboBox.setSelectedIndex(0);
						} catch(NumberFormatException numberFormatException) {
							messageBox2();
							resultTxt.setText("");
							resultTxt.requestFocusInWindow();
							comboBox.setSelectedIndex(0);
						}
					}
				
				// select class Armstrong
				if (e.getStateChange() == ItemEvent.SELECTED)
					if (comboBox.getSelectedIndex() == 9) {
						int armNumber;
						try {
							armNumber = Integer.valueOf(resultTxt.getText());						
							Armstrong armstrong = new Armstrong(armNumber);
							if (armstrong.isArmstrong())
								resultTxt.setText("True: " + armNumber);
							else
								resultTxt.setText("False: " + armNumber);
							comboBox.setSelectedIndex(0);
						} catch(NumberFormatException numberFormatException) {
							messageBox2();
							resultTxt.setText("");
							resultTxt.requestFocusInWindow();
							comboBox.setSelectedIndex(0);
						}
					}
				
				// select class Disarium
				if (e.getStateChange() == ItemEvent.SELECTED)
					if (comboBox.getSelectedIndex() == 10) {
						int disNumber;
						try {
							disNumber = Integer.valueOf(resultTxt.getText());						
							Disarium disarium = new Disarium(disNumber);
							if (disarium.isDisarium())
								resultTxt.setText("True: " + disNumber);
							else
								resultTxt.setText("False: " + disNumber);
							comboBox.setSelectedIndex(0);
						} catch(NumberFormatException numberFormatException) {
							messageBox2();
							resultTxt.setText("");
							resultTxt.requestFocusInWindow();
							comboBox.setSelectedIndex(0);
						}
					}
				
				// select class Prime
				if (e.getStateChange() == ItemEvent.SELECTED)
					if (comboBox.getSelectedIndex() == 11) {
						int primeNumber;
						try {
							primeNumber = Integer.valueOf(resultTxt.getText());						
							Prime prime = new Prime(primeNumber); 
							if (prime.isPrime())
								resultTxt.setText("True: " + primeNumber);
							else
								resultTxt.setText("False: " + primeNumber);
							comboBox.setSelectedIndex(0);
						} catch(NumberFormatException numberFormatException) {
							messageBox2();
							resultTxt.setText("");
							resultTxt.requestFocusInWindow();
							comboBox.setSelectedIndex(0);
						}
					}
				
				// select class Perfect
				if (e.getStateChange() == ItemEvent.SELECTED)
					if (comboBox.getSelectedIndex() == 12) {
						int perfectNumber;
						try {
							perfectNumber = Integer.valueOf(resultTxt.getText());						
							Perfect perfect = new Perfect(perfectNumber); 
							if (perfect.isPerfect())
								resultTxt.setText("True: " + perfectNumber);
							else
								resultTxt.setText("False: " + perfectNumber);
							comboBox.setSelectedIndex(0);
						} catch(NumberFormatException numberFormatException) {
							messageBox2();
							resultTxt.setText("");
							resultTxt.requestFocusInWindow();
							comboBox.setSelectedIndex(0);
						}
					}
				
				// select class Happy
				if (e.getStateChange() == ItemEvent.SELECTED)
					if (comboBox.getSelectedIndex() == 13) {
						long happyNumber;
						try {
							happyNumber = Integer.valueOf(resultTxt.getText());						
							Happy happy = new Happy(happyNumber); 
							if (happy.isHappy())
								resultTxt.setText("True: " + happyNumber);
							else
								resultTxt.setText("False: " + happyNumber);
							comboBox.setSelectedIndex(0);
						} catch(NumberFormatException numberFormatException) {
							messageBox2();
							resultTxt.setText("");
							resultTxt.requestFocusInWindow();
							comboBox.setSelectedIndex(0);
						}
					}
				
				// select class Neon
				if (e.getStateChange() == ItemEvent.SELECTED)
					if (comboBox.getSelectedIndex() == 14) {
						int neonNumber;
						try {
							neonNumber = Integer.valueOf(resultTxt.getText());						
							Neon neon = new Neon(neonNumber); 
							if (neon.isNeon())
								resultTxt.setText("True: " + neonNumber);
							else
								resultTxt.setText("False: " + neonNumber);
							comboBox.setSelectedIndex(0);
						} catch(NumberFormatException numberFormatException) {
							messageBox2();
							resultTxt.setText("");
							resultTxt.requestFocusInWindow();
							comboBox.setSelectedIndex(0);
						}
					}
				
				// select class ConvertColorGUI
				if (e.getStateChange() == ItemEvent.SELECTED)
					if (comboBox.getSelectedIndex() == 15) {
						ConvertColorGUI convertColorGUI = new ConvertColorGUI();
						convertColorGUI.frame.setVisible(true);
						comboBox.setSelectedIndex(0);
					}
			}
		});
		comboBox.setFont(new Font("Dialog", Font.BOLD, 14));
		comboBox.setBounds(344, 12, 237, 25);
		frame.getContentPane().add(comboBox);

		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Dialog", Font.BOLD, 12));
		menuBar.setBounds(587, 12, 50, 25);
		frame.getContentPane().add(menuBar);

		editMenu = new JMenu("Edit");
		menuBar.add(editMenu);
		editMenu.setMnemonic(KeyEvent.VK_E);

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

		versionLbl = new JLabel(versionLabel);
		versionLbl.setBounds(649, 16, 114, 15);
		frame.getContentPane().add(versionLbl);

		fractionBtn = new JButton("fract");
		fractionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FractionGUI fractionGUI = new FractionGUI();
				fractionGUI.frame.setVisible(true);
			}
		});
		fractionBtn.setFont(new Font("Dialog", Font.BOLD, 16));
		fractionBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
				null, null));
		fractionBtn.setBounds(668, 251, 75, 25);
		frame.getContentPane().add(fractionBtn);
		
		convertTmp = new JButton("°C °F");
		convertTmp.setToolTipText("For convert °C to °F use f-temperature, °F to °C use c-temperature");
		convertTmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formatter formatter = new Formatter();
				String[] input = resultTxt.getText().split("-"); // split string input[0] °C or °F input[1] temperature
				ConvertTemperature convertTemperature = new ConvertTemperature(Double.parseDouble(input[1]), input[0].toLowerCase());
				formatter.format("%.4f", convertTemperature.temperature());
				resultTxt.setText(formatter.toString());
				formatter.close();
			}
		});
		convertTmp.setFont(new Font("Dialog", Font.BOLD, 16));
		convertTmp.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,
						null, null));
		convertTmp.setBounds(668, 295, 75, 25);
		frame.getContentPane().add(convertTmp);		
	}
}
