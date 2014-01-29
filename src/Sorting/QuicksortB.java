/*
 * Als Ansatz der Verbesserung von Quicksort habe ich zwei Punkte gewahlt
 * 1. Voruberprufung ob das Teilarray bereits sortiert ist
 * 2. Benutzung von Insertionsort bei sehr kleinen Teilarrays
 * 
 *  1. Uberprufung ob Teilarray bereits sortiert ist bei jedem Rekursionsaufruf
 *  2. Uberprufung der Teillange vor neuem Rekursionsaufruf, bei length <= 20, Insertionsort
 *  
 *  Die Effizienz meines Quicksorts ist bei der Zahl der Schritte 
 *  von teilweise kaum merklich (1000 unsortierte Elemente)
 *  bis teils über 50% weniger Schritte (1000 Elemente, bereits absteigend sortiert) gesunken.
 *  Die Rekursionstiefe lag im Schnitt bei < 1/10. 
 */
package Sorting;

import Helper.CountingSorter;
import Helper.Sorter;

public class QuicksortB extends CountingSorter implements Sorter
{
	private int[] array;
	private int length;

	@Override
	public void sort(int[] array)
	{
		this.array = array;
		length = array.length;

		quicksort(0, length - 1);

	}

	/**
	 * sort an array using the quicksort technique (divide and conquer)
	 * 
	 * @see https://en.wikipedia.org/wiki/Quicksort
	 * 
	 * @param low start of part to be sorted
	 * @param high end of part to be sorted
	 */
	private void quicksort(int low, int high)
	{
		incrementRekursionDepth();

		// if the given part of the array is already sorted, we're done here
		if (!isSorted(array, low, high))
		{
			int i = low, j = high;

			// comparision element x
			int x = array[c((low + high) / 2)];

			// splitting
			while (i <= j)
			{
				while (array[c(i)] < x)
					i++;
				while (array[c(j)] > x)
					j--;
				if (i <= j)
				{
					exchange(i, j);
					i++;
					j--;
				}
			}
			// if (lo<j) quicksort(lo, j);
			// if (i<hi) quicksort(i, hi);
			// insertionsort(lo, hi);
			// recursion; if length <= 20 => insertionsort
			if (low < j)
				if (j - low <= 20)
					insertionsort(low, j);
				else
					quicksort(low, j);
			if (i < high)
				if (high - i <= 20)
					insertionsort(i, high);
				else
					quicksort(i, high);
		}
	}

	/**
	 * swaps two elements in array a
	 * 
	 * @param i first element
	 * @param j second element
	 */
	private void exchange(int i, int j)
	{
		int temp = array[c(i)];
		array[c(i)] = array[c(j)];
		array[c(j)] = temp;
	}

	/**
	 * check if array is sorted
	 * 
	 * @param array array to check if it is sorted
	 * @return boolean whether or not the array is sorted
	 */
	private boolean isSorted(int[] array)
	{
		return isSorted(array, 0, array.length - 1);
	}

	/**
	 * checks if array is sorted between a starting point and an end point
	 * 
	 * @param array array of which to check if part is sorted
	 * @param low start of allegedly sorted part
	 * @param high end of allegedly sorted part
	 * @return boolean whether or not the given part of array is sorted
	 */
	private boolean isSorted(int[] array, int low, int high)
	{
		// keep checking as long as a[i+1] is >= a[i]
		for (int i = low; i < high - 1; i++)
			if (array[c(i + 1)] < array[c(i)])
				return false;
		return true;
	}

	/**
	 * insertionsort a part of an array
	 * 
	 * @param low start of part to be sorted using insertionsort
	 * @param high end of part to be sorted using insertionsort
	 */
	public void insertionsort(int low, int high)
	{
		int i, j, t;
		for (i = low; i <= high; i++)
		{
			j = i;
			t = array[c(j)];
			while (j > 0 && array[j - 1] > t)
			{
				array[c(j)] = array[c(j - 1)];
				j--;
			}
			array[c(j)] = t;
		}
	}

}