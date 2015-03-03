package test.part2;
/*��дһ��Java���򣬶���һ����ʾѧ�����Student��
 *������Ա����"ѧ��"��"�༶"��"����"��"�Ա�"��"����"��
 *����"���ѧ��"��"��ð༶"��"����Ա�"��"�������"��"�������"��"�޸�����"��*/
 
 class student
 {
 	String name;
 	int id;
 	String cl;
 	String sex;
 	int age;
 	
 	public student()
 	{
 		
 	}
 	public student(String name,int id,String cl,String sex,int age)
 	{
 		this.name=name;
 		this.id=id;
 		this.cl=cl;
 		this.sex=sex;
 		this.age=age;
 	}
 	
 	public String getName()
 	{
 		return name;
 	}
 	public int getId()
 	{
 		return id;
 	}
 	public String getCl()
 	{
 		return cl;
 	}
 	public String getSex()
 	{
 		return sex;
 	}
 	public int getAge()
 	{
 		return age;
 	}
 }
 public class test237
 {
 	public static void main(String args[])
 	{
 		student s1=new student();
 		student s2=new student("zhang",1,"jisuanji","male",21);
 		System.out.println("s1: "+s1.getName()+s1.getId()+s1.getCl()+s1.getSex()+s1.getAge());
 		System.out.println("s2: "+s2.getName()+s2.getId()+s2.getCl()+s2.getSex()+s2.getAge());
 	}
 }