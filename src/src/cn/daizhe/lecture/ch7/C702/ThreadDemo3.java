package cn.daizhe.lecture.ch7.C702;

//两种方式的比较、售票的例子
//四个窗口同时卖100张票，
//用四个进程表示四个窗口，则四个进程需要对同一个tickets变量操作
public class ThreadDemo3 {
	public static void main(String args[]) {
		// 方法一：调用线程t的start方法四次，试图使线程t执行四次 //结果：不行，出现异常，一个线程死亡前只能开始一次
		// TestThread3 t = new TestThread3();
		// t.start();
		// t.start();
		// t.start();
		// t.start();
		// 方法二：创建四个线程， //结果：不行，四个线程都有各自的tickets变量 //相当于四个售票口各卖了100张票 new
		// new TestThread3().start();
		// new TestThread3().start();
		// new TestThread3().start();
		// new TestThread3().start();

		// /*方法三：创建一个目标对象t，用它创建四个线程
		// 结果：可以，四个线程共享同一个目标对象的变量
		TestThread3 t = new TestThread3();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		// */
	}
}

class TestThread3 implements Runnable {
	// class TestThread3 extends Thread {
	private int tickets = 100;

	public void run() {
		for (int i = 1; i < 10000; i++) {
			if (tickets > 0)
				System.out.println(Thread.currentThread().getName()
						+ " is saling tickets " + tickets--);
		}
	}
}