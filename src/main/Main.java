package main;

import test.TestTable;
import Helper.TestSort;

public class Main
{
	public static void main (String[] args)
	{
		//Insertionsort sort = new Insertionsort();
		
		// 10^3, 10^4, 10^5
		/*int noOfElements = 1000;
		long[] durations = new long[3];
		
		for(int i = 0; i < durations.length; i++)
		{
			/*durations[i] = new TestSort(noOfElements).testSort();
			System.out.println("Number of elements: "+noOfElements);
			System.out.println("Duration in ns: " + durations[i]);
			System.out.println("Time in s: " +  durations[i]*Math.pow(10, -9));*//*
			new TestSort(noOfElements).testSort();
			System.out.println("-------------------------");
			noOfElements *= 10;
		}*/
		
		new TestSort(1000).testSort();
		
		
		/*System.out.println("Number of elements: 100000"); // + mySort.unsorted.length);
		System.out.println("Time took for execution: " + duration + "ns");
		double seconds = duration * Math.pow(10, -9);
		System.out.println("That's: " + seconds + "s");
		System.out.println("--------------");*/
		
		
	}
}
