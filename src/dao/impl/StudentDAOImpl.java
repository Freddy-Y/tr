package dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import vo.Student;
import dao.IStudentDAO;

public class StudentDAOImpl implements IStudentDAO{
	
	private Connection con=null;
	private PreparedStatement st=null;
	
	
	public StudentDAOImpl(Connection con){
		this.con=con;
	}

	public boolean findLogin(Student student) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			String sql="select name from student where sid=? and password=?";
			this.st=this.con.prepareStatement(sql);
			this.st.setString(1, student.getSid());
			this.st.setString(2,student.getPassword());
			ResultSet rs=this.st.executeQuery();
			if(rs.next()){
				student.setName(rs.getString(1));
				flag=true;
			}
		}catch(Exception e){
			throw e;
		}finally{
			if(this.st!=null){
				try{
					st.close();
				}catch(Exception e){
					throw e;
				}
			}
		}
		
		return flag;
	}
	
	public boolean doCreate(Student student) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			String sql="insert into student values(?,?,?,?,?)";
			this.st=this.con.prepareStatement(sql);
			this.st.setString(1, student.getSid());
			this.st.setString(2, student.getName());
			this.st.setString(3,student.getPassword());
			this.st.setString(4, student.getCollege());
			this.st.setString(5,student.getTelephone());
			int rs=this.st.executeUpdate();
			if(rs>0){
				flag=true;
			}
		}catch(Exception e){
			throw e;
		}finally{
			if(this.st!=null){
				try{
					st.close();
				}catch(Exception e){
					throw e;
				}
			}
		}
		return flag;
	}
	
	public Student findByid(String id) throws Exception {
		// TODO Auto-generated method stub
		Student student=null;
		String sql="select * from student where sid=?";
		this.st=this.con.prepareStatement(sql);
		this.st.setString(1, id);
		ResultSet rs=this.st.executeQuery();
		if(rs.next()){
			student=new Student();
			student.setSid(rs.getString(1));
			student.setName(rs.getString(2));
			student.setPassword(rs.getString(3));
			student.setCollege(rs.getString(4));
			student.setTelephone(rs.getString(5));
		}
		this.st.close();
		return student;
	}

	
	public List<Student> findAll() {
		List<Student> all=new ArrayList();
		try{
			String sql="select * from student";
			this.st=this.con.prepareStatement(sql);
			ResultSet rs=this.st.executeQuery();
			Student student=null;
			System.out.println("真实主题类进入");
			while(rs.next()){
				student=new Student();
				student.setSid(rs.getString(1));
				student.setName(rs.getString(2));
				student.setPassword(rs.getString(3));
				student.setCollege(rs.getString(4));
				student.setTelephone(rs.getString(5));
				all.add(student);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(this.st!=null){
				try{
					this.st.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return all;
	}

	
	public boolean doDelete(String sid) throws Exception {
		boolean flag=false;
		try{
			String sql="delete from student where sid=?";
			this.st=this.con.prepareStatement(sql);
			this.st.setString(1, sid);
			int rs=this.st.executeUpdate();
			if(rs>0){
				flag=true;
			}
		}catch(Exception e){
			throw e;
		}finally{
			if(this.st!=null){
				try{
					this.st.close();
				}catch(Exception e){
					throw e;
				}
			}
		}
		return flag;
	}

}
