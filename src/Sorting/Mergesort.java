package Sorting;

import Helper.CountingSorter;
import Helper.Sorter;

public class Mergesort extends CountingSorter implements Sorter
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

 // bitonische Merge-Variante c
    void merge(int lo, int m, int hi)
    {
        int i=lo, j=hi, k=lo;

        // vordere Hälfte in Array b kopieren
        while (i<=m)
            b[c(k++)]=a[c(i++)];

        // hintere Hälfte in umgekehrter Reihenfolge in Array b kopieren
        while (j>m)
            b[c(k++)]=a[c(j--)];

        i=lo; j=hi; k=lo;
        // jeweils das nächstgrößte Element zurückkopieren,
        // bis i und j sich überkreuzen
        while (i<=j)
            if (b[c(i)]<=b[c(j)])
                a[c(k++)]=b[c(i++)];
            else
                a[c(k++)]=b[c(j--)];
    }

}    // end class MergeSorter
