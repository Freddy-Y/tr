package dao.proxy;

import vo.Person;
import vo.Student;
import dbc.DatabaseConnection;
import dao.impl.PersonDAOImpl;

import java.util.List;

import dao.IPersonDAO;


public class PersonDAOProxy implements  IPersonDAO{
	private DatabaseConnection dbc=null;
	private IPersonDAO dao=null;
	
	public PersonDAOProxy(){
		try{
			System.out.println("正在连接数据库：");
			this.dbc=new DatabaseConnection();
			System.out.println("进入完毕：");
		}catch(Exception e){
			e.printStackTrace();
		}
		this.dao=new PersonDAOImpl(this.dbc.getConnection());
	}
	
	
	public boolean findLogin(Person person) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			flag=this.dao.findLogin(person);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		return flag;
	}


	
	public boolean doCreate(Person person) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			if(this.dao.findByid(person.getPersonid())==null){
				flag=this.dao.doCreate(person);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
		
		return flag;
	}


	
	public Person findByid(String id) throws Exception {
		Person person=null;
		try{
			person=this.dao.findByid(id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				this.dbc.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return person;
	}


	
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		List<Person> all=null;
		try{
			if(this.dao.findAll()!=null){
				all=this.dao.findAll();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return all;

	}


	
	public boolean doDelete(String persinid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			if(this.dao.doDelete(persinid)){
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
