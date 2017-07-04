package dao.proxy;

import java.util.List;
import dbc.DatabaseConnection;
import dao.impl.MassageDAOImpl;
import dao.IMassageDAO;
import vo.Massage;
import java.util.*;

public class MassageDAOProxy implements IMassageDAO{

	private DatabaseConnection con=null;
	private MassageDAOImpl dao=null;
	public MassageDAOProxy(){
		try{
			this.con=new DatabaseConnection();
		}catch(Exception e ){
			e.printStackTrace();
		}
		this.dao=new MassageDAOImpl(this.con.getConnection());
	}
	public boolean doCreate(Massage massage) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			if(this.dao.findByid(massage.getMassageid())==null){
				flag=this.dao.doCreate(massage);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.con.close();
		}
		return flag;
	}

	
	public Massage findByid(String massageid) throws Exception {
		// TODO Auto-generated method stub
		Massage massage=new Massage();
		try{
			massage=this.dao.findByid(massageid);
		}catch(Exception e){
			throw e;
		}finally{
			this.con.close();
		}
		return massage;
	}

	
	public List<Massage> findAll() throws Exception {
		List<Massage> all=new ArrayList();
		try{
			all=this.dao.findAll();
		}catch(Exception e){
			throw e;
		}finally{
			this.con.close();
		}
		return all;
	}

}
