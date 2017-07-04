package dao.proxy;

import dao.IAdminDAO;
import dao.impl.AdminDAOImpl;
import dbc.DatabaseConnection;
import vo.Admin;

public class AdminDAOProxy implements IAdminDAO{
	private AdminDAOImpl dao=null;
	private DatabaseConnection con=null;
	
	public AdminDAOProxy(){
		try{
			this.con=new DatabaseConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.dao=new AdminDAOImpl(this.con.getConnection());
	}
	
	
	public boolean findALogin(Admin admin) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		System.out.println("进入代理类");
		try{
			if(this.dao.findALogin(admin)){
				System.out.println("查找成功");
				flag=true;
			}
		}catch(Exception e){
			throw e;
		}finally{
			if(this.con!=null){
				try{
					this.con.close();
				}catch(Exception e){
					throw e;
				}
			}
		}
		
		return flag;
	}

	
	public boolean doCreateAdmin(Admin admin) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			if(this.dao.findByaid(admin.getAdminid())==null){
				flag=this.dao.doCreateAdmin(admin);
			}
		}catch(Exception e){
			throw e;
		}finally{
			if(this.con!=null){
				try{
					this.con.close();
				}catch(Exception e){
					throw e;
				}
			}
		}
		return flag;
	}

	
	public Admin findByaid(String aid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	

}
