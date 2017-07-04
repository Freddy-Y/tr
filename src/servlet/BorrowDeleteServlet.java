package servlet;

import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import factory.DAOFactory;
import vo.Borrow;
import vo.Person;
import vo.Student;
import java.sql.Date;


public class BorrowDeleteServlet extends HttpServlet{
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
		String path="admin/equip/return.jsp";
		req.setCharacterEncoding("utf-8");
		String equipid=req.getParameter("equipid");
		String use1=req.getParameter("use1");
		String use2=req.getParameter("use2");
		String inforeturn=null;
		Borrow borrows=null;
		boolean flag=false;
		HttpSession sess=req.getSession();
		String build=(String)sess.getAttribute("buildnum");

		if("look".equals(use1)){		//查看借用信息
			borrows=factory.DAOFactory.getBorrowDAOInstance().findByid(equipid);
			req.setAttribute("borrows", borrows);
			
		}
		
		if("delete".equals(use2)){
			if(factory.DAOFactory.getEquipDAOInstance().doChangestate(equipid, 1, build)){
				flag=factory.DAOFactory.getBorrowDAOInstance().doDelete(equipid);
				inforeturn ="归还成功";
			}else{
				inforeturn ="归还异常";
			}
		}	
		req.setAttribute("inforeturn", inforeturn);
		req.getRequestDispatcher(path).forward(req, resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		this.doGet(req, res);
	}

}
