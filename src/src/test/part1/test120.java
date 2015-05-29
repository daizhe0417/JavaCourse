package test.part1;

/**
 * 下面程序是否会导致错误，若有，那行出错，原因何在
 * 
 * @author daizhe
 *
 */
public class test120 {

	public static void main(String[] args) {
		String str = null;
		if ((str != null) && (str.length() > 10)) {
			System.out.println("more than 10");
		} else if ((str != null) & (str.length() < 5)) {
			System.out.println("less than 5");
		} else {
			System.out.println("end");
		}
	}
}
