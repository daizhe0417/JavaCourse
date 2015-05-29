//线程同步的原因
//解决方法一，代码块同步
public class ThreadDemo4
{
	public static void main(String args[])
	{
		TestThread t=new TestThread();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
	}
}

class TestThread implements Runnable//extends Thread
{
	private int tickets=100;
	//代码块同步时用该句创建一个对象作为监视器
	String str="";
	public void run()
	{
		while(true)
		{
			//代码块同步时用该句说明需同步的代码块
			synchronized(this.tickets)
			{
				if(tickets>0)
				///*用sleep方法模拟判断后没来得及售出即轮到下一线程执行
				{
					try
					{
						Thread.sleep(5);
					}
					catch(InterruptedException e)
					{
					}
				//*/
					System.out.println(Thread.currentThread().getName()+
				" is saling tickets "+tickets--);
				}
			}
		}
	}
}
//结果：未同步时票数会出现0、－1、－2，同步后票数最后为1
//原因：见课件