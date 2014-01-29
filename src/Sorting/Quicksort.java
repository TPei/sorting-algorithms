package Sorting;

import Helper.CountingSorter;
import Helper.Sorter;

public class Quicksort extends CountingSorter implements Sorter {
	private int[] array;
	private int length;

	/**
	 * sort an array
	 * @param array array to be sorted
	 */
	public void sort(int[] array) {
		this.array = array;
		length = array.length;
		quicksort(0, length - 1);
	}

	/**
	 * quicksort alogrithm
	 * @param low lower boundary of array part to be quicksorted
	 * @param high upper boundary of array part to be quicksorted
	 */
	private void quicksort(int low, int high) {
		incrementRekursionDepth();
		int i = low, j = high;

		// pick middle element as comparison element
		int comparisonElement = array[c((low + high) / 2)];

		// splitting
		while (i <= j) {
			while (array[c(i)] < comparisonElement)
				i++;
			while (array[c(j)] > comparisonElement)
				j--;
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
		}

		// recursive quicksort call
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}

	/**
	 * swap elements in array
	 * @param i first element to swap
	 * @param j second element to swap
	 */
	private void exchange(int i, int j) {
		int temp = array[c(i)];
		array[c(i)] = array[c(j)];
		array[c(j)] = temp;
	}

}