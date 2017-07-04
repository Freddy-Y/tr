package dao;

import vo.Borrow;
import java.util.*;
import java.sql.Date;

public interface IBorrowDAO {
	public boolean doCreate(Borrow borrow);
	public List<Borrow> findBydate(Date date);
	public boolean doDelete(String equipnum);
	public Borrow findByid(String equipnum);
	
}
