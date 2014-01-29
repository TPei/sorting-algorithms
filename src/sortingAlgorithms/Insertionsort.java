package sortingAlgorithms;

import Helper.CountingSorter;
import Helper.Sorter;

public class Insertionsort extends CountingSorter implements Sorter {
	private int[] array;
	private int length;

	/**
	 * sort an array
	 * @param array array to be sorted
	 */
	public void sort(int[] array) {
		this.array = array;
		length = array.length;
		insertionsort();
	}

	/**
	 * Insertionsort 
	 * two logical parts of array (sorted, unsorted) takes the
	 * first element of the unsorted part moves it to the right position of the
	 * sorted part
	 */
	private void insertionsort() {
		int i, j, temporaryElement;

		for (i = 1; i < length; i++) {
			j = i;

			// save the element to be moved
			temporaryElement = array[countStep(j)];

			// find the right position to move the element to
			while (j > 0 && array[j - 1] > temporaryElement) {
				// move element to the right to make space for element to be
				// sorted
				array[countStep(j)] = array[countStep(j - 1)];
				j--;
			}

			// move temp element to the right position of sorted array part
			array[countStep(j)] = temporaryElement;
		}
	}
}
