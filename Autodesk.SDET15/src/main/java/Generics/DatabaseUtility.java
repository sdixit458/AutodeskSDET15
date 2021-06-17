package Generics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class DatabaseUtility {
	Connection conn=null;
	ResultSet result=null;
	/**
	 * This method will establish connection with Database
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {
		Driver driverref;
		try {
		driverref=new Driver();
		DriverManager.registerDriver(driverref);		
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet_15", "root", "root");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * This method will close the Database Connection
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		conn.close();
	}
	/**
	 * This method help to verify data in database
	 * @param query
	 * @param columnName
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndGetData(String query,int columnName,String expData) throws SQLException {
		boolean flag=false;
		result=conn.createStatement().executeQuery(query);
		while(result.next()) {
			if(result.getString(columnName).equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expData+"Data is verified in Database");
			return expData;
		}else {
			System.out.println(expData+"Data not verified");
			return expData;
		}
	}
	 public ResultSet readDataFromDatabase(String table, int column, int row) throws SQLException {

		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet_15", "root", "root"); 
		Statement stat = conn.createStatement();
		result = stat.executeQuery(table);
		while (result.next()) {
			System.out.println(result.getString(1)+"\t"+result.getString(2));
			
		}
		return result;
		
	}
}
