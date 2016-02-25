package com.wpsnetwork.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class Util {
	private static DataSource datasource;

	static{
		try{
			Properties recurso = new Properties();
			recurso.load(RepositorioClientesDao.class.getResourceAsStream("../../../configuracionBD.properties"));
			
			//cargamos el driver
			Class.forName(recurso.getProperty("DRIVER")).newInstance();
			
			OracleDataSource ds = new OracleDataSource();
			ds.setURL(recurso.getProperty("URL"));
			ds.setUser(recurso.getProperty("USUARIO"));
			ds.setPassword(recurso.getProperty("PASSWORD"));
			
			datasource = ds;
			
		}catch(Exception ex){
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static Connection getConexion() throws SQLException{
		return datasource.getConnection();
	}
}
