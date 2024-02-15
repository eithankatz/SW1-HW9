package il.ac.tau.cs.sw1.ex9.riddles.second;

public class B2 extends A2
{
	public boolean bool;
	
	public B2(boolean bool)
	{
		//super();
		this.bool = bool;
	}
	
	public B2()
	{
	}
	
	
	public A2 getA(boolean bool)
	{
		return new B2(bool);
	}
	
	public String foo(String s) 
	{
		if(bool)
			return s.toUpperCase();
		else
			return s.toLowerCase();
	}
	
}
