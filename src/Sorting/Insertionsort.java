package Sorting;

import java.util.ArrayList;
import java.util.Random;

import main.CountingSorter;
import main.Sorter;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Insertionsort extends CountingSorter implements Sorter
{
	public Insertionsort()
	{
		 
	}
	
	@Override
	public void sort(int[] a)
	{
		//int sortedCount = 1;
		//long startTime = System.nanoTime();
		 
		for (int i = 1; i < a.length; i++)
		{
			/*for (int j = 0; j < sortedCount; j++)
			{
				if(a[i] < a[j])
					addBefore(a, j, i);
			}*/
			
			int j = i-1;
			int copy = a[c(i)];
			
			//System.out.println("i:"+ i + " j:" + j +" a[i]:" + a[i] + " a[j]:" + a[j]);
			
			while(j >= 0 && copy < a[c(j)])
			{
				a[c(i)] = a[c(j)];
				j--;
			}
			//j = Math.max(j, 0);
			a[c(j+1)] = copy;
			
		}
		
		
		/*long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("Anzahl der Elemente: " + a.length);
		System.out.println(duration + "ns");
		double seconds = duration * Math.pow(10, -9);
		System.out.println(seconds + "s");
		System.out.println("---------------------");
		//System.out.println("finished");*/
		System.out.println("Insertionsort: " + getC() + " Schritte");
	}
	
	
	/**
	 * @param a the array in which elements are moved
	 * @param targetPosition position TO which the element has to be moved
	 * @param sourcePosition position FROM which the element has to be moved
	 */
	public void addBefore(int[] a, int targetPosition, int sourcePosition)
	{
		// copy element to be moved
		int toMove = a[sourcePosition];
		
		// move all elements from source position to target position by one to the right
		for(int i = sourcePosition-1; i >= targetPosition; i--)
		{
			a[i+1] = a[i];
		}
		
		// insert copied element at target position
		a[targetPosition] = toMove;
	}

}
