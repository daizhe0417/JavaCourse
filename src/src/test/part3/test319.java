package test.part3;
class Parent{
	private String name;
	public Parent(){}
}

public class Child extends Parent{
	private String department;
	public Child() {}
	public String getValue(){ return name; }
	public static void main(String arg[]){
		Parent p = new Parent();
	}
}
