package bookmanage;
import javax.swing.JFrame;  
import javax.swing.JTextField;  
import javax.swing.text.Document;  
import javax.swing.event.DocumentListener;  
import javax.swing.event.DocumentEvent;  
  
/** 
* author:���Ű��ٽ� 
*/  
public class TextChangeEvent extends JFrame implements DocumentListener {  
  
    private JTextField textField1;
    private JTextField textField2;
      
    public TextChangeEvent(JTextField text1, JTextField text2) {  
          
        this.textField1=text1;
        this.textField2=text2;
        Document doc = textField1.getDocument(); 
        doc.addDocumentListener(this);  
    }  
      
      
    /** 
    * ʵ��DocumentListener�ӿ���insertUpdate���� 
    * �÷������Ը����ı�������������� 
    */  
    public void insertUpdate(DocumentEvent e) {  
//        Document doc = e.getDocument();  
//        String s = doc.getText(0, doc.getLength); //�����ı������������  
    }  
      
    /** 
    * ʵ��DocumentListener�ӿ�removeUpdate���� 
    * �÷������Ը����ı������Ƴ������ݣ����磺���ı����е��Backspace 
    */  
    public void removeUpdate(DocumentEvent e) {  
//        Document doc = e.getDocument();  
//        String s = doc.getText(0, doc.getLength); //�����ı������������  
    }  
      
    /** 
    * ʵ��DocumentListener�ӿ�changedUpdate���� 
    * �÷������Ը��ٵ��ı������Ѵ��ڵ����ݸı�ʱ����ȡ��Ӧ��ֵ 
    */  
    public void changedUpdate(DocumentEvent e) {  
       textField2.setText("��һ���༭�����ı䣡");
                                                                     
    }  
  
}  
