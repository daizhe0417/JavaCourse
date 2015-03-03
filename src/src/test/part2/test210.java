package test.part2;
public class test210
{
	public static void main(String arg[])
	{
		String s="hello";
		String t = "hello";
		char c[] = {'h','e','l','l','o'} ;
		
		System.out.println(s.equals(t));
		System.out.println(t.equals(c));
		System.out.println(s==t);
		System.out.println(t.equals(new String("hello")));
	}
} 
