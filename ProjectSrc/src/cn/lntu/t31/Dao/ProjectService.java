package cn.lntu.t31.Dao;

import java.util.ArrayList;
import java.util.List;

import cn.lntu.t31.Bean.ProjectSearch;
import cn.lntu.t31.Bean.ProjectSubmit;
import cn.lntu.t31.Persistent.DataOperate;

public class ProjectService {
	
	
	public int projectSubmit(ProjectSubmit ps){
		DataOperate dataOperate = new DataOperate();
		int result;
		String SQL = "insert  into Project(PName,PType,PDevelopers,PContent,Submiter,DevelopTime,IsCheck,IsExamine) value('"
		+ps.getpName()+"','"+ps.getType()+"','"+ps.getDevelopers()+"','"+ps.getpContent()+"','"+ps.getpSubmiter()+"','"+ps.getDevelopTime()+"',"+'0'+","+'0'
				+ ")";
		result = dataOperate.ExcuSQL(SQL);
		return result;
	}
	
	public List<ProjectSearch> projectSearch(String Keyword,int States,String id){
		DataOperate dataOperate = new DataOperate();
		String SQL = null;
		List<ProjectSearch> res = new ArrayList<ProjectSearch>();
		switch(States){
		case 0 : SQL = "select PNum,PName,PType,PContent,PDevelopers,DevelopTime from project where Submiter = '"+id+"'and IsCheck = '0' and IsExamine = '0' and PName like '%"+ Keyword + "%'";break;
		case 1 : SQL = "select PNum,PName,PType,PContent,PDevelopers,DevelopTime from project where Submiter = '"+id+"'and IsCheck = '0' and IsExamine = '1' and PName like '%"+ Keyword + "%'";break;
		case 2 : SQL = "select PNum,PName,PType,PContent,PDevelopers,DevelopTime from project where Submiter = '"+id+"'and IsCheck = '1' and IsExamine = '1' and PName like '%"+ Keyword + "%'";break;
		}
		List<String[]> result = dataOperate.GetMutiRowDataBySQL(SQL, 6);
		ProjectSearch ps = null;
		//System.out.print(result.size());
		for (int i = 0; i < result.size(); i++)
        {
			ps = new ProjectSearch();
            String[] data = result.get(i);
            if (data.length > 0)
            {
            	ps.setpNum(data[0]);
            	ps.setpName(data[1]);
            	ps.setType(data[2]);
            	ps.setpContent(data[3]);
            	ps.setDevelopTime(data[5]);
            	ps.setDevelopers(data[4]);
            }
            res.add(ps);
        }
	    return res;
	   }
	
	public int projectDelete(int Pnum){
		DataOperate dataOperate = new DataOperate();
		int result;
		String SQL = "delete from project where IsCheck = '0' and IsExamine = '0' and PNum = "+Pnum+" ";
		result = dataOperate.ExcuSQL(SQL);
		return result;
		
	}

	public List<ProjectSearch> cProjectSearch(String keyword, int states) {
		DataOperate dataOperate = new DataOperate();
		String SQL = null;
		List<ProjectSearch> res = new ArrayList<ProjectSearch>();
		switch(states){
		case 0 : SQL = "select PNum,PName,PType,PContent,PDevelopers,DevelopTime from project where IsCheck = '0' and IsExamine = '0' and PName like '%"+ keyword + "%'";break;
		case 1 : SQL = "select PNum,PName,PType,PContent,PDevelopers,DevelopTime from project where IsCheck = '0' and IsExamine = '1' and PName like '%"+ keyword + "%'";break;
		case 2 : SQL = "select PNum,PName,PType,PContent,PDevelopers,DevelopTime from project where IsCheck = '1' and IsExamine = '1' and PName like '%"+ keyword + "%'";break;
		}
		List<String[]> result = dataOperate.GetMutiRowDataBySQL(SQL, 6);
		ProjectSearch ps = null;
		//System.out.print(result.size());
		for (int i = 0; i < result.size(); i++)
        {
			ps = new ProjectSearch();
            String[] data = result.get(i);
            if (data.length > 0)
            {
            	ps.setpNum(data[0]);
            	ps.setpName(data[1]);
            	ps.setType(data[2]);
            	ps.setpContent(data[3]);
            	ps.setDevelopTime(data[5]);
            	ps.setDevelopers(data[4]);
            }
            res.add(ps);
        }
	    return res;
	}

	public int projectEC(int pnum,int index) {
		DataOperate dataOperate = new DataOperate();
		int result;
		String SQL = null;
		switch(index){
			case 1: SQL = "update  project set IsExamine='1' where  PNum='"+pnum+"'";break;
			case 2: SQL = "update  project set IsCheck='1' where  PNum='"+pnum+"'";break;
		}
		result = dataOperate.ExcuSQL(SQL);
		return result;
	}

}
