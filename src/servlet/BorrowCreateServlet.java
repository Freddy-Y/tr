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


public class BorrowCreateServlet extends HttpServlet{
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
		String path="admin/equip/select.jsp";
		req.setCharacterEncoding("utf-8");
		String equipid=req.getParameter("equipid");
		String equipname=req.getParameter("equipname");
		String type=req.getParameter("type");
		String userid=req.getParameter("userid");
		String infoborrow=null;
		Borrow borrow=null;
		boolean flag=false;
		HttpSession sess=req.getSession();
		String build=(String)sess.getAttribute("buildnum");
		System.out.println(type);
		System.out.println(userid);
		System.out.println(equipid);
		System.out.println(equipname);
		if("person".equals(type)||type=="person"){
			try {
				if(factory.DAOFactory.getPersonDAOInstance().findByid(userid)!=null){
					Person person=factory.DAOFactory.getPersonDAOInstance().findByid(userid);
					String username=person.getName();
					System.out.println(username);
					System.out.println("用户验证成功");
					if(factory.DAOFactory.getEquipDAOInstance().findState(equipid, build)&&factory.DAOFactory.getEquipDAOInstance().doChangestate(equipid, 0, build)){
						System.out.println("设备验证成功");	
						borrow=new Borrow();
						borrow.setPrincipalid(userid);
						borrow.setUsername(username);
						borrow.setEquipnum(equipid);
						borrow.setEquipname(equipname);
						borrow.setType("教师");
						flag=factory.DAOFactory.getBorrowDAOInstance().doCreate(borrow);
						if(flag){
							infoborrow=username+"老师借取"+equipid+"号"+equipname+"成功";
						}else{
							infoborrow="借取失败,请重新选取设备";
						}
					}else{
						infoborrow="设备状态异常，请选取其他设备";
					}
					
				}else{
					infoborrow="该教师未注册，请注册后再试！";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if("student".equals(type)){
			try {
				if(factory.DAOFactory.getStudentDAOInstance().findByid(userid)!=null){
					if(factory.DAOFactory.getEquipDAOInstance().findState(equipid, build)&&factory.DAOFactory.getEquipDAOInstance().doChangestate(equipid, 0, build)){
					Student student=factory.DAOFactory.getStudentDAOInstance().findByid(userid);
					String username=student.getName();
					borrow=new Borrow();
					borrow.setPrincipalid(userid);
					borrow.setUsername(username);
					borrow.setEquipnum(equipid);
					borrow.setEquipname(equipname);
					borrow.setType("学生");
					flag=factory.DAOFactory.getBorrowDAOInstance().doCreate(borrow);
					if(flag){
						infoborrow=username+"同学借取"+equipid+"号"+equipname+"成功";
					}else{
						infoborrow="借取失败,请重新选取设备";
					}
					}else{
						infoborrow="设备状态异常，请选取其他设备";
					}
				}else{
					infoborrow="该用户不存在，请注册后再试！";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
			
		req.setAttribute("infoborrow", infoborrow);
		
		
		
		
		req.getRequestDispatcher(path).forward(req, resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		this.doGet(req, res);
	}

}
