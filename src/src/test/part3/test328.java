package test.part3;
public class test328 extends TT
{
	public static void main(String args[])
	{
		test328 t = new test328("Tom");
	}
	public test328(String s)
	{
		super(s);
		System.out.println("How do you do?");
	}
	public test328()
	{
		this("I am Tom");
	}
} 
class TT
{
	public TT()
	{
		System.out.println("What a pleasure!");
	}
	public TT(String s)
	{
		this();
		System.out.println("I am "+s);
	}
}
