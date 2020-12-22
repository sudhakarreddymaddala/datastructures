package ueb;

import java.util.Arrays;

/**
 * Tools for using an array.
 *
 * @author Mo, klk
 */
public class ArrayTools {
    /**
     * determines if a certain {@code value} is containing in a given {@code array}
     * and returns the position of the first occurrence.
     *
     * @param array the given array
     * @param value the value to look for
     * @return the position of the first occurrence of the value, if not contained
     *         -1
     * @throws IllegalArgumentException if the given array is {@code null}
     */
    public static int containsAt(int[] array, int value) {
        // TODO insert code that makes sense
        int index = 0;
        boolean found = false;
        if (array == null) {
            throw new IllegalArgumentException();
        }
        if (array.length == 0) {
            index = -1;
        }
        for (int i : array) {
            if (i == value) {
                found = true;
                return index;
            }
            index++;
        }
        if (found == false) {
            index = -1;
        }
        return index;
    }

    /**
     * deletes in a given array the element at position {@code idx}
     *
     * @param array the given array
     * @param idx   the position to delete at
     * @return a new array not containing the {@code idx}-th value
     * @throws IllegalArgumentException if the given array is {@code null} or the
     *                                  {@code idx} is invalid
     */

    public static int[] deleteElementAt(int[] array, int idx) {
        int[] anotherArray = new int[array.length - 1];
        for (int i = 0, k = 0; i < array.length; i++) {
            if (i == idx) {
//				continue;
                i++;
            }
            if (i != array.length) {
                anotherArray[k++] = array[i];
            }
        }
        return anotherArray;
    }

    /**
     * inserts in a given array the element at position {@code idx}
     *
     * @param array the given array
     * @param idx   the position to insert at
     * @param value the inserting value
     * @return a new array containing at {@code idx} the given {@code value}, null
     *         if invalid params
     * @throws IllegalArgumentException if the array is {@code null} or the
     *                                  {@code idx} is invalid
     */
    public static int[] insertElementAt(int[] array, int idx, int value) {
        // TODO insert code that makes sense
        int newArray[] = null;
        if (array == null || idx < 0 || idx > array.length) {
            throw new IllegalArgumentException();
        } else {
            newArray = new int[array.length + 1];
            int j = 0;
            for (int i = 0; i < newArray.length; i++) {
                if (i == idx) {
                    newArray[i] = value;
                } else {
                    newArray[i] = array[j];
                    j++;
                }
            }
        }
        return newArray;
    }

    /**
     * Gets the length of the longest array in given array.
     *
     * @param array 2-dimensional array to look in
     * @return length of longest array in given array, -1 if only
     *         {@code null}-values contained
     * @throws IllegalArgumentException if array is {@code null} or length of array
     *                                  is 0
     */
    public static int getLengthOfLongestArray(int[][] array) {
        int big = 0;
        int nullCount = 0;
        // TODO insert code that makes sense
        if (array == null) {
            big = -1;
        }
        if (array.length == 0) {
            big = 0;
        }
        for (int[] i : array) {
            if (i == null) {
                nullCount++;
            }
            if (nullCount == array.length) {
                return -1;
            }
            if (nullCount == 0) {
                int length = i.length;
                if (length > big) {
                    big = length;
                }
            }
        }
        return big;
    }
}
