package Sorting;

import Helper.CountingSorter;
import Helper.Sorter;

public class MyMergesort extends CountingSorter implements Sorter
{

	private int[] a;
	private int[] b;
	private int n;

	@Override
	public void sort(int[] a)
	{
		this.a = a;
		n = a.length;
		b = new int[n];
		mergesort(0, n - 1);
	}

	private void mergesort(int lo, int hi)
	{
		incrementRekursionDepth();
		if (lo < hi)
		{
			int m = (lo + hi) / 2;
			mergesort(lo, m);
			mergesort(m + 1, hi);
			merge(lo, m, hi);
		}
	}

	private void merge(int lo, int m, int hi)
	{
		int i, j, k;
		boolean broken = true;

		while (broken && lo <= m)
		{
			if (a[c(lo)] <= a[c(m + 1)])
			{
				lo++;
			} else
			{
				broken = false;
			}
		}

		i = 0;
		j = lo;
		// vordere Hälfte von a in Hilfsarray b kopieren
		while (j <= m)
			b[c(i++)] = a[c(j++)];

		i = 0;
		k = lo;
		// jeweils das nächstgrößte Element zurückkopieren
		while (k < j && j <= hi)
			if (b[c(i)] <= a[c(j)])
				a[c(k++)] = b[c(i++)];
			else
				a[c(k++)] = a[c(j++)];

		// Rest der vorderen Hälfte falls vorhanden zurückkopieren
		while (k < j)
			a[c(k++)] = b[c(i++)];
	}

}