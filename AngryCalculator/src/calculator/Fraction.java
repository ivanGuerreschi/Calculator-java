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
 * Fraction.java
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
 * Class for calculating fractions
 * 
 * @author ivan
 * 
 */
public class Fraction {

	private double num = 0.0; // numerator
	private double den = 1.0; // denominator

	/**
	 * empty constructor
	 */
	public Fraction() {
		this(0, 1);
	}

	/**
	 * constructor with 2 parameters
	 * 
	 * @param num numerator
	 * @param den denominator
	 */
	public Fraction(double num, double den) {
		this.num = num;
		if (den != 0)
			this.den = den;
		else
			this.den = 1;
	}

	/**
	 * constructor with 1 parameters
	 * 
	 * @param num numerator
	 */
	public Fraction(int num) {
		this(num, 1);
	}

	/**
	 * control over primes
	 * 
	 * @return numerator
	 */
	public double getNum() {

		if (num % 2 == 0 && den % 2 == 0) {
			num = num / 2;
			den = den / 2;
		}

		else if (num % 3 == 0 && den % 3 == 0) {
			num = num / 3;
			den = den / 3;
		}

		else if (num % 5 == 0 && den % 5 == 0) {
			num = num / 5;
			den = den / 5;
		}

		else if (num % 7 == 0 && den % 7 == 0) {
			num = num / 7;
			den = den / 7;
		}

		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}

	/**
	 * control over primes
	 * 
	 * @return denominator
	 */
	public double getDen() {

		if (num % 2 == 0 && den % 2 == 0) {
			num = num / 2;
			den = den / 2;
		}

		else if (num % 3 == 0 && den % 3 == 0) {
			num = num / 3;
			den = den / 3;
		}

		else if (num % 5 == 0 && den % 5 == 0) {
			num = num / 5;
			den = den / 5;
		}

		else if (num % 7 == 0 && den % 7 == 0) {
			num = num / 7;
			den = den / 7;
		}

		return den;
	}

	public void setDen(double den) {
		this.den = den;
	}

	/**
	 * calculates the sum 2 fractions
	 * 
	 * @param otherFraction first fraction 
	 * @return fraction sum 
	 */
	public Fraction sum(Fraction otherFraction) {

		return new Fraction(num * otherFraction.den + den * otherFraction.num,
				den * otherFraction.den);
	}

	/**
	 * calculated multiplication 2 fractions
	 * 
	 * @param otherFraction first fraction
	 * @return fraction multiplying
	 */
	public Fraction mult(Fraction otherFraction) {

		return new Fraction(num * otherFraction.num, den * otherFraction.den);
	}

	/**
	 * calculates division 2 fractions
	 * 
	 * @param otherFraction first fraction
	 * @return fraction division
	 */
	public Fraction div(Fraction otherFraction) {

		return new Fraction(num * otherFraction.den, den * otherFraction.num);
	}

	/**
	 * calculated subtracting fractions 2
	 * 
	 * @param otherFraction first fraction
	 * @return fraction subtracting
	 */
	public Fraction soct(Fraction otherFraction) {

		return new Fraction(num * otherFraction.den - den * otherFraction.num,
				den * otherFraction.den);
	}

}