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
 * Factorial.java
 * --------------------
 * Copyright (C) 2014 Ivan Guerreschi
 *
 * Original Author:  Ivan Guerreschi;
 * Contributor(s): 
 * 
 * Changes
 * -------
 * 
 * Date changes 16/10/2014
 * Separate class factorial calculation from GUI
 * Date changes 21/11/2014
 * Add multithreading 
 * Date changes 24/11/2014
 * New method to calculate the factorial
 */

package calculator;

import java.math.BigInteger;

import javax.swing.JTextArea;

/**
 *  Class for calculate factorial 
 * 
 * @author Ivan Guerreschi
 *   
 */
public class Factorial implements Runnable {
	
	private JTextArea jTextArea = null;
	private int number = 0;
	
	/**
	 * constructor
	 * 
	 * @param jTextArea text area result
	 * @param number input number 
	 */
	public Factorial(JTextArea jTextArea, int number) {
		this.jTextArea = jTextArea;
		this.number = number;
	}

	/**
	 * method for calculating the factorial
	 * @param n input number
	 * @return factorial factorial number
	 */
	private BigInteger factorial(int n) {
		 BigInteger fact = new BigInteger("1");
	       for (int i = 1; i <= n; i++) 
	           fact = fact.multiply(new BigInteger(i + ""));
	       return fact;	 
	}

	@Override
	public void run() {
		jTextArea.append(number + ": " + factorial(number) + "\n\n");		
	}

}
