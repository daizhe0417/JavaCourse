package cn.lntu.t31;

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

@SuppressWarnings("serial")
public class CheckFrame extends JFrame implements MainFrame,Runnable {
	
	private  DefaultMutableTreeNode  root=new DefaultMutableTreeNode(new MyNode("菜单",0));
	private  DefaultMutableTreeNode  root1=new DefaultMutableTreeNode(new MyNode("项目信息管理",1));
	private  DefaultMutableTreeNode  root2=new DefaultMutableTreeNode(new  MyNode("个人信息管理",2));
	private  DefaultMutableTreeNode  root3=new DefaultMutableTreeNode(new  MyNode("系统管理",3));
	private  DefaultMutableTreeNode  root11=new DefaultMutableTreeNode(new  MyNode("个人项目信息检索",11));
	private  DefaultMutableTreeNode  root12=new DefaultMutableTreeNode(new  MyNode("科研人员项目信息检索",12));
	private  DefaultMutableTreeNode  root13=new DefaultMutableTreeNode(new  MyNode("工程项目申报",13));
	private  DefaultMutableTreeNode  root14=new DefaultMutableTreeNode(new  MyNode("工程项目审批",14));
	private  DefaultMutableTreeNode  root15=new DefaultMutableTreeNode(new  MyNode("工程项目验收",15));
	private  DefaultMutableTreeNode  root21=new DefaultMutableTreeNode(new  MyNode("个人信息管理",21));
	private  DefaultMutableTreeNode  root22=new DefaultMutableTreeNode(new  MyNode("个人密码修改",22));
	private  DefaultMutableTreeNode  root31=new DefaultMutableTreeNode(new  MyNode("系统设置",31));
	private  DefaultMutableTreeNode  root32=new DefaultMutableTreeNode(new  MyNode("重新登录",32));
	private  DefaultMutableTreeNode  root33=new DefaultMutableTreeNode(new  MyNode("退出系统",33));
	
	private  DefaultTreeModel    dtm;
	private  JTree  tree=new  JTree();
	private  JScrollPane  scroll=new JScrollPane(tree);
	private  JPanel jpanel=new JPanel();
	private  JSplitPane jsplit=new  JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,jpanel);
	private  CardLayout cardlay = new CardLayout();
	
	private  StartUpPanel startUp;
	private  SystemSetPanel systemSet;
	private  ChangePwdPanel changePwd;
	private  PersonInfoPanel personInfo;
	private  ProjectSubmitPanel projectSubmit;
	private  ProjectResultPanel projectResult;
	private  ExamineProjectPanel examineProject;
	private  CheckProjectPanel checkProject;
	private  CProjectResultPanel cProjectResult;
	
    private User user;
    
    CheckFrame(User user) {
		this.user = user;
		run();
	}
    
    /**
	 * 初始化frame
	 */
	@Override
	public void initialFrame() {
		this.add(jsplit);
		this.setSize(1000, 700);
		this.setTitle("审查员管理系统");
		jsplit.setDividerLocation(200);
		jsplit.setDividerSize(6);
		Dimension  screen=Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(screen.width/2-this.getWidth()/2, screen.height/2-this.getHeight()/2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
		this.setResizable(false);
	}
	
	/**
	 * 添加jpanel
	 */
	@Override
	public void addJpanel() {
		jpanel.setLayout(new CardLayout());
		cardlay=(CardLayout) jpanel.getLayout();
		jpanel.add(startUp,"StartUpFrame");
		jpanel.add(systemSet,"SystemSetFrame");
		jpanel.add(changePwd,"ChangePwdPanel");
		jpanel.add(personInfo,"PersonInfoPanel");
		jpanel.add(projectSubmit,"ProjectSubmitPanel");
		jpanel.add(projectResult, "ProjectResultPanel");
		jpanel.add(examineProject,"ExamineProjectPanel");
		jpanel.add(checkProject,"CheckProjectPanel");
		jpanel.add(cProjectResult,"CProjectResultPanel");
		cardlay.show(jpanel, "StartUpFrame");
		
	}
	
	/**
	 * 添加监听器Listener
	 */
	@Override
	public void addListener() {
		tree.addTreeSelectionListener( new TreeSelectionListener() {	
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				if (e.getSource() == tree) {
					DefaultMutableTreeNode dtm = (DefaultMutableTreeNode) tree
							.getLastSelectedPathComponent();
					MyNode mynode = (MyNode) dtm.getUserObject();
					if(mynode.getIndex()==0){
						cardlay.show(jpanel, "StartUpPanel");		
					}
					if (mynode.getIndex() == 11) {
						cardlay.show(jpanel, "ProjectResultPanel");
					}
					if (mynode.getIndex() == 12) {
						cardlay.show(jpanel, "CProjectResultPanel");
					}
					if(mynode.getIndex()==13){
						cardlay.show(jpanel, "ProjectSubmitPanel");		
					}
					if(mynode.getIndex()==14){
						cardlay.show(jpanel, "ExamineProjectPanel");		
					}
					if(mynode.getIndex()==15){
						cardlay.show(jpanel, "CheckProjectPanel");		
					}
					if(mynode.getIndex()==21){
						cardlay.show(jpanel, "PersonInfoPanel");		
					}
					if(mynode.getIndex()==22){
						cardlay.show(jpanel, "ChangePwdPanel");		
					}
					if(mynode.getIndex()==31){
						cardlay.show(jpanel, "SystemSetFrame");		
					}
					if(mynode.getIndex()==32){//重新登录
						int choose=JOptionPane.showConfirmDialog(getParent(), "您确认要重新登录吗？");
						if(choose==0){
							back();	
						}			
					}		
					if(mynode.getIndex()==33){
						int choose=JOptionPane.showConfirmDialog(getParent(), "您确认要退出吗？");
						if(choose==0){
					         	System.exit(0);
						}
					}
				}
			}
		});	
	}
	
	/**
	 * 初始化树
	 */
	@Override
	public void initialTree() {
		root.add(root1);
		root.add(root2);
		root.add(root3);
		root1.add(root11);
		root1.add(root12);
		root1.add(root13);
		root1.add(root14);
		root1.add(root15);
		root2.add(root21);
		root2.add(root22);
		root3.add(root31);
		root3.add(root32);
		root3.add(root33);
		dtm = new DefaultTreeModel(root);
		((DefaultTreeModel)tree.getModel()).setRoot(root);
		tree.setToggleClickCount(1);
		tree.setEditable(false);
		tree.setRootVisible(true);
		tree.setFocusCycleRoot(true);
		
	}
	
	/**
	 * 初始化panel
	 */
	@Override
	public void initialPanel() {
		startUp = new StartUpPanel();
		systemSet = new SystemSetPanel();
		changePwd = new ChangePwdPanel(user);
		personInfo = new PersonInfoPanel(user);
		projectSubmit = new ProjectSubmitPanel(user);
		projectResult = new ProjectResultPanel(user);
		checkProject = new CheckProjectPanel(user);
		examineProject = new ExamineProjectPanel(user);
		cProjectResult = new CProjectResultPanel(user);
	
	 }

	@Override
	public void run() {
		this.initialTree();
		this.initialPanel();
		this.addListener();
		this.addJpanel();
		this.initialFrame();	
	}

	public void back(){
		 //  this.setVisible(false);
		this.dispose();
		new LoginFrame();
	   }

}
