package expe.ch2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取文本文件信息
 * @author venice
 * @version 2013-03-12
 */
public class ReadFile {
	public static void main(String args[]) {
		// 创建文件对象，在当前位置下的emp.txt文件
		File file = new File("emp.txt");
		// 输出当前位置的绝对路径（应将emp.txt文件放到这个路径下，才能读到文件）
		System.out.println(new File(".").getAbsolutePath());
		FileReader fin;
		try {
			fin = new FileReader(file);
			BufferedReader bin = new BufferedReader(fin);
			String str = null;
			List emplist=new ArrayList();
			// 循环读文件各行内容，并做相应处理
			str=bin.readLine();
			while ((str = bin.readLine()) != null) {
				System.out.println(str);
				EmployeeModel em=new EmployeeModel();
				String emp[]=str.split("\t");
				em.setYgno(emp[0]);
				em.setYgxm(emp[1]);
				em.setZw(emp[2]);
				
				emplist.add(em);
			}
			
			for(int i=0;i<emplist.size();i++){
				Object obj=emplist.get(i);
				obj.toString();
				EmployeeModel em=(EmployeeModel) emplist.get(i);
				System.out.println(em);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
