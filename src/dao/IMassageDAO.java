package dao;

import vo.Massage;
import java.util.*;

public interface IMassageDAO {
	public boolean doCreate(Massage massage)throws Exception;
	public Massage findByid(String massageid)throws Exception;
	public List<Massage> findAll()throws Exception;
}
