package cn.lntu.t22.studentmanager;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import com.borland.jbcl.layout.XYLayout;
import com.borland.jbcl.layout.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class KeChengF extends JFrame {
 XYLayout xYLayout1 = new XYLayout();
 JLabel jLabel1 = new JLabel();
 JPanel jPanel1 = new JPanel();
 JScrollPane jScrollPane1 = new JScrollPane();
 JButton jButton1 = new JButton();
 JButton jButton2 = new JButton();
 XYLayout xYLayout2 = new XYLayout();
 JTable jTable1 = new JTable();
 JRadioButton jRadioButton1 = new JRadioButton();
 JRadioButton jRadioButton2 = new JRadioButton();

 JRadioButton jRadioButton3 = new JRadioButton();
 ButtonGroup buttonGroup1 = new ButtonGroup();
 JLabel jLabel2 = new JLabel();
 JLabel jLabel3 = new JLabel();
 JLabel jLabel4 = new JLabel();
 JTextField jTextField1 = new JTextField();
 JButton jButton3 = new JButton();
 JComboBox jComboBox1 = new JComboBox();
 JButton jButton4 = new JButton();
 JTextField jTextField2 = new JTextField();
 JButton jButton5 = new JButton();
 dbConn sta = new dbConn();
 String sql;
 Object[][] arrData = {};
 String[] arrField = {"专业课程编号","课程编号","专业名称", "课程名称","任课教师", "学分" };
 DefaultTableModel model = new DefaultTableModel();
 int intRow;
 static String find;
 JOptionPane jOptionPane1 = new JOptionPane();
 JButton jButton6 = new JButton();
 public KeChengF() {
 try {
 jbInit();
 } catch (Exception exception) {
 exception.printStackTrace();
 }
 }
 private void jbInit() throws Exception {
 getContentPane().setLayout(xYLayout1);
 jLabel1.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
 jLabel1.setText("课 程 查 询");
 jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
 jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));

 jButton1.setText("修 改");
 jButton1.addActionListener(new KeChengF_jButton1_actionAdapter(this));
 jButton2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
 jButton2.setText("退 出");
 jButton2.addActionListener(new KeChengF_jButton2_actionAdapter(this));
 jPanel1.setLayout(xYLayout2);
 jRadioButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN,16));
 jRadioButton1.setText("按课程名查询：");
 jRadioButton1.addItemListener(new KeChengF_jRadioButton1_itemAdapter(this));
 jRadioButton1.addActionListener(new KeChengF_jRadioButton1_actionAdapter(this));
 jPanel1.setBorder(BorderFactory.createEtchedBorder());
 xYLayout1.setWidth(550);
 xYLayout1.setHeight(560);
 jRadioButton2.setFont(new java.awt.Font("Dialog", Font.PLAIN,
16));
 jRadioButton2.setText("按 专 业 查 询：");
 jRadioButton2.addItemListener(new
KeChengF_jRadioButton2_itemAdapter(this));
 jRadioButton2.addActionListener(new

KeChengF_jRadioButton2_actionAdapter(this));
 jRadioButton3.setFont(new java.awt.Font("Dialog", Font.PLAIN,
16));
 jRadioButton3.setText("按 学 分 查 询：");
 jRadioButton3.addItemListener(new
KeChengF_jRadioButton3_itemAdapter(this));
 jRadioButton3.addActionListener(new

KeChengF_jRadioButton3_actionAdapter(this));

 jLabel2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jLabel2.setText("请输入课程名");
 jLabel3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jLabel3.setText("请 选 择 专 业");
 jLabel4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jLabel4.setText("请 输 入 学 分");
 jButton3.setEnabled(false);
 jButton3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jButton3.setText("查 询");
 jButton3.addActionListener(new
KeChengF_jButton3_actionAdapter(this));
 jButton4.setEnabled(false);
 jButton4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jButton4.setText("查 询");
 jButton4.addActionListener(new
KeChengF_jButton4_actionAdapter(this));
 jButton5.setEnabled(false);
 jButton5.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jButton5.setText("查 询");
 jButton5.addActionListener(new
KeChengF_jButton5_actionAdapter(this));
 jTextField1.setEnabled(true);
 jTextField1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jTextField1.setEditable(false);
 jComboBox1.setEnabled(false);
 jComboBox1.setFont(new java.awt.Font("Dialog", Font.PLAIN,
16));
 jTextField2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
 jTextField2.setEditable(false);
 this.setTitle("课程查询");
 jButton6.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
 jButton6.setText("删 除");
 jScrollPane1.getViewport().add(jTable1);
 jPanel1.add(jRadioButton3, new XYConstraints(10, 95, 145, 25));
 jPanel1.add(jRadioButton2, new XYConstraints(10, 55, 145, 25));

 jPanel1.add(jRadioButton1, new XYConstraints(10, 15, 145, 25));
 jPanel1.add(jLabel3, new XYConstraints(155, 55, 100, 25));
 jPanel1.add(jLabel4, new XYConstraints(155, 95, 100, 25));
 this.getContentPane().add(jLabel1, new XYConstraints(208, 13, 135,
43));
 this.getContentPane().add(jButton1, new XYConstraints(74, 508, 100,
-1));
 this.getContentPane().add(jButton2, new XYConstraints(374, 508,
100, -1));
 this.getContentPane().add(jPanel1, new XYConstraints(17, 68, 515,
154));
 this.getContentPane().add(jScrollPane1,
 new XYConstraints(18, 242, 515,
245));
 this.getContentPane().add(jButton6, new XYConstraints(224, 508,
100, -1));
 buttonGroup1.add(jRadioButton3);
 buttonGroup1.add(jRadioButton2);
 buttonGroup1.add(jRadioButton1);
 jPanel1.add(jLabel2, new XYConstraints(155, 15, 100, 25));
 jPanel1.add(jTextField1, new XYConstraints(260, 15, 140, 25));
 jPanel1.add(jButton3, new XYConstraints(420, 15, 80, 25));
 jPanel1.add(jComboBox1, new XYConstraints(260, 55, 140, 25));
 jPanel1.add(jButton4, new XYConstraints(420, 55, 80, 25));
 jPanel1.add(jTextField2, new XYConstraints(260, 95, 140, 25));
 jPanel1.add(jButton5, new XYConstraints(420, 95, 80, 25));
 jComboBox1.addItem("请选择");
 try {
 ResultSet rs = sta.getRs("select * from Speciality");
 while (rs.next()) {
 String xibu = rs.getString("SpecialityName");
 jComboBox1.addItem(xibu);
 }
 rs.close();


 } catch (Exception ce) {
 System.out.println("++++++++" + ce);
 }
 }
 public void UpdateRecord() {
 Object[][] arrTmp = {}; //设定表格的字段
 Vector vec = new Vector(1, 1);
 model = new DefaultTableModel(arrTmp, arrField);
 jTable1 = new JTable(model);
 jScrollPane1.getViewport().add(jTable1, null);
 try {
 ResultSet rs = sta.getRs(sql);
 int i = 1;
 while (rs.next()) {
 vec = new Vector();
 vec.add(String.valueOf(rs.getInt(1)));
 vec.add(String.valueOf(rs.getInt(2)));
 vec.add(rs.getString(3).trim());
 vec.add(rs.getString(4).trim());
 vec.add(rs.getString(5).trim());
 vec.add(String.valueOf(rs.getInt(6)));
 model.addRow(vec);
 }
 rs.close();
 } catch (Exception ce) {
 System.out.println(ce);
 }
 jScrollPane1.getHorizontalScrollBar();
 jTable1.setGridColor(Color.blue);
 jTable1.setDragEnabled(true);
 jTable1.setSelectionForeground(Color.red);
 jTable1.setSelectionBackground(Color.green);
 

jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 jTable1.setRowSelectionAllowed(true);
 jTable1.setShowVerticalLines(true);
 }
 public void getM() {
 intRow = jTable1.getSelectedRow();
 if (intRow == -1) {
 jOptionPane1.showMessageDialog(this, "请选择要修改的课程！", "提示",JOptionPane.INFORMATION_MESSAGE, null);
 return;
 }
 try {
 find = model.getValueAt(intRow, 0).toString().trim();
 System.out.println(find);
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
 public void jRadioButton1_actionPerformed(ActionEvent e) {
 jTextField1.setEditable(true);
 jButton3.setEnabled(true);
 }
 public void jRadioButton2_actionPerformed(ActionEvent e) {
 jComboBox1.setEnabled(true);
 jButton4.setEnabled(true);
 }
 public void jRadioButton3_actionPerformed(ActionEvent e) {

 jTextField2.setEditable(true);
 jButton5.setEnabled(true);
 }
 public void jButton2_actionPerformed(ActionEvent e) {
 this.dispose();
 }
 public void jButton3_actionPerformed(ActionEvent e) {
 String kename = jTextField1.getText().trim();
 sql = "select * from CourseS where CourseName='" + kename + "' ";
 UpdateRecord();
 }
 public void jButton4_actionPerformed(ActionEvent e) {
 String kename = String.valueOf(jComboBox1.getSelectedItem());
 sql = "select * from CourseS where SpecialityName='" + kename +
"'";
 UpdateRecord();
 }
 public void jButton5_actionPerformed(ActionEvent e) {
 int xuefen = Integer.parseInt(jTextField2.getText().trim());
 sql = "select * from CourseS where CreaditHour='" + xuefen + "' ";
 UpdateRecord();
 }
 public void jButton1_actionPerformed(ActionEvent e) {
 getM();
 if(find!=null){
 KeChengManager siadd = new KeChengManager( find );
 siadd.setLocation(400, 200);
 siadd.setSize(500, 380);
 siadd.setVisible(true);

 siadd.setResizable(false);
 siadd.validate();
 this.dispose();
 }
 }
 public void jRadioButton1_itemStateChanged(ItemEvent e) {
 jTextField1.setText("");
 jTextField1.setEditable(false);
 jButton3.setEnabled(false);
 }
 public void jRadioButton2_itemStateChanged(ItemEvent e) {
 jComboBox1.setEnabled(false);
 jButton4.setEnabled(false);
 }
 public void jRadioButton3_itemStateChanged(ItemEvent e) {
 jTextField2.setText("");
 jTextField2.setEditable(false);
 jButton5.setEnabled(false);
 }
}
class KeChengF_jButton1_actionAdapter implements ActionListener {
 private KeChengF adaptee;
 KeChengF_jButton1_actionAdapter(KeChengF adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jButton1_actionPerformed(e);
 }
}

class KeChengF_jButton5_actionAdapter implements ActionListener {
 private KeChengF adaptee;
 KeChengF_jButton5_actionAdapter(KeChengF adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jButton5_actionPerformed(e);
 }
}
class KeChengF_jButton4_actionAdapter implements ActionListener {
 private KeChengF adaptee;
 KeChengF_jButton4_actionAdapter(KeChengF adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jButton4_actionPerformed(e);
 }
}
class KeChengF_jRadioButton3_actionAdapter implements ActionListener {
 private KeChengF adaptee;
 KeChengF_jRadioButton3_actionAdapter(KeChengF adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jRadioButton3_actionPerformed(e);
 }
}
class KeChengF_jRadioButton3_itemAdapter implements ItemListener {
 private KeChengF adaptee;

 KeChengF_jRadioButton3_itemAdapter(KeChengF adaptee) {
 this.adaptee = adaptee;
 }
 public void itemStateChanged(ItemEvent e) {
 adaptee.jRadioButton3_itemStateChanged(e);
 }
}
class KeChengF_jButton2_actionAdapter implements ActionListener {
 private KeChengF adaptee;
 KeChengF_jButton2_actionAdapter(KeChengF adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jButton2_actionPerformed(e);
 }
}
class KeChengF_jButton3_actionAdapter implements ActionListener {
 private KeChengF adaptee;
 KeChengF_jButton3_actionAdapter(KeChengF adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jButton3_actionPerformed(e);
 }
}
class KeChengF_jRadioButton2_actionAdapter implements ActionListener {
 private KeChengF adaptee;
 KeChengF_jRadioButton2_actionAdapter(KeChengF adaptee) {
 this.adaptee = adaptee;

 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jRadioButton2_actionPerformed(e);
 }
}
class KeChengF_jRadioButton2_itemAdapter implements ItemListener {
 private KeChengF adaptee;
 KeChengF_jRadioButton2_itemAdapter(KeChengF adaptee) {
 this.adaptee = adaptee;
 }
 public void itemStateChanged(ItemEvent e) {
 adaptee.jRadioButton2_itemStateChanged(e);
 }
}
class KeChengF_jRadioButton1_actionAdapter implements ActionListener {
 private KeChengF adaptee;
 KeChengF_jRadioButton1_actionAdapter(KeChengF adaptee) {
 this.adaptee = adaptee;
 }
 public void actionPerformed(ActionEvent e) {
 adaptee.jRadioButton1_actionPerformed(e);
 }
}
class KeChengF_jRadioButton1_itemAdapter implements ItemListener {
 private KeChengF adaptee;
 KeChengF_jRadioButton1_itemAdapter(KeChengF adaptee) {
 this.adaptee = adaptee;
 }

 public void itemStateChanged(ItemEvent e) {
 adaptee.jRadioButton1_itemStateChanged(e);
 }

}

