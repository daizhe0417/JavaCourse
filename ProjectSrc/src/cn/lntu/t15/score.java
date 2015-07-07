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
					System.out.println("===================ѧ���ɼ�¼��========================");
					Student stu = new Student();
					stu.className = putMessage("¼��༶����:");
					stu.stuNo = putMessage("¼��ѧ��:");
					stu.name = putMessage("¼��������");
					stu.courseName = putMessage("¼��γ�����");
					stu.score = putMessage("¼�������");
					addStuScore(stu);
					break;
				case 2:
					String className = putMessage("����༶���ƣ�");
					List<Student> list = FileUtil.queryByClassName(className);
					System.out.println("�༶	ѧ��	����	�γ�		����");
					System.out.println("=================================================================");
					for(Student student:list){
						System.out.println(student.getClassName()+"	"+student.getStuNo()+"	"+student.getName()+"	"+student.getCourseName()+"	"+student.getScore()+"	");
						System.out.println("-----------------------------------------------------------------");
					}
					break;
				case 3:
					String courseName = putMessage("����γ����ƣ�");
					List<Student> list1 = FileUtil.queryByCourseName(courseName);
					System.out.println("�༶	ѧ��	����	�γ�		����");
					System.out.println("=================================================================");
					for(Student student:list1){
						System.out.println(student.getClassName()+"	"+student.getStuNo()+"	"+student.getName()+"	"+student.getCourseName()+"	"+student.getScore()+"	");
						System.out.println("-----------------------------------------------------------------");
					}
					break;
				case 4:
					String  stuNo= putMessage("����ѧ�ţ�");
					List<Student> list2 = FileUtil.queryByStuNo(stuNo);
					System.out.println("�༶	ѧ��	����	�γ�		����");
					System.out.println("=================================================================");
					for(Student student:list2){
						System.out.println(student.getClassName()+"	"+student.getStuNo()+"	"+student.getName()+"	"+student.getCourseName()+"	"+student.getScore()+"	");
						System.out.println("-----------------------------------------------------------------");
					}
					break;
				case 5:
					String  stuNo1= putMessage("����ѧ�ţ�");
					String  course= putMessage("����γ����ƣ�");
					String  score1 = putMessage("�ɼ��޸�Ϊ��");
					FileUtil.updateScore(stuNo1,course,score1);
					break;
				
				case 6:
					FileUtil.printClassFile();
					String className2 = putMessage("����༶���ƣ�");
					FileUtil.deleteClassFile(className2);
					break;
				case 7:
					String backupName = putMessage("���뱸�ݺ���ļ�����");
					FileUtil.backUpMainFile(backupName);
					break;
				case 8:
					FileUtil.printClassFile("");
					String backupName1 = putMessage("����ָ����ݵ��ļ�����");
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
	 * ѡ��
	 * @return
	 */
	public static int putChooseNum(){
		int chooseNum = 0;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("");
			System.out.println("****************************ѧ���ɼ�����ϵͳ***************************");
			System.out.println("*	1�����ѧ���ɼ� ----------------------------------------------*");
			System.out.println("* 	2�����༶��ѯ�ɼ�---------------------------------------------*");
			System.out.println("* 	3�����γ̲�ѯ�ɼ�---------------------------------------------*");
			System.out.println("* 	4����ѧ�Ų�ѯ�ɼ�---------------------------------------------*");
			System.out.println("* 	5���޸�ѧ���ɼ�-----------------------------------------------*");
			System.out.println("* 	6��ɾ���༶�ɼ��ļ�-------------------------------------------*");
			System.out.println("* 	7������ѧ���ɼ�-----------------------------------------------*");
			System.out.println("* 	8���ָ�ѧ���ɼ�-----------------------------------------------*");
			System.out.println("* 	0���˳�-------------------------------------------------------*");
			System.out.println("************************************************************************");
			System.out.print("��ѡ�������");
			String a = br.readLine();
			System.out.println("");
			chooseNum = Integer.parseInt(a);
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception e){
			System.out.println("��������ѡ��");
		}
		return chooseNum;
	}
	/**
	 * ¼����Ϣ����
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
	 * ���ѧ���ɼ�
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
			System.out.println("¼��ɹ���");
		return false;
	}
	
}
