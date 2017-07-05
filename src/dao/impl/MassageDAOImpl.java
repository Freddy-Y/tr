package dao.impl;

import java.util.ArrayList;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.IMassageDAO;
import vo.Massage;

public class MassageDAOImpl implements IMassageDAO{

	private Connection con=null;
	private PreparedStatement pst=null;
	
	public MassageDAOImpl(Connection con){
		this.con=con;
	}
	
	public boolean doCreate(Massage massage) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			String sql="insert into massage values(?,?,curdate(),?)";
			this.pst=this.con.prepareStatement(sql);
			this.pst.setString(1, massage.getMassageid());
			this.pst.setString(2, massage.getMcontent());
			this.pst.setString(3, massage.getUserid());
			int rs=this.pst.executeUpdate();
			if(rs>0){
				flag=true;
			}
		}catch(Exception e){
			throw e;
		}finally{
			if(this.pst!=null){
				this.pst.close();
			}
		}
		return flag;
	}

	
	public Massage findByid(String massageid) throws Exception {
		// TODO Auto-generated method stub
		Massage massage=null;
		try{
			String sql="select * from massage where massageid=?";
			this.pst=this.con.prepareStatement(sql);
			this.pst.setString(1, massageid);
			ResultSet rs=this.pst.executeQuery();
			while(rs.next()){
				massage=new Massage();
				massage.setMassageid(rs.getString(1));
				massage.setMcontent(rs.getString(2));
				massage.setDate(rs.getDate(3));
				massage.setUserid(rs.getString(4));
			}
			
		}catch(Exception e){
			throw e;
		}finally{
			if(this.pst!=null){
				this.pst.close();
			}
		}
		return massage;
	}

	
	public List<Massage> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Massage> all=new ArrayList();
		try{
			String sql="select * from massage";
			this.pst=this.con.prepareStatement(sql);
			ResultSet rs=this.pst.executeQuery();
			//Massage massage=null;
			while(rs.next()){
				Massage massage=new Massage();
				massage.setMassageid(rs.getString(1));
				massage.setMcontent(rs.getString(2));
				massage.setDate(rs.getDate(3));
				massage.setUserid(rs.getString(4));
				all.add(massage);
			}
		}catch(Exception e){
			throw e;
		}finally{
			if(this.pst!=null){
				this.pst.close();
			}
		}
		return all;
	}

}
