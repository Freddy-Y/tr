package dao.proxy;

import java.util.*;
import dbc.*;
import dao.impl.EquipDAOImpl;
import vo.Equip;
import dao.IEquipDAO;


public class EquipDAOProxy implements IEquipDAO{
	
	private DatabaseConnection con;
	private EquipDAOImpl dao;
	
	public EquipDAOProxy(){
		try{
			this.con=new DatabaseConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.dao=new EquipDAOImpl(this.con.getConnection());
	}
	
	public boolean doCreate(Equip equip) throws Exception {
		boolean flag=false;
		try{
			if(this.dao.doCreate(equip)){
				flag=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(this.con!=null){
				this.con.close();
			}
		}
		return flag;
	}

	
	public List<Equip> findAll(String build,int state) throws Exception {
		// TODO Auto-generated method stub
		List<Equip> all=null;
		try{
			all=this.dao.findAll(build,state);
			System.out.println("查找所有设备成功");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.con.close();
		}
		return all;
	}

	
	public Equip findByid(String equipid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean doDelete(String equipid,String build) throws Exception {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			if(this.dao.doDelete(equipid, build)){
				flag=true;
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.con.close();
		}
		return flag;
	}


	public boolean findState(String equipid, String build) {
		boolean flag=false;
		try{
			flag=dao.findState(equipid, build);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				this.con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public boolean doChangestate(String equipid, int state, String build) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			if(this.dao.doChangestate(equipid, state, build)){
				flag=true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				this.con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

}
