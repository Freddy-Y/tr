package factory;
import dao.IStudentDAO;
import dao.IPersonDAO;
import dao.IRepairDAO;
import dao.IAdminDAO;
import dao.IBorrowDAO;
import dao.IClassroomDAO;
import dao.IEquipDAO;
import dao.IMassageDAO;
import dao.proxy.*;

public class DAOFactory {
	
	
	public static IStudentDAO getStudentDAOInstance(){
		
		return new StudentDAOProxy();
		
	}
	public static IPersonDAO getPersonDAOInstance(){
		
		return new PersonDAOProxy();
		
	}
	
	public static IAdminDAO getAdminDAOInstance(){
		return new AdminDAOProxy();
		
	}
	
	public static IEquipDAO getEquipDAOInstance(){
		return new EquipDAOProxy();
		
	}
	
	public static IBorrowDAO getBorrowDAOInstance(){
		return new BorrowDAOProxy();
	}
	
	public static IClassroomDAO getClassroomDAOInstance(){
		return new ClassroomDAOProxy();
	}
	
	public static IRepairDAO getRepairDAOInstance(){
		return new RepairDAOproxy();
	}
	
	public static IMassageDAO getMassageDAOInstance(){
		return new MassageDAOProxy();
	}

		



}
