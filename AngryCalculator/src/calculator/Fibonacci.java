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
 * Fibonacci.java
 * --------------------
 * Copyright (C) 2014 Ivan Guerreschi
 *
 * Original Author:  Ivan Guerreschi;
 * Contributor(s): 
 * 
 * Changes
 * -------
 * Date changes 16/10/2014
 * Separate class fibonacci calculation from GUI
 * Date changes 21/11/2014
 * Add multithreading 
 * Date 24/11/2014
 * New efficient method uses recursion 
 */

package calculator;

import javax.swing.JTextArea;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *  Class for calculate fibonacci 
 * 
 * @author Ivan Guerreschi
 *   
 */
public class Fibonacci implements Runnable {

	private JTextArea jTextArea = null;
	private int number = 0;
	
	/**
	 * constructor
	 * 
	 * @param jTextArea text area result
	 * @param number input number 
	 */
	public Fibonacci(JTextArea jTextArea, int number) {
		this.jTextArea = jTextArea;
		this.number = number;
	}
	
	private static ArrayList<BigInteger> fibCache = new ArrayList<BigInteger>();
	
	static {
		fibCache.add(BigInteger.ZERO);
		fibCache.add(BigInteger.ONE);
	}
	
	/**
	 * method uses recursion for calculate the fibonacci series
	 * 
	 * @param n input number
	 * @return fibonacci result
	 */
	private BigInteger fibonacci(int n) {		
		if (n >= fibCache.size())
			fibCache.add(n, fibonacci(n-1).add(fibonacci(n-2)));        
       	return fibCache.get(n);
	}            
	
	@Override
	public void run() {
		jTextArea.append(number + ": " + fibonacci(number) + "\n\n" );		
	}

}
