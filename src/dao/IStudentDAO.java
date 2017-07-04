package dao;

import vo.Student;
import java.util.*;

public interface IStudentDAO{
	
	public boolean findLogin(Student student) throws Exception;
	public boolean doCreate(Student student) throws Exception;
	public Student findByid(String id) throws Exception;
	public List<Student> findAll();
	public boolean doDelete(String sid)throws Exception;
}