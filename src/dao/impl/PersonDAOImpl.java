package dao.impl;

import java.sql.*;
import java.util.*;

import vo.Person;
import vo.Student;
import dao.IPersonDAO;


public class PersonDAOImpl implements IPersonDAO{
	
	private Connection con=null;
	private PreparedStatement st=null;
	
	
	public PersonDAOImpl(Connection con){
		this.con=con;
	}

	public boolean findLogin(Person person) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			String sql="select name from person where personid=? and password=?";
			this.st=this.con.prepareStatement(sql);
			this.st.setString(1, person.getPersonid());
			this.st.setString(2,person.getPassword());
			ResultSet rs=this.st.executeQuery();
			if(rs.next()){
				person.setName(rs.getString(1));
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

	public boolean doCreate(Person person) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			String sql="insert into person values(?,?,?,?,?)";
			this.st=this.con.prepareStatement(sql);
			this.st.setString(1, person.getPersonid());
			this.st.setString(2, person.getPassword());
			this.st.setString(3,person.getName());
			this.st.setString(4, person.getCollege());
			this.st.setString(5,person.getTelephone());
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
	
	public Person findByid(String id) throws Exception {
		Person person=null;
		String sql="select * from person where personid=?";
		this.st=this.con.prepareStatement(sql);
		this.st.setString(1, id);
		ResultSet rs=this.st.executeQuery();
		if(rs.next()){
			person=new Person();
			person.setPersonid(rs.getString(1));
			person.setPassword(rs.getString(2));
			person.setName(rs.getString(3));
			person.setCollege(rs.getString(4));
			person.setTelephone(rs.getString(5));
		}
		this.st.close();
		return person;
	}


	public List<Person> findAll() {
		// TODO Auto-generated method stub
		List<Person> all=new ArrayList();
		try{
			String sql="select * from person";
			this.st=this.con.prepareStatement(sql);
			ResultSet rs=this.st.executeQuery();
			Person person=null;
			while(rs.next()){
				person=new Person();
				person.setPersonid(rs.getString(1));
				person.setPassword(rs.getString(2));
				person.setName(rs.getString(3));
				person.setCollege(rs.getString(4));
				person.setTelephone(rs.getString(5));
				all.add(person);
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

	
	public boolean doDelete(String personid) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			String sql="delete from person where personid=?";
			this.st=this.con.prepareStatement(sql);
			this.st.setString(1, personid);
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
