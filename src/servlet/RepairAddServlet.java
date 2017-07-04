package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import factory.DAOFactory;
import vo.Repair;


public class RepairAddServlet extends HttpServlet{
	
	/**
	 * 
	 */
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
		String path="equip.jsp";
		req.setCharacterEncoding("utf-8");
		String repairid=req.getParameter("repairid");
		String roomid=req.getParameter("roomid");
		String repairmass=req.getParameter("repairmass");
		String building=req.getParameter("building");
		String userid=null;
		String info=null;
		HttpSession sess=req.getSession();
		if(sess.getAttribute("stuid")!=null){
			userid=(String)sess.getAttribute("stuid");
		}else if(sess.getAttribute("personid")!=null){
			userid=(String)sess.getAttribute("stuid");
		}else{
			info="用户未登陆，请登陆后重试！";
		}
		if(repairid==null||"".equals(repairid)){
			info="日期不能为空";
		}
		if(roomid==null||"".equals(roomid)){
			info="教室不能为空";
		}
		try {
			System.out.println("开始验证教室");
			System.out.println(roomid);
			System.out.println(building);
			if(DAOFactory.getClassroomDAOInstance().findByid(roomid,building)==null){
				info="教室未存在！";
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(repairmass==null||"".equals(repairmass)){
			info="报修信息不能为空！";
		}
		if(info==null||"".equals(info)){
			Repair repair=new Repair();
			repair.setRepairid(repairid);
			repair.setRoomid(roomid);
			repair.setUserid(userid);
			repair.setRepairmass(repairmass);
			repair.setBuild(building);
			try{
				if(DAOFactory.getRepairDAOInstance().doCreate(repair)){
					info="报修成功！";		
				}
				else{
					info="异常！";
				}
			}catch(Exception e){
					e.printStackTrace();
			}
		}
			

		req.setAttribute("repairinfo", info);
		req.getRequestDispatcher(path).forward(req, resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		this.doGet(req, res);
	}

}
