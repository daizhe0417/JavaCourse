package test.part2;

public class test235 {
	public static void main(String[] args) {
		Outer outer = new Outer();
//		Outer.Inner inner = new outer.Inner();
		Outer.Inner inner =  outer.new Inner();
		// outer.new Inner()
		inner.doStuff();
	}
}

class Outer {
	private int size = 10;

	public class Inner {
		public void doStuff() {
			System.out.println(++size);
		}
	}
}