package Helper;

public class Helper
{
	public static void reverseArray(int[] a)
	{
		for (int i = 0; i < a.length / 2; i++)
		{
			int temp = a[i];
			a[i] = a[a.length - i - 1];
			a[a.length - i - 1] = temp;
		}
	}
	
	/**
     * check if array is sorted
     * 
     * @param a array to check if it is sorted
     * @return boolean whether or not the array is sorted
     */
    public static boolean isSorted(int[] a)
	{
		return isSorted(a, 0, a.length-1);
	}
    
	/**
     * checks if array is sorted between a starting point and an end point
     * 
     * @param a array of which to check if part is sorted
     * @param lo start of allegedly sorted part
     * @param hi end of allegedly sorted part
     * @return boolean whether or not the given part of array is sorted
     */
    public static boolean isSorted(int[] a, int lo, int hi)
	{
		// keep checking as long as a[i+1] is >= a[i]
    	for(int i = lo; i < hi-1; i++)
    		if(a[i+1] < a[i])
    			return false;
		return true;
	}
    
    /**
     * formats a string so that it has the format abc.def.ghi
     *(split after every third char, starting from the back)
     * @param input
     * @return formatted string
     */
    public static String format(String input){
		int count = 0;
		int countThree = 0;
		int length = input.length();
		for(int i = length-1; i >= 0; i--, count++, countThree++){
			if(countThree >= 3){
				input = input.substring(0, length-count) + "." + input.substring(length-count, length);
				length++;
				count++;
				countThree = 0;
			}
		}
		
		return input;
	}
	
}
