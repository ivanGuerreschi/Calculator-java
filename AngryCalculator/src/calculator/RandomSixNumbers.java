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
 * RandomSixNumbers.java
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

import java.util.Random;

import javax.swing.JOptionPane;

/**
 * Class generates six random numbers
 * 
 * @author Ivan Guerreschi
 * 
 */
public class RandomSixNumbers {

	/**
	 * generates six random numbers from 1 to 90
	 */
	public void numbers() {

		int[] doubleNumbers = new int[7];
		int number = 0;
		int i = 0;

		for (i = 0; i < 6; i++) {

			Random random = new Random();

			number = random.nextInt(91);

			// checks if there are no duplicate numbers
			for (int k = 1; k < doubleNumbers.length; k++) {
				if (number == doubleNumbers[k])
					number += 1;
			}

			// check that it does not generate numbers greater than 90 and less
			// than 1
			if (number == 91)
				number -= 1;

			JOptionPane.showMessageDialog(null, "Numbers " + (i + 1) + " = "
					+ number, "Random six numbers", JOptionPane.PLAIN_MESSAGE);

			doubleNumbers[i + 1] = number;

		}

	}

}
