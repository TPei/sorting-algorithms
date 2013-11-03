package Helper;

public abstract class CountingSorter
{
	private int counter = 0;
	private int rekursionDepth = 0;
	
	public int getRekursionDepth()
	{
		return rekursionDepth;
	}

	public void setRekursionDepth(int rekursionDepth)
	{
		this.rekursionDepth = rekursionDepth;
	}
	
	public void incrementRekursionDepth()
	{
		this.rekursionDepth++;
	}

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
