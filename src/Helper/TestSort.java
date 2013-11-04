package Helper;

import html.dom.Table;
import html.dom.TableContentProvider;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import test.TestTable;

import Sorting.Insertionsort;
import Sorting.Mergesort;
import Sorting.MyQuicksort;
import Sorting.MyQuicksort2;
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
		for (int i = 0; i < arrayLength; i++)
		{
			int n = (int) (Math.random() * 100000 - 50000);
			testArray[i] = n;
		}
		copy = testArray.clone();
	}

	public void testSort()
	{
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter("ausgabe.html"));
			bw.write("<html><head><title>Testausgabe</title><style>table,th, td{border: 1px solid black;}</style></head><body>");
			bw.write("<table><thead><td>Versuche</td><td>Insertionsort</td><td>Quicksort</td><td>MyQuicksort</td><td>MyQuickSort2</td><td>Quicksort Median</td><td>Quicksort Random</td><td>Mergesort</td></thead><tr>");
			bw.write("<tr><td>Sort mit " + length + " Elementen (unsortiert)</td></tr>");
			bw.write("<td>Schritte");
			bw.write("</td><td>");
			System.out.println("TestArray:");
			for(int i = 0; i < testArray.length; i++)
    			System.out.print(testArray[i] + ", ");
			System.out.println();
			Insertionsort myInsertion = new Insertionsort();
			myInsertion.sort(testArray);
			bw.write(Integer.toString(myInsertion.getC()));
			
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted");
	    		System.out.println("not sorted");
	    		for(int i = 0; i < testArray.length; i++)
	    			System.out.print(testArray[i] + ", ");
				System.out.println();
			}
			
			testArray = copy.clone();
			bw.write("</td><td>");

			Quicksort quicksort = new Quicksort();
			quicksort.sort(testArray);
			bw.write(Integer.toString(quicksort.getC()));
			
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted1");
	    		System.out.println("not sorted1");
	    		for(int i = 0; i < testArray.length; i++)
	    			System.out.print(testArray[i] + ", ");
				System.out.println();
			}

			testArray = copy.clone();
			bw.write("</td><td>");
			System.out.println("Quicksort 2");
			MyQuicksort myQuicksort = new MyQuicksort();
			myQuicksort.sort(testArray);
			bw.write(Integer.toString(myQuicksort.getC()));
			
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted2");
	    		System.out.println("not sorted2");
	    		for(int i = 0; i < testArray.length; i++)
	    			System.out.print(testArray[i] + ", ");
				System.out.println();
			}
			
			testArray = copy.clone();
			bw.write("</td><td>");
			
			MyQuicksort2 myQuicksortImproved = new MyQuicksort2();
			myQuicksortImproved.sort(testArray);
			bw.write(Integer.toString(myQuicksortImproved.getC()));
			
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted3");
	    		System.out.println("not sorted3");
			}
			testArray = copy.clone();
			bw.write("</td><td>");

			QuicksortMedian3X myQuicksortMedian = new QuicksortMedian3X();
			myQuicksortMedian.sort(testArray);
			bw.write(Integer.toString(myQuicksortMedian.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted4");
	    		System.out.println("not sorted4");
			}

			testArray = copy.clone();
			bw.write("</td><td>");

			QuicksortRandomX myQuicksortRandom = new QuicksortRandomX();
			myQuicksortRandom.sort(testArray);
			bw.write(Integer.toString(myQuicksortRandom.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted5");
	    		System.out.println("not sorted5");
			}

			bw.write("</td><td>");
			
			testArray = copy.clone();
			Mergesort mergesort = new Mergesort();
			mergesort.sort(testArray);
			bw.write(Integer.toString(mergesort.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted6");
	    		System.out.println("not sorted5");
			}

			bw.write("</td></tr>");

			bw.write("</td></tr>");
			bw.write("<td>Rekursionstiefe</td><td>-</td><td>");
			bw.write(Integer.toString(quicksort.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksort.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortImproved.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortMedian.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortRandom.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(mergesort.getRekursionDepth()));
			bw.write("</td></tr>");

			bw.write("<tr><td>Sort mit " + length + " Elementen (vorsortiert)</td></tr>");
			for (int i = 0; i < length; i++)
			{
				testArray[i] = i;
			}
			copy = testArray.clone();
			
			bw.write("<td>Schritte");
			bw.write("</td><td>");
			myInsertion.sort(testArray);
			bw.write(Integer.toString(myInsertion.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted7");
	    		System.out.println("not sorted7");
			}
			bw.write("</td><td>");
			
			testArray = copy.clone();
			
			quicksort.sort(testArray);
			bw.write(Integer.toString(quicksort.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted8");
	    		System.out.println("not sorted8");
			}
			
			testArray = copy.clone();
			bw.write("</td><td>");
			System.out.println("Quicksort 9");
			myQuicksort.sort(testArray);
			bw.write(Integer.toString(myQuicksort.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted9");
	    		System.out.println("not sorted9");
			}
			
			testArray = copy.clone();
			bw.write("</td><td>");
			
			myQuicksortImproved.sort(testArray);
			bw.write(Integer.toString(myQuicksortImproved.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted10");
	    		System.out.println("not sorted10");
			}
			

			bw.write("</td><td>");
			testArray = copy.clone();
			myQuicksortMedian.sort(testArray);
			bw.write(Integer.toString(myQuicksortMedian.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted11");
	    		System.out.println("not sorted11");
			}

			bw.write("</td><td>");
			testArray = copy.clone();
			myQuicksortRandom.sort(testArray);
			bw.write(Integer.toString(myQuicksortRandom.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted12");
	    		System.out.println("not sorted12");
			}
			
			bw.write("</td><td>");
			testArray = copy.clone();
			
			mergesort.sort(testArray);
			bw.write(Integer.toString(mergesort.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted13");
	    		System.out.println("not sorted13");
			}

			bw.write("</td></tr>");
			bw.write("<td>Rekursionstiefe</td><td>-</td><td>");
			bw.write(Integer.toString(quicksort.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksort.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortImproved.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortMedian.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortRandom.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(mergesort.getRekursionDepth()));
			bw.write("</td></tr>");

			Helper.reverseArray(testArray);
			invert = testArray.clone(); // copy of inverted array

			bw.write("<tr><td>Sort mit " + length + " Elementen (absteigend sortiert)</td></tr>");
			bw.write("<td>Schritte");
			bw.write("</td><td>");
			myInsertion.sort(testArray);
			bw.write(Integer.toString(myInsertion.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted14");
				System.out.println("not sorted14");
			}
			testArray = invert.clone();
			bw.write("</td><td>");

			quicksort.sort(testArray);
			bw.write(Integer.toString(quicksort.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted15");
	    		System.out.println("not sorted15");
			}

			testArray = copy.clone();
			bw.write("</td><td>");
			
			myQuicksort.sort(testArray);
			System.out.println("Quicksort 16");
			bw.write(Integer.toString(myQuicksort.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted16");
	    		System.out.println("not sorted16");
			}
			
			testArray = copy.clone();
			bw.write("</td><td>");
			
			myQuicksortImproved.sort(testArray);
			bw.write(Integer.toString(myQuicksortImproved.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted17");
	    		System.out.println("not sorted17");
			}
			
			testArray = invert.clone();
			bw.write("</td><td>");

			myQuicksortMedian.sort(testArray);
			bw.write(Integer.toString(myQuicksortMedian.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted18");
	    		System.out.println("not sorted18");
			}

			testArray = invert.clone();
			bw.write("</td><td>");

			myQuicksortRandom.sort(testArray);
			bw.write(Integer.toString(myQuicksortRandom.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted19");
	    		System.out.println("not sorted19");
			}
			
			bw.write("</td><td>");
			testArray = invert.clone();
			
			mergesort.sort(testArray);
			bw.write(Integer.toString(mergesort.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted20");
				System.out.println("not sorted20");
			}

			bw.write("</td></tr>");
			bw.write("<td>Rekursionstiefe</td><td>-</td><td>");
			bw.write(Integer.toString(quicksort.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksort.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortImproved.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortMedian.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortRandom.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(mergesort.getRekursionDepth()));
			bw.write("</td></tr>");

			for (int i = 0; i < length; i++)
			{
				int n = (int) (Math.random() * 99);
				testArray[i] = n;
			}
			copy = testArray.clone();

			bw.write("<tr><td>Sort mit " + length + " Elementen (unsortiert, 0 - 99)</td></tr>");
			bw.write("<td>Schritte");
			bw.write("</td><td>");
			myInsertion.sort(testArray);
			bw.write(Integer.toString(myInsertion.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted21");
				System.out.println("not sorted21");
			}
			testArray = copy.clone();
			bw.write("</td><td>");

			quicksort.sort(testArray);
			bw.write(Integer.toString(quicksort.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted22");
	    		System.out.println("not sorted22");
			}
			
			testArray = copy.clone();
			bw.write("</td><td>");
			
			System.out.println("Quicksort 23");
			myQuicksort.sort(testArray);
			bw.write(Integer.toString(myQuicksort.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted23");
	    		System.out.println("not sorted23");
			}
			
			testArray = copy.clone();
			bw.write("</td><td>");
			
			myQuicksortImproved.sort(testArray);
			bw.write(Integer.toString(myQuicksortImproved.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted24");
	    		System.out.println("not sorted24");
			}

			testArray = copy.clone();
			bw.write("</td><td>");

			myQuicksortMedian.sort(testArray);
			bw.write(Integer.toString(myQuicksortMedian.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted25");
	    		System.out.println("not sorted25");
			}

			testArray = copy.clone();
			bw.write("</td><td>");

			myQuicksortRandom.sort(testArray);
			bw.write(Integer.toString(myQuicksortRandom.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted26");
	    		System.out.println("not sorted26");
			}
			
			bw.write("</td><td>");
			testArray = copy.clone();
			
			mergesort.sort(testArray);
			bw.write(Integer.toString(mergesort.getC()));
			if(!Helper.isSorted(testArray))
			{
				//bw.close();
	    		//throw new Exception("array wasn't sorted27");
	    		System.out.println("not sorted27");
			}

			bw.write("</td></tr>");
			bw.write("<td>Rekursionstiefe</td><td>-</td><td>");
			bw.write(Integer.toString(quicksort.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksort.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortImproved.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortMedian.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(myQuicksortRandom.getRekursionDepth()));
			bw.write("</td><td>");
			bw.write(Integer.toString(mergesort.getRekursionDepth()));
			bw.write("</td></tr>");

			bw.write("</table>");
			bw.write("</body></html>");
			bw.close();

			newTest();

		} catch (Exception exc)
		{
			System.out.println("Error!");
			System.out.println(exc.getMessage());
		}
	}

	private void newTest()
	{
		// ---------------------------
		// ---------------------------
		// ---------------------------
		// Testausgabe mit neuer Klasse
		// ---------------------------
		// ---------------------------
		// ---------------------------
		try
		{
			BufferedWriter testWriter = new BufferedWriter(new FileWriter("ausgabe2.html"));
			List<String[]> values = new ArrayList<>();
			values.add(new String[] { "Sort mit 1000 Elementen unsortiert", "28442", "24808", "29851", "58331541" });

			values.add(new String[] { "Rekursionstiefe", "-", "890", "960", "254133" });

			testWriter.write("<html><head></head><body>");
			Table<String[]> table = new Table<>(values);
			table.addHeader("Versuche");
			table.addHeader("Insertionsort");
			table.addHeader("Quicksort");
			table.addHeader("Quicksort Median");
			table.addHeader("QuicksortRandomX");

			table.setContentProvider(new TableContentProvider<String[]>()
			{
				@Override
				public String[] getContentForRow(int row, String[] value)
				{
					return value;
				}
			});

			testWriter.write(table.render());
			testWriter.write("</body></html>");
			testWriter.close();
		} catch (Exception exc)
		{
			System.out.println("Error!");
			System.out.println(exc.getMessage());
		}

	}
}
