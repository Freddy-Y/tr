package servlet;

import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import factory.DAOFactory;
import vo.Repair;


public class RepairSelectServlet extends HttpServlet{
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
		String path="admin/repair/select.jsp";
		req.setCharacterEncoding("utf-8");
		List<Repair> all=null;
		HttpSession sess=req.getSession();
		String num=(String)sess.getAttribute("buildnum");
		if(!(req.getParameter("state")==null||"".equals(req.getParameter("state")))){
			try{
				all=DAOFactory.getRepairDAOInstance().findAll(num);
				req.setAttribute("all", all);
			}catch(Exception e){
				e.printStackTrace();
			}
		req.getRequestDispatcher(path).forward(req, resp);
		}
}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		this.doGet(req, res);
	}

}
