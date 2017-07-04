package dao.proxy;

import java.sql.Date;
import java.util.*;
import dbc.*;
import dao.impl.BorrowDAOImpl;
import vo.Borrow;
import dao.IBorrowDAO;

public class BorrowDAOProxy implements IBorrowDAO{
	
	private DatabaseConnection con=null;
	private BorrowDAOImpl dao=null;
	
	public BorrowDAOProxy(){
		try{
			this.con=new DatabaseConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		this.dao=new BorrowDAOImpl(this.con.getConnection());
		
	}
	
	public boolean doCreate(Borrow borrow) {
		boolean flag=false;
		try{
			if(dao.findByid(borrow.getPrincipalid())==null){
				flag=dao.doCreate(borrow);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				this.con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	public List<Borrow> findBydate(Date date) {
		List<Borrow> all=new ArrayList();
		try{
			all=this.dao.findBydate(date);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				this.con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return all;
	}
	
	public boolean doDelete(String equipnum) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try{
			flag=this.dao.doDelete(equipnum);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				this.con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	
	public Borrow findByid(String equipnum) {
		// TODO Auto-generated method stub
		Borrow borrow=null;
		try{
			borrow=this.dao.findByid(equipnum);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(this.con!=null){
				try {
					this.con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return borrow;
	}
	
	
	
	
	
	
	

}
