package test.part3;
public class test315
{
	public int addValue( int a,int b)
	{
		int s;
		s = a+b;
		return s;
	}
}
class Child extends test315
{
	//int addValue( int a, int b ){}
	public void addValue (){}
	public int addValue( int a ){}
	//public int addValue( int a, int b )throws MyException {}
}

class MyException extends Exception
{
}