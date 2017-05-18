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
 * Neon.java
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

/**
 * Class for calculate neon number
 * 
 * @author Ivan Guerreschi
 *
 */
public class Neon {
	
	private int number;

	/**
	 * constructor
	 * 
	 * @param number is inpput number
	 */
	public Neon(int number) {
		super();
		this.number = number;
	}
	
	/**
	 * method for calculate neon number
	 * 
	 * @return boolean true if neon number
	 */
	public boolean isNeon() {	
		int tot = 0;
		String numberString = Integer.toString(number * number);
		int ln = numberString.length();
		char numbers[] = new char[ln];
		for (int i = 0; i < ln; i++) { 
		    numbers[i] = numberString.charAt(i);
		    tot += Character.digit(numbers[i], 10);
		} 
		if (tot == number)
		    return true;
		else
		    return false;		
	}

}
