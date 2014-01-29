package main;

import html.dom.Table;
import html.dom.TableContentProvider;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sortingAlgorithms.Heapsort;
import sortingAlgorithms.Insertionsort;
import sortingAlgorithms.Mergesort;
import sortingAlgorithms.MergesortB;
import sortingAlgorithms.Quicksort;
import sortingAlgorithms.QuicksortB;
import sortingAlgorithms.QuicksortMedian3;
import sortingAlgorithms.QuicksortRandomX;
import test.TestTable;
import Helper.CountingSorter;
import Helper.Helper;

class NotSortedException extends Exception
{
	public NotSortedException() {}
	public NotSortedException(String s)
	{
		super(s);
	}
}

public class SortingTests
{
	int length;
	int[] testArray;
	String filename;

	public SortingTests(int length, String filename)
	{
		this.length = length;
		this.filename = filename;

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
			BufferedWriter testWriter = new BufferedWriter(new FileWriter(filename+".html"));
			testWriter.write("<html><head></head><body>");
			
			List<String[]> values = new ArrayList<>();
			
			// random array
			values = getValueList(testArray, filename,  "unsortiert", values);
						
			// now it's sorted
			values = getValueList(testArray, filename, "vorsortiert", values);

			// reverse sorted
			Helper.reverseArray(testArray);
			values = getValueList(testArray, filename, "absteigend sortiert", values);

			// only small numbers
			/*for (int i = 0; i < length; i++)
			{
				int n = (int) (Math.random() * 99);
				testArray[i] = n;
			}
			values = getValueList(testArray, "Wertebereich 0-99", values);*/
			
			// partially presorted array
			int k = 0;
			int temp = 0;
			for (int i = 0; i < length; i++)
			{
				if(k != 0)
					temp = (int) (Math.random() * 10);
				testArray[i] = temp;
				
				if(k >= 5)
					k = 0;
				else
					k++;
			}
			values = getValueList(testArray, filename, "Teilweise sortiert", values);
			
			Table<String[]> table = new Table<>(values);
			table.addHeader("Versucheseigenschaften");
			table.addHeader("Insertionsort");
			table.addHeader("Quicksort");
			table.addHeader("QuicksortB");
			table.addHeader("QSMedian3");
			/*table.addHeader("QSRandX");*/
			table.addHeader("Mergesort");
			table.addHeader("MergesortB");
			table.addHeader("Heapsort");

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

		}
		catch (NotSortedException exc){
			System.out.println("Array wasn't sorted correctly!");
			System.out.println(exc.getMessage());
		}
		catch (IOException exc){
			System.out.println("IO Exception");
			System.out.println(exc.getMessage());
		}
		catch (Exception exc)
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
	private List<String[]> getValueList(int[] arrayToSort, String problemSize, String status, List<String[]> values) throws NotSortedException
	{
		
		// do all sorts
		int length = arrayToSort.length;
		int[] copy = arrayToSort.clone();

		Insertionsort myInsertion = new Insertionsort();
		myInsertion.sort(arrayToSort);
		
		if(!Helper.isSorted(arrayToSort))
			throw new NotSortedException();

		arrayToSort = copy.clone();

		Quicksort quicksort = new Quicksort();
		quicksort.sort(arrayToSort);
		
		if(!Helper.isSorted(arrayToSort))
		throw new NotSortedException();

		arrayToSort = copy.clone();

		QuicksortB myQuicksort = new QuicksortB();
		myQuicksort.sort(arrayToSort);
		
		if(!Helper.isSorted(arrayToSort))
		throw new NotSortedException();

		arrayToSort = copy.clone();

		QuicksortMedian3 myQuicksortMedian = new QuicksortMedian3();
		myQuicksortMedian.sort(arrayToSort);
		
		if(!Helper.isSorted(arrayToSort))
		throw new NotSortedException();
		/* quicksort with random comparision is so terribly bad 
		 * it will throw stackoverloferrors with numbers this large
		arrayToSort = copy.clone();

		QuicksortRandomX myQuicksortRandom = new QuicksortRandomX();
		myQuicksortRandom.sort(arrayToSort);
		
		if(!Helper.isSorted(arrayToSort))
			throw new NotSortedException();
		*/
		arrayToSort = copy.clone();
		Mergesort mergesort = new Mergesort();
		mergesort.sort(arrayToSort);
		
		if(!Helper.isSorted(arrayToSort))
		throw new NotSortedException();

		arrayToSort = copy.clone();
		MergesortB myMergesort = new MergesortB();
		myMergesort.sort(arrayToSort);
		
		if(!Helper.isSorted(arrayToSort))
		throw new NotSortedException();
		
		arrayToSort = copy.clone();
		Heapsort myHeapsort = new Heapsort();
		myHeapsort.sort(arrayToSort);
		
		if(!Helper.isSorted(arrayToSort))
		throw new NotSortedException();

		
		// add stepscount to table
		String myInsertionSteps = ""+myInsertion.getStepcount();
		String quicksortSteps = ""+quicksort.getStepcount();
		String myQuicksortSteps = ""+myQuicksort.getStepcount();
		String myQuicksortMedianSteps = ""+myQuicksortMedian.getStepcount();
		//String myQuicksortRandomSteps = ""+myQuicksortRandom.getStepcount();
		String mergesortSteps = ""+mergesort.getStepcount();
		String myMergesortSteps = ""+myMergesort.getStepcount();
		String myHeapsortSteps = ""+myHeapsort.getStepcount();
		
		values.add(new String[] { problemSize + " Elemente, " + status, 
				Helper.format(myInsertionSteps), 
				Helper.format(quicksortSteps),
				Helper.format(myQuicksortSteps), 
				Helper.format(myQuicksortMedianSteps), 
				//Helper.format(myQuicksortRandomSteps),
				Helper.format(mergesortSteps), 
				Helper.format(myMergesortSteps), 
				Helper.format(myHeapsortSteps) });
		
		
		// add recursiondepth to table
		String quicksortRecursion = Integer.toString(quicksort.getRekursionDepth());
		String myQuicksortRecursion = Integer.toString(myQuicksort.getRekursionDepth());
		String myQuicksortMedianRecursion = Integer.toString(myQuicksortMedian.getRekursionDepth());
		//String myQuicksortRandomRecursion = Integer.toString(myQuicksortRandom.getRekursionDepth());
		String mergesortRecursion = Integer.toString(mergesort.getRekursionDepth());
		String myMergesortRecursion = Integer.toString(myMergesort.getRekursionDepth());
		
		values.add(new String[] { "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&rarr;&nbsp;Rekursionstiefe", 
				"-", 
				Helper.format(quicksortRecursion), 
				Helper.format(myQuicksortRecursion),
				Helper.format(myQuicksortMedianRecursion),
				//Helper.format(myQuicksortRandomRecursion),
				Helper.format(mergesortRecursion), 
				Helper.format(myMergesortRecursion), 
				"-" });

		return values;

	}
}
