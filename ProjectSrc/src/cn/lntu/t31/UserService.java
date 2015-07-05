package cn.lntu.t31;

import java.util.ArrayList;
import java.util.List;

public class UserService {
	
	/**
	 * 登录操作
	 * @param userName
	 * @param password
	 * @return
	 */
	public String login(String userName,String password){
		
		DataOperate dataOperate = new DataOperate();
		String [] res = null;
		//System.out.print(password);
		String SQL = "select UserName,Password,Power,IsStop,RealName,Tel ,Sex,PhotoPath,Unit from User where UserName ='"+userName+"' AND Password ='"+ password+"'";
		//System.out.print(SQL);
		res = dataOperate.GetARowDataBySQL(SQL,9);
		if(res == null){
			return null;
		}else if(res[1].equals(password)){		
					User us = new User();
					us.setUserName(res[0]);
					us.setPassword(res[1]);
					us.setPower(res[2]);
					us.setIsStop(res[3]);
					us.setRealName(res[4]);
					us.setTel(res[5]);
					us.setSex(res[6]);
					us.setPhotoPath(res[7]);
					us.setUnit(res[8]);
					return us.toJson();
				}else{
						return "-1";
					}		
	}
	
	/**
	 * 更改密码操作
	 * @param userName
	 * @param password
	 * @return
	 */
	public int updatePassword(String userName,String password){
		DataOperate dataOperate = new DataOperate();
		int result;
		String SQL = "update  User set password='"+ password +"' where  UserName='"+userName+"'";
		result = dataOperate.ExcuSQL(SQL);
		return result;		
	}
	
	/**
	 * 更新信息操作
	 * @param request
	 * @return
	 */
	public int updateInfo(String [] request){
		DataOperate dataOperate = new DataOperate();
		int result;
		if(request==null){
			return 0;
		}
		String SQL = "update  User set RealName = '"+request[1]+ "',Tel ='"+request[2]+"',Sex = '"+request[3]+"'where  UserName='"+request[0]+"'";
		result = dataOperate.ExcuSQL(SQL);
		return result;	
	}
	
	/**
	 * 根据条件查询用户操作
	 * @param request
	 * @return
	 */
	public String selectUserByCondition( MutiCondition request){
		DataOperate dataOperate = new DataOperate();
		List<String[]> res = null;
		if(request==null){
			return "-1";
		}
		String SQL = "Select * from  User";
		res = dataOperate.GetMutiRowDataBySQL(SQL,7,request);
		return null;		
	}
	
	public List<User> userSearch(String Keyword,int States){
		DataOperate dataOperate = new DataOperate();
		String SQL = null;
		List<User> res = new ArrayList<User>();
		switch(States){
		case 0 : SQL = "select UserName,Password,Power,IsStop,Tel,RealName,Sex,PhotoPath,Unit from user where IsStop= '"+States+"' and UserName like '%"+ Keyword + "%'";break;
		case 1 : SQL = "select UserName,Password,Power,IsStop,Tel,RealName,Sex,PhotoPath,Unit from user where IsStop= '"+States+"' and UserName like '%"+ Keyword + "%'";break;
		case 2 : SQL = "select UserName,Password,Power,IsStop,Tel,RealName,Sex,PhotoPath,Unit from user where IsStop= '"+States+"' and UserName like '%"+ Keyword + "%'";break;
		}
		List<String[]> result = dataOperate.GetMutiRowDataBySQL(SQL, 9);
		User us = null;
		//System.out.print(result.size());
		for (int i = 0; i < result.size(); i++)
        {
			us = new User();
            String[] data = result.get(i);
            if (data.length > 0)
            {
            	us.setUserName(data[0]);
            	us.setPassword(data[1]);
            	switch(data[2]){
            		case "1":us.setPower("普通用户");break;
            		case "2":us.setPower("审核人员");break;
            		case "3":us.setPower("管理员");break;
            	}           	
            	us.setIsStop(data[3]);     	
            	us.setTel(data[4]);
            	us.setRealName(data[5]);
            	us.setSex(data[6]);
            	us.setPhotoPath(data[7]);
            	us.setUnit(data[8]);
            }
            res.add(us);
        }
	    return res;
	   }

	public int userInfoDelete(String userName) {
		DataOperate dataOperate = new DataOperate();
		int result;
		String SQL = "delete from user where UserName = '"+userName+"'";
		result = dataOperate.ExcuSQL(SQL);
		return result;
	}
	
}
