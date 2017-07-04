package vo;

public class Student{
	private String sid;
	private String name;
	private String password;
	private String college;
	private String telephone; 

	public void setSid(String sid){
		this.sid=sid;
	}
	public String getSid(){
		return sid;
	}

	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}

	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}

	public void setCollege(String college){
		this.college=college;
	}
	public String getCollege(){
		return college;
	}

	public void setTelephone(String telephone){
		this.telephone=telephone;
	}
	public String getTelephone(){
		return telephone;
 	}

}