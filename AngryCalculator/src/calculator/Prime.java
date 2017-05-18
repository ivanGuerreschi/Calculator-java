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
 * Prime.java
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
 * Class for calculate prime number
 * 
 * @author Ivan Guerreschi
 *
 */
public class Prime {
	
	private int number;

	/**
	 * costructor
	 *  
	 * @param number input number
	 */
	public Prime(int number) {
		super();
		this.number = number;
	}
	
	/**
	 * method for calculate prime number
	 * 
	 * @return boolean true if prime number
	 */
	public boolean isPrime() {
		if (number == 2) return true;
		if (number % 2 == 0) return false;
	    for(int i = 3; i * i <= number; i += 2) {
	        if(number % i == 0)
	            return false;
	    }
	    return true;
	}

}
