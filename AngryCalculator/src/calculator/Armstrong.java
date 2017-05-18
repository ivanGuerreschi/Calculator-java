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
 * Armstrong.java
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
 * Class for calculate armstrong number
 * 
 * @author Ivan Guerreschi
 *
 */
public class Armstrong {
	
	private int number;
	
	/**
	 * constructor
	 * 
	 * @param number input number
	 */
	public Armstrong(int number) {
		super();
		this.number = number;
	}	

	/**
	 * method for calculate Armstrong number
	 * 
	 * @return boolean true if Armstrong number
	 */
	public boolean isArmstrong() {
		int tot = 0;		
		String numberString = Integer.toString(number);
		int ln = numberString.length();
		char numbers[] = new char[ln];
		for (int i = 0; i < ln; i++) { 
		    numbers[i] = numberString.charAt(i);
		    tot += Math.pow(Character.digit(numbers[i], 10), ln);
		} 
		if (tot == number)
		    return true;
		else
		    return false;
	}
}
