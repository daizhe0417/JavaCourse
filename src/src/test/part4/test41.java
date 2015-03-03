package test.part4;
public class test41 extends Thread implements Runnable
{
	public void run()
	{
		System.out.println(" this is run()");
	}
	public static void main(String args[])
	{
		Thread t=new Thread(new test41());
		t.start();
	}
}
