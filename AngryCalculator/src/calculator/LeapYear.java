/* ===========================================================
 * Angry calculator : a free calculator for the Java(tm) platform
 * ===========================================================
 *
 * Project Info:  navicolt@gmail.com
 *
 * Copyright (C) 2015 Ivan Guerreschi
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
 * LeapYear.java
 * --------------------
 * Copyright (C) 2015 Ivan Guerreschi
 *
 * Original Author:  Ivan Guerreschi;
 * Contributor(s): 
 * 
 * Changes
 * ------- 
 */
package calculator;

/**
 * Class to determine if a year is a leap year or not
 * 
 * @author Ivan Guerreschi
 *
 */
public class LeapYear {
	private int year;	
	
	/**
	 * constructor
	 * 
	 * @param year year to check
	 */
	public LeapYear(int year) {
		this.year = year;
	}
	
	/**
	 * boolean method to determine if a year is a leap year or not
	 * 
	 * @return true if year is leap, false is year leap is not 
	 */
	public boolean isLeapYear() {
		if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) 
			return true; 
	    else 
	    	return false;	 
	}
}
