package il.ac.tau.cs.sw1.ex9.riddles.third;

public class B3 extends A3
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public B3(String s)
	{
		super(s);
		// TODO Auto-generated constructor stub
	}
	
	public void foo(String s) throws Exception
	{
		System.out.println("success!");
		if (s.equals(this.s))
		{
			throw new Exception();
		}
	}
	
	/*
	public void foo(String s) throws Exception
	{
		throw this;
	}
	
	public String getMessage() 
	{
		return s;
	}
	*/
	
}