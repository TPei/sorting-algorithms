package Sorting;

import Helper.CountingSorter;
import Helper.Sorter;

public class MyMergesort extends CountingSorter implements Sorter
{
    private int[] a;
    private int[] b;    // Hilfsarray
    private int n;

    public void sort(int[] a)
    {
        this.a=a;
        n=a.length;
        // je nach Variante entweder/oder:
        b=new int[c((n+1)/2)];    b=new int[c(n)];
        mergesort(0, n-1);
    }

    private void mergesort(int lo, int hi)
    {
    	incrementRekursionDepth();
        if (lo<hi)
        {
            int m=(lo+hi)/2;
            mergesort(lo, m);
            mergesort(m+1, hi);
            merge(lo, m, hi);
        }
    }

    // Variante b
    void merge(int lo, int m, int hi)
    {
    	int i, j, k;

        i=0; j=lo;
        // vordere Hälfte von a in Hilfsarray b kopieren
        while (j<=m)
            b[c(i++)]=a[c(j++)];

        i=0; k=lo;
        // jeweils das nächstgrößte Element zurückkopieren
        while (k<j && j<=hi)
            if (b[c(i)]<=a[c(j)])
                a[c(k++)]=b[c(i++)];
            else
                a[c(k++)]=a[c(j++)];

        // Rest von b falls vorhanden zurückkopieren
        while (k<j)
            a[c(k++)]=b[c(i++)];
    }

}    // end class MergeSorter
