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
 * Perfect.java
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
 * Class for calculate perfect number
 * 
 * @author Ivan Guerreschi
 *
 */
public class Perfect {
	
	private int number;

	/**
	 * costructor
	 *  
	 * @param number input number
	 */
	public Perfect(int number) {
		super();
		this.number = number;
	}
	
	/**
	 * method for calculate perfect number
	 * 
	 * @return boolean true if perfect number
	 */
	public boolean isPerfect() {
		int s = 0;
		for (int i = 1; i < number; i++) 
			if (number % i == 0)
				s = s + i;
			if (s == number)
				return true;
			else 
				return false;		
	}

}
