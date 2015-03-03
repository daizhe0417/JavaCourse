package test.part3;
class Parent
{
	String one, two;
	public Parent(String a, String b)
	{
		one = a;
		two = b;
	}
	public void print()
	{
		System.out.println(one);
	}
}
public class test318 extends Parent
{
	public test318(String a, String b)
	{
		super(a,b);
	}
	public void print()
	{
		System.out.println(one + " to " + two);
	}
	public static void main(String arg[])
	{
		Parent p = new Parent("south", "north");
		Parent t = new test318("east", "west");
		p.print();
		t.print();
	}
}
