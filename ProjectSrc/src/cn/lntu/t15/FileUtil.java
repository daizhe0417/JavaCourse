import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * �����ļ� ʵ�ֶ��ļ��Ĵ���������д��ɾ���Ȳ���
 * ѧ���ɼ�����ӡ����ҡ��޸� �ǽ��ļ����ݶ�ȡ���ڴ�list�У����в�������ɺ󣬽�����д�ص��ļ���
 * @author Administrator
 *
 */
public class FileUtil {
	private static final String mainFileName = "main.db";
	/**
	 * ���ѧ���ɼ� ���浽�ļ�
	 * @param content
	 * @return
	 */
	public static boolean saveFileContent(String content){
		FileWriter writer = null;
		try {
			String path = System.getProperty("user.dir");//��ȡ��ǰ·��
			String fileName = path+"/"+mainFileName;//ѧ���ɼ��ļ������ļ���
			File file = new File(fileName);
			if(!file.exists())//�жϸ��ļ��Ƿ����
				file.createNewFile();//�������½�һ�����ļ�
			writer = new FileWriter(fileName, true);
			writer.write(content+"\n");//ѧ���ɼ�д���ļ�

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
	 * ���ݰ༶��ѯ
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
	         // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
	         while ((tempString = reader.readLine()) != null) {
	             if(!"".equals(tempString)){
		             Student student = StringToStudent(tempString);  //��ѧ���ɼ��ַ���ת����ѧ������
		             if(className.equals(student.getClassName())) //����༶������İ༶һ�£��ͽ�ѧ����Ϣ��ӵ�list��
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
	 * ���ݿγ̲�ѯ
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
	         // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
	         while ((tempString = reader.readLine()) != null) {
	             if(!"".equals(tempString)){
		             Student student = StringToStudent(tempString); //��ѧ���ɼ��ַ���ת����ѧ������
		             if(courseName.equals(student.getCourseName()))//����γ�������Ŀγ�һ�£��ͽ�ѧ����Ϣ��ӵ�list��
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
	 * ����ѧ�Ų�ѯ
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
	         // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
	         while ((tempString = reader.readLine()) != null) {
	             if(!"".equals(tempString)){
		             Student student = StringToStudent(tempString);//��ѧ���ɼ��ַ���ת����ѧ������
		             if(stuNo.equals(student.getStuNo())){//���ѧ���������ѧ��һ�£��ͽ�ѧ����Ϣ��ӵ�list��
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
	 * �޸�ѧ���ɼ�
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
	         // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
	         while ((tempString = reader.readLine()) != null) {
	             // ��ʾ�к�
	             if(!"".equals(tempString)){
	            	//��ѧ���ɼ��ַ�����ƥ��ѧ�źͿγ� �����ƥ��ɹ��ͽ����޸Ĳ���
		             if(tempString.indexOf("$"+stuNo+"$")!=-1&&tempString.indexOf("$"+course+"$")!=-1){
		            	System.out.println(tempString);
		            	Student stu = StringToStudent(tempString);
		            	StringBuffer stuInfoBuffer = new StringBuffer();
		         		stuInfoBuffer.append(stu.getClassName()+"$");
		         		stuInfoBuffer.append(stu.getStuNo()+"$");
		         		stuInfoBuffer.append(stu.getName()+"$");
		         		stuInfoBuffer.append(stu.getCourseName()+"$");
		         		stuInfoBuffer.append(score);//�滻���µĳɼ�
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
	 			for(String content:list)//���޸ĺ��ѧ���ɼ� ����֮ǰ��ѧ���ɼ�������֮ǰ��main.db�е����ݣ�
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
		System.out.println("���³ɹ���");
		return true;
	}
	/**
	 * �ַ���ת����Student����
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
	 * ���ư༶�ɼ����ļ�
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
	         // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
	         while ((tempString = reader.readLine()) != null) {
	             // ��ʾ�к�
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
		// ���Ƶ��༶�ļ�
		if(list.size()!=0){
	        FileWriter writer = null;
	 		try {
				String fileName = path+"/data/"+className+".csv";
				File file = new File(fileName);
				if(!file.exists())
					file.createNewFile();
	 			writer = new FileWriter(fileName, false);
	 			writer.write("�༶,ѧ��,����,�γ�,����\n");
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
 		System.out.println("���Ƴɹ���");
		printClassFile();
        return list1;
	}
	/**
	 * ɾ���༶�ɼ��ļ�
	 * @param className
	 * @return
	 */
	public static boolean deleteClassFile(String className){
			String path = System.getProperty("user.dir");
			String fileName = path+"/data/"+className+".csv";
			File file1 = new File(fileName);
			if(file1.exists())
				file1.delete();
			System.out.println("ɾ���ɹ���");
			printClassFile();
		return false;
	}
	/**
	 * ����ѧ���ɼ�
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
	         // һ�ζ���һ�У�ֱ������nullΪ�ļ�����
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
		// ����
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
 		System.out.println("���ݳɹ���");
 		printClassFile("");
		return false;
	}
	/**
	 * ����ѧ���ɼ�
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
				System.out.println("�����ļ������ڣ���ȷ�ϱ����ļ������²�����");
				return false;
			}
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			// һ�ζ���һ�У�ֱ������nullΪ�ļ�����
			while ((tempString = reader.readLine()) != null) {
				// ��ʾ�к�
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
		// ����
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
		System.out.println("�ָ��ɹ���");
		return true;
	}
	public static void printClassFile(String...fileName){
		String path = System.getProperty("user.dir");
		if(fileName.length!=0){
			path = path+"/backup/";
			System.out.println("�����ļ����£�============================");
		}else{
			path = path+"/data/";
			System.out.println("�༶�ɼ��ļ����£�============================");
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

