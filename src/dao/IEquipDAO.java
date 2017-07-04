package dao;

import vo.Equip;
import java.util.*;

public interface IEquipDAO {
	 public boolean doCreate(Equip equip)throws Exception; 
	 public List<Equip> findAll(String build,int state) throws Exception;
	 public Equip findByid(String equipid) throws Exception;
	 public boolean doDelete(String equipid,String build)throws Exception;
	 public boolean findState(String equipid,String build);
	 public boolean doChangestate(String equipid,int state,String build);
}
