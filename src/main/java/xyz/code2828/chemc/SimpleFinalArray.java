package xyz.code2828.chemc;

public class SimpleFinalArray<T> implements SimpleFinalArrayInterface<T>
{
	private final T[] ar;

	protected SimpleFinalArray(T[] arr)
	{
		this.ar = arr;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasObject(Object t)
	{
		for (int i = 0; i < ar.length; i++)
		{
			if (t.equals(ar[i]))
			{
				return true;
			}
		}
		return false;
	}

}
