package dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection{
	private static String Driver="com.mysql.jdbc.Driver";
	private static String Url="jdbc:mysql://localhost:3306/ysu";
	private static String Usr="root";
	private static String Passwd="123456";
	private Connection con=null;

	public DatabaseConnection()throws Exception{
		
		try{
			Class.forName(Driver);
			System.out.println("驱动一加载");
			this.con=DriverManager.getConnection(Url,Usr,Passwd);
			System.out.println("完毕");
		}catch(Exception e){
			throw e;
		}
	}

	public Connection getConnection(){
		return this.con;
	}

	public void close() throws Exception{
		if(this.con!=null){
			try{
				this.con.close();
			}catch(Exception e){
				throw e;
			}
		}
	}


}