package vo;

import java.sql.Date;

public class Equip {
	private String equipid;
	private String name;
	private String build;
	private int state;
	private Date time;
	public void setEquipid(String equipid){
		this.equipid=equipid;
	}
	public String getEquipid(){
		return equipid; 
	}
	
	public void setBuild(String build){
		this.build=build;
	}
	public String getBuild(){
		return build;
	}
	
	public void setState(int state){
		this.state=state;
	}
	public int getState(){
		return state;
	}
	public void setTime(Date time){
		this.time=time;
	}
	public Date getTime(){
		return time;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}

}
