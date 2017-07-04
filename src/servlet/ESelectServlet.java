package servlet;

import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import factory.DAOFactory;
import vo.Equip;


public class ESelectServlet extends HttpServlet{
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
		String path="admin/equip/select.jsp";
		req.setCharacterEncoding("utf-8");
		int state = -1;
		List<Equip> all=null;
		HttpSession sess=req.getSession();
		String num=(String)sess.getAttribute("buildnum");
		if(!(req.getParameter("abc")==null||"".equals(req.getParameter("abc")))){
			if("0".equals(req.getParameter("abc")))
			{
				state=0;
				req.setAttribute("bbbttt", state);
			}else if("1".equals(req.getParameter("abc")))
			{
				state=1;
				req.setAttribute("bbbttt", state);
			}else{
				System.out.println("获取设备状态异常");
			}
			try{
				if(DAOFactory.getEquipDAOInstance().findAll(num,state).size()!=0){
					 all=DAOFactory.getEquipDAOInstance().findAll(num,state);
					 req.setAttribute("all", all);
					 Iterator<Equip> iter=all.iterator();
						while(iter.hasNext()){
							Equip equip=iter.next();
								System.out.println(equip.getEquipid());
								System.out.println(equip.getName() );
								System.out.println(equip.getBuild());
								System.out.println(equip.getState() );
								System.out.println(equip.getTime() );
								
						}
				}
				
			}catch(Exception e){
					e.printStackTrace();
			}
		}
		
			
		
		
		
		
		
		req.getRequestDispatcher(path).forward(req, resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		this.doGet(req, res);
	}

}
