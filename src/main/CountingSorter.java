package main;

public abstract class CountingSorter
{
	private int counter = 0;
	
	protected int c(int i)
	{
		counter++;
		return i;
	}
	
	protected int getC()
	{
		return counter;
	}

}
