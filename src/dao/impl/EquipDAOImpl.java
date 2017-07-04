package dao.impl;

import vo.Equip;

import java.util.*;
import dao.IEquipDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipDAOImpl implements IEquipDAO {

	private Connection con=null;
	private PreparedStatement pst=null;
	
	public EquipDAOImpl(Connection con){
		this.con=con;
	}
	
	public boolean doCreate(Equip equip) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			String sql="insert into equip values(?,?,?,1,curdate())";
			this.pst=this.con.prepareStatement(sql);
			this.pst.setString(1, equip.getEquipid());
			this.pst.setString(2, equip.getName());
			this.pst.setString(3, equip.getBuild());
			int rs=this.pst.executeUpdate();
			if(rs>0){
				System.out.println("插入设备成功");
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


	public List<Equip> findAll(String build,int state) throws Exception {
		
		List<Equip> all= new ArrayList();
		try{
			String sql="select * from equip where build=? and state=?";
			this.pst=this.con.prepareStatement(sql);
			this.pst.setString(1, build);
			this.pst.setInt(2, state);
			ResultSet rs=this.pst.executeQuery();
			Equip equip=null;
			while(rs.next()){
				equip=new Equip();
				equip.setEquipid(rs.getString(1));
				equip.setName(rs.getString(2));
				equip.setBuild(rs.getString(3));
				equip.setState(rs.getInt(4));
				equip.setTime(rs.getDate(5));
				all.add(equip);
				System.out.println("查找所有设备成功");
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

	public Equip findByid(String equipid) throws Exception {
		// TODO Auto-generated method stub
		Equip equip=null;
		String sql="select * from equip where equipid=?";
		this.pst=this.con.prepareStatement(sql);
		this.pst.setString(1, equipid);
		ResultSet rs=this.pst.executeQuery();
		if(rs.next()){
			equip=new Equip();
			equip.setEquipid(rs.getString(1));
			equip.setName(rs.getString(2));
			equip.setBuild(rs.getString(3));
			equip.setState(rs.getInt(4));
			equip.setTime(rs.getDate(5));
		}
		this.pst.close();
		return equip;
	}

	
	public boolean doDelete(String equipid,String build) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			String sql="delete from equip where equipid=? and build=?";
			this.pst=this.con.prepareStatement(sql);
			this.pst.setString(1, equipid);
			this.pst.setString(2, build);
			int rs=this.pst.executeUpdate();
			if(rs>0){
				System.out.println("删除一条记录");
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

	
	public boolean findState(String equipid, String build) {
		boolean flag=false;
		int state;
		try{
			String sql="select state from equip where equipid=? and build=?";
			this.pst=this.con.prepareStatement(sql);
			this.pst.setString(1, equipid);
			this.pst.setString(2,build);
			ResultSet rs=this.pst.executeQuery();
			while(rs.next()){
				state=rs.getInt(1);
				if(state==1){
					flag=true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(this.con!=null){
				try {
					this.con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	
	public boolean doChangestate(String equipid, int state,String build) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			String sql="update equip set state=? where equipid=? and build=?";
			this.pst=this.con.prepareStatement(sql);
			this.pst.setInt(1, state);
			this.pst.setString(2, equipid);
			this.pst.setString(3, build);
			int rs=this.pst.executeUpdate();
			if(rs>0){
				flag=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(this.con!=null){
				try{
					this.con.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
}
