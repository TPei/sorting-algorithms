package Helper;

public abstract class CountingSorter
{
	private long stepCount = 0;
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

	public int countStep(int i)
	{
		stepCount++;
		return i;
	}
	
	public long getStepcount()
	{
		return stepCount;
	}

}
