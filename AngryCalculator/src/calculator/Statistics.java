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
 * Statistics.java
 * --------------------
 * Copyright (C) 2014 Ivan Guerreschi
 *
 * Original Author:  Ivan Guerreschi;
 * Contributor(s): 
 * 
 * Changes
 * -------
 * Date changes 16/11/2014
 * Fixed bug on calculation of double values in the statistics program
 */

package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class for calculating the statistical base
 * 
 * @author Ivan Guerreschi
 * 
 */
public class Statistics {

	private ArrayList<Double> numbersSubmissions = new ArrayList<Double>();
	private ArrayList<Double> numbersStrDev = new ArrayList<Double>();
	private Set<Double> numbersDouble = new TreeSet<Double>();
	private double sum = 0.0;
	private double more = 0.0;
	private double fewer = 0.0;
	private double average = 0.0;
	private double sumSq = 0.0;

	/**
	 * adds a value to the list
	 * 
	 * @param number input number
	 */
	public void enterNumber(double number) {
		numbersSubmissions.add(number);
	}

	/**
	 * numbers values included
	 * 
	 * @return int numbers values included
	 */
	public int numbersValues() {
		return numbersSubmissions.size();

	}

	/**
	 * sum of the squares
	 * 
	 * @return double sum sum of the squares
	 */
	public double sumSquares() {
		for (Double tmp : numbersSubmissions)
			sumSq += Math.pow(tmp, 2);
		return sumSq;
	}

	/**
	 * method for sum the numbers
	 * 
	 * @return sum the numbers
	 */
	public double sum() {
		for (Double tmp : numbersSubmissions)
			sum += tmp;
		return sum;
	}

	/**
	 * method to calculate the average
	 * 
	 * @return double average values
	 */
	public double average() {
		average = sum / numbersSubmissions.size();
		return average;
	}

	/**
	 * 
	 * method for the calculation of the maximum value
	 * 
	 * @return double maximum value
	 */
	public double maximum() {
		double tmpMgr = 0;
		for (Double tmp : numbersSubmissions) {
			if (tmp > tmpMgr)
				tmpMgr = tmp;
		}
		return more = tmpMgr;
	}

	/**
	 * 
	 * method for the calculation of the minimum value
	 * 
	 * @return double minimum value
	 */
	public double minimum() {
		double tmpMnr = more;
		for (Double tmp : numbersSubmissions) {
			if (tmp < tmpMnr)
				tmpMnr = tmp;
		}
		return fewer = tmpMnr;
	}

	/**
	 * difference between major and minor number
	 * 
	 * @return double difference number
	 */
	public double difference() {
		return more - fewer;
	}

	/**
	 * method to find how many values ​​are repeated
	 * 
	 * @return double repeated values
	 */
	public double valDou() {
		Collections.sort(numbersSubmissions);
		numbersSubmissions.add(0.0);
		for (int i = 0; i < numbersSubmissions.size() - 1; i++) {
			if (numbersSubmissions.get(i).equals(numbersSubmissions.get(i + 1))) 
				numbersDouble.add(numbersSubmissions.get(i));
		}
		return numbersDouble.size();
	}

	/**
	 * retrieves the double value
	 * 
	 * @return String double value
	 */
	public String numDou() {
		String num = "";
		Iterator<Double> it = numbersDouble.iterator();
		while (it.hasNext()) {
			num += it.next() + " ";
		}
		return num;
	}

	/**
	 * calculate the standard deviation
	 * 
	 * @return standard deviation
	 */
	public double strdDev() {
		numbersSubmissions.remove(numbersSubmissions.size() - 1); // remove last
																	// element
																	// list
		for (int i = 0; i < numbersSubmissions.size(); i++)
			numbersStrDev.add(Math.pow(numbersSubmissions.get(i) - average, 2));
		Double strDev = 0.0;
		for (Double tmp : numbersStrDev)
			strDev += tmp;
		return Math.sqrt(strDev / numbersStrDev.size());
	}
	
	/**
	 * search quantity numbers present
	 * 
	 * @param num input number
	 * @return quantity numbers present
	 */
	public int numberSearch(double num) {
		int quantity = 0;
		for (Double i : numbersSubmissions ) {
			if (i == num)
				quantity++;
		}
		return quantity;
	}

	/**
	 * reset variables
	 */
	public void reset() {
		numbersSubmissions.clear();
		numbersDouble.clear();
		numbersStrDev.clear();
		more = 0.0;
		fewer = 0.0;
		average = 0.0;
		sum = 0.0;
		sumSq = 0.0;
	}
}
