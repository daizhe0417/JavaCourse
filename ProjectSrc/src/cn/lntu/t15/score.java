import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class score {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			int chooseNum = putChooseNum();
			while(chooseNum!=0){
				switch(chooseNum){
				case 1:
					System.out.println("===================学生成绩录入========================");
					Student stu = new Student();
					stu.className = putMessage("录入班级名称:");
					stu.stuNo = putMessage("录入学号:");
					stu.name = putMessage("录入姓名：");
					stu.courseName = putMessage("录入课程名：");
					stu.score = putMessage("录入分数：");
					addStuScore(stu);
					break;
				case 2:
					String className = putMessage("输入班级名称：");
					List<Student> list = FileUtil.queryByClassName(className);
					System.out.println("班级	学号	姓名	课程		分数");
					System.out.println("=================================================================");
					for(Student student:list){
						System.out.println(student.getClassName()+"	"+student.getStuNo()+"	"+student.getName()+"	"+student.getCourseName()+"	"+student.getScore()+"	");
						System.out.println("-----------------------------------------------------------------");
					}
					break;
				case 3:
					String courseName = putMessage("输入课程名称：");
					List<Student> list1 = FileUtil.queryByCourseName(courseName);
					System.out.println("班级	学号	姓名	课程		分数");
					System.out.println("=================================================================");
					for(Student student:list1){
						System.out.println(student.getClassName()+"	"+student.getStuNo()+"	"+student.getName()+"	"+student.getCourseName()+"	"+student.getScore()+"	");
						System.out.println("-----------------------------------------------------------------");
					}
					break;
				case 4:
					String  stuNo= putMessage("输入学号：");
					List<Student> list2 = FileUtil.queryByStuNo(stuNo);
					System.out.println("班级	学号	姓名	课程		分数");
					System.out.println("=================================================================");
					for(Student student:list2){
						System.out.println(student.getClassName()+"	"+student.getStuNo()+"	"+student.getName()+"	"+student.getCourseName()+"	"+student.getScore()+"	");
						System.out.println("-----------------------------------------------------------------");
					}
					break;
				case 5:
					String  stuNo1= putMessage("输入学号：");
					String  course= putMessage("输入课程名称：");
					String  score1 = putMessage("成绩修改为：");
					FileUtil.updateScore(stuNo1,course,score1);
					break;
				
				case 6:
					FileUtil.printClassFile();
					String className2 = putMessage("输入班级名称：");
					FileUtil.deleteClassFile(className2);
					break;
				case 7:
					String backupName = putMessage("输入备份后的文件名：");
					FileUtil.backUpMainFile(backupName);
					break;
				case 8:
					FileUtil.printClassFile("");
					String backupName1 = putMessage("输入恢复备份的文件名：");
					FileUtil.reserve(backupName1);
					break;
				}
				chooseNum = putChooseNum();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 选择
	 * @return
	 */
	public static int putChooseNum(){
		int chooseNum = 0;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("");
			System.out.println("****************************学生成绩管理系统***************************");
			System.out.println("*	1、添加学生成绩 ----------------------------------------------*");
			System.out.println("* 	2、按班级查询成绩---------------------------------------------*");
			System.out.println("* 	3、按课程查询成绩---------------------------------------------*");
			System.out.println("* 	4、按学号查询成绩---------------------------------------------*");
			System.out.println("* 	5、修改学生成绩-----------------------------------------------*");
			System.out.println("* 	6、删除班级成绩文件-------------------------------------------*");
			System.out.println("* 	7、备份学生成绩-----------------------------------------------*");
			System.out.println("* 	8、恢复学生成绩-----------------------------------------------*");
			System.out.println("* 	0、退出-------------------------------------------------------*");
			System.out.println("************************************************************************");
			System.out.print("请选择操作：");
			String a = br.readLine();
			System.out.println("");
			chooseNum = Integer.parseInt(a);
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("你输入编号选择！");
		}
		return chooseNum;
	}
	/**
	 * 录入信息处理
	 * @param tip
	 * @return
	 */
	public static String putMessage(String tip){
		String input = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print(tip);
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return input;
	}
	/**
	 * 添加学生成绩
	 * @return
	 */
	public static boolean addStuScore(Student stu){
		StringBuffer stuInfoBuffer = new StringBuffer();
		stuInfoBuffer.append(stu.getClassName()+"$");
		stuInfoBuffer.append(stu.getStuNo()+"$");
		stuInfoBuffer.append(stu.getName()+"$");
		stuInfoBuffer.append(stu.getCourseName()+"$");
		stuInfoBuffer.append(stu.getScore());
		String result = stuInfoBuffer.toString();
		boolean flag = FileUtil.saveFileContent(result);
		if(flag)
			System.out.println("录入成功！");
		return false;
	}
	
}
