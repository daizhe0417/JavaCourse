package cn.lntu.t25;

import javax.swing.JFrame;

public class adminClient extends JFrame implements MainFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2976953786977125434L;
  private  int id;
  private String password;
	
	adminClient(int id,String password){
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addJpanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialTree() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initialPanel() {
		// TODO Auto-generated method stub
		
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
}
