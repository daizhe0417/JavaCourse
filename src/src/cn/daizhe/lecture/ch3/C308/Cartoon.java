package cn.daizhe.lecture.ch3.C308;

/**
 * 类的实例化的过程：先执行父类构造方法，再初始化本类实例成员，最后执行本类构造方法的其他部分
 * Constructor calls during inheritance. From 'Thinking in Java, 2nd ed.'
 * 
 * @author Bruce Eckel
 * 
 */
class Art {
	Art(String str) {
		System.out.println("Art constructor " + str);
	}
}

class Drawing extends Art {
	Art a = new Art(" a in Drawing ");

	Drawing(String str) {
		super(" super in Drawing ");
		System.out.println("Drawing constructor " + str);
	}
}

public class Cartoon extends Drawing {
	Art a = new Art(" a in Cartoon");
	Drawing d = new Drawing(" d in Cartoon");

	Cartoon(String str) {
		super(" super in Cartoon");
		System.out.println("Cartoon constructor " + str);
	}

	public static void main(String[] args) {
		Cartoon x = new Cartoon(" x in main");
	}
}

/*
执行结果：
Art constructor  super in Drawing 
Art constructor  a in Drawing 
Drawing constructor  super in Cartoon
Art constructor  a in Cartoon
Art constructor  super in Drawing 
Art constructor  a in Drawing 
Drawing constructor  d in Cartoon
Cartoon constructor  x in main
*/
