package com.collaba.management.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;
import com.collaba.management.util.ApplicationProperties;


public class DBConnector  {

	static ArrayList<String> lst = null;

	Connection connection = null;
	String database = null;
	String url = null;
	String username = null;
	String password = null;
	String driver = null;
	String tablename=null;

	static Logger logger = Logger.getLogger(DBConnector.class.getName());

	public DBConnector() 	throws ClassNotFoundException, SQLException {


		try {

			ApplicationProperties prop = ApplicationProperties.getInstance();
			Properties p = prop.getPropertyFile(".\\properties\\AppConfiguration.properties");



			database="remstruts";
			username="root";
			password="root";
			url="jdbc:mysql://localhost:3306/";
			driver="com.mysql.jdbc.Driver";
			connection = getConnection();

		}

		catch(Exception ex){  ex.printStackTrace();}

	}


	public DBConnector(String database, String tablename,String driver, String url, String username, String password)
	throws ClassNotFoundException, SQLException {

		try {

			this.database = database;
			this.tablename=tablename;
			this.username = username;
			this.password = password;
			this.url = url;
			this.driver = driver;


			// Create MySQL database connection

			connection = getConnection();
		}


		catch(Exception ewr) {ewr.printStackTrace(); }
	}


	public  Connection getConnection() throws SQLException,ClassNotFoundException
	{  
		// Create MySQL database connection

		String  connectString = url + database;
		Class.forName(driver);
		connection = DriverManager.getConnection(connectString, username, password);

		return connection;
	} 

	public ResultSet getResultSet(String tablename,boolean queryStatus) throws SQLException {


		String query = null;
		ResultSet rs = null;

		if  (queryStatus == true ) {

			query = tablename;
		}

		else {
			query  = 	"select *from " + tablename;
		}

		PreparedStatement stmt =  connection.prepareStatement(query);
		rs = stmt.executeQuery();

		return rs;
	}
	public ResultSet getResultSet1(String query,boolean queryStatus,String string) throws SQLException
	{
		
		
		ResultSet rs = null;
		PreparedStatement stmt=null;
		Connection connection=null;

		if  (queryStatus == true && string.equals("select")) 
		{
			try {
				connection=getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt=connection.prepareStatement(query);
			rs=stmt.executeQuery();
		}

		else if(queryStatus == true &&string.equals("delete"))
		{
			try {
				connection=getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt=connection.prepareStatement(query);
			stmt.executeUpdate();
		}
		else if(queryStatus == true &&string.equals("insert"))
		{
			try {
				connection=getConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt=connection.prepareStatement(query);
			stmt.executeUpdate();
		}

		return rs;
	}





	public static ArrayList getColumnNames(ResultSet resultSet) {
		ArrayList<String> dataList = new ArrayList<String>();
		try {
			logger.info(" INSIDE resultSetToArrayList() ");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int cols = resultSetMetaData.getColumnCount();


			for ( int i = 1; i <= cols; i++)

			{
				System.out.println(resultSetMetaData.getColumnName(i));
				dataList.add(resultSetMetaData.getColumnName(i) );

			}


		} catch (Exception exception) {
			logger.info(" EXCEPTION HAS OCCURED INSIDE resultSetToArrayList() "	+ exception.getMessage().toString());
			exception.printStackTrace();
		}
		return dataList;
	}




	//Close database connection


	public void disconnect () throws SQLException {
		connection.close();
	}


	public static void main(String[] args) {


		try {


			String url = "jdbc:mysql://localhost:3306/";
			String driver = "com.mysql.jdbc.Driver";
			String username = "root";
			String password = "root";
			String database= "realestatemgmt";
			String tablename = "login";

			DBConnector db=new DBConnector();
			ResultSet rst =  db.getResultSet("contest", false);
			lst = (ArrayList)getColumnNames(rst);
			// ArrayList VO  =  makeResultSetToRoomDetailVO(rst);
			db.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




}


