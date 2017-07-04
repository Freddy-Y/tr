package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import factory.DAOFactory;
import vo.Admin;


public class ASignServlet extends HttpServlet{
	
	/**
	 * 
	 */
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException{
		String path="admin/signin.jsp";
		req.setCharacterEncoding("utf-8");
		String Usrid=req.getParameter("userid");
		String Usrpw=req.getParameter("passwd");
		String Usrname=req.getParameter("name");
		String Usrnum=req.getParameter("num");
		String Usrtelephone=req.getParameter("telephone");

		String info=null;
		System.out.println("Servlet进入");
		if(Usrid==null||"".equals(Usrid)){
			info="用户名不能为空";
		}
		if(Usrpw==null||"".equals(Usrpw)){
			info="密码不能为空";
		}
		if(Usrname==null||"".equals(Usrname)){
			info="用户姓名不能为空";
		}
		if(Usrnum==null||"".equals(Usrnum)){
			info="用户单位不能为空";
		}
		if(Usrtelephone==null||"".equals(Usrtelephone)){
			info="用户电话不能为空";
		}
		
		if(info==null||"".equals(info)){
			
			
		
			Admin admin=new Admin();
			admin.setAdminid(Usrid);
			admin.setName(Usrname);
			admin.setNum(Usrnum);
			admin.setPassword(Usrpw);
			admin.setTelphone(Usrtelephone);
		try{
				if(DAOFactory.getAdminDAOInstance().doCreateAdmin(admin)){
					info=admin.getName()+"恭喜注册成功！";		
				}
				else{
					info="注册失败，用户以存在，请联系管理员找回账号";
				}
				}catch(Exception e){
					e.printStackTrace();
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
