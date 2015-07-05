package cn.lntu.t31;

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

public class CProjectResultPanel extends JPanel{
	private JLabel JLPstates,JLPkeyword;
	private JTextField JFPkeyword;
	private JComboBox JCPstates;
	private JButton JBSearch;
	private JTable JTproject;
	private DefaultTableModel tableModel;
	private String Index;
    private Vector vector;
	private User user;
	private ProjectSearch ps;
	private ProjectService pService;
	CProjectResultPanel(User user){	
		this.user=user;
		this.initialFrame();
		this.addListener();	
		JFPkeyword.setText("");
	}

	private void initialFrame() {
		this.setLayout(null);
		JLPstates = new JLabel("项目状态:");
		JLPkeyword = new JLabel("关键词(项目名称):");
		JFPkeyword = new JTextField("");
		String [] statesName = {"已申报","已审批","已验收"};
		JCPstates = new JComboBox(statesName); 
		JBSearch = new JButton("查询");
		
		JLPstates.setBounds(350,60,80,30);
		JLPkeyword.setBounds(50,60,120,30);
		JFPkeyword.setBounds(170,60,150,30);
		JCPstates.setBounds(420,60,150,30);
		JBSearch.setBounds(640,60,100,30);
		
		String name[] = {"编号","名称","类型","周期","内容","开发者"};
		tableModel = new DefaultTableModel(name,0);
		JTproject = new JTable(this.tableModel);	
		//JTproject.setEnabled(false);
        JScrollPane jsp = new JScrollPane(JTproject);
       
        jsp.setBounds(50,120,700,400);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS) ;

        this.add(jsp);
        this.add(JLPstates);
        this.add(JLPkeyword);
        this.add(JFPkeyword);
        this.add(JCPstates);
        this.add(JBSearch);
	}

	private void addListener() {
		JBSearch.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				String Keyword = JFPkeyword.getText().toString();
				int states = JCPstates.getSelectedIndex();
				ps = new ProjectSearch();
				pService = new ProjectService();
				try{					
					List<ProjectSearch> psl = pService.cProjectSearch(Keyword, states);
					if(psl.size()>=30){
						tableModel.setRowCount(psl.size());
						for(int i=0;i<psl.size();i++){
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
					for(int i=0;i<psl.size();i++){
						ps = psl.get(i);
						tableModel.setValueAt(ps.getpNum(), i, 0);
						tableModel.setValueAt(ps.getpName(), i, 1);
						tableModel.setValueAt(ps.getType(), i, 2);
						tableModel.setValueAt(ps.getDevelopTime(), i, 3);
						tableModel.setValueAt(ps.getpContent(), i, 4);
						tableModel.setValueAt(ps.getDevelopers(), i, 5);				
					}	
				}catch(Exception error){
					JOptionPane.showMessageDialog(getParent(), "数据解析失败!");						
					return;
				}
			}
		});
	}

}