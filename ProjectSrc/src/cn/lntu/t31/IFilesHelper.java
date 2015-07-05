package cn.lntu.t31;

public interface IFilesHelper extends ICommontHelper {
	
	//读文件
	public String readFiles(String url);
	//读文件
    public String readFromFile(String filename);
    //写文件
    public int writeToFile(String filename, String buffer);

}
