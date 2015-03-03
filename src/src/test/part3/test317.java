package test.part3;
public class test317
{
	int change() {return 1;}
	public static void main(String args[]){
		int a=10;
		System.out.println(a);
	}
}

class child extends test317
{
	public int change(){return 1;}
	int change(int i){return 1;}
	//private int change(){}
	//abstract int chang(){}
	
}