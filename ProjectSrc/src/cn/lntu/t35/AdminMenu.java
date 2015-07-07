package cn.lntu.t35;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;



public class AdminMenu extends JFrame implements MainFrame, Runnable {

	/**
	 * 学校管理员端
	 */
	private static final long serialVersionUID = 1L;

	// private AdminUserService service=new AdminUserService();
	private DefaultMutableTreeNode root0 = new DefaultMutableTreeNode(
			new MyNode("Menu", 0));
	private DefaultMutableTreeNode root1 = new DefaultMutableTreeNode(
			new MyNode("学生信息管理", 1));
	private DefaultMutableTreeNode root2 = new DefaultMutableTreeNode(
			new MyNode("课程信息管理", 2));
	private DefaultMutableTreeNode root3 = new DefaultMutableTreeNode(
			new MyNode("其他信息管理", 3));
	private DefaultMutableTreeNode root4 = new DefaultMutableTreeNode(
			new MyNode("系统选项", 4));
	private DefaultMutableTreeNode root11 = new DefaultMutableTreeNode(
			new MyNode("新生录入", 11));
	private DefaultMutableTreeNode root12 = new DefaultMutableTreeNode(
			new MyNode("学生信息操作", 12));
	private DefaultMutableTreeNode root21 = new DefaultMutableTreeNode(
			new MyNode("成绩录入", 21));
	private DefaultMutableTreeNode root22 = new DefaultMutableTreeNode(
			new MyNode("添加课程", 22));
	private DefaultMutableTreeNode root23 = new DefaultMutableTreeNode(
			new MyNode("成绩查询", 23));
	private DefaultMutableTreeNode root31 = new DefaultMutableTreeNode(
			new MyNode("班级信息管理", 31));
	private DefaultMutableTreeNode root32 = new DefaultMutableTreeNode(
			new MyNode("部门信息管理", 32));
	private DefaultMutableTreeNode root33 = new DefaultMutableTreeNode(
			new MyNode("奖罚管理", 33));
	private DefaultMutableTreeNode root331 = new DefaultMutableTreeNode(
			new MyNode("奖励管理", 331));
	private DefaultMutableTreeNode root332 = new DefaultMutableTreeNode(
			new MyNode("惩罚管理", 332));
	private DefaultMutableTreeNode root41 = new DefaultMutableTreeNode(
			new MyNode("修改密码", 41));
	private DefaultMutableTreeNode root42 = new DefaultMutableTreeNode(
			new MyNode("重新登录", 42));
	private DefaultMutableTreeNode root43 = new DefaultMutableTreeNode(
			new MyNode("退出系统", 43));
	private DefaultTreeModel dtm = new DefaultTreeModel(root0);
	private JTree jtree = new JTree(dtm);
	private JScrollPane scroll = new JScrollPane(jtree);
	private JPanel jpane = new JPanel();
	private JSplitPane jsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
			scroll, jpane);
	
	CardLayout CardLay;
	private  Welcome  welcome;
	private  ChangePassword adminPwd;
    private  StuInformation addStudent; 
    private  InformationOperate infOperate;
    private  InputCourse course;
    private  InputScore score;
    private  QuarryScore quarrys;

	private User user;



	public AdminMenu(User user) {
		
		this.user=user;
		run();

	}

	public void initialFrame() {
		/*
		 * 设置窗口位置为居中，大小，布局
		 */
		this.setResizable(false);
		this.add(jsplit);
		this.setSize(900, 600);
		this.setTitle("管理员客户端");
		jsplit.setDividerLocation(200);
		jsplit.setDividerSize(0);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(screen.width / 2 - this.getWidth() / 2, screen.height
				/ 2 - this.getHeight() / 2);    
		this.setVisible(true);
	}

	public void addJpanel() {
		jpane.setLayout(new CardLayout());
		CardLay = (CardLayout) jpane.getLayout();
		jpane.add(adminPwd, "adminpwd");
		jpane.add(welcome, "welcome");
		jpane.add(addStudent,"addStudent");
		jpane.add(infOperate,"infOperate");
		jpane.add(course,"course");
		jpane.add(score, "inputScore");		
		jpane.add(quarrys, "quarryScore");
		CardLay.show(jpane, "welcome");
		
	}

	public void addListener() {
		/**
		 * 树   按钮设置
		 */
      jtree.addTreeSelectionListener(new TreeSelectionListener() {
		
			public void valueChanged(TreeSelectionEvent e) {
				// TODO Auto-generated method stub
				
				DefaultMutableTreeNode dtm = (DefaultMutableTreeNode) jtree
						.getLastSelectedPathComponent();
				MyNode mynode = (MyNode) dtm.getUserObject();
				if (mynode.getIndex() == 43) {      
					int choose = JOptionPane.showConfirmDialog(getParent(),
							"您确定要退出吗？");
					if (choose == 0) {
						System.exit(0);
					}
				} //系统退出
				
				
				if (mynode.getIndex() == 42) {   
					int choose = JOptionPane.showConfirmDialog(getParent(),
							"您确定要重新登录吗？");
					if (choose == 0) {
						dispose();
						new LoginIn();
					}
					    
				} //重新登录
				
				else if (mynode.getIndex() == 41) {
					CardLay.show(jpane, "adminpwd");
					adminPwd.grabFocus();					
				} // 改密页面
				
				else if (mynode.getIndex() == 11) {
					CardLay.show(jpane, "addStudent");
					addStudent.grabFocus();
				}//学生信息的录入
				
				else if (mynode.getIndex() == 12) {
					CardLay.show(jpane, "infOperate");
					infOperate.grabFocus();
				}//学生信息操作 （删除，修改，添加）
				else if (mynode.getIndex() == 21) {
					CardLay.show(jpane,"inputScore");
					score.grabFocus();
				}//成绩管理
				else if (mynode.getIndex() == 22) {
					CardLay.show(jpane,"course");
					course.grabFocus();
				}//课程信息的录入
				else if (mynode.getIndex() == 23) {
					CardLay.show(jpane,"quarryScore");
					course.grabFocus();
				}//管理员客户端成绩查询
				if (mynode.getIndex() == 0||mynode.getIndex() == 1||
						mynode.getIndex() == 2||mynode.getIndex() == 3||
						mynode.getIndex() == 4) {
					CardLay.show(jpane, "welcome");
					welcome.grabFocus();
				}//设置父类按钮为welcome界面
			}
		});
		

	}

	public void initialTree() {
		root0.add(root1);
		root0.add(root2);
		root0.add(root3);
		root0.add(root4);
		root1.add(root11);
		root1.add(root12);	
		root2.add(root21);
		root2.add(root22);
		root2.add(root23);
		root3.add(root31);
		root3.add(root32);
		root3.add(root33);
		root33.add(root331);
		root33.add(root332); 
		root4.add(root41);
		root4.add(root42);
		root4.add(root43);
		jtree.setToggleClickCount(1);

	}

	public void initialPanel() {
		welcome=new Welcome();
		adminPwd = new ChangePassword(user);
		addStudent = new StuInformation();
		infOperate = new InformationOperate();
		course = new InputCourse();
		score = new InputScore();
		quarrys = new QuarryScore(user);
		
	}

	@Override
	public void run() {
		this.initialTree();
		this.initialPanel();
		this.addListener();
		this.addJpanel();
		this.initialFrame();
		
	}

//	public static void main(String[] args) {
//	new AdminMenu("  ");
//
//	}
}
