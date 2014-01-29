package sortingAlgorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;

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
        
		//System.out.println("QuicksortRandomX: " + getC() + " Schritte");
		//System.out.println("Rekursionstiefe: " + getRekursionDepth());
    }

    private void quicksort (int lo, int hi)
    {
    	incrementRekursionDepth();
        int i=lo, j=hi;

        // Vergleichselement x
        //int x=a[c((lo+hi)/2)];
        
        // random element as comparision element
        int x = a[countStep((int)(Math.random()*a.length))];
        
        //  Aufteilung
        while (i<=j)
        {    
            while (a[countStep(i)]<x) i++; 
            while (a[countStep(j)]>x) j--;
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
        int t=a[countStep(i)];
        a[countStep(i)]=a[countStep(j)];
        a[countStep(j)]=t;
    }

}    // end class QuickSorter