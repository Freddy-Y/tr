package dao.proxy;

import dbc.DatabaseConnection;
import vo.Repair;
import dao.impl.RepairDAOImpl;
import dao.IRepairDAO;
import java.util.*;

public class RepairDAOproxy implements IRepairDAO{
	private DatabaseConnection con=null;
	private RepairDAOImpl dao=null;
	
	public RepairDAOproxy(){
		try{
			this.con=new DatabaseConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.dao=new RepairDAOImpl(this.con.getConnection());
	}

	
	public boolean doCreate(Repair repair) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
				flag=dao.doCreate(repair);
		}catch(Exception e){
			throw e;
		}finally{
			this.con.close();
		}
		return flag;
	}

	
	public boolean doDelete(String repairid,String build) throws Exception {
		boolean flag=false;
		try{
			System.out.print(build);
			System.out.print(repairid);
			if(this.dao.doDelete(repairid,build)){
				flag=this.dao.doDelete(repairid,build);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.con.close();
		}
		return flag;
	}

	
	public List<Repair> findAll(String build) throws Exception {
		List<Repair> all=new ArrayList();
		try{
			if(this.dao.findAll(build)!=null){
				all=this.dao.findAll(build);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.con.close();
		}
		return all;
	}
}
