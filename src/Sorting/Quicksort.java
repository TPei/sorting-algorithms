package Sorting;

import main.CountingSorter;
import main.Sorter;

public class Quicksort extends CountingSorter implements Sorter
{
    private int[] a;
    private int n;
    
    @Override
    public void sort(int[] a)
    {
        this.a=a;
        n=a.length;
        quicksort(0, n-1);
        
		System.out.println("Quicksort: " + getC() + " Schritte");
    }

    private void quicksort (int lo, int hi)
    {
        int i=lo, j=hi;

        // Vergleichs­element x
        int x=a[c((lo+hi)/2)];
        
        // random element as comparision element
        //int x = (int)Math.random()*a.length;
        
        // get the median of three elements as comparision element
        /*int first = 0;
        int second = a.length-1;
        int last = (a.length-1)/2;
        int x = medianOfThree(first, second, last);*/

        //  Aufteilung
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

        // Rekursion
        if (lo<j) quicksort(lo, j);
        if (i<hi) quicksort(i, hi);
    }

    private int medianOfThree(int first, int second, int last)
	{
		// returns the median of three array elements
    	if (a[c(first)] > a[c(second)]) 
    	{
    		if (a[c(second)] >= a[c(last)]) 
    		{
    			return second;
    		} 
    		else if (a[c(first)] > a[c(last)]) 
    		{
    		    return last;
    		} 
    		else 
    		{
    			return first;
    		}
    	} 
    	else 
    	{
    		if (a[c(first)] > a[c(last)]) 
    		{
    			return first;
    		} 
    		else if (a[c(second)] > a[c(last)]) 
    		{
    		    return last;
    		} 
    		else 
    		{
    			return second;
    		}
    	}
	}

	private void exchange(int i, int j)
    {
        int t=a[c(i)];
        a[c(i)]=a[c(j)];
        a[c(j)]=t;
    }

}    // end class QuickSorter