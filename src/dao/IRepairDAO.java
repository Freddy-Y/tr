package dao;

import vo.Repair;
import java.util.*;

public interface IRepairDAO {
	public boolean doCreate(Repair repair)throws Exception;
	public boolean doDelete(String repairid,String build)throws Exception;
	public List<Repair> findAll(String build)throws Exception;
}
