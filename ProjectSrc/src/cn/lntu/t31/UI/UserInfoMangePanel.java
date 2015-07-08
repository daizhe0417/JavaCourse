package cn.lntu.t31.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.lntu.t31.Bean.User;
import cn.lntu.t31.Dao.UserService;

@SuppressWarnings("serial")
public class UserInfoMangePanel extends JPanel {
	private JLabel JLUstates,JLUkeyword;
	private JTextField JFUkeyword;
	private JComboBox JCUstates;
	private JButton JBSearch,JBDelete;
	private JTable JTUserInfo;
	private DefaultTableModel tableModel;
	private String Index;
    private Vector vector;
    private UserService uService;
    
	UserInfoMangePanel(){	
		this.initialFrame();
		this.addListener();	
		JFUkeyword.setText("");
	}

	private void addListener() {
		JBSearch.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String Keyword = JFUkeyword.getText().toString();
				int states = JCUstates.getSelectedIndex();
				User us = new User();
				uService = new UserService();
				try{					
					List<User> usl = uService.userSearch(Keyword, ++states);
					if(usl.size()>=30){
						tableModel.setRowCount(usl.size());
						for(int i=0;i<usl.size();i++){
							tableModel.setValueAt(null, i, 0);
							tableModel.setValueAt(null, i, 1);
							tableModel.setValueAt(null, i, 2);
							tableModel.setValueAt(null, i, 3);
							tableModel.setValueAt(null, i, 4);
							tableModel.setValueAt(null, i, 5);
						}
					}else{
						tableModel.setRowCount(30);
						for(int i=0;i<30;i++){
							tableModel.setValueAt(null, i, 0);
							tableModel.setValueAt(null, i, 1);
							tableModel.setValueAt(null, i, 2);
							tableModel.setValueAt(null, i, 3);
							tableModel.setValueAt(null, i, 4);
							tableModel.setValueAt(null, i, 5);
						}
					}
					for(int i=0;i<usl.size();i++){
						us = usl.get(i);
						tableModel.setValueAt(us.getUserName(), i, 0);
						tableModel.setValueAt(us.getSex(), i, 1);
						tableModel.setValueAt(us.getRealName(), i, 2);
						tableModel.setValueAt(us.getPower(), i, 3);
						tableModel.setValueAt(us.getTel(), i, 4);
						tableModel.setValueAt(us.getUnit(), i, 5);	
					}	
				}catch(Exception error){
					JOptionPane.showMessageDialog(getParent(), "数据解析失败!");						
					return;
				}
			}
		});
		JBDelete.addActionListener(new ActionListener() {						
			@Override			
			public void actionPerformed(ActionEvent e) {				
				// TODO Auto-generated method stub				
				//获取要删除的�?,没有选择�?-1				
				uService = new UserService();
				int row = JTUserInfo.getSelectedRow();				
				if(row == -1){					
					JOptionPane.showMessageDialog(getParent(),"请�?�择要删除的�?!");	
					return;
				}else{					
					
					String userName =(String)tableModel.getValueAt(row, 0);
					int res = uService.userInfoDelete(userName);
					if(res==0){
						JOptionPane.showMessageDialog(getParent(), "删除异常!");						
						return;
					}else if(res==1){
						tableModel.removeRow(row);
						JTUserInfo.updateUI();
						JOptionPane.showMessageDialog(getParent(), "删除成功!");						
						return;
					}else{
						JOptionPane.showMessageDialog(getParent(), "删除异常!");						
						return;
					}
					
				}
			}		
		});
	}

	@SuppressWarnings("unchecked")
	private void initialFrame() {
		this.setLayout(null);
		JLUstates = new JLabel("用户状�??:");
		JLUkeyword = new JLabel("关键�?(用户�?):");
		JFUkeyword = new JTextField("");
		String [] statesName = {"使用�?","已停�?","未激�?"};
		JCUstates = new JComboBox(statesName); 
		JBSearch = new JButton("查询");
		JBDelete = new JButton("删除");
		
		JLUstates.setBounds(350,60,80,30);
		JLUkeyword.setBounds(50,60,100,30);
		JFUkeyword.setBounds(170,60,150,30);
		JCUstates.setBounds(420,60,150,30);
		JBSearch.setBounds(640,60,100,30);
		JBDelete.setBounds(50,550,100,30);
		
		String name[] = {"用户�?","性别","真实姓名","权限","电话","单位"};
		tableModel = new DefaultTableModel(name,0);
		JTUserInfo = new JTable(this.tableModel);	
		//JTproject.setEnabled(false);
		
        JScrollPane jsp = new JScrollPane(JTUserInfo);
       
        jsp.setBounds(50,120,700,400);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS) ;

        this.add(jsp);
        this.add(JLUstates);
        this.add(JLUkeyword);
        this.add(JFUkeyword);
        this.add(JCUstates);
        this.add(JBSearch);
        this.add(JBDelete);
	}
}
