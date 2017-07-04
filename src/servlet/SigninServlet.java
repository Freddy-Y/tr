package servlet;

import java.io.IOException;
//import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import factory.DAOFactory;
import vo.Student;
import vo.Person;

public class SigninServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
		String path="signin.jsp";
		req.setCharacterEncoding("utf-8");
		String Usrid=req.getParameter("userid");
		String Usrpw=req.getParameter("passwd");
		String Usrname=req.getParameter("name");
		String Usrcollege=req.getParameter("college");
		String Usrtelephone=req.getParameter("telephone");
		String type=req.getParameter("style");
		//List<String> info=new ArrayList<String>();
		String info=null;
		System.out.println("Servlet进入");
		if(Usrid==null||"".equals(Usrid)){
			info="用户名不能为空";
		}
		if(Usrpw==null||"".equals(Usrpw)){
			info="密码不能为空";
		}
		if(type==null||"".equals(type)){
			info="用户类型不能为空";
		}
		if(Usrname==null||"".equals(Usrname)){
			info="用户姓名不能为空";
		}
		if(Usrcollege==null||"".equals(Usrcollege)){
			info="用户学院不能为空";
		}
		if(Usrtelephone==null||"".equals(Usrtelephone)){
			info="用户电话不能为空";
		}
		System.out.println(type);
		if(info==null||"".equals(info)){
			
			
			if(type=="学生"||"学生".equals(type)){
				Student stu=new Student();
				stu.setSid(Usrid);
				stu.setName(Usrname);
				stu.setCollege(Usrcollege);
				stu.setPassword(Usrpw);
				stu.setTelephone(Usrtelephone);
				try{
					if(DAOFactory.getStudentDAOInstance().doCreate(stu)){
						info=stu.getName()+"同学，恭喜注册成功！";
						
					}
					else{
						info="注册失败，用户以存在，请联系管理员找回账号";
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
			if(type=="教师"||"教师".equals(type)){
				Person person=new Person();
				person.setPersonid(Usrid);
				person.setName(Usrname);
				person.setCollege(Usrcollege);
				person.setPassword(Usrpw);
				person.setTelephone(Usrtelephone);
				try{
					if(DAOFactory.getPersonDAOInstance().doCreate(person)){
						info=person.getName()+"老师，恭喜注册成功！";
						
					}
					else{
						info="注册失败，用户以存在，请联系管理员找回账号";
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		//HttpSession res=req.getSession();
		//res.setAttribute("info", info);
		req.setAttribute("signinfo", info);
		req.getRequestDispatcher(path).forward(req, resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		this.doGet(req, res);
	}

}
