package Utils;

import java.util.Arrays;

public class Utils {

	/**
	 * Get the max value from a Array
	 * @param array
	 * @return max value of the array
	 */
	public static int maxValue(int array[]) {
		Arrays.sort(array);
		return array[array.length-1];
	}
}
