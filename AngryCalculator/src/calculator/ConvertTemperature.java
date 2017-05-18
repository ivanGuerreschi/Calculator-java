/* ===========================================================
 * Angry calculator : a free calculator for the Java(tm) platform
 * ===========================================================
 *
 * Project Info:  navicolt@gmail.com
 *
 * Copyright (C) 2017 Ivan Guerreschi
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
 * ConvertTemperature.java
 * --------------------
 * Copyright (C) 2017 Ivan Guerreschi
 *
 * Original Author:  Ivan Guerreschi;
 * Contributor(s): 
 * 
 * Changes
 * -------
 */

package calculator;

/**
 * Class for converts the temperature
 * 
 * @author Ivan Guerreschi
 *
 */
public class ConvertTemperature {

	private double temp = 0;
	private String selectCF;
	
	/**
	 * Constructor with two parameters
	 * 
	 * @param temp input temperature
	 * @param selectCF input select converter Celsius or Fahrenheit
	 */
	public ConvertTemperature(double temp, String selectCF) {
		this.temp = temp;
		this.selectCF = selectCF;
	}
	
	/**
	 * Method that converts the temperature
	 * 
	 * @return temp converted temperature
	 */
	public double temperature() {
		if (selectCF.equals("f")) 
		    return temp = (temp * 1.8) + 32; //	from Celsius to Fahrenheit	    
		else      
		    return temp = (temp - 32) / 1.8; // from Fahrenheit to Celsius		
	}
	
}
