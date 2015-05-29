package cn.daizhe.lecture.ch5.C501;

/**
 * java编译时能产生除数为整数0的异常，除数为浮点0.0时结果为无穷大
 * 
 * @author venice
 * @version 2013
 */
public class ZeroTest {
	static String str[];

	public static void main(String args[]) {
		int i = 0;
//		System.out.println(3 / i);// 此代码将产生ArithmeticException
		System.out.print(3 / 0.0);// 结果为Infinity
		double d = 0.0;
		System.out.print(3 / d);// 结果为Infinity

		// str虽然是成员变量，会自动初始化，但引用类型的初始化为null
		// 因此访问str[0]将空指针异常
		// 异常信息将会先于上面两个Infinity输出
		// 因为异常信息由System.err错误流输出，这个流是无缓冲的
		// 而System.out流是行缓冲的，遇到换行时才真正输出至屏幕
		System.err.println(str[0]);
	}
}
