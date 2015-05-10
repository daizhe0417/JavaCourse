package bookmanage;
import javax.swing.*;
import java.awt.*;
public class MakeComponent {
	public MakeComponent(){}
	 
	 public JButton makeJButton(Container ct,String name,GridBagLayout gridbag,GridBagConstraints c){
	  JButton jbutton=new JButton(name);
	  gridbag.setConstraints(jbutton,c);
	  ct.add(jbutton);
	  return jbutton;
	 }
	 
	 public JTextField makeJTextField(Container ct, String name, GridBagLayout gridbag,GridBagConstraints c){
	  JTextField jt=new JTextField(name);
	  
	  gridbag.setConstraints(jt,c);
	  jt.setHorizontalAlignment(JTextField.LEFT);
	  jt.setColumns(0);
	  ct.add(jt);
	  return jt;
	 }

	 public JTextArea makeJTextArea(Container ct,String name,GridBagLayout gridbag,GridBagConstraints c){
	  JTextArea jta=new JTextArea(name);
	  gridbag.setConstraints(jta,c);
	  ct.add(jta);
	  return jta;
	 }
	 public JLabel makeJLabel(Container ct,String name,GridBagLayout gridbag,GridBagConstraints c){
	  JLabel jlb=new JLabel(name);
	  gridbag.setConstraints(jlb,c);
	  ct.add(jlb);
	  return jlb; 
	 }

	 public JPasswordField makeJPasswordField(Container ct,String name,GridBagLayout gridbag,GridBagConstraints c){
	  JPasswordField jpf=new JPasswordField(name);
	  gridbag.setConstraints(jpf, c);
	  jpf.setHorizontalAlignment(JTextField.LEFT);
	  jpf.setColumns(0);
	  ct.add(jpf);
	  return jpf;
	 }
	 
	 public static void main(String [] args){
		 
	 }

}
