//�߳�ͬ����ԭ��
//�������һ�������ͬ��
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
	//�����ͬ��ʱ�øþ䴴��һ��������Ϊ������
	String str="";
	public void run()
	{
		while(true)
		{
			//�����ͬ��ʱ�øþ�˵����ͬ���Ĵ����
			synchronized(this.tickets)
			{
				if(tickets>0)
				///*��sleep����ģ���жϺ�û���ü��۳����ֵ���һ�߳�ִ��
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
//�����δͬ��ʱƱ�������0����1����2��ͬ����Ʊ�����Ϊ1
//ԭ�򣺼��μ�