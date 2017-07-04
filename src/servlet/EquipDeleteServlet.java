package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import factory.DAOFactory;



public class EquipDeleteServlet extends HttpServlet{
	
	/**
	 * 
	 */
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
		String path="admin/equip/delete.jsp";
		req.setCharacterEncoding("utf-8");
		String Equipid=req.getParameter("equipid");
		HttpSession sess=req.getSession();
		String build=(String)sess.getAttribute("buildnum");
		String info=null;

		try{
			if(DAOFactory.getEquipDAOInstance().doDelete(Equipid, build)){
				info="删除成功！";		
			}
			else{
				info="删除失败！";
			}
		}catch(Exception e){
				e.printStackTrace();
		}

			

		req.setAttribute("deleteinfo", info);
		req.getRequestDispatcher(path).forward(req, resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		this.doGet(req, res);
	}

}
