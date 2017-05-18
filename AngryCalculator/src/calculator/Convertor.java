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
 * Convertor.java
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
 * Class for conversions
 * 
 * @author ivan
 *
 */
public class Convertor {
	private double input = 0.0;
	private int inputComboBox = 0;
	private int resultComboBox = 0;

	/**
	 * constructor with 3 parameters
	 * 
	 * @param input input value
	 * @param inputComboBox selected value
	 * @param resultComboBox selected value
	 */
	public Convertor(double input, int inputComboBox, int resultComboBox) {
		this.input = input;
		this.inputComboBox = inputComboBox;
		this.resultComboBox = resultComboBox;		
	}

	/**
	 * method for conversions
	 * @return double converted value
	 * 0 : Byte, 1 : Kilobyte, 2 : Megabyte, 3 : Gigabyte, 4 : Terabyte
	 */
	public double calcConvertor() {
	
		if (inputComboBox == resultComboBox)
			return input;

		// byte
		else if ((inputComboBox == 0) && (resultComboBox == 1))
			return input  / 1024;

		else if ((inputComboBox == 0) && (resultComboBox == 2))
			return input / Math.pow(1024, 2);

		else if ((inputComboBox == 0) && (resultComboBox == 3))
			return input / Math.pow(1024, 3);

		else if ((inputComboBox == 0) && (resultComboBox == 4))
			return input / Math.pow(1024, 4);
		

		// kilobyte
		else if ((inputComboBox == 1) && (resultComboBox == 0))
			return input * 1024;

		else if ((inputComboBox == 1) && (resultComboBox == 2))
			return input / 1024;

		else if ((inputComboBox == 1) && (resultComboBox == 3))
			return input / Math.pow(1024, 2);

		else if ((inputComboBox == 1) && (resultComboBox == 4))
			return input / Math.pow(1024, 3);		

		// megabyte
		else if ((inputComboBox == 2) && (resultComboBox == 0))
			return input * Math.pow(1024, 2);

		else if ((inputComboBox == 2) && (resultComboBox == 1))
			return input * 1024;

		else if ((inputComboBox == 2) && (resultComboBox == 3))
			return input / 1024;

		else if ((inputComboBox == 2) && (resultComboBox == 4))
			return input / Math.pow(1024, 2);		

		// gigabyte
		else if ((inputComboBox == 3) && (resultComboBox == 0))
			return input * Math.pow(1024, 3);

		else if ((inputComboBox == 3) && (resultComboBox == 1))
			return input * Math.pow(1024, 2);

		else if ((inputComboBox == 3) && (resultComboBox == 2))
			return input * 1024;

		else if ((inputComboBox == 3) && (resultComboBox == 4))
			return input / 1024;
		
		// terabyte
		else if ((inputComboBox == 4) && (resultComboBox == 0))
			return input * Math.pow(1024, 4);

		else if ((inputComboBox == 4) && (resultComboBox == 1))
			return input * Math.pow(1024, 3);

		else if ((inputComboBox == 4) && (resultComboBox == 2))
			return input * Math.pow(1024, 2);

		else if ((inputComboBox == 4) && (resultComboBox == 3))
			return input * 1024;
		
		return 0;
	}

}
