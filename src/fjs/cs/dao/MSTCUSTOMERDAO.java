/**
 * @(#)MSTCUSTOMERDAO.java 01-00 2017/08/16.
 * Copyright(C) FUJINET CO., LTD.
 *
 * Version 1.00.
 */
package fjs.cs.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fjs.cs.action.form.EditForm;
import fjs.cs.action.form.SearchForm;
import fjs.cs.common.ConnectDB;
import fjs.cs.action.form.CustomerForm;

/**
 * MSTCUSTOMERDAO
 * 
 * @author chanh-nm 2017/08/21
 * @version 1.00
 */
public class MSTCUSTOMERDAO {

	ConnectDB connectDB = new ConnectDB();
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	// So luong customer toi da cua mot trang.
	private final int LIMIT = 15;
	// Ket qua cua viec edit hay add customer.
	private boolean check = false;
	/**
	 * 
	 * @param index
	 *            * vi tri cua trang hien tai.
	 * @return danh sach customer cua trang.
	 */
	public List<CustomerForm> getAllcustomers(int index) {
		// Khoi tao danh sach customer cua trang.
		List<CustomerForm> customers = new ArrayList<CustomerForm>();
		try {
			String query = "SELECT * FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY CUSTOMER_ID) as row FROM MSTCUSTOMER WHERE DELETE_YMD IS NULL ) a WHERE row > ? and row <= ?";

			// Lay danh sach customer cua table MSTCUSTOMER lon hon vi tri bat
			// dau va nho hon va bang vi tri ket thuc.
			PreparedStatement ps = connectDB.getConnection().prepareStatement(
					query);

			// Gia tri bat dau bang vi tri trang hien tai nhan voi gioi han hien
			// thi toi da cua mot trang.
			int start = index * LIMIT;
			ps.setInt(1, start);

			// Gia tri ket thuc bang gia tri bat dau cong voi gioi han hien thi
			// toi da cua mot trang.
			int end = start + LIMIT;
			ps.setInt(2, end);

			// Lay thong tin customer trong table MSTCUSTOMER.
			rs = ps.executeQuery();
			while (rs.next()) {
				String sex = "";
				//Neu gia tri get tu table columm SEX =0 là male 
				if (rs.getString("SEX").equals("0")) {
				sex = "Female";
				//Neu gia tri get tu table columm SEX =1 là female 
				} else if (rs.getString("SEX").equals("1")) {
				sex = "Male";
				} else {
				sex = rs.getString("SEX");
				}
				CustomerForm customer = new CustomerForm();
				customer.setCustomer_Id(rs.getInt("CUSTOMER_ID"));
				customer.setCustomer_Name(rs.getString("CUSTOMER_NAME"));
				customer.setSex(sex);
				customer.setBirthDay(rs.getString("BIRTHDAY"));
				customer.setAddress(rs.getString("ADDRESS"));
				customers.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}

	// Phuong thuc dung de dem so luong customer co trong table MSTCUSTOMER.
	public int countCustomers() throws SQLException {

		// Khoi tao gia tri so luong customer co trong table MSTCUSTOMER bang 0.
		int count = 0;
		String sql="SELECT Count(CUSTOMER_ID) FROM MSTCUSTOMER";

		// Lay so luong customer co trong table MSTCUSTOMER bang cach dem so
		// luong customer_id.
		PreparedStatement ps=connectDB.getConnection().prepareStatement(sql);
		rs=ps.executeQuery();
		while (rs.next()) {
			count = rs.getInt(1);
		}
		// Tra ve so luong customer co trong table MSTCUSTOMER.
		return count;
	}
	/**
	 * 
	 * @param i
	 *            la vi tri customer xoa.
	 * @throws SQLException
	 */
	public void deleted(int i) throws SQLException {

		// Xoa Customer trong table MSTCUSTOMER dua vao customer_id.
		String sql="UPDATE MSTCUSTOMER SET DELETE_YMD=? WHERE CUSTOMER_ID= ?";
		PreparedStatement ps=connectDB.getConnection().prepareStatement(sql);
		//Lay vi tri customer can delete truyen gia tri get duoc vao query thuc hien delete customer trong table MSTCUSTOMER.
		ps.setDate(1, new java.sql.Date(new Date().getTime()));
		ps.setInt(2, i);
		ps.executeUpdate();
	}
	/**
	 * 
	 * @param EditForm
	 *            ef
	 * @return ket qua cua viec editCustomer la true hay false.
	 */
	public boolean EditCustomer(EditForm ef) {
		// Câu lenh truy van sql dung de update Customer.
		String sql = "UPDATE MSTCUSTOMER SET"
				+ " CUSTOMER_NAME=?, SEX=?, BIRTHDAY=?, "
				+ "ADDRESS=?, EMAIL=?, INSERT_YMD=?, INSERT_PSN_CD=?,"
				+ " UPDATE_PSN_CD=? WHERE CUSTOMER_ID=?";
		PreparedStatement ps;
		// Update du lieu customer vao table MSTCUSTOMER.
		try {
			ps = connectDB.getConnection().prepareStatement(sql);
			ps.setString(1, ef.getCustomerName());
			ps.setString(2, ef.getSex());
			ps.setString(3, ef.getBirthDay());
			ps.setString(4, ef.getAddress());
			ps.setString(5, ef.getEmail());
			ps.setDate(6, new java.sql.Date(new Date().getTime()));
			ps.setInt(7, ef.getInsertPSN());
			ps.setInt(8, ef.getUpdatePSN());
			ps.setInt(9, ef.getUserid());
			int i = ps.executeUpdate();
			if (i > 0) {
				// Tra ve true neu ket qua update customer thanh cong.
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Tra ve false neu ket qua update customer that bai.
		return check;
	}
	/**
	 * @param ac
	 * @return ket qua addCustomer la true hay false.
	 * @throws SQLException
	 */
	public boolean addCustomer(EditForm ac) throws SQLException {
		// Cau lenh sql dung de insert du lieu customer vao table MSTCUSTOMER.
		String sql = "INSERT INTO MSTCUSTOMER (CUSTOMER_NAME,SEX,BIRTHDAY,ADDRESS,EMAIL,INSERT_YMD,INSERT_PSN_CD,UPDATE_PSN_CD) VALUES (?,?,?,?,?,?,?,?)";
		try {
			// Set du lieu customer vao table MSTCUSTOMER.
			PreparedStatement ud = connectDB.getConnection().prepareStatement(
					sql);
			ud.setString(1, ac.getCustomerName());
			ud.setString(2, ac.getSex());
			ud.setString(3, ac.getBirthDay());
			ud.setString(4, ac.getAddress());
			ud.setString(5, ac.getEmail());
			ud.setDate(6, new java.sql.Date(new Date().getTime()));
			ud.setInt(7, ac.getInsertPSN());
			ud.setInt(8, ac.getUpdatePSN());
			int executeUpdate = ud.executeUpdate();
			if (executeUpdate > 0) {
				// Tra ve true neu ket qua insert customer thanh cong.
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Tra ve false neu ket qua insert customer that bai.
		return check;
	}
	/**
	 * 
	 * @param int userid
	 * @return EditForm editForm. Tra ve du lieu customer co trong table
	 *         MSTCUSTOMER.
	 * @throws SQLException
	 */
	public EditForm getEditForm(int userid) throws SQLException {
		// Cau lenh sql cung de truy van du lieu customer trong table
		// MSTCUSTOMER dua vao customer_id.
		String sql="SELECT*FROM MSTCUSTOMER WHERE CUSTOMER_ID= ?";
		PreparedStatement ps=connectDB.getConnection().prepareStatement(sql);
		ps.setInt(1,userid);
		rs=ps.executeQuery();
		EditForm editForm = new EditForm();
		// Lay du lieu trong customer trong table MSTCUSTOMER.
		while (rs.next()) {
			editForm.setUserid(rs.getInt("CUSTOMER_ID"));
			editForm.setCustomerName(rs.getString("CUSTOMER_NAME"));
			editForm.setSex(rs.getString("SEX"));
			editForm.setBirthDay(rs.getString("BIRTHDAY"));
			editForm.setAddress(rs.getString("ADDRESS"));
			editForm.setEmail(rs.getString("EMAIL"));
		}
		// Tra du lieu customer get duoc tu table MSTCUSTOMER ve editForm.
		return editForm;
	}

	/**
	 * 
	 * @param String customername
	 * @return int PSN_CD.
	 * @throws SQLException
	 */
	public int getPSNCDbyUsername(String customername) throws SQLException {
		// Cau lenh sql dung de truy van du lieu user trong table MSTUSER.
		// Dua vao userid va password cua user login vao trang.
		String sql="SELECT*FROM MSTUSER WHERE USERID = ?";
		PreparedStatement ps=connectDB.getConnection().prepareStatement(sql);
		ps.setString(1,customername);
		rs=ps.executeQuery();
		rs.next();
		// lay gia tri PSN_CD cua user dang nhap trong table MSTUSER.
		return rs.getInt("PSN_CD");

	}

	/**
	 * @param SearchForm
	 *            searchForm.
	 * @return danh sach customer sau search.
	 */
	public List<CustomerForm> searchCustomers(SearchForm searchForm) {
		// Khoi tao list luu tru gia tri customer.
		List<CustomerForm> customers = new ArrayList<CustomerForm>();
		// Bien query duoc su dung luu tru noi dung cau lenh truy van sql. Thay
		// cho kieu du lieu String.
		StringBuffer query = new StringBuffer();

		query.append("SELECT * FROM MSTCUSTOMER WHERE CUSTOMER_ID <> 0  AND DELETE_YMD IS NULL");
		// Search by sex
		if(!searchForm.getSex().equals("false")){
			query.append("AND SEX = '"+searchForm.getSex()+"'");
		}
		// Search by name
		if (searchForm.getCustomer_Name() != null) {
			query.append(" AND CUSTOMER_NAME LIKE '%"
					+ searchForm.getCustomer_Name() + "%'");
		}
		// Search theo birthday tu ngay den ngay.
		// Convet dung de chuyen doi tu lieu nhap vao la String sang date de
		// thuc hien truy van.
		if (searchForm.getBirthDayStart().length() != 0) {
			query.append(" AND CONVERT(date, BIRTHDAY) BETWEEN '"
					+ searchForm.getBirthDayStart() + "'");
		}
		if (searchForm.getBirthDayEnd().length() != 0) {
			query.append(" AND '" + searchForm.getBirthDayEnd() + "'");
		}
		try {
			Statement statement = connectDB.getConnection().createStatement();
			ResultSet rs = statement.executeQuery(query.toString());
			while (rs.next()) {
				String sex = "";
				//Neu gia tri get tu table columm SEX =0 là male 
				if (rs.getString("SEX").equals("0")) {
				sex = "Female";
				//Neu gia tri get tu table columm SEX =1 là female 
				} else if (rs.getString("SEX").equals("1")) {
				sex = "Male";
				} else {
				sex = rs.getString("SEX");
				}
				// Set du lieu vao list customer bang cach get du lieu search
				// duoc.
				CustomerForm customer = new CustomerForm();
				customer.setCustomer_Id(rs.getInt("CUSTOMER_ID"));
				customer.setCustomer_Name(rs.getString("CUSTOMER_NAME"));
				customer.setSex(sex);
				customer.setBirthDay(rs.getString("BIRTHDAY"));
				customer.setAddress(rs.getString("ADDRESS"));
				customers.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
	}
}