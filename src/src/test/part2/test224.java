package test.part2;

class Person {
	String name, department;
	int age;

	public Person(String n) {
		name = n;
	}

	public Person(String n, int a) {
		name = n;
		age = a;
	}

	public Person(String n, String d, int a) {
		// doing the same as two arguments version of constructor
		// including assignment name=n,age=a
//		Person(n,a);
		
		this(n,a);
		department = d;
	}

	private void Person(String n, int a) {
		// TODO Auto-generated method stub
		
	}
}