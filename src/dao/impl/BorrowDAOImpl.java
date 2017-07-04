package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.*;
import vo.Borrow;
import dao.IBorrowDAO;


public class BorrowDAOImpl implements IBorrowDAO{
	private Connection con=null;
	private PreparedStatement pst=null;
	
	public BorrowDAOImpl(Connection con){
		this.con=con;
	}


	public boolean doCreate(Borrow borrow) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			String sql="insert into borrow values(?,?,?,?,?,curdate())";
			this.pst=this.con.prepareStatement(sql);
			this.pst.setString(1,borrow.getPrincipalid());
			this.pst.setString(2,borrow.getUsername());
			this.pst.setString(3, borrow.getEquipnum());
			this.pst.setString(4, borrow.getEquipname());
			this.pst.setString(5,borrow.getType());
			//this.pst.setDate(6, borrow.getDate());
			int rs=this.pst.executeUpdate();
			if(rs>0){
				flag=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(this.pst!=null){
				try{
					this.pst.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		return flag;
	}

	public List<Borrow> findBydate(Date date) {
		// TODO Auto-generated method stub
		List<Borrow> all=new ArrayList();
		try{
			String sql="select * from borrow where date=?";
			this.pst=this.con.prepareStatement(sql);
			this.pst.setDate(1, date);
			ResultSet rs=this.pst.executeQuery();
			Borrow borrow =null;
			while(rs.next()){
				borrow=new Borrow();
				borrow.setPrincipalid(rs.getString(1));
				borrow.setUsername(rs.getString(2));
				borrow.setEquipnum(rs.getString(3));
				borrow.setEquipname(rs.getString(4));
				borrow.setType(rs.getString(5));
				borrow.setDate(rs.getDate(6));
				all.add(borrow);
			}
			
		}catch(Exception e){
			e.printStackTrace();;
		}finally{
			if(this.pst!=null){
				try{
					this.pst.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return all;
	}

	
	public boolean doDelete(String equipnum) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			String sql="delete from borrow where equipnum=?";
			this.pst=this.con.prepareStatement(sql);
			
			this.pst.setString(1, equipnum);
			int rs=this.pst.executeUpdate();
			if(rs>0){
				flag=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(this.pst!=null){
				try{
					this.pst.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return flag;
	}


	
	public Borrow findByid(String equipnum) {
		// TODO Auto-generated method stub
		Borrow borrow=null;
		try{
			String sql="select * from borrow where equipnum=?";
			this.pst=this.con.prepareStatement(sql);
			this.pst.setString(1, equipnum);
			ResultSet rs=this.pst.executeQuery();
			while(rs.next()){
				borrow=new Borrow();
				borrow.setPrincipalid(rs.getString(1));
				borrow.setUsername(rs.getString(2));
				borrow.setEquipnum(rs.getString(3));
				borrow.setEquipname(rs.getString(4));
				borrow.setType(rs.getString(5));
				borrow.setDate(rs.getDate(6));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(this.pst!=null){
				try{
					this.pst.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return borrow;
	}
	
}
