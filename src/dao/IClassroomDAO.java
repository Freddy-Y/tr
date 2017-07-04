package dao;

import vo.Classroom;

public interface IClassroomDAO {
	public Classroom findByid(String roomid,String building)throws Exception;
}
