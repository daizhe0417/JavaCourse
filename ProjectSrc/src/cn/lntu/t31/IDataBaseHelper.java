package cn.lntu.t31;

import java.util.List;

public interface IDataBaseHelper extends ICommontHelper{
  
	//执行sql命令
	public int ExcuSQL(String SQLString);
	 //返回数据库中的一行数据---字符串数组,从数据库中返回一个字符串数组（select）
    public String[] GetARowDataBySQL(String SQLString, int length);
    //数据存在性 
    public boolean HasData(String SQLString);
    //返回数据库中的多行数据---字符串数组,从数据库中返回一个字符串数组（select）
    public List<String[]> GetMutiRowDataBySQL(String SQLString, int length);
    //返回数据库中的多行数据---字符串数组,从数据库中返回一个字符串数组（select 带有条件）
    public List<String[]> GetMutiRowDataBySQL(String SQLString, int length, MutiCondition request); 
}
