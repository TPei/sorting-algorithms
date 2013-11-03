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
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter("ausgabe.html"));
			bw.write("<html><head><title>Testausgabe</title><style>table,th, td{border: 1px solid black;}</style></head><body>");
			bw.write("<table><thead><td>Versuche</td><td>Insertionsort</td><td>Quicksort</td><td>Quicksort Median</td><td>Quicksort Random</td></thead><tr>");
			bw.write("<tr><td>Sort mit " + length + " Elementen (unsortiert)</td></tr>");
			bw.write("<td>Schritte");
			bw.write("</td><td>");
			Insertionsort myInsertion = new Insertionsort();
			myInsertion.sort(testArray);
			bw.write(Integer.toString(myInsertion.getC()));
			testArray = copy.clone();
			bw.write("</td><td>");
			
			Quicksort myQuicksort = new Quicksort();
			myQuicksort.sort(testArray);
			bw.write(Integer.toString(myQuicksort.getC()));
			
			testArray = copy.clone();
			bw.write("</td><td>");
			
			QuicksortMedian3X myQuicksortMedian = new QuicksortMedian3X();
			myQuicksortMedian.sort(testArray);
			bw.write(Integer.toString(myQuicksortMedian.getC()));
			
			testArray = copy.clone();
			bw.write("</td><td>");
			
			QuicksortRandomX myQuicksortRandom = new QuicksortRandomX();
			myQuicksortRandom.sort(testArray);
			bw.write(Integer.toString(myQuicksortRandom.getC()));
			
			bw.write("</td></tr>");
			
			bw.write("</td></tr>");
			bw.write("<td>Rekursionstiefe</td><td>-</td><td>");
			bw.write(Integer.toString(myQuicksort.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortMedian.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortRandom.getRekursionDepth()));
			bw.write("</td></tr>");
			
			
			bw.write("<tr><td>Sort mit " + length + " Elementen (vorsortiert)</td></tr>");
			bw.write("<td>Schritte");
			bw.write("</td><td>");
			myInsertion.sort(testArray);
			bw.write(Integer.toString(myInsertion.getC()));
			bw.write("</td><td>");
			
			myQuicksort.sort(testArray);
			bw.write(Integer.toString(myQuicksort.getC()));
			
			bw.write("</td><td>");
			myQuicksortMedian.sort(testArray);
			bw.write(Integer.toString(myQuicksortMedian.getC()));
			
			bw.write("</td><td>");
			
			myQuicksortRandom.sort(testArray);
			bw.write(Integer.toString(myQuicksortRandom.getC())); 
			
			bw.write("</td></tr>");
			bw.write("<td>Rekursionstiefe</td><td>-</td><td>");
			bw.write(Integer.toString(myQuicksort.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortMedian.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortRandom.getRekursionDepth()));
			bw.write("</td></tr>");
			
			// invert array
			for(int i = 0; i < testArray.length / 2; i++)
			{
			    int temp = testArray[i];
			    testArray[i] = testArray[testArray.length - i - 1];
			    testArray[testArray.length - i - 1] = temp;
			}
			invert = testArray.clone(); // copy of inverted array
			
			bw.write("<tr><td>Sort mit " + length + " Elementen (absteigend sortiert)</td></tr>");
			bw.write("<td>Schritte");
			bw.write("</td><td>");
			myInsertion.sort(testArray);
			bw.write(Integer.toString(myInsertion.getC()));
			testArray = invert.clone();
			bw.write("</td><td>");
			
			myQuicksort.sort(testArray);
			bw.write(Integer.toString(myQuicksort.getC()));
			
			testArray = invert.clone();
			bw.write("</td><td>");
			
			myQuicksortMedian.sort(testArray);
			bw.write(Integer.toString(myQuicksortMedian.getC()));
			
			testArray = invert.clone();
			bw.write("</td><td>");
			
			myQuicksortRandom.sort(testArray);
			bw.write(Integer.toString(myQuicksortRandom.getC()));
			
			bw.write("</td></tr>");
			
			bw.write("</td></tr>");
			bw.write("<td>Rekursionstiefe</td><td>-</td><td>");
			bw.write(Integer.toString(myQuicksort.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortMedian.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortRandom.getRekursionDepth()));
			bw.write("</td></tr>");
			
			
			for (int i=0; i<length; i++)
			{
				int n = (int)(Math.random()*99);
				testArray[i] = n;
			}
			copy = testArray.clone();
			
			bw.write("<tr><td>Sort mit " + length + " Elementen (unsortiert, 0 - 99)</td></tr>");
			bw.write("<td>Schritte");
			bw.write("</td><td>");
			myInsertion.sort(testArray);
			bw.write(Integer.toString(myInsertion.getC()));
			testArray = copy.clone();
			bw.write("</td><td>");
			
			myQuicksort.sort(testArray);
			bw.write(Integer.toString(myQuicksort.getC()));
			
			testArray = copy.clone();
			bw.write("</td><td>");
			
			myQuicksortMedian.sort(testArray);
			bw.write(Integer.toString(myQuicksortMedian.getC()));
			
			testArray = copy.clone();
			bw.write("</td><td>");
			
			myQuicksortRandom.sort(testArray);
			bw.write(Integer.toString(myQuicksortRandom.getC()));
			bw.write("</td></tr>");
			
			bw.write("</td></tr>");
			bw.write("<td>Rekursionstiefe</td><td>-</td><td>");
			bw.write(Integer.toString(myQuicksort.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortMedian.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortRandom.getRekursionDepth()));
			bw.write("</td></tr>");
			
			bw.write("</table>");
			bw.write("</body></html>");
			bw.close();
		}catch(Exception exc){
		}
	}
}
