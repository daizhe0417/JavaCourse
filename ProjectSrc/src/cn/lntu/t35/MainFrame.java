package cn.lntu.t35;

class MyNode {
	//树的节点类
	private  String  name;
	private  int  index;
	MyNode(String  name,int index){
		this.name=name;
		this.index=index;
	}
	public  int getIndex(){
		return  this.index;
	}
	public  String toString(){
		return  this.name;
	}
	
}

public interface MainFrame {
	void  initialFrame();
	void  addJpanel();
	void  addListener();
    void  initialTree();
    void  initialPanel();
}
