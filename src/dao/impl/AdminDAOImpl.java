package dao.impl;

import dao.IAdminDAO;
import vo.Admin;
import java.sql.*;

public class AdminDAOImpl implements IAdminDAO{
	private Connection con;
	private PreparedStatement pst;
	
	
	public AdminDAOImpl(Connection con){
		this.con=con;
	}


	public boolean findALogin(Admin admin) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			System.out.println("进入真实主题类");
			String sql="select name from admin where adminid=? and password=? and num=?";
			pst=this.con.prepareStatement(sql);
			this.pst.setString(1, admin.getAdminid());
			this.pst.setString(2,admin.getPassword());
			this.pst.setString(3, admin.getNum());
			System.out.println(admin.getAdminid());
			System.out.println(admin.getPassword());
			System.out.println(admin.getNum());
			ResultSet rs=this.pst.executeQuery();
			if(rs.next()){
				admin.setName(rs.getString(1));
				System.out.println("有结果");
				flag=true;
			}
			
		}catch(Exception e){
			throw e;
		}finally{
			if(this.pst!=null){
				try{
					this.pst.close();
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
			String sql="insert into admin values(?,?,?,?,?)";
			this.pst=this.con.prepareStatement(sql);
			this.pst.setString(1, admin.getAdminid());
			this.pst.setString(2, admin.getName());
			this.pst.setString(3, admin.getPassword());
			this.pst.setString(4, admin.getNum());
			this.pst.setString(5, admin.getTelephone());
			int rs=this.pst.executeUpdate();
			if(rs>=0){
				flag=true;
			}
			
		}catch(Exception e){
			throw e;
		}finally{
			if(this.pst!=null){
				try{
					this.pst.close();
				}catch(Exception e){
					throw e;
				}
			}
		}
		return flag;
	}

	public Admin findByaid(String aid) throws Exception {
		// TODO Auto-generated method stub
		Admin admin=null;
		try{
			String sql="select * from admin where adminid=?";
			this.pst=this.con.prepareStatement(sql);
			this.pst.setString(1, aid);
			ResultSet rs=this.pst.executeQuery();
			if(rs.next()){
				admin.setAdminid(rs.getString(1));
				admin.setName(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setNum(rs.getString(4));
				admin.setTelphone(rs.getString(5));
			}
		}catch(Exception e){
			throw e;
		}finally{
			if(this.pst!=null){
				try{
					this.pst.close();
				}catch(Exception e){
					throw e;
				}
			}
		}
		return admin;
	}



	

}
