package vo;

public class Admin {
	private String adminid;
	private String name;
	private String password;
	private String num;
	private String telephone;
	
	public void setAdminid(String adminid){
		this.adminid=adminid;
	} 
	public String getAdminid(){
		return adminid;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setNum(String num){
		this.num=num;
	}
	public String getNum(){
		return num;
	}
	public void setTelphone(String telephone){
		this.telephone=telephone;
	}
	public String getTelephone(){
		return telephone;
	}
}
