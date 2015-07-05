package cn.daizhe.lecture.ch9.C902;

import java.io.*;

public class TextFile {
	private String filename;

	public TextFile(String filename) {
		this.filename = filename;
	}

	// 将Fibonacci序列值写入指定文本文件
	public void writeToFile() throws IOException {
		FileWriter fout = new FileWriter(this.filename);
		String str = "asdfa";
			fout.write(str); // 向文件字符输出流写入一个字符串

		fout.close();
		System.out.println("Write Fibonacci to File " + this.filename);
	}

	// 从指定文本文件中读取字符串
	public void readFromFile() throws IOException {
		FileReader fin = new FileReader(this.filename);
		BufferedReader bin = new BufferedReader(fin);

		System.out.println("readFromFile " + this.filename);

		String aline = "";
		do {
			aline = bin.readLine(); // 读取一行字符串，输入流结束时返回null
			if (aline != null)
				System.out.println(aline);
		} while (aline != null);

		bin.close();
		fin.close();
	}

	public static void main(String args[]) throws IOException {
		TextFile afile = new TextFile("wu.txt");
		afile.writeToFile();
		afile.readFromFile();
	}
}