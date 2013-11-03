package Sorting;

import Helper.CountingSorter;
import Helper.Sorter;

public class QuicksortRandomX extends CountingSorter implements Sorter
{
    private int[] a;
    private int n;
    
    @Override
    public void sort(int[] a)
    {
        this.a=a;
        n=a.length;
        quicksort(0, n-1);
        
		System.out.println("QuicksortRandomX: " + getC() + " Schritte");
		System.out.println("Rekursionstiefe: " + getRekursionDepth());
    }

    private void quicksort (int lo, int hi)
    {
    	incrementRekursionDepth();
        int i=lo, j=hi;

        // Vergleichselement x
        //int x=a[c((lo+hi)/2)];
        
        // random element as comparision element
        int x = a[c((int)(Math.random()*a.length))];
        
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

}    // end class QuickSorter