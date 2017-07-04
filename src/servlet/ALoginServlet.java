package servlet;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import factory.DAOFactory;
import vo.Admin;


public class ALoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
		String path=null;
		req.setCharacterEncoding("utf-8");
		String Usrid=req.getParameter("username");
		String Usrpw=req.getParameter("usrpassword");
		String Usrnum=req.getParameter("num");
		String info=new String();
		System.out.println("Servlet进入");
		if(Usrid==null||"".equals(Usrid)){
			info=("管理员账号不能为空");
		}
		if(Usrpw==null||"".equals(Usrpw)){
			info=("密码不能为空");
		}
		if(Usrnum==null||"".equals(Usrnum)){
			info=("管理员所属教学楼不能为空");
		}
		if(info!=null||"".equals(info)){
			
			Admin admin=new Admin();
			admin.setAdminid(Usrid);
			admin.setPassword(Usrpw);
			admin.setNum(Usrnum);
			System.out.println(admin.getAdminid());
			System.out.println(admin.getPassword());
			System.out.println(admin.getNum());
			
			try{
				if(DAOFactory.getAdminDAOInstance().findALogin(admin)){
					HttpSession res=req.getSession();
					System.out.println("正在生成管理员名字");
					res.setAttribute("adminname", admin.getName());
					res.setAttribute("buildnum", admin.getNum());
				}
				else{
					info=("登陆失败，用户名或密码错误");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			
			
			
		}
		if(info!=null||"".equals(info)){
			
			path="admin/loginSuccess.jsp";
		}
		else{
			path="admin/login.jsp";
		}
		HttpSession res=req.getSession();
		res.setAttribute("admininfo", info);
		req.getRequestDispatcher(path).forward(req, resp);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		this.doGet(req, res);
	}
	

}
