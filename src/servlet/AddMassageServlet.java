package servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factory.DAOFactory;
import vo.Massage;


public class AddMassageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMassageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path="index.jsp";
		request.setCharacterEncoding("utf-8");
		String massagecontent=request.getParameter("massage");
		String userid=null;
		String info=null;
		Massage massage=new Massage();
		Date date = new Date();   
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");   
		String time = format.format(date); //2013-01-14   
		String massageid=null;
		HttpSession sess=request.getSession();
		if(sess.getAttribute("stuid")!=null){
			userid=(String)sess.getAttribute("stuid");
			massageid=userid+time;
		}else if(sess.getAttribute("personid")!=null){
			userid=(String)sess.getAttribute("stuid");
			massageid=userid+time;
		}else{
			info="用户未登陆，请登陆后重试！";
		}
		if(massagecontent==null||"".equals(massagecontent)){
			info="意见不能为空";
		}
		massage.setMassageid(massageid);
		massage.setMcontent(massagecontent);
		massage.setUserid(userid);
		try{
			if(DAOFactory.getMassageDAOInstance().doCreate(massage)){
				info="留言已提交，感谢你的意见！";
			}else{
				info="留言异常，请稍后重试！";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("massageinfo", info);
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
