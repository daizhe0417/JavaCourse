package test.part2;

public class test232 {
	public static void main(String[] args) {
		Person232 p1 = new Person232();
		p1.getInfo();
		Person232 p2 = new Person232("张三", 21);
//		System.out.println(p2.name);
	}
}

class Person232 {
	private String name;
	// Private int age;
	private int age;

	// void private Person(String name,int age)
	public Person232(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Person232(){
		
	}

	void getInfo() {
		System.out.println("I am chinese");
	}
}
