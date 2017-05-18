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
 * FileRecord.java
 * --------------------
 * Copyright (C) 2014 Ivan Guerreschi
 *
 * Original Author:  Ivan Guerreschi;
 * Contributor(s): 
 * 
 * Changes
 * -------
 * 
 */

package calculator;

/**
 * Class that retrieves the values ​​of the input the name and constant
 * 
 * @author Ivan Guerreschi
 * 
 */
public class FileRecord {

	private String nameConstant = "";
	private String constant = "";

	/**
	 * empty constructor
	 */
	public FileRecord() {

		this("", "");
	}

	/**
	 * manufacturer with your parameters to derive the input
	 * 
	 * @param nameConstant name constant 
	 * @param constant value constant 
	 */
	public FileRecord(String nameConstant, String constant) {

		this.setNameConstant(nameConstant);
		this.setConstant(constant);
	}

	/**
	 * method get name constant
	 * 
	 * @return input name
	 */
	public String getNameConstant() {
		return nameConstant;
	}

	/**
	 * method set name constant
	 * 
	 * @param nameConstant name constant
	 */
	public void setNameConstant(String nameConstant) {
		this.nameConstant = nameConstant;
	}

	/**
	 * method get constant
	 * 
	 * @return input constant
	 */
	public String getConstant() {
		return constant;
	}

	/**
	 * method set constant
	 * 
	 * @param constant set constant 
	 */
	public void setConstant(String constant) {
		this.constant = constant;
	}

}
