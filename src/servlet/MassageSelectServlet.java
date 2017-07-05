package servlet;

import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import factory.DAOFactory;
import vo.Massage;


public class MassageSelectServlet extends HttpServlet{
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
		String path="admin/massage/select.jsp";
		req.setCharacterEncoding("utf-8");
		List<Massage> all=new ArrayList();
		if(!(req.getParameter("start")==null||"".equals(req.getParameter("start")))){
			try{
				if(DAOFactory.getMassageDAOInstance().findAll()!=null){
					System.out.println("不是空");
					all=DAOFactory.getMassageDAOInstance().findAll();
					req.setAttribute("allmassage0", all);
				}
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
