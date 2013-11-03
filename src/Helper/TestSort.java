package Helper;

import java.io.BufferedWriter;
import java.io.FileWriter;

import Sorting.Insertionsort;
import Sorting.Quicksort;
import Sorting.QuicksortMedian3X;
import Sorting.QuicksortRandomX;

public class TestSort
{
	int length;
	int[] testArray;
	int[] copy;
	int[] invert;
	
	public TestSort(int length)
	{
		this.length = length;
		
		int arrayLength = length;
		testArray = new int[arrayLength];
		copy = new int[arrayLength];
		invert = new int[arrayLength];
		for (int i=0; i<arrayLength; i++)
		{
			int n = (int)(Math.random()*100000 - 50000);
			testArray[i] = n;
		}
		copy = testArray.clone();
	}
	
	public void testSort()
	{
		//BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		//bw.write("<html><head><title>New Page</title></head><body><p>This is Body</p></body></html>");
		//bw.close();
		
		System.out.println("Sort mit " + length + " Elementen (unsortiert)");
		new Insertionsort().sort(testArray);
		System.out.println("---------");
		testArray = copy.clone();
		new Quicksort().sort(testArray);
		System.out.println("---------");
		testArray = copy.clone();
		new QuicksortMedian3X().sort(testArray);
		System.out.println("---------");
		testArray = copy.clone();
		new QuicksortRandomX().sort(testArray);
		
		System.out.println("-------------------");
		System.out.println("-------------------");
		
		System.out.println("Sort mit " + length + " Elementen (vorsortiert)");
		new Insertionsort().sort(testArray);
		System.out.println("---------");
		new Quicksort().sort(testArray);
		System.out.println("---------");
		new QuicksortMedian3X().sort(testArray);
		System.out.println("---------");
		new QuicksortRandomX().sort(testArray);
		
		System.out.println("-------------------");
		System.out.println("-------------------");
		
		// invert array
		for(int i = 0; i < testArray.length / 2; i++)
		{
		    int temp = testArray[i];
		    testArray[i] = testArray[testArray.length - i - 1];
		    testArray[testArray.length - i - 1] = temp;
		}
		invert = testArray.clone(); // copy of inverted array
		
		System.out.println("Sort mit " + length + " Elementen (absteigend sortiert)");
		new Insertionsort().sort(testArray);
		System.out.println("---------");
		testArray = invert.clone();
		new Quicksort().sort(testArray);
		System.out.println("---------");
		testArray = invert.clone();
		new QuicksortMedian3X().sort(testArray);
		System.out.println("---------");
		testArray = invert.clone();
		new QuicksortRandomX().sort(testArray);
		
		System.out.println("-------------------");
		System.out.println("-------------------");
		
		for (int i=0; i<length; i++)
		{
			int n = (int)(Math.random()*99);
			testArray[i] = n;
		}
		copy = testArray.clone();
		System.out.println("Sort mit " + length + " Elementen (unsortiert, 0-99)");
		new Insertionsort().sort(testArray);
		System.out.println("---------");
		testArray = copy.clone();
		new Quicksort().sort(testArray);
		System.out.println("---------");
		testArray = copy.clone();
		new QuicksortMedian3X().sort(testArray);
		System.out.println("---------");
		testArray = copy.clone();
		new QuicksortRandomX().sort(testArray);
	}
}
