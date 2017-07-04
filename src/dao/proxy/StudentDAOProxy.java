package dao.proxy;

import vo.Person;
import vo.Student;
import dbc.DatabaseConnection;
import dao.impl.StudentDAOImpl;

import java.util.List;

import dao.IStudentDAO;

public class StudentDAOProxy implements  IStudentDAO{
	private DatabaseConnection dbc=null;
	private IStudentDAO dao=null;
	
	public StudentDAOProxy(){
		try{
			System.out.println("正在连接数据库：");
			this.dbc=new DatabaseConnection();
			System.out.println("进入完毕：");
		}catch(Exception e){
			e.printStackTrace();
		}
		this.dao=new StudentDAOImpl(this.dbc.getConnection());
	}
	
	
	
	public boolean findLogin(Student student) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			flag=this.dao.findLogin(student);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}



	public boolean doCreate(Student student) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			if(this.dao.findByid(student.getSid())==null){
				flag=this.dao.doCreate(student);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		
		return flag;
	}


	
	public Student findByid(String id) throws Exception {
		Student student=null;
		try{
			student=this.dao.findByid(id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				this.dbc.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return student;
	}




	public List<Student> findAll() {
		List<Student> all=null;
		try{
			System.out.println("代理类进入");
			if(this.dao.findAll()!=null){
				all=this.dao.findAll();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return all;
	}



	
	public boolean doDelete(String sid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			if(this.dao.doDelete(sid)){
				flag=true;
			}
		}catch(Exception e){
			throw e;
		}finally{
			try{
				this.dbc.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return flag;
	}
}
