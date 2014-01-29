package Sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;

import Helper.CountingSorter;
import Helper.Sorter;

public class QuicksortMedian3 extends CountingSorter implements Sorter
{
	private int[] array;
	private int length;

	public void sort(int[] array)
	{
		this.array = array;
		length = array.length;
		quicksort(0, length - 1);
	}

	private void quicksort(int low, int high)
	{
		incrementRekursionDepth();
		int i = low, j = high;

		// comparison element 
		// is median of the array values with highest, lowest and middle index

		int middle = (low + high) / 2;
		int comparisonElement;
		if (array[c(middle)] < array[c(high)] && array[c(middle)] > array[c(low)])
		{
			comparisonElement = array[c(middle)];
		} else if (array[c(middle)] > array[c(high)])
		{
			comparisonElement = array[c(high)];
		} else
		{
			comparisonElement = array[c(low)];
		}

		// splitting
		while (i <= j)
		{
			while (array[c(i)] < comparisonElement)
				i++;
			while (array[c(j)] > comparisonElement)
				j--;
			if (i <= j)
			{
				exchange(i, j);
				i++;
				j--;
			}
		}

		// recursion
		if (low < j)
			quicksort(low, j);
		if (i < high)
			quicksort(i, high);
	}

	/**
	 * swap two elements in array
	 * 
	 * @param i first element to be swapped
	 * @param j second element to be swapped
	 */
	private void exchange(int i, int j)
	{
		int temp = array[c(i)];
		array[c(i)] = array[c(j)];
		array[c(j)] = temp;
	}

}