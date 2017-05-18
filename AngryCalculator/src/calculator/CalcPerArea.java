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
 * CalcPerArea.java
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
 * Class containing methods for calculation of 
 * perimeter and area
 * 
 * @author Ivan Guerreschi
 *
 */
public class CalcPerArea {
	
	/**
	 * calculate perimeter square
	 * 
	 * @param l side
	 * @return double perimeter square
	 */
	public double perSqaere(double l) {
		return 4 * l;
	}
	
	/**
	 * calculate area square
	 * 
	 * @param l side
	 * @return double area square
	 */
	public double areaSquare(double l) {
		return Math.pow(l, 2);
	}
	
	/**
	 * calculate perimeter rectangle
	 * 
	 * @param a width
	 * @param b height
	 * @return double perimeter rectangle
	 */
	public double perRectangle(double a, double b) {
		return 2 * (a + b);
	}
	
	/**
	 * calculate area rectangle
	 * 
	 * @param a width
	 * @param b height
	 * @return double area rectangle
	 */
	public double areaRectangle(double a, double b) {
		return b * a;
	}
	
	/**
	 * calculate perimeter triangle
	 * 
	 * @param a side
	 * @param b side
	 * @param c side	
	 * @return double perimeter triangle
	 */
	public double perTriangle(double a, double b, double c) {
		return a + b + c;
	}
	
	/**
	 * calculate area triangle
	 * 
	 * @param a width 
	 * @param b height
	 * @return double area triangle
	 */
	public double areaTriangle(double a, double b) {
		return (b * a) / 2;
	}
	
	/**
	 * calculate perimeter parallelogram
	 * 
	 * @param a side
	 * @param b side
	 * @return double perimeter parallelogram
	 */
	public double perParallelogram(double a, double b) {
		return this.perRectangle(a, b);
	}
	
	/**
	 * calculate area parallelogram
	 * 
	 * @param a side 
	 * @param b side
	 * @return double area parallelogram
	 */
	public double areaParallelogram(double a, double b) {
		return this.areaRectangle(a, b);
	}
	
	/**
	 * calculate perimeter rhombus
	 * 
	 * @param l side
	 * @return double perimeter rhombus
	 */
	public double perRhombus(double l) {
		return this.perSqaere(l);
	}
	
	/**
	 * calculate area rhombus
	 * 
	 * @param a diagonal higher
	 * @param b diagonal lower
	 * @return double area rhombus
	 */
	public double areaRhombus(double a, double b) {
		return this.areaTriangle(a, b);
	}
	
	/**
	 * calculate perimeter trapezoid
	 * 
	 * @param a side 
	 * @param b side
	 * @param c side
	 * @param d side
	 * @return double perimeter trapezoid
	 */
	public double perTrapezoid(double a, double b, double c, double d) {
		return a + b + c + d;
	}
	
	/**
	 * calculate area trapezoid
	 * 
	 * @param a side higher
	 * @param b side lower
	 * @param c height
	 * @return double area trapezoid
	 */
	public double areaTrapezoid(double a, double b, double c) {
		return ((c + b)) * a / 2;
	}
	
	/**
	 * calculate perimeter circle
	 * 
	 * @param r radius
	 * @return double perimeter circle
	 */
	public double perCircle(double r) {
		return 2 * Math.PI * r;
	}
	
	/**
	 * calculate area circle
	 * 
	 * @param r radius
	 * @return double area circle
	 */
	public double areaCircle(double r) {
		return Math.PI * Math.pow(r, 2);
	}

}
