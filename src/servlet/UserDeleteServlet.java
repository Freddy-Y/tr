package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import factory.DAOFactory;



public class UserDeleteServlet extends HttpServlet{
	
	/**
	 * 
	 */
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
		String path="admin/user/delete.jsp";
		req.setCharacterEncoding("utf-8");
		String userid=req.getParameter("userid");
		String type=req.getParameter("type");
		String info=null;
		if("student".equals(type)){
			try{
				if(DAOFactory.getStudentDAOInstance().doDelete(userid)){
					info="删除成功！";		
				}
				else{
					info="删除失败！";
				}
			}catch(Exception e){
					e.printStackTrace();
			}
		}
		if("person".equals(type)){
			try{
				if(DAOFactory.getPersonDAOInstance().doDelete(userid)){
					info="删除成功！";		
				}
				else{
					info="删除失败！";
				}
			}catch(Exception e){
					e.printStackTrace();
			}
		}
		
		

			

		req.setAttribute("deleteinfo", info);
		req.getRequestDispatcher(path).forward(req, resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		this.doGet(req, res);
	}

}
