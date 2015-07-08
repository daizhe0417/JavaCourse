package cn.lntu.t31.Interface;

public interface IFilesHelper extends ICommontHelper {
	
	//读文�?
	public String readFiles(String url);
	//读文�?
    public String readFromFile(String filename);
    //写文�?
    public int writeToFile(String filename, String buffer);

}
