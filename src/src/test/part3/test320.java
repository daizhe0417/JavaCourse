package test.part3;
class Person
{
	
}

class Teacher extends Person
{
	
}

class Student extends Person
{
	
}

public class test320
{
	public static void main(String args[])
	{
		Person p=new Person();
		Teacher t=new Teacher();
		Student s=new Student();
		if(t instanceof Person) { s = (Student)t; }
	}
}