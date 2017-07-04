package dao;

import vo.Person;
import java.util.*;

public interface IPersonDAO {
	public boolean findLogin(Person person) throws Exception;
	public boolean doCreate(Person person) throws Exception;
	public Person findByid(String id) throws Exception;
	public List<Person> findAll()throws Exception;
	public boolean doDelete(String persinid)throws Exception;
}
