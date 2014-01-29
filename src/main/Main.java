package main;

import test.TestTable;

public class Main
{
	public static void main (String[] args)
	{
		// do some testsorts
		new SortingTests(1000, "10^3").testSort();
		new SortingTests(10000, "10^4").testSort();
		//new TestSort(100000, "10^5").testSort();
		//new TestSort(1000000, "10^6").testSort();
		
	}
	
}
