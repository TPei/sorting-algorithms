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
import Sorting.MyMergesort;
import Sorting.MyQuicksort;
import Sorting.QuicksortCombined;
import Sorting.QuicksortJannik;
import Sorting.Quicksort;
import Sorting.QuicksortJonas;
import Sorting.QuicksortMedian3X;
import Sorting.QuicksortRandomX;

public class TestSort
{
	int length;
	int[] testArray;

	public TestSort(int length)
	{
		this.length = length;

		int arrayLength = length;
		testArray = new int[arrayLength];
		for (int i = 0; i < arrayLength; i++)
		{
			int n = (int) (Math.random() * 100000 - 50000);
			testArray[i] = n;
		}
	}

	public void testSort()
	{
		try
		{
			BufferedWriter testWriter = new BufferedWriter(new FileWriter("ausgabe2.html"));
			testWriter.write("<html><head></head><body>");
			
			List<String[]> values = new ArrayList<>();
			
			// random array
			values = getValueList(testArray, "unsortiert", values);
						
			// now it's sorted
			values = getValueList(testArray, "vorsortiert", values);

			// reverse sorted
			Helper.reverseArray(testArray);
			values = getValueList(testArray, "absteigend sortiert", values);

			// only small numbers
			for (int i = 0; i < length; i++)
			{
				int n = (int) (Math.random() * 99);
				testArray[i] = n;
			}
			values = getValueList(testArray, "Wertebereich 0-99", values);
			
			Table<String[]> table = new Table<>(values);
			table.addHeader("Versuche");
			table.addHeader("Insertionsort");
			table.addHeader("Quicksort");
			table.addHeader("MyQuicksort");
			table.addHeader("QuicksortMedianX");
			table.addHeader("QuicksortRandomX");
			table.addHeader("Mergesort");
			table.addHeader("MyMergesort");

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

	/**
	 * expects an array to sort, a description of that array and an exisiting list of values
	 * @param arrayToSort
	 * @param status
	 * @param values
	 * @return List<String[]> of values
	 */
	private List<String[]> getValueList(int[] arrayToSort, String status, List<String[]> values)
	{
		int length = arrayToSort.length;
		int[] copy = arrayToSort.clone();

		Insertionsort myInsertion = new Insertionsort();
		myInsertion.sort(arrayToSort);

		arrayToSort = copy.clone();

		Quicksort quicksort = new Quicksort();
		quicksort.sort(arrayToSort);

		arrayToSort = copy.clone();

		MyQuicksort myQuicksort = new MyQuicksort();
		myQuicksort.sort(arrayToSort);

		arrayToSort = copy.clone();

		QuicksortMedian3X myQuicksortMedian = new QuicksortMedian3X();
		myQuicksortMedian.sort(arrayToSort);

		arrayToSort = copy.clone();

		QuicksortRandomX myQuicksortRandom = new QuicksortRandomX();
		myQuicksortRandom.sort(arrayToSort);

		arrayToSort = copy.clone();
		Mergesort mergesort = new Mergesort();
		mergesort.sort(arrayToSort);

		arrayToSort = copy.clone();
		MyMergesort myMergesort = new MyMergesort();
		myMergesort.sort(arrayToSort);

		values.add(new String[] { "Sort mit " + length + " Elementen " + status, Integer.toString(myInsertion.getC()), Integer.toString(quicksort.getC()),
				Integer.toString(myQuicksort.getC()), Integer.toString(myQuicksortMedian.getC()), Integer.toString(myQuicksortRandom.getC()),
				Integer.toString(mergesort.getC()), Integer.toString(myMergesort.getC()) });

		values.add(new String[] { "Rekursionstiefe", "-", Integer.toString(quicksort.getRekursionDepth()), Integer.toString(myQuicksort.getRekursionDepth()),
				Integer.toString(myQuicksortMedian.getRekursionDepth()), Integer.toString(myQuicksortRandom.getRekursionDepth()),
				Integer.toString(mergesort.getRekursionDepth()), Integer.toString(myMergesort.getRekursionDepth()) });

		return values;

	}
}
