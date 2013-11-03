package Sorting;

import Helper.CountingSorter;
import Helper.Sorter;

public class QuicksortMedian3X extends CountingSorter implements Sorter
{
    private int[] a;
    private int n;
 
    public void sort(int[] a)
    {
        this.a=a;
        n=a.length;
        quicksort(0, n-1);
       
        System.out.println("Quicksort Median: " + this.getC() + " Schritte");
        System.out.println("Rekursionstiefe: " + getRekursionDepth());
    }
 
    private void quicksort (int lo, int hi)
    {
    	incrementRekursionDepth();
    	int i=lo, j=hi;
        
        // Vergleichs­element x
        // x wird aus dem Mittelwert der Arraywerte von dem höchsten, niedrigsten und zentralem Index genommen
       
        int m = (lo + hi) / 2;
        int x;
        if(a[c(m)] < a[c(hi)] && a[c(m)]> a[c(lo)])
        {
        	x = a[c(m)];
        }
        else if(a[c(m)] > a[c(hi)])
        {
        	x = a[c(hi)];
        }
        else
        {
        	x = a[c(lo)];
        }
        
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