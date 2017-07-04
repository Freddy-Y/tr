package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import dao.IRepairDAO;
import vo.Repair;
	
public class RepairDAOImpl implements IRepairDAO{
	private Connection con=null;
	private PreparedStatement pst=null;
	public RepairDAOImpl(Connection con){
		this.con=con;
	}
	
	public boolean doCreate(Repair repair) throws Exception {
		boolean flag=false;
		try{
			String sql="insert into repair values(?,?,?,?,?)";
			this.pst=this.con.prepareStatement(sql);
			this.pst.setString(1, repair.getRepairid());
			this.pst.setString(2, repair.getUserid());
			this.pst.setString(3, repair.getRepairmass());
			this.pst.setString(4, repair.getRoomid());
			this.pst.setString(5, repair.getBuild());
			int rs=this.pst.executeUpdate();
			if(rs>0){
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
	
	public boolean doDelete(String repairid,String build) throws Exception {
		boolean flag=false;
		try{
			String sql="delete from repair where repairid=? and build=?";
			this.pst=this.con.prepareStatement(sql);
			this.pst.setString(1, repairid);
			this.pst.setString(2, build);
			int rs=this.pst.executeUpdate();
			if(rs>0){
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
	
	public List<Repair> findAll(String build) throws Exception {
		List<Repair> all=new ArrayList();
		try{
			String sql="select * from repair where build=?";
			this.pst=this.con.prepareStatement(sql);
			this.pst.setString(1,build);
			ResultSet rs=this.pst.executeQuery();
			Repair repair=null;
			while(rs.next()){
				repair=new Repair();
				repair.setRepairid(rs.getString(1));
				repair.setUserid(rs.getString(2));
				repair.setRepairmass(rs.getString(3));
				repair.setRoomid(rs.getString(4));
				all.add(repair);
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
		return all;
	}
}
