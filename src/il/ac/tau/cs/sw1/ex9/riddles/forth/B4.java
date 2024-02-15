package il.ac.tau.cs.sw1.ex9.riddles.forth;

import java.util.Iterator;

public class B4 implements Iterator<String>
{
	private String[] strings;
	private int k;
	private int j;

	public B4(String[] strings, int k) 
	{
		this.strings = strings;
		this.k = k;
		this.j = 0;
	}

	@Override
	public boolean hasNext() 
	{
		return (j < k*strings.length); 
	}

	@Override
	public String next() 
	{
		return strings[this.j++ % strings.length];
	}
	
}