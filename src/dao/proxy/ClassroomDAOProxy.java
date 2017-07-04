package dao.proxy;

import dao.IClassroomDAO;
import dao.impl.BorrowDAOImpl;
import dao.impl.ClassroomDAOImpl;
import dbc.DatabaseConnection;
import vo.Classroom;

public class ClassroomDAOProxy implements IClassroomDAO{
	private DatabaseConnection con=null;
	private ClassroomDAOImpl dao=null;
	
	public ClassroomDAOProxy(){
		try{
			this.con=new DatabaseConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.dao=new ClassroomDAOImpl(this.con.getConnection());
		
	}

	public Classroom findByid(String roomid,String building) throws Exception {
		// TODO Auto-generated method stub
		Classroom classroom=new Classroom();
		try{
			System.out.println("教室查询进入");
			if(this.dao.findByid(roomid,building)!=null){
				classroom=this.dao.findByid(roomid,building);
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
		return classroom;
	}
}
