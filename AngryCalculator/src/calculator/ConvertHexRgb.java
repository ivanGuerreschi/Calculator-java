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
 * ConvertHexRgb.java
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
 * Class for convert Hex color to RGB color
 * 
 * @author Ivan Guerreschi
 *
 */
public class ConvertHexRgb {

	private String colorHex;
	private String[] pieces;

	/**
	 * 
	 * @param colorHex input color hex
	 */
	public ConvertHexRgb(String colorHex) {
		this.colorHex = colorHex;
	}

	/**
	 * method for substring string
	 * 
	 * @return String[] array string
	 */
	private String[] substring() {
		pieces = new String[3];
		for (int i = 0, j = 0; i < 6; i += 2, j++)
			pieces[j] = colorHex.substring(i, i + 2);
		return pieces;
	}

	/**
	 * method for convert number RGB to Hex
	 * 
	 * @return String
	 */
	public String convert() {
		String colorRgb = "";
		int[] colorDecimal = new int[3];
		substring();
		for (int i = 0; i < 3; i++) {
			colorDecimal[i] = Integer.parseInt(pieces[i], 16);
			colorRgb += colorDecimal[i];
		}
		return colorRgb;
	}
}
