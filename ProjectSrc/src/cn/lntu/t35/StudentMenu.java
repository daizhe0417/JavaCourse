package cn.lntu.t35;

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

import cn.lntu.t35.User;
import cn.lntu.t35.Welcome;

public class StudentMenu extends JFrame implements MainFrame {
	
	/**
	 * 学生端
	 */
	private static final long serialVersionUID = 1L;
	// private StuUserService service=new StuUserService();
	private DefaultMutableTreeNode root = new DefaultMutableTreeNode(
			new MyNode("Menu", 0));
	private DefaultMutableTreeNode root1 = new DefaultMutableTreeNode(
			new MyNode("信息查询", 1));
	private DefaultMutableTreeNode root2 = new DefaultMutableTreeNode(
			new MyNode("课程信息", 2));
	private DefaultMutableTreeNode root3 = new DefaultMutableTreeNode(
			new MyNode("系统选项", 3));
	private DefaultMutableTreeNode root11 = new DefaultMutableTreeNode(
			new MyNode("个人信息", 11));
	private DefaultMutableTreeNode root12 = new DefaultMutableTreeNode(
			new MyNode("成绩查询", 12));
	private DefaultMutableTreeNode root21 = new DefaultMutableTreeNode(
			new MyNode("选课信息", 21));
	private DefaultMutableTreeNode root22 = new DefaultMutableTreeNode(
			new MyNode("课程表", 22));
	private DefaultMutableTreeNode root31 = new DefaultMutableTreeNode(
			new MyNode("修改密码", 31));
	private DefaultMutableTreeNode root32 = new DefaultMutableTreeNode(
			new MyNode("重新登陆", 32));
	private DefaultMutableTreeNode root33 = new DefaultMutableTreeNode(
			new MyNode("退出系统", 33));
	private DefaultTreeModel dtm = new DefaultTreeModel(root);
	private JTree jtree = new JTree(dtm);
	private JScrollPane scroll = new JScrollPane(jtree);
	private JPanel jpane = new JPanel();
	private JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
			scroll, jpane);
	
	CardLayout CardLay;
	private   Welcome  welcome;
	private   ChangePassword userPwd;
	private   User user;
	private   PersonalStuInfo personal;
	
	
	StudentMenu(User user) {
		this.user=user;
        this.initialTree();
		this.initialPanel();
		this.addListener();
		this.addJpanel();
		this.initialFrame();

	}

	@Override
	public void initialFrame() {
		this.setResizable(false);
		this.add(split);
		this.setSize(900, 600);
		split.setDividerLocation(200);
		split.setDividerSize(0);
		this.setTitle("学生客户端");
		this.setVisible(true);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width - this.getWidth()) / 2,
				(screen.height - this.getHeight()) / 2);

	}

	@Override
	public void addJpanel() {
		jpane.setLayout(new CardLayout());
		CardLay = (CardLayout) jpane.getLayout();
		//jpane.add(teacherpwd, "teacherp");
		jpane.add(welcome, "welcome");
		jpane.add(userPwd, "userpwd");
		jpane.add(personal,"personalInfo");
		CardLay.show(jpane, "welcome");
	}

	@Override
	public void addListener() {
		jtree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultMutableTreeNode dtm = (DefaultMutableTreeNode) jtree
						.getLastSelectedPathComponent();
				MyNode mynode = (MyNode) dtm.getUserObject();
				if (mynode.getIndex() == 33) {
					int choose = JOptionPane.showConfirmDialog(getParent(),
							"您确定要退出吗？");
					if (choose == 0) {
						System.exit(0);
					}
				}
				if (mynode.getIndex() == 32) {
					int choose = JOptionPane.showConfirmDialog(getParent(),
							"您确定要重新登录吗？");
					if (choose == 0) {
						dispose();
						new LoginIn();
					}
				}
				if (mynode.getIndex() == 11) {
					CardLay.show(jpane,"personalInfo");
				}
				if (mynode.getIndex() == 31) {
					CardLay.show(jpane,"userpwd");
				}
				if (mynode.getIndex() == 0) {
					CardLay.show(jpane, "welcome");
				}
			}
		});
	}

	@Override
	public void initialTree() {
		root.add(root1);
		root.add(root2);
		root.add(root3);
		root1.add(root11);
		root1.add(root12);
        root2.add(root21);
        root2.add(root22);
		root3.add(root31);
		root3.add(root32);
		root3.add(root33);
		jtree.setToggleClickCount(1);

	}

	@Override
	public void initialPanel() {
		welcome=new Welcome();
		userPwd=new ChangePassword(user);
		personal=new PersonalStuInfo(user);
	}
   
}
