/**
 * @(#)MSTUSERDAO.java 01-00 2017/08/16.
 * Copyright(C) FUJINET CO., LTD.
 *
 * Version 1.00.
 */
package fjs.cs.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


import fjs.cs.common.ConnectDB;
/**
 * MSTUSERDAO
 *
 * @author chanh-nm 2017/08/21
 * @version 1.00
 */
public class MSTUSERDAO {	
	/**
	 * @param String UserId
	 * @param String Password
	 * @return true or false.
	 */
	public boolean authenticate(String UserId, String Password) {
		ConnectDB connectDB = new ConnectDB();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = connectDB.getConnection();
			//Cau lenh sql truy van du lieu userid va passwrod trong table MSTUSER.
			String sql = "SELECT COUNT(*) AS CNT FROM MSTUSER WHERE USERID=? AND PASSWORD=? AND DELETE_YMD IS NULL";
			//Lay du lieu userid va password tu table MSTUSER.
			ps = conn.prepareStatement(sql);
			ps.setString(1, UserId);
			ps.setString(2, Password);
//			ps.setDate(3, (java.sql.Date) Delete_YMD);
			rs = ps.executeQuery();
			rs.next();
			int cnt = rs.getInt("CNT");
			//Check User Id / Password ton tai trong table MSTUSER		
			if (cnt==1) {
			//Truong hop userid va password hop le return true.
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//Truong hop userid va password hop le return false.
		return false;
	}
}