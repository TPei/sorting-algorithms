/*
 * Als Ansatz der Verbesserung von Quicksort habe ich zwei Punkte gewahlt
 * 1. Voruberprufung ob das Teilarray bereits sortiert ist
 * 2. Benutzung von Insertionsort bei sehr kleinen Teilarrays
 * 
 *  1. Uberprufung ob Teilarray bereits sortiert ist bei jedem Rekursionsaufruf
 *  2. Uberprufung der Teillange vor neuem Rekursionsaufruf, bei length <= 20, Insertionsort
 *  
 *  Die Effizienz meines Quicksorts ist bei der Zahl der Schritte 
 *  von teilweise kaum merklich (1000 unsortierte Elemente)
 *  bis teils über 50% weniger Schritte (1000 Elemente, bereits absteigend sortiert) gesunken.
 *  Die Rekursionstiefe lag im Schnitt bei < 1/10. 
 */
package Sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;

import Helper.CountingSorter;
import Helper.Sorter;

public class MyQuicksort extends CountingSorter implements Sorter
{
    private int[] a;
    private int n;
    
    @Override
    public void sort(int[] a)
    {
       this.a=a;
       n=a.length;
        
       quicksort(0, n-1);   	   
        
    }

    /**
     * sort an array using the quicksort technique (divide and conquer)
     * @see https://en.wikipedia.org/wiki/Quicksort
     * 
     * @param lo start of part to be sorted
     * @param hi end of part to be sorted
     */
	private void quicksort (int lo, int hi)
    {
    	incrementRekursionDepth();
    	
    	// if the given part of the array is already sorted, we're done here
    	if(!isSorted(a, lo, hi))
    	{
	        int i=lo, j=hi;
	
	        // comparision element x
	        int x=a[c((lo+hi)/2)];
	
	        //  splitting
	        while (i<=j)
	        {    
	            while (a[c(i)]<x) i++;
	            while (a[c(j)]>x) j--;
	            if (i<=j)
	            {
	                exchange(i, j);
	                i++; j--;
	            }
	        }
	        //if (lo<j) quicksort(lo, j);
	        //if (i<hi) quicksort(i, hi);
	        //insertionsort(lo, hi);
	        // Rekursion; if length <= 20 => insertionsort
	        if (lo<j) 
	        	if(j-lo<=20)
	        		insertionsort(lo, j);
	        	else
	        		quicksort(lo, j);
	        if (i<hi) 
	        	if(hi-i<=20)
	        		insertionsort(i, hi);
	        	else
	        		quicksort(i, hi);
    	}
    }

	/**
	 * swaps two elements in array a
	 * 
	 * @param i first element
	 * @param j second element
	 */
	private void exchange(int i, int j)
    {
        int t=a[c(i)];
        a[c(i)]=a[c(j)];
        a[c(j)]=t;
    }
	
	/**
     * check if array is sorted
     * 
     * @param a array to check if it is sorted
     * @return boolean whether or not the array is sorted
     */
    private boolean isSorted(int[] a)
	{
		return isSorted(a, 0, a.length-1);
	}
    
    /**
     * checks if array is sorted between a starting point and an end point
     * 
     * @param a array of which to check if part is sorted
     * @param lo start of allegedly sorted part
     * @param hi end of allegedly sorted part
     * @return boolean whether or not the given part of array is sorted
     */
    private boolean isSorted(int[] a, int lo, int hi)
	{
		// keep checking as long as a[i+1] is >= a[i]
    	for(int i = lo; i < hi-1; i++)
    		if(a[c(i+1)] < a[c(i)])
    			return false;
		return true;
	}
	
    /**
     * insertionsort a part of an array
     * 
     * @param lo start of part to be sorted using insertionsort
     * @param hi end of part to be sorted using insertionsort
     */
	public void insertionsort(int lo, int hi)
	{
		//int sortedCount = 1;
		//long startTime = System.nanoTime();
		 
		int i, j, t;
	    for (i=lo; i<=hi; i++)
	    {
	        j=i;
	        t=a[c(j)];
	        while (j>0 && a[j-1]>t)
	        {
	            a[c(j)]=a[c(j-1)];
	            j--;
	        }
	        a[c(j)]=t;
	    }
	}

}    // end class QuickSort