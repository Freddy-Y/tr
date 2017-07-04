package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import vo.Student;
import vo.Person;
import factory.DAOFactory;


public class UserSelectServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path="admin/user/select.jsp";
		request.setCharacterEncoding("utf-8");
		String type=request.getParameter("type");
		List<Person> allperson=new ArrayList();
		List<Student> allstudent=new ArrayList();
		if(type=="student"||"student".equals(type)){
			System.out.println("查询进入，student选中");
			if(factory.DAOFactory.getStudentDAOInstance().findAll()!=null){
				allstudent=factory.DAOFactory.getStudentDAOInstance().findAll();
				request.setAttribute("allstudent", allstudent);
				System.out.println("查询返回结果");
				
			}
		}
		if(type=="person"||"person".equals(type)){
			try{
				if(factory.DAOFactory.getPersonDAOInstance().findAll()!=null){
					allperson=factory.DAOFactory.getPersonDAOInstance().findAll();
					request.setAttribute("allperson", allperson);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		request.setAttribute("type", type);
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
