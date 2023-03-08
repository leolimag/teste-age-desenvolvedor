package br.com.empresa.projeto.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/teste2?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "root123";
	
//	private DataSource dataSource;
//
//	public ConnectionFactory() {
//		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
//		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/teste2?useTimezone=true&serverTimezone=UTC");
//		comboPooledDataSource.setUser("root");
//		comboPooledDataSource.setPassword("root123");
//		this.dataSource = comboPooledDataSource;
//	}
	
	public Connection getConnection() {
//		return this.dataSource.getConnection();
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
		
	}
	
}
