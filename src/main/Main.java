package main;

import test.TestTable;
import Helper.TestSort;

public class Main
{
	public static void main (String[] args)
	{
		// do some testsorts
		new TestSort(1000, "10^3").testSort();
		new TestSort(10000, "10^4").testSort();
		//new TestSort(100000, "10^5").testSort();
		//new TestSort(1000000, "10^6").testSort();
		
	}
	
}
