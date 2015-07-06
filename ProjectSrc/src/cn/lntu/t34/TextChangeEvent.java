package bookmanage;
import javax.swing.JFrame;  
import javax.swing.JTextField;  
import javax.swing.text.Document;  
import javax.swing.event.DocumentListener;  
import javax.swing.event.DocumentEvent;  
  
/** 
* author:国信安百杰 
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
    * 实现DocumentListener接口中insertUpdate方法 
    * 该方法可以跟踪文本框中输入的内容 
    */  
    public void insertUpdate(DocumentEvent e) {  
//        Document doc = e.getDocument();  
//        String s = doc.getText(0, doc.getLength); //返回文本框输入的内容  
    }  
      
    /** 
    * 实现DocumentListener接口removeUpdate方法 
    * 该方法可以跟踪文本框中移除的内容，例如：在文本框中点击Backspace 
    */  
    public void removeUpdate(DocumentEvent e) {  
//        Document doc = e.getDocument();  
//        String s = doc.getText(0, doc.getLength); //返回文本框输入的内容  
    }  
      
    /** 
    * 实现DocumentListener接口changedUpdate方法 
    * 该方法可以跟踪当文本框中已存在的内容改变时，获取相应的值 
    */  
    public void changedUpdate(DocumentEvent e) {  
       textField2.setText("上一个编辑框发生改变！");
                                                                     
    }  
  
}  
