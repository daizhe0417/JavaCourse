package cn.lntu.t31.Persistent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import cn.lntu.t31.Interface.IFilesHelper;

public class FilesOperate implements IFilesHelper{

	/**
	 * BufferedReader读文�?
	 */
	@SuppressWarnings("resource")
	@Override
	public String readFiles(String url) {
		String str = null,res=null;
		try{
		// 创建文件对象，在当前位置下的emp.txt文件
		File file = new File(".\\"+url);
		// 输出当前位置的绝对路径（应将url文件放到这个路径下，才能读到文件�?
		FileReader fin;
		try {
			fin = new FileReader(file);
			BufferedReader bin = new BufferedReader(fin);
			// 循环读文件各行内容，并做相应处理
			str = bin.readLine();
			while ((str = bin.readLine()) != null) {
				res =res + str+"";
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
			}
		fin.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return str;
	}
	
	/**
	 * Fibonacci 写文�?
	 */
	public int writeToFile(String filename, String buffer){
		FileWriter fout;
		try {
			fout = new FileWriter(filename);
			fout.write(buffer); // 向文件字符输出流写入�?个字符串	
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
		try {
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
		return 1;
	}

	/**
	 * 从指定文本文件中读取字符�?
	 */
	public String readFromFile(String filename){
		FileReader fin;
		String res = null;
		try {
			fin = new FileReader(filename);
			BufferedReader bin = new BufferedReader(fin);
			do {
				try {
					res = bin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				} 
				// 读取�?行字符串，输入流结束时返回null
				if (res != null)
					System.out.println(res);
			} while (res != null);
			try {
				bin.close();
				fin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
      return res;
	}
	
}
