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
 * DownloadFile.java
 * --------------------
 * Copyright (C) 2015 Ivan Guerreschi
 *
 * Original Author:  Ivan Guerreschi;
 * Contributor(s): 
 * 
 * Changes
 * -------
 * 
 */

package calculator;

import java.util.Formatter;

/**
 * Class to calculate the download file
 * 
 * @author Ivan Guerreschi
 * 
 */
public class DownloadFile {
	
	private double dimension = 0.0;
	private double speed = 0.0;
	private Formatter formatter;
	
	/**
	 * constructor
	 * 
	 * @param dimension dimension file 
	 * @param speed speed connection 
	 */
	public DownloadFile(double dimension, double speed) {
		this.dimension = dimension;
		this.speed = speed;
	}
		
	/**
	 * method that calculates the download time
	 * 
	 * @return string time download
	 */
	public String time() {
		formatter = new Formatter();
		double calcTime = (dimension / speed) * 8;
		return formatter.format("%s:M %s:S",Math.floor(calcTime / 60), Math.floor(calcTime % 60)).toString();	
	}
}
