package test.part3;
class ExSuper
{ 
	String name;
	String nick_name;
	public ExSuper(String s,String t)
	{ 
		name=s;
		nick_name=t;
	} 
	public String toString()
	{
		return name; 
	} 
} 
public class test34 extends ExSuper
{
	public test34(String s,String t)
	{
		super(s,t);
	}
	public String toString()
	{
		return name +"a.k.a"+nick_name;
	}
	public static void main(String args[])
	{
		ExSuper a = new ExSuper("First","1st");
		ExSuper b = new test34("Second","2nd");
		System.out.println("a is"+a.toString());
		System.out.println("b is"+b.toString());
	}
}
