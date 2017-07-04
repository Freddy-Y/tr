package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import factory.DAOFactory;
import vo.Equip;


public class EquipAddServlet extends HttpServlet{
	
	/**
	 * 
	 */
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
		String path="admin/equip/add.jsp";
		req.setCharacterEncoding("utf-8");
		String Equipid=req.getParameter("equipid");
		String name=req.getParameter("name");
		HttpSession sess=req.getSession();
		String build=(String)sess.getAttribute("buildnum");
		Equip equip=null;
		String info=null;

		if(Equipid==null||"".equals(Equipid)){
			info="设备编号不能为空";
		}
		if(name==null||"".equals(name)){
			info="设备型号不能为空";
		}
		
		
		if(info==null||"".equals(info)){
			equip=new Equip();
			equip.setEquipid(Equipid);
			equip.setName(name);
			equip.setBuild(build);
			try{
				if(DAOFactory.getEquipDAOInstance().doCreate(equip)){
					info="添加成功！";		
				}
				else{
					info="添加失败，该设备已存在";
				}
			}catch(Exception e){
					e.printStackTrace();
			}
		}
			

		req.setAttribute("addinfo", info);
		req.getRequestDispatcher(path).forward(req, resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		this.doGet(req, res);
	}

}
