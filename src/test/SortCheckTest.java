package test;

public class SortCheckTest
{
	public static void main(String[] args)
	{
		int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("a ist sortiert: " + isSorted(a));
		
		int[] b = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 25, 26};
		System.out.println("b ist sortiert: " + isSorted(b));
		
		int[] c = {0, 1, 2, 2, 2, 2, 2, 2};
		System.out.println("c ist sortiert: " + isSorted(c));
		
		int[] d = {0, 0, 0, 0, 0, 0};
		System.out.println("d ist sortiert: " + isSorted(d));
		
		int[] e = {1, 2, 3, 4, 5, 6, 7, 6};
		System.out.println("e ist sortiert: " + isSorted(e));
		
		int[] testArray;
		testArray = new int[1000];
		for (int i = 0; i < 1000; i++)
		{
			testArray[i] = i;
		}
		System.out.println("testArray ist sortiert: " + isSorted(testArray));
		
	}
	
	private static boolean isSorted(int[] a)
	{
		return isSorted(a, 0, a.length);
	}
	
	private static boolean isSorted(int[] a, int lo, int hi)
	{
		// keep checking as long as a[i+1] is >= a[i]
    	for(int i = lo; i < hi-1; i++)
    		if(a[i+1] < a[i])
    			return false;
		return true;
	}
}
