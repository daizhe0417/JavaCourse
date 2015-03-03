package test.part1;
public class text118
{
	public static void main(String [] args)
	{
		boolean a=false;
		boolean b=true;
		boolean c=(a&&b)&&(!b);
		int result=c==false?1:2;
		System.out.println("c= "+c+"  resule= "+result);
	}
}
