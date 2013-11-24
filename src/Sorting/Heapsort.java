package Sorting;

import Helper.CountingSorter;
import Helper.Sorter;

public class Heapsort extends CountingSorter implements Sorter
{
    private int[] a;
    private int n;

    public void sort(int[] a)
    {
        this.a=a;
        n=a.length;
        heapsort();
    }

    private void heapsort()
    {
        buildheap();
        while (n>1)
        {
            n--;
            exchange(0, n);
            downheap(0);
        } 
    }

    private void buildheap()
    {
        for (int v=n/2-1; v>=0; v--)
            downheap(v);
    }

    private void downheap(int v)
    {
        int w=2*v+1;         // erster Nachfolger von v
        while (w<n)
        {
            if (w+1<n)       // gibt es einen zweiten Nachfolger?
                if (a[c(w+1)]>a[c(w)]) w++;
            // w ist der Nachfolger von v mit maximaler Markierung

            if (a[c(v)]>=a[c(w)]) return;  // v hat die Heap-Eigenschaft
            // sonst
            exchange(v, w);  // vertausche Markierungen von v und w
            v=w;             // fahre mit v=w fort
            w=2*v+1;
        }
    }

    private void exchange(int i, int j)
    {
        int t=a[c(i)];
        a[c(i)]=a[c(j)];
        a[c(j)]=t;
    }

}    // end class HeapSorter