package test.part3;
class Outer1
{
	private int a;
	void foo(double d,final float f)
	{
		String s;
		final boolean b;
		class Inner
		{
			void methodInner()
			{
				System.out.println("in the Inner");
			}
		}
	}
	public static void main(String args[])
	{
		Outer1 me=new Outer1();
		me.foo(123,123);
		System.out.println("outer");
	}
}
