package dao;

import vo.Admin;

public interface IAdminDAO {
	/**
	 * 
	 * 
	 * 
	 */
	 public boolean findALogin(Admin admin)throws Exception;
	 /*
	  * 
	  * 
	  * 
	  * */
	 public boolean doCreateAdmin(Admin admin)throws Exception;
	 /*
	  * 
	  * 
	  * 
	  * 
	  * */
	 public Admin findByaid(String aid)throws Exception;

}
