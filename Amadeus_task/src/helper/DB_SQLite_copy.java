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
public class DB_SQLite_copy {
 
    /**
     * Connect to a sample database
     *
     * @param fileName the database file name
     */
	
	public static Connection conn;
	public static Statement statmt;
	public static ResultSet resSet;
	
   
	// --------ПОДКЛЮЧЕНИЕ К БД--------
	public static void ConnectDB(String path_to_sqlite_db) throws ClassNotFoundException, SQLException 
	   {
		   conn = null;
		   Class.forName("org.sqlite.JDBC");
    	   conn = DriverManager.getConnection("jdbc:sqlite:"+path_to_sqlite_db);
		   System.out.println("ConnectDB");
	   }		
	
	// --------Закрытие --------
	public static void CloseDB() throws ClassNotFoundException, SQLException
	   {
		conn.close();
		System.out.println("CloseDB");
	   }	
	
	
	// --------Создание таблицы--------
	public static void CreateDB_Table() throws ClassNotFoundException, SQLException
	   {
		statmt = conn.createStatement();
		statmt.execute("CREATE TABLE if not exists 'phones' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'phone_model' text, 'phone_price' INT);");
		
		System.out.println("CreateDB_Table");
	   }
	
	
	// --------Заполнение таблицы--------
	public static void WriteDB(String phone_model, Integer phone_price) throws SQLException
	{

		statmt.execute("INSERT INTO 'phones' (phone_model, phone_price) VALUES ('"+phone_model+"', "+phone_price+"); ");
		   System.out.println("WriteDB");
	}
	
	
	// -------- Вывод таблицы--------
	public static void ReadDB() throws ClassNotFoundException, SQLException
	   {
		resSet = statmt.executeQuery("SELECT * FROM phones GROUP BY phone_model");
		
		while(resSet.next())
		{
			int id = resSet.getInt("id");
			String  name = resSet.getString("phone_model");
			String  price = resSet.getString("phone_price");
	         System.out.println( "ID = " + id );
	         System.out.println( "phone_model = " + name );
	         System.out.println( "phone_price = " + price );
	         System.out.println();
		}	
		
		System.out.println("ReadDB");
	    }
    

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

    	String  path_to_sqlite_db = new GetPropertyValues().getPropValues("path_to_sqlite_db");
    	//System.out.println(path_to_sqlite_db);
    	ConnectDB(path_to_sqlite_db);
		CreateDB_Table();
        WriteDB("Nokia 1100",123213);
		//WriteDB2();
		ReadDB();
		CloseDB();
    }
}