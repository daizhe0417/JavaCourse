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

public class EnterpriseClient extends JFrame implements MainFrame{

	/**
	 * 企业端  用树形和卡片布局实现
	 */
	private static final long serialVersionUID = -4291512066492333923L;
    private  Integer id;
    private String password;
    private  DefaultMutableTreeNode  root=new  DefaultMutableTreeNode(new MyNode("菜单",0));
    private  DefaultMutableTreeNode  root1=new  DefaultMutableTreeNode(new MyNode("信息管理",1)); 
    private  DefaultMutableTreeNode  root2=new  DefaultMutableTreeNode(new MyNode("系统管理",2));
    private  DefaultMutableTreeNode  root11=new  DefaultMutableTreeNode(new MyNode("发布信息",11));
    private  DefaultMutableTreeNode  root12=new  DefaultMutableTreeNode(new MyNode("处理求职信息",12));
    private  DefaultMutableTreeNode  root21=new  DefaultMutableTreeNode(new MyNode("修改密码",21));
    private  DefaultMutableTreeNode  root22=new  DefaultMutableTreeNode(new MyNode("退出系统",22));
    private  DefaultTreeModel  dtm=new  DefaultTreeModel(root);
    private  JTree jtree=new  JTree(dtm);
    private  JScrollPane  scroll=new  JScrollPane(jtree);
    private  JPanel  jpane=new  JPanel();
    private   JSplitPane  jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,jpane);
    private   CardLayout  cardlay;
    private  ChangePassword  change;
    private  Welcome  welcome;
    private  PublishInformation publish;
    private EnterpriseProcess  enterprocess;
    private  EnterUserService  service=new EnterUserService();
	EnterpriseClient(int id,String password){
		
		this.id = id;
		this.password = password;
		this.initialTree();
		this.initialPanel();
		this.addListener();
		this.addJpanel();
		this.initialFrame();
		
	}
	
	

	@Override
	public void initialFrame() {
		this.add(jsp);
		this.setSize(1000, 700);
		this.setTitle("企业管理端");
		this.setVisible(true);
		Dimension  screen=Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width-this.getWidth())/2, (screen.height-this.getHeight())/2);
		jsp.setDividerLocation(200);
		jsp.setDividerSize(6);
		
	}

	@Override
	public void addJpanel() {
	jpane.setLayout(new CardLayout());
	cardlay=(CardLayout) jpane.getLayout();
	jpane.add(welcome,"welcome");
	jpane.add(change,"change");
	jpane.add(publish,"publish");
	jpane.add(enterprocess, "process");
	cardlay.show(jpane, "welcome");
	}

	@Override
	public void addListener() {
	jtree.addMouseListener(new MouseAdapter(){
		public  void   mouseClicked(MouseEvent e){
			DefaultMutableTreeNode  dtm=(DefaultMutableTreeNode) jtree.getLastSelectedPathComponent();
		    MyNode  mynode=	(MyNode) dtm.getUserObject();
			if(mynode.getIndex()==11){
				
				cardlay.show(jpane, "publish");
			}
			if(mynode.getIndex()==12){
				cardlay.show(jpane, "process");
				
			}
			if(mynode.getIndex()==21){
				cardlay.show(jpane, "change");
				
			}
			if(mynode.getIndex()==22){
				
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
		root1.add(root11);
		root1.add(root12);
		root2.add(root21);
		root2.add(root22);
		jtree.setToggleClickCount(2);
	}

	@Override
	public void initialPanel() {
		welcome =new Welcome();
	    change=new ChangePassword(id,password,service);
		publish=new PublishInformation(id);
		enterprocess=new EnterpriseProcess(id);
	}
}
