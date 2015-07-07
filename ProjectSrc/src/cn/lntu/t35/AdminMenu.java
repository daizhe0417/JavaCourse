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
	 * ѧУ����Ա��
	 */
	private static final long serialVersionUID = 1L;

	// private AdminUserService service=new AdminUserService();
	private DefaultMutableTreeNode root0 = new DefaultMutableTreeNode(
			new MyNode("Menu", 0));
	private DefaultMutableTreeNode root1 = new DefaultMutableTreeNode(
			new MyNode("ѧ����Ϣ����", 1));
	private DefaultMutableTreeNode root2 = new DefaultMutableTreeNode(
			new MyNode("�γ���Ϣ����", 2));
	private DefaultMutableTreeNode root3 = new DefaultMutableTreeNode(
			new MyNode("������Ϣ����", 3));
	private DefaultMutableTreeNode root4 = new DefaultMutableTreeNode(
			new MyNode("ϵͳѡ��", 4));
	private DefaultMutableTreeNode root11 = new DefaultMutableTreeNode(
			new MyNode("����¼��", 11));
	private DefaultMutableTreeNode root12 = new DefaultMutableTreeNode(
			new MyNode("ѧ����Ϣ����", 12));
	private DefaultMutableTreeNode root21 = new DefaultMutableTreeNode(
			new MyNode("�ɼ�¼��", 21));
	private DefaultMutableTreeNode root22 = new DefaultMutableTreeNode(
			new MyNode("��ӿγ�", 22));
	private DefaultMutableTreeNode root23 = new DefaultMutableTreeNode(
			new MyNode("�ɼ���ѯ", 23));
	private DefaultMutableTreeNode root31 = new DefaultMutableTreeNode(
			new MyNode("�༶��Ϣ����", 31));
	private DefaultMutableTreeNode root32 = new DefaultMutableTreeNode(
			new MyNode("������Ϣ����", 32));
	private DefaultMutableTreeNode root33 = new DefaultMutableTreeNode(
			new MyNode("��������", 33));
	private DefaultMutableTreeNode root331 = new DefaultMutableTreeNode(
			new MyNode("��������", 331));
	private DefaultMutableTreeNode root332 = new DefaultMutableTreeNode(
			new MyNode("�ͷ�����", 332));
	private DefaultMutableTreeNode root41 = new DefaultMutableTreeNode(
			new MyNode("�޸�����", 41));
	private DefaultMutableTreeNode root42 = new DefaultMutableTreeNode(
			new MyNode("���µ�¼", 42));
	private DefaultMutableTreeNode root43 = new DefaultMutableTreeNode(
			new MyNode("�˳�ϵͳ", 43));
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
		 * ���ô���λ��Ϊ���У���С������
		 */
		this.setResizable(false);
		this.add(jsplit);
		this.setSize(900, 600);
		this.setTitle("����Ա�ͻ���");
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
		 * ��   ��ť����
		 */
      jtree.addTreeSelectionListener(new TreeSelectionListener() {
		
			public void valueChanged(TreeSelectionEvent e) {
				// TODO Auto-generated method stub
				
				DefaultMutableTreeNode dtm = (DefaultMutableTreeNode) jtree
						.getLastSelectedPathComponent();
				MyNode mynode = (MyNode) dtm.getUserObject();
				if (mynode.getIndex() == 43) {      
					int choose = JOptionPane.showConfirmDialog(getParent(),
							"��ȷ��Ҫ�˳���");
					if (choose == 0) {
						System.exit(0);
					}
				} //ϵͳ�˳�
				
				
				if (mynode.getIndex() == 42) {   
					int choose = JOptionPane.showConfirmDialog(getParent(),
							"��ȷ��Ҫ���µ�¼��");
					if (choose == 0) {
						dispose();
						new LoginIn();
					}
					    
				} //���µ�¼
				
				else if (mynode.getIndex() == 41) {
					CardLay.show(jpane, "adminpwd");
					adminPwd.grabFocus();					
				} // ����ҳ��
				
				else if (mynode.getIndex() == 11) {
					CardLay.show(jpane, "addStudent");
					addStudent.grabFocus();
				}//ѧ����Ϣ��¼��
				
				else if (mynode.getIndex() == 12) {
					CardLay.show(jpane, "infOperate");
					infOperate.grabFocus();
				}//ѧ����Ϣ���� ��ɾ�����޸ģ���ӣ�
				else if (mynode.getIndex() == 21) {
					CardLay.show(jpane,"inputScore");
					score.grabFocus();
				}//�ɼ�����
				else if (mynode.getIndex() == 22) {
					CardLay.show(jpane,"course");
					course.grabFocus();
				}//�γ���Ϣ��¼��
				else if (mynode.getIndex() == 23) {
					CardLay.show(jpane,"quarryScore");
					course.grabFocus();
				}//����Ա�ͻ��˳ɼ���ѯ
				if (mynode.getIndex() == 0||mynode.getIndex() == 1||
						mynode.getIndex() == 2||mynode.getIndex() == 3||
						mynode.getIndex() == 4) {
					CardLay.show(jpane, "welcome");
					welcome.grabFocus();
				}//���ø��ఴťΪwelcome����
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
