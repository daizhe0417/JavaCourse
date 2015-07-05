package Hospital;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
class MyTree extends JFrame implements TreeSelectionListener{
	JTree tree = null;
	JTextArea text = new JTextArea(20, 20);
	MyTree()
	{Container con = getContentPane();
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("医生查询器");
	DefaultMutableTreeNode r1 = new DefaultMutableTreeNode("查询医生信息");
	DefaultMutableTreeNode r2 = new DefaultMutableTreeNode("退出系统");
	DefaultMutableTreeNode r11 = new DefaultMutableTreeNode("姓名");
	DefaultMutableTreeNode r12 = new DefaultMutableTreeNode("编号");
	DefaultMutableTreeNode r21 = new DefaultMutableTreeNode("退出");
	root.add(r1);
	root.add(r2);
	r1.add(r11);
	r1.add(r12);
	r2.add(r21);
	tree = new JTree(root);
	tree.setEditable(true);
	JPanel panel = new JPanel(new GridLayout(3, 2));
	this.add(panel);
	JScrollPane sp = new JScrollPane(text);
	JSplitPane spl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true,
			tree, sp);

	tree.addTreeSelectionListener(this);
	con.add(spl);
	
	addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	});
	setVisible(true);
	setBounds(200, 100, 300, 300);}
	@Override
	public void valueChanged(TreeSelectionEvent ev) {
		// TODO Auto-generated method stub
		if (ev.getSource() == tree) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			if (node.isLeaf()) {
				String str = node.toString();
				if (str.equals("姓名")) {
					try{
						File f = new File("C:\\Doctor.txt");
						if (f.exists()) {
						} 
						else 
						{f.createNewFile();
						}
						InputStream is = new FileInputStream(f);
				        String line; // 用来保存每行读取的内容
				        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
				        line = reader.readLine(); // 读取第一行
				        while(line!=null)
				        {   Vector<String>  vec=new  Vector<String>();
				        	String  [] st=line.split("@");				          		
				            vec.add(st[0]);				          
				        	text.append(vec+"\n");
				        	line = reader.readLine();
				        }				        
				        reader.close();
				        is.close();		
				        }catch (Exception e) {
					     e.printStackTrace();
					}
				} else if (str.equals("编号")) {
					try{
						File f = new File("C:\\Doctor.txt");
						if (f.exists()) {
						} 
						else 
						{f.createNewFile();
						}
						InputStream is = new FileInputStream(f);
				        String line; // 用来保存每行读取的内容
				        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
				        line = reader.readLine(); // 读取第一行
				        while(line!=null)
				        {   Vector<String>  vec=new  Vector<String>();
				        	String  [] st=line.split("@");    		
				            vec.add(st[3]);	
				            text.append(vec+"\n");	
				            line = reader.readLine();			        				        
				        }
				        reader.close();
				        is.close();		
				        }catch (Exception e) {
					     e.printStackTrace();
				        }
				}
				if (str.equals("退出")) {
					if (JOptionPane.showConfirmDialog(this, "终止当前程序运行？") == 0){
						Doctor value[]={new Doctor()};
						new DoctorJFrame(new DoctorJPanel(),value);
						this.hide();
					}
				}
			} else {
				text.setText(node.getUserObject().toString());
			}
		}
	}
}
public class TreeDoctorselect{
	public static void main(String args[]) {
		MyTree t = new MyTree();
		t.pack();
	}

}