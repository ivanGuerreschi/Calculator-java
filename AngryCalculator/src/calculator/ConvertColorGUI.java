/* ===========================================================
 * Angry calculator : a free calculator for the Java(tm) platform
 * ===========================================================
 *
 * Project Info:  navicolt@gmail.com
 *
 * Copyright (C) 2016 Ivan Guerreschi
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
 * ConvertColorGUI.java
 * --------------------
 * Copyright (C) 2016 Ivan Guerreschi
 *
 * Original Author:  Ivan Guerreschi;
 * Contributor(s): 
 * 
 * Changes
 * -------
 */


package calculator;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class ConvertColorGUI {
	
	protected JFrame frame;
	
	private JTextField rTxt;
	private JTextField gTxt;
	private JTextField bTxt;
	private JTextField resultHexTxt;
	private JTextField hexTxt;
	private JTextField resultRgbTxt;
	
	private JLabel titleLabel;
	private JLabel rLbl;
	private JLabel hexLbl;
	private JLabel hexsLbl;
	private JLabel gLbl;
	private JLabel rgbLbl;
	private JLabel bLbl;
	private JButton rgbBtn;
	private JButton hexBtn;
    private JButton cancBtn;
    
    // message info
 	public void messageBox() {
 		JOptionPane.showMessageDialog(null,	"Enter valid value");
 	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConvertColorGUI window = new ConvertColorGUI();
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
	public ConvertColorGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBackground(Color.GRAY);
		frame.setTitle("Convertor Color");
		frame.setResizable(false);
		frame.setBounds(100, 100, 273, 319);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		titleLabel = new JLabel("Convert color");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		titleLabel.setBounds(10, 11, 165, 14);
		frame.getContentPane().add(titleLabel);
		
		rLbl = new JLabel("R");
		rLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rLbl.setHorizontalAlignment(SwingConstants.LEFT);
		rLbl.setBounds(10, 55, 46, 14);
		frame.getContentPane().add(rLbl);
		
		rTxt = new JTextField();
		rTxt.setToolTipText("255");
		rTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		rTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rTxt.setBounds(32, 50, 51, 31);
		frame.getContentPane().add(rTxt);
		rTxt.setColumns(10);
		
		gLbl = new JLabel("G");
		gLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		gLbl.setBounds(93, 55, 46, 14);
		frame.getContentPane().add(gLbl);
		
		gTxt = new JTextField();
		gTxt.setToolTipText("255");
		gTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		gTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		gTxt.setBounds(114, 50, 51, 31);
		frame.getContentPane().add(gTxt);
		gTxt.setColumns(10);
		
		bLbl = new JLabel("B");
		bLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bLbl.setBounds(175, 55, 46, 14);
		frame.getContentPane().add(bLbl);
		
		bTxt = new JTextField();
		bTxt.setToolTipText("255");
		bTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		bTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bTxt.setBounds(197, 50, 51, 31);
		frame.getContentPane().add(bTxt);
		bTxt.setColumns(10);
		
		hexLbl = new JLabel("Hex");
		hexLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		hexLbl.setBounds(10, 97, 46, 14);
		frame.getContentPane().add(hexLbl);
		
		resultHexTxt = new JTextField();
		resultHexTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		resultHexTxt.setEditable(false);
		resultHexTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		resultHexTxt.setBounds(65, 92, 122, 31);
		frame.getContentPane().add(resultHexTxt);
		resultHexTxt.setColumns(10);
		
		hexsLbl = new JLabel("Hex#");
		hexsLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		hexsLbl.setBounds(10, 155, 73, 14);
		frame.getContentPane().add(hexsLbl);
		
		hexTxt = new JTextField();
		hexTxt.setToolTipText("FFFFFF");
		hexTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		hexTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		hexTxt.setBounds(65, 150, 122, 31);
		frame.getContentPane().add(hexTxt);
		hexTxt.setColumns(10);
		
		rgbBtn = new JButton("RGB");
		rgbBtn.setToolTipText("Hex -> RGB");
		rgbBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		rgbBtn.addActionListener(new ActionListener() {
			/**
			 * convert color Hex in RGB
			 */
			public void actionPerformed(ActionEvent e) {
				ConvertHexRgb convertHexRgb;
				String input = hexTxt.getText();
				if (!input.equals("")) {
					convertHexRgb = new ConvertHexRgb(input);
					resultRgbTxt.setText(convertHexRgb.convert());
				} else
					messageBox();
			}
		});
		rgbBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rgbBtn.setBounds(102, 234, 70, 30);
		frame.getContentPane().add(rgbBtn);
		
		rgbLbl = new JLabel("RGB");
		rgbLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rgbLbl.setBounds(10, 197, 46, 14);
		frame.getContentPane().add(rgbLbl);
		
		resultRgbTxt = new JTextField();
		resultRgbTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		resultRgbTxt.setEditable(false);
		resultRgbTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		resultRgbTxt.setBounds(65, 192, 122, 31);
		frame.getContentPane().add(resultRgbTxt);
		resultRgbTxt.setColumns(10);
		
		hexBtn = new JButton("HEX");
		hexBtn.setToolTipText("RGB -> Hex");
		hexBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		hexBtn.addActionListener(new ActionListener() {
			/**
			 * convert color RGB in Hex
			 */
			public void actionPerformed(ActionEvent e) {
				ConvertRgbHex convertRgbHex;				
				String inputR = rTxt.getText();
				String inputG = gTxt.getText();
				String inputB = bTxt.getText();				
				if (!inputR.equals("") && !inputG.equals("") && !inputB.equals("")) {
					convertRgbHex = new ConvertRgbHex(inputR + "," + inputG + "," + inputB);
					resultHexTxt.setText("#" + convertRgbHex.convert());
				} else
					messageBox();
			}
		});
		hexBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		hexBtn.setBounds(178, 234, 70, 30);
		frame.getContentPane().add(hexBtn);
		
		cancBtn = new JButton("CANC");
		cancBtn.setToolTipText("Delete all");
		cancBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		cancBtn.addActionListener(new ActionListener() {
			/**
			 * all cancel
			 */
			public void actionPerformed(ActionEvent arg0) {
				rTxt.setText("");
				gTxt.setText("");
				bTxt.setText("");
				resultHexTxt.setText("");
				hexTxt.setText("");
				resultRgbTxt.setText("");
			}
		});
		cancBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cancBtn.setBounds(10, 234, 70, 30);
		frame.getContentPane().add(cancBtn);
	}
}
