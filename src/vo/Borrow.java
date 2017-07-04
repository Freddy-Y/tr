package vo;

import java.sql.Date;

public class Borrow {
	private String principalid;
	private String username;
	private String equipname;
	private Date date;
	private String equipnum;
	private String type;
	
	public void setPrincipalid(String principalid){
		this.principalid=principalid;
	}
	public String getPrincipalid(){
		return principalid;
	}
	
	public void setDate(Date date){
		this.date=date;
	}
	public Date getDate(){
		return date;
	}
	
	public void setEquipnum(String equipnum){
		this.equipnum=equipnum;
	}
	public String getEquipnum(){
		return equipnum;
	}
	
	public void setType(String type){
		this.type=type;
	}
	public String getType(){
		return type;
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	public String getUsername(){
		return username;
	}
	
	public void setEquipname(String equipname){
		this.equipname=equipname;
	}
	public String getEquipname(){
		return equipname;
	}
	
}
