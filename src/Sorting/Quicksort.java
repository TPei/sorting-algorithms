package Sorting;

import java.io.BufferedWriter;
import java.io.FileWriter;

import Helper.CountingSorter;
import Helper.Sorter;

public class Quicksort extends CountingSorter implements Sorter
{
	private int[] a;
    private int n;

    public void sort(int[] a)
    {
        this.a=a;
        n=a.length;
        quicksort(0, n-1);
    }

    private void quicksort (int lo, int hi)
    {
    	incrementRekursionDepth();
        int i=lo, j=hi;

        // Vergleichs­element x
        int x=a[c((lo+hi)/2)];

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

    private void exchange(int i, int j)
    {
        int t=a[c(i)];
        a[c(i)]=a[c(j)];
        a[c(j)]=t;
    }

}    // end class QuickSort