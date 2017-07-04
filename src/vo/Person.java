package vo;

public class Person {
	private String  personid;
	private String password;
	private String name;
	private String college;
	private String telephone;
	public void setPersonid(String personid){
		this.personid=personid;
	}
	public String getPersonid(){
		return personid;
	}
	
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
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
