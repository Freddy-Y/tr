package vo;

import java.sql.Date;
public class Massage {
	private String massageid;
	private String mcontent;
	private Date date;
	private String userid;
	public String getMassageid() {
		return massageid;
	}
	public void setMassageid(String massageid) {
		this.massageid = massageid;
	}
	public String getMcontent() {
		return mcontent;
	}
	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

}
