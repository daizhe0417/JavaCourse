package test.part3;
class Person
{
	public void printValue(int i,int j)
	{
		System.out.println("printValue(int i,int j)");
	}
	public void printValue(int i)
	{
		System.out.println("printValue(int i) in Person");
	}
}
public class test312 extends Person
{
	public void printValue()
	{
		System.out.println("printValue()");
	}
	public void printValue(int i)
	{
		System.out.println("printValue(int i) in test312");
	}
	public static void main(String args[])
	{
		Person t = new test312();
		t.printValue(10);
	}
}
