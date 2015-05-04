package cn.lntu.t25;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;



public class SchoolAdminClient extends JFrame implements MainFrame,Runnable{

	
	private static final long serialVersionUID = -2976953786977125434L;
    private  int id;
    private  String password,sql;
	private  DefaultMutableTreeNode  root=new DefaultMutableTreeNode(new MyNode("菜单",0));
	private  DefaultMutableTreeNode  root1=new DefaultMutableTreeNode(new MyNode("学生信息管理",1));
	private  DefaultMutableTreeNode  root2=new DefaultMutableTreeNode(new  MyNode("企业信息管理",2));
	private  DefaultMutableTreeNode  root3=new DefaultMutableTreeNode(new  MyNode("院系专业管理",3));
	private  DefaultMutableTreeNode  root4=new DefaultMutableTreeNode(new  MyNode("系统管理",4));
	private  DefaultMutableTreeNode  root11=new DefaultMutableTreeNode(new  MyNode("录入学生信息",11));
	private  DefaultMutableTreeNode  root12=new DefaultMutableTreeNode(new  MyNode("学生信息查询修改",12));
	private  DefaultMutableTreeNode  root21=new DefaultMutableTreeNode(new  MyNode("录入企业信息",21));
	private  DefaultMutableTreeNode  root22=new DefaultMutableTreeNode(new  MyNode("企业信息修改",22));
	private  DefaultMutableTreeNode  root31=new DefaultMutableTreeNode(new  MyNode("院系专业处理",31));
	private  DefaultMutableTreeNode  root32=new DefaultMutableTreeNode(new  MyNode("查询就业信息",32));
	private  DefaultMutableTreeNode  root41=new DefaultMutableTreeNode(new  MyNode("修改密码",41));
	private  DefaultMutableTreeNode  root42=new DefaultMutableTreeNode(new  MyNode("退出系统",42));
	private  DefaultTreeModel    dtm=new  DefaultTreeModel(root);
	private  JTree  jtree=new  JTree(dtm);
	private  JScrollPane  scroll=new JScrollPane(jtree);
	private  JPanel jpane=new JPanel();
	private  JSplitPane jsplit=new  JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,jpane);
	private  CardLayout  cardlay;
	private   Welcome  welcome;
	private  ChangePassword changepassword;
	private  InputStuInfo  stuinfo;
	private  EmployRate  rate;
	private   InputEnInfo  enterinfo;
	private  StudentInformationQU  qustuinfor;
	private  EnterpriseInforQU     quenterinfor;  
	private  CollegeManager  collegemana;
	SchoolAdminClient(int id,String password){
		
		this.id = id;
		this.password = password;
		run();
		
	}
	
	

	@Override
	public void initialFrame() {
	this.add(jsplit);
	this.setSize(1000, 700);
	this.setTitle("管理员客户端");
	jsplit.setDividerLocation(200);
	jsplit.setDividerSize(6);
	Dimension  screen=Toolkit.getDefaultToolkit().getScreenSize();
	this.setLocation(screen.width/2-this.getWidth()/2, screen.height/2-this.getHeight()/2);
	this.setVisible(true);
	}

	@Override
	public void addJpanel() {
	  jpane.setLayout(new CardLayout());
	  cardlay=(CardLayout) jpane.getLayout();
	  jpane.add(welcome,"welcome");
	  jpane.add(changepassword,"changepassword");
	  jpane.add(stuinfo,"stuinfo");
	  jpane.add(rate,"rate");
	  jpane.add(enterinfo,"enterinfo");
	  jpane.add(qustuinfor,"qustuinfor");
	  jpane.add(quenterinfor,"quenterinfor");
	  jpane.add(collegemana,"collegemana");
	  cardlay.show(jpane, "welcome");
		
	}

	@Override
	public void addListener() {
	jtree.addMouseListener(new MouseAdapter(){
		public  void  mouseClicked(MouseEvent e){
		DefaultMutableTreeNode  dtm=	(DefaultMutableTreeNode) jtree.getLastSelectedPathComponent();
		MyNode  mynode=(MyNode) dtm.getUserObject();
			if(mynode.getIndex()==11){
				cardlay.show(jpane, "stuinfo");
				
			}
	        if(mynode.getIndex()==12){
			cardlay.show(jpane, "qustuinfor");
				
			}		
	        if(mynode.getIndex()==21){
				cardlay.show(jpane, "enterinfo");
				
			}
	        if(mynode.getIndex()==22){
				cardlay.show(jpane, "quenterinfor");
				
			}	
	        if(mynode.getIndex()==31){
				cardlay.show(jpane, "collegemana");
				
			}if(mynode.getIndex()==32){
				
				cardlay.show(jpane, "rate");
				
			}
			if(mynode.getIndex()==41){
				
				cardlay.show(jpane, "changepassword");
				
			}	
			if(mynode.getIndex()==42){
				
				int choose=JOptionPane.showConfirmDialog(getParent(), "您确认要退出吗？");
				if(choose==0){
			         	System.exit(0);
				}
			}	
		}
	});
		
	}

	@Override
	public void initialTree() {
	root.add(root1);
	root.add(root2);
	root.add(root3);
	root.add(root4);
	root1.add(root11);
	root1.add(root12);
	root2.add(root21);
	root2.add(root22);
	root3.add(root31);
	root3.add(root32);
	root4.add(root41);
	root4.add(root42);
	jtree.setToggleClickCount(1);
		
	}

	@Override
	public void initialPanel() {
		welcome=new Welcome();
		sql="update  admin_user set password=?   where  id=? ";
		changepassword=new  ChangePassword(id,password,sql);
		stuinfo=new  InputStuInfo();
		qustuinfor=new StudentInformationQU();
		rate=new  EmployRate();
		enterinfo=new  InputEnInfo();
		quenterinfor=new EnterpriseInforQU();
		collegemana=new CollegeManager();
	}

	@Override
	public void run() {
		this.initialTree();
		this.initialPanel();
		this.addListener();
		this.addJpanel();
		this.initialFrame();
	}	
}
