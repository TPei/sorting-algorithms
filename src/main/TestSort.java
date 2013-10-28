package main;

import Sorting.Insertionsort;
import Sorting.Quicksort;

public class TestSort
{
	int length;
	int[] unsorted;
	int[] unsortedCopy;
	
	public TestSort(int length)
	{
		this.length = length;
		
		int arrayLength = length;
		unsorted = new int[arrayLength];
		unsortedCopy = new int[arrayLength];
		
		 for (int i=0; i<arrayLength; i++)
		 {
			 int n = (int)(Math.random()*100000 - 50000);
			 unsorted[i] = n;
			 unsortedCopy[i] = n;
		 }
		 
	}
	
	public void testSort()
	{
		System.out.println("Sort mit " + length + " Elementen");
		new Insertionsort().sort(unsorted);
		System.out.println("---------");
		new Quicksort().sort(unsortedCopy);
	}
}
