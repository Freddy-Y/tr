package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vo.Repair;
import factory.DAOFactory;

/**
 * Servlet implementation class RepairDeleteServlet
 */
@WebServlet("/RepairDeleteServlet")
public class RepairDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepairDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String repairid=(String)request.getParameter("repairid");
		HttpSession sess=request.getSession();
		String build=(String)sess.getAttribute("buildnum");
		String path="admin/repair/delete.jsp";
		String info=null;
		try{
			System.out.println(repairid);
			System.out.println(build);
			if(!(DAOFactory.getRepairDAOInstance().doDelete(repairid,build))){
				info="删除成功！";
			}else{
				info="删除异常！";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		request.setAttribute("deleteinfo", info);
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
