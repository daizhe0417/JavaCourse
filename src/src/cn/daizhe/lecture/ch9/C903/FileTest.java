package cn.daizhe.lecture.ch9.C903;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		File file = new File("filetest.txt");
		File currentPath = new File(".");
		System.out.println(currentPath.getAbsolutePath() + "   "
				+ file.getAbsolutePath());
		// 若文件不存在，单纯创建File类实例，不会真的创建文件，执行crateNewFile会创建不存在的文件
		try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// 若文件不存在，单纯创建File类实例，不会真的创建文件，创建输出流时会创建文件
		// try {
		// FileWriter fw=new FileWriter(file);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// 文件不存在，读文件时会报java.io.FileNotFoundException异常
//		try {
//			FileReader fw = new FileReader(file);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
