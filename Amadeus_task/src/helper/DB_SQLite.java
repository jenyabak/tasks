package helper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class DB_SQLite {
 
    /**
     * Connect to a sample database
     *
     * @param fileName the database file name
     */
	
	
	public  Connection conn;
	public  Statement statmt;
	public  ResultSet resSet;
	
	
	// --------ПОДКЛЮЧЕНИЕ К БД--------
	public  DB_SQLite(String path_to_sqlite_db) throws SQLException, ClassNotFoundException{
	   conn = null;
	   Class.forName("org.sqlite.JDBC");
	   
 	   this.conn = DriverManager.getConnection("jdbc:sqlite:"+path_to_sqlite_db);
 	   
	   this.statmt = this.conn.createStatement(); 	// --------Создание таблицы--------
	   this.statmt.execute("CREATE TABLE if not exists 'phones' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'phone_model' text, 'phone_price' INT);");
 	   
	   this.statmt = this.conn.createStatement();
	   this.resSet = this.statmt.executeQuery("SELECT * FROM phones GROUP BY phone_model");
	
	}
   
	// --------ПОДКЛЮЧЕНИЕ К БД--------
	public void Connect(String path_to_sqlite_db) throws ClassNotFoundException, SQLException 
	   {
		   conn = null;
		   Class.forName("org.sqlite.JDBC");
    	   this.conn = DriverManager.getConnection("jdbc:sqlite:"+path_to_sqlite_db);
		   System.out.println("ConnectDB");
	   }		
	
	// --------Закрытие --------
	public void Close() throws ClassNotFoundException, SQLException
	   {
		this.conn.close();
		System.out.println("CloseDB");
	   }	
	
	
//	// --------Создание таблицы--------
//	public void Create_Table() throws ClassNotFoundException, SQLException
//	   {
//		this.statmt = this.conn.createStatement();
//		this.statmt.execute("CREATE TABLE if not exists 'phones' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'phone_model' text, 'phone_price' INT);");
//		
//		System.out.println("CreateDB_Table");
//	   }
	
	
	// --------Заполнение таблицы--------
	public void Write(String phone_model, Integer phone_price) throws SQLException
	{

		this.statmt.execute("INSERT INTO 'phones' (phone_model, phone_price) VALUES ('"+phone_model+"', "+phone_price+"); ");
		   System.out.println("WriteDB");
	}
	
	
	// -------- Вывод таблицы--------
	public void Read() throws ClassNotFoundException, SQLException
	   {
		 this.resSet = this.statmt.executeQuery("SELECT * FROM phones GROUP BY phone_model");
		
		while(this.resSet.next())
		{
			int id = this.resSet.getInt("id");
			String  name = this.resSet.getString("phone_model");
			String  price = this.resSet.getString("phone_price");
	         System.out.println( "ID = " + id );
	         System.out.println( "phone_model = " + name );
	         System.out.println( "phone_price = " + price );
	         System.out.println();
		}	
		
		//System.out.println("ReadDB");
	    }
    

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

//    	String  path_to_sqlite_db = new GetPropertyValues().getPropValues("path_to_sqlite_db");
    	//System.out.println(path_to_sqlite_db);
//    	ConnectDB(path_to_sqlite_db);
//		CreateDB_Table();
//        WriteDB("Nokia 1100",123213);
//		//WriteDB2();
//		ReadDB();
//		CloseDB();
    }
}