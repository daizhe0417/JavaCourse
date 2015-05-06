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

public class StudentClient extends JFrame implements MainFrame{

	/**
	 * 学生等路端
	 */
	private static final long serialVersionUID = 3302467460328717024L;
    private  int id;
    private  String password,sql;
	private  DefaultMutableTreeNode  root=new DefaultMutableTreeNode(new MyNode("菜单",0)); 
	private  DefaultMutableTreeNode  root1=new DefaultMutableTreeNode(new MyNode("求职信息处理",1)); 
	private  DefaultMutableTreeNode  root2=new DefaultMutableTreeNode(new MyNode("系统选项",2)); 
	private  DefaultMutableTreeNode  root11=new DefaultMutableTreeNode(new MyNode("查看已发布的信息",11)); 
	private  DefaultMutableTreeNode  root12=new DefaultMutableTreeNode(new MyNode("处理通过的信息",12)); 
	private  DefaultMutableTreeNode  root21=new DefaultMutableTreeNode(new MyNode("修改密码",21)); 
	private  DefaultMutableTreeNode  root22=new DefaultMutableTreeNode(new MyNode("退出系统",22)); 
	private  DefaultTreeModel  dtm=new DefaultTreeModel(root);
	private  JTree  jtree=new JTree(dtm);
	private  JScrollPane  scroll=new JScrollPane (jtree);
	private   JPanel  jpane=new JPanel();
	private  JSplitPane   split=  new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,jpane);
	private  CardLayout  cardlay;
	private  Welcome  welcome;
	private  ChangePassword  change;
	private  CheckInformation   checkinfor;
	private  StudentConfirm   confirm;
	StudentClient(int id,String password){
		
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
		this.add(split);
		split.setDividerLocation(200);
		split.setDividerSize(6);
		this.setTitle("学生管理端");
		this.setVisible(true);
		this.setSize(1000, 700);
		Dimension  screen=Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width-this.getWidth())/2, (screen.height-this.getHeight())/2);
		
	}

	@Override
	public void addJpanel() {
		jpane.setLayout(new CardLayout());
		cardlay=(CardLayout) jpane.getLayout();
		jpane.add(welcome, "welcome");
		jpane.add(change,"change");
		jpane.add(checkinfor,"checkinfor");
		jpane.add(confirm,"confirm");
		cardlay.show(jpane, "welcome");
	}

	@Override
	public void addListener() {
		jtree.addMouseListener(new  MouseAdapter(){
			public  void mouseClicked(MouseEvent e){
				DefaultMutableTreeNode  dtm=(DefaultMutableTreeNode) jtree.getLastSelectedPathComponent();
				MyNode  mynode=(MyNode) dtm.getUserObject();
				if(mynode.getIndex()==11){
					cardlay.show(jpane, "checkinfor");
					
				}
				if(mynode.getIndex()==12){
					cardlay.show(jpane, "confirm");
				}
				if(mynode.getIndex()==21){
					
					cardlay.show(jpane, "change");
					
				}if(mynode.getIndex()==22){
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
		jtree.setToggleClickCount(1);
		
	}

	@Override
	public void initialPanel() {
		welcome=new Welcome();
		sql="update  stu_user set password=?   where  id=? ";
		change=new ChangePassword(id,password,sql);
		checkinfor=new CheckInformation(id);
		confirm=new StudentConfirm(id);
	}
}
