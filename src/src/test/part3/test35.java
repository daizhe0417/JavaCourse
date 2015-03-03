package test.part3;
abstract class MineBase
{
	abstract void amethod();
	static int i;
}
public class test35 extends MineBase
{
	public static void main(String argv[])
	{
		int[] ar = new int[5];
		for(i = 0;i < ar.length;i++)
			System.out.println(ar[i]);
	}
}
