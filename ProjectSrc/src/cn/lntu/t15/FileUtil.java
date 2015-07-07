import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 操作文件 实现对文件的创建、读、写、删除等操作
 * 学生成绩的添加、查找、修改 是将文件内容读取到内存list中，进行操作，完成后，将内容写回到文件中
 * @author Administrator
 *
 */
public class FileUtil {
	private static final String mainFileName = "main.db";
	/**
	 * 添加学生成绩 保存到文件
	 * @param content
	 * @return
	 */
	public static boolean saveFileContent(String content){
		FileWriter writer = null;
		try {
			String path = System.getProperty("user.dir");//获取当前路径
			String fileName = path+"/"+mainFileName;//学生成绩文件（主文件）
			File file = new File(fileName);
			if(!file.exists())//判断该文件是否存在
				file.createNewFile();//不存在新建一个空文件
			writer = new FileWriter(fileName, true);
			writer.write(content+"\n");//学生成绩写入文件

		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}finally{
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return true;
	}
	/**
	 * 根据班级查询
	 * @param className
	 * @return
	 */
	public static List<Student> queryByClassName(String className){
		BufferedReader reader = null;
		List<Student> list = new ArrayList<Student>();
		try{
			String path = System.getProperty("user.dir");
			String fileName = path+"/"+mainFileName;
			File file = new File(fileName);
			 reader = new BufferedReader(new FileReader(file));
	         String tempString = null;
	         // 一次读入一行，直到读入null为文件结束
	         while ((tempString = reader.readLine()) != null) {
	             if(!"".equals(tempString)){
		             Student student = StringToStudent(tempString);  //将学生成绩字符串转换成学生对象
		             if(className.equals(student.getClassName())) //如果班级与输入的班级一致，就将学生信息添加到list中
		            	 list.add(student);
	             }
	         }
		  } catch (IOException e) {
	          e.printStackTrace();
	      } finally {
	          if (reader != null) {
	              try {
	                  reader.close();
	              } catch (IOException e1) {
	              }
	          }
	      }

		return list;
	}
	/**
	 * 根据课程查询
	 * @param courseName
	 * @return
	 */
	public static List<Student> queryByCourseName(String courseName){
		BufferedReader reader = null;
		List<Student> list = new ArrayList<Student>();
		try{
			String path = System.getProperty("user.dir");
			String fileName = path+"/"+mainFileName;
			File file = new File(fileName);
			 reader = new BufferedReader(new FileReader(file));
	         String tempString = null;
	         // 一次读入一行，直到读入null为文件结束
	         while ((tempString = reader.readLine()) != null) {
	             if(!"".equals(tempString)){
		             Student student = StringToStudent(tempString); //将学生成绩字符串转换成学生对象
		             if(courseName.equals(student.getCourseName()))//如果课程与输入的课程一致，就将学生信息添加到list中
		            	 list.add(student);
	             }
	         }
		  } catch (IOException e) {
	          e.printStackTrace();
	      } finally {
	          if (reader != null) {
	              try {
	                  reader.close();
	              } catch (IOException e1) {
	              }
	          }
	      }

		return list;
	}
	/**
	 * 根据学号查询
	 * @param stuNo
	 * @return
	 */
	public static List<Student> queryByStuNo(String stuNo){
		BufferedReader reader = null;
		List<Student> list = new ArrayList<Student>();
		try{
			String path = System.getProperty("user.dir");
			String fileName = path+"/"+mainFileName;
			File file = new File(fileName);
			 reader = new BufferedReader(new FileReader(file));
	         String tempString = null;
	         // 一次读入一行，直到读入null为文件结束
	         while ((tempString = reader.readLine()) != null) {
	             if(!"".equals(tempString)){
		             Student student = StringToStudent(tempString);//将学生成绩字符串转换成学生对象
		             if(stuNo.equals(student.getStuNo())){//如果学号与输入的学号一致，就将学生信息添加到list中
		            	 list.add(student);
		             }
	             }
	         }
		  } catch (IOException e) {
	          e.printStackTrace();
	      } finally {
	          if (reader != null) {
	              try {
	                  reader.close();
	              } catch (IOException e1) {
	              }
	          }
	      }

		return list;
	}
	/**
	 * 修改学生成绩
	 * @param stuNo
	 * @param score
	 * @return
	 */
	public static boolean updateScore(String stuNo,String course,String score){
		BufferedReader reader = null;
		List<String> list = new ArrayList<String>();
		try{
			String path = System.getProperty("user.dir");
			String fileName = path+"/"+mainFileName;
			File file = new File(fileName);
			 reader = new BufferedReader(new FileReader(file));
	         String tempString = null;
	         // 一次读入一行，直到读入null为文件结束
	         while ((tempString = reader.readLine()) != null) {
	             // 显示行号
	             if(!"".equals(tempString)){
	            	//在学生成绩字符串中匹配学号和课程 如果都匹配成功就进行修改操作
		             if(tempString.indexOf("$"+stuNo+"$")!=-1&&tempString.indexOf("$"+course+"$")!=-1){
		            	System.out.println(tempString);
		            	Student stu = StringToStudent(tempString);
		            	StringBuffer stuInfoBuffer = new StringBuffer();
		         		stuInfoBuffer.append(stu.getClassName()+"$");
		         		stuInfoBuffer.append(stu.getStuNo()+"$");
		         		stuInfoBuffer.append(stu.getName()+"$");
		         		stuInfoBuffer.append(stu.getCourseName()+"$");
		         		stuInfoBuffer.append(score);//替换成新的成绩
		         		String result = stuInfoBuffer.toString();
		         		list.add(result);
		             }else{
		            	list.add(tempString);
		             }
	             }
	         }
	         
	         
	        FileWriter writer = null;
	 		try {
	 			writer = new FileWriter(fileName, false);
	 			for(String content:list)//将修改后的学生成绩 覆盖之前的学生成绩（覆盖之前的main.db中的内容）
	 				writer.write(content+"\n");

	 		} catch (IOException e) {
	 			e.printStackTrace();
	 			return false;
	 		}finally{
	 			try {
	 				writer.close();
	 			} catch (IOException e) {
	 				e.printStackTrace();
	 			}
	 			
	 		}
		  } catch (IOException e) {
	          e.printStackTrace();
	      } finally {
	          if (reader != null) {
	              try {
	                  reader.close();
	              } catch (IOException e1) {
	              }
	          }
	      }
		System.out.println("更新成功！");
		return true;
	}
	/**
	 * 字符串转换成Student对象
	 * @param stustr
	 * @return
	 */
	public static Student StringToStudent(String stustr){
		 Student student  = new Student();
		 String[] studentInfo = stustr.split("\\$");
		 student.className = studentInfo[0];
		 student.stuNo = studentInfo[1];
		 student.name = studentInfo[2];
		 student.courseName = studentInfo[3];
		 student.score = studentInfo[4];
		 return student;
	}
	/**
	 * 复制班级成绩到文件
	 * @param className
	 * @return
	 */
	public static List<String> copyScoreToFile(String className){
		BufferedReader reader = null;
		List<String> list = new ArrayList<String>();
		List<String> list1 = new ArrayList<String>();
		String path = System.getProperty("user.dir");
		try{
			String fileName = path+"/"+mainFileName;
			File file = new File(fileName);
			 reader = new BufferedReader(new FileReader(file));
	         String tempString = null;
	         // 一次读入一行，直到读入null为文件结束
	         while ((tempString = reader.readLine()) != null) {
	             // 显示行号
	             if(!"".equals(tempString)){
		             if(tempString.indexOf(className+"$")!=-1){
		         		list.add(tempString);
		             }
	             }
	         }
	         
	         
		  } catch (IOException e) {
	          e.printStackTrace();
	      } finally {
	          if (reader != null) {
	              try {
	                  reader.close();
	              } catch (IOException e1) {
	              }
	          }
	      }
		// 复制到班级文件
		if(list.size()!=0){
	        FileWriter writer = null;
	 		try {
				String fileName = path+"/data/"+className+".csv";
				File file = new File(fileName);
				if(!file.exists())
					file.createNewFile();
	 			writer = new FileWriter(fileName, false);
	 			writer.write("班级,学号,姓名,课程,分数\n");
	 			for(String content:list)
	 				writer.write(content.replace("$", ",")+"\n");
	
	 		} catch (IOException e) {
	 			e.printStackTrace();
	 		}finally{
	 			try {
	 				writer.close();
	 			} catch (IOException e) {
	 				e.printStackTrace();
	 			}
	 		}
		}
 		System.out.println("复制成功！");
		printClassFile();
        return list1;
	}
	/**
	 * 删除班级成绩文件
	 * @param className
	 * @return
	 */
	public static boolean deleteClassFile(String className){
			String path = System.getProperty("user.dir");
			String fileName = path+"/data/"+className+".csv";
			File file1 = new File(fileName);
			if(file1.exists())
				file1.delete();
			System.out.println("删除成功！");
			printClassFile();
		return false;
	}
	/**
	 * 备份学生成绩
	 * @param mainBackup
	 * @return
	 */
	public static boolean backUpMainFile(String mainBackup){
		BufferedReader reader = null;
		List<String> list = new ArrayList<String>();
		List<String> list1 = new ArrayList<String>();
		String path = System.getProperty("user.dir");
		try{
			String fileName = path+"/"+mainFileName;
			File file = new File(fileName);
			 reader = new BufferedReader(new FileReader(file));
	         String tempString = null;
	         // 一次读入一行，直到读入null为文件结束
	         while ((tempString = reader.readLine()) != null) {
	             if(!"".equals(tempString)){
		         		list.add(tempString);
	             }
	         }
	         
	         
		  } catch (IOException e) {
	          e.printStackTrace();
	      } finally {
	          if (reader != null) {
	              try {
	                  reader.close();
	              } catch (IOException e1) {
	              }
	          }
	      }
		// 备份
		if(list.size()!=0){
	        FileWriter writer = null;
	 		try {
				String fileName = path+"/backup/"+mainBackup;
				File file = new File(fileName);
				File file1 = new File(path+"/backup/");
				if(!file1.exists()){
					file1.mkdirs();
				}
				if(!file.exists())
					file.createNewFile();
	 			writer = new FileWriter(fileName, false);
	 			for(String content:list)
	 				writer.write(content+"\n");
	
	 		} catch (IOException e) {
	 			e.printStackTrace();
	 		}finally{
	 			try {
	 				writer.close();
	 			} catch (IOException e) {
	 				e.printStackTrace();
	 			}
	 		}
		}
 		System.out.println("备份成功！");
 		printClassFile("");
		return false;
	}
	/**
	 * 备份学生成绩
	 * @param mainBackup
	 * @return
	 */
	public static boolean reserve(String mainBackup){
		BufferedReader reader = null;
		List<String> list = new ArrayList<String>();
		List<String> list1 = new ArrayList<String>();
		String path = System.getProperty("user.dir");
		try{
			
			String fileName = path+"/backup/"+mainBackup;
			File file = new File(fileName);
			if(!file.exists()){
				System.out.println("备份文件不存在，请确认备份文件后，重新操作！");
				return false;
			}
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				if(!"".equals(tempString)){
					list.add(tempString);
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		// 备份
		if(list.size()!=0){
			FileWriter writer = null;
			try {
				String fileName = path+"/"+mainFileName;
				File file = new File(fileName);
				if(!file.exists())
					file.createNewFile();
				writer = new FileWriter(fileName, false);
				for(String content:list)
					writer.write(content+"\n");
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("恢复成功！");
		return true;
	}
	public static void printClassFile(String...fileName){
		String path = System.getProperty("user.dir");
		if(fileName.length!=0){
			path = path+"/backup/";
			System.out.println("备份文件如下：============================");
		}else{
			path = path+"/data/";
			System.out.println("班级成绩文件如下：============================");
		}
		File file = new File(path);  
        if (file.isDirectory()) {  
            File[] dirFile = file.listFiles();  
            for (File f : dirFile) {  
            	if(fileName.length==0){
                    if (f.getName().endsWith(".csv"))  {
                        System.out.println(f.getAbsolutePath());  
                    }
            	}else{
            		 System.out.println(f.getAbsolutePath());  
            	}
            }  
        }  
	}
}

