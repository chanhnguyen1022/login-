/**
 * @(#)ConnectDB.java 01-00 2017/08/16.
 * Copyright(C) FUJINET CO., LTD.
 *
 * Version 1.00.
 */
package fjs.cs.common;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ConnectDB
 *
 * @author chanh-nm 2017/08/21
 * @version 1.00
 */
public class ConnectDB {
	
	//Phuong thuc dung de ket noi database.
	public Connection getConnection() {
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
					
			//Duong dan den database
			String url = "jdbc:jtds:sqlserver://localhost:1433/StrutsProject";
			
			//Ket noi du lieu dua vao url, username, password cua database.
			Connection conn = DriverManager
					.getConnection(url, "sa", "Abc12345");
			return conn;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}