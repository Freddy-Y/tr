package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.IClassroomDAO;
import vo.Classroom;


public class ClassroomDAOImpl implements IClassroomDAO{
	private Connection con=null;
	private PreparedStatement pst=null;
	public ClassroomDAOImpl(Connection con){
		this.con=con;
	}

	
	public Classroom findByid(String roomid,String building) throws Exception {
		Classroom classroom=null;
		try{
			String sql="select * from classroom where roomid=? and building=?";
			this.pst=this.con.prepareStatement(sql);
			this.pst.setString(1,roomid);
			this.pst.setString(2, building);
			ResultSet rs=this.pst.executeQuery();
			classroom=new Classroom();
			while(rs.next()){
				classroom.setRoomid(rs.getString(1));
				classroom.setBuilding(rs.getString(2));
				classroom.setState(rs.getString(3));
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
		return classroom;
	}
}
