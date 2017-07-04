package servlet;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import factory.DAOFactory;
import vo.Student;
import vo.Person;

public class SLoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
		String path="index.jsp";
		req.setCharacterEncoding("utf-8");
		String Usrid=req.getParameter("userid");
		String Usrpw=req.getParameter("passwd");
		List<String> info=new ArrayList<String>();
		String type=req.getParameter("style");
		System.out.println("Servlet进入");
		if(Usrid==null||"".equals(Usrid)){
			info.add("用户名不能为空");
		}
		if(Usrpw==null||"".equals(Usrpw)){
			info.add("密码不能为空");
		}
		if(type==null||"".equals(type)){
			info.add("用户类型不能为空");
		}
		System.out.println(type);
		if(info.size()==0){
			
			
			if(type=="学生"||"学生".equals(type)){
				Student stu=new Student();
				stu.setSid(Usrid);
				stu.setPassword(Usrpw);
				try{
					if(DAOFactory.getStudentDAOInstance().findLogin(stu)){
						info.add("欢迎"+stu.getName()+"光临");
						HttpSession res=req.getSession();
						res.setAttribute("stuid", stu.getSid());
						res.setAttribute("stuname", stu.getName());
					}
					else{
						info.add("登陆失败，用户名或密码错误");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
			if(type=="教师"||"教师".equals(type)){
				Person person=new Person();
				person.setPersonid(Usrid);
				person.setPassword(Usrpw);
				try{
					if(DAOFactory.getPersonDAOInstance().findLogin(person)){
						info.add("欢迎"+person.getName()+"光临");
						HttpSession res=req.getSession();
						res.setAttribute("personid", person.getPersonid());
						res.setAttribute("personname", person.getName());
					}
					else{
						info.add("登陆失败，用户名或密码错误");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}		
		}
		HttpSession res=req.getSession();
		res.setAttribute("info", info);
		res.setAttribute("type", type);
		//req.setAttribute("info", info);
		req.getRequestDispatcher(path).forward(req, resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		this.doGet(req, res);
	}
	

}
