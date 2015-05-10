package cn.lntu.t32;

import java.awt.*;;
public class Dengruchaungkou extends Frame{
	public Dengruchaungkou()
	{
		super("user login");
		this.setSize(200,130);
		this.setLocation(300, 240);
		this.setBackground(Color.lightGray);
		this.setLayout(new FlowLayout());
		this.add(new Label("userid"));
		this.add(new TextField("user1",10));
		this.add(new Label("password"));
		this.add(new TextField(10));
		this.add(new Button("OK"));
		this.add(new Button("Cancel"));
		this.setVisible(true);
	}
	public static void main(String arg[]){new Dengruchaungkou();}

}
