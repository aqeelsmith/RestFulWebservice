package com.home.dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OracleHome {
	private static DataSource datasource = null;
	private static Context context = null;
	
	/*
	 * Get value of JNDI configured in the server.
	 * 
	 */
	public static DataSource DataSourceConn(){
		
		if(datasource!=null){
			return datasource;
		}
		
		try{
			if(context == null){
				context = new InitialContext();
			}
			datasource = (DataSource)context.lookup("HomeJNDI");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return datasource;
	}
	
	protected static Connection getPCPartsConnection(){
		Connection conn = null;
		try{
			conn = DataSourceConn().getConnection();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	
}
