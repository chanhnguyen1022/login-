/**
 * @(#)EditForm.java 01-00 2017/08/16.
 * Copyright(C) FUJINET CO., LTD.
 *
 * Version 1.00.
 */
package fjs.cs.action.form;

import java.sql.Date;

import org.apache.struts.action.ActionForm;

/**
 * EditForm
 *
 * @author chanh-nm 2017/08/21
 * @version 1.00
 */
@SuppressWarnings("serial")
public class EditForm extends ActionForm {
	//Day la cac bien luu tru du lieu tu trang edit.jsp.
	private int userid;
	private String customerName;
	private String sex;
	private String birthDay;
	private String address;
	private String email;
	private Date insert;
	private int insertPSN;
	private int updatePSN;
/**
 * 
 * @return int userid.
 */
	public int getUserid() {
		return userid;
	}
/**
 * 
 * @param int userid.
 * @return gia tri userid.
 */
	public void setUserid(int userid) {
		this.userid = userid;
	}
/**
 * 
 * @return String customerName.
 */
	public String getCustomerName() {
		return customerName;
	}
/**
 * 
 * @param String customerName.
 * @return gia tri customerName.
 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
/**
 * 
 * @return String sex.
 */
	public String getSex() {
		return sex;
	}
/**
 * 
 * @param String sex.
 * @return gia tri bien sex.
 */
	public void setSex(String sex) {
		this.sex = sex;
	}
/**
 * 
 * @return String birthDay.
 */
	public String getBirthDay() {
		return birthDay;
	}
/**
 * 
 * @param String birthDay.
 * @return gia tri bien birthDay.
 */
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
/**
 * 
 * @return String address.
 */ 
	public String getAddress() {
		return address;
	}
/**
 * 
 * @param String address.
 * @return gia tri bien address.
 */
	public void setAddress(String address) {
		this.address = address;
	}
/**
 * 
 * @return String email.
 */
	public String getEmail() {
		return email;
	}
/**
 * 
 * @param String email.
 * @return gia tri bien email.
 */
	public void setEmail(String email) {
		this.email = email;
	}
/**
 * 
 * @return Date insert.
 */
	public Date getInsert() {
		return insert;
	}
/**
 * 
 * @param Date insert.
 * @return gia tri bien insert.
 */
	public void setInsert(Date insert) {
		this.insert = insert;
	}
/**
 * 
 * @return int insertPSN.
 */
	public int getInsertPSN() {
		return insertPSN;
	}
/**
 * 
 * @param int insertPSN.
 * @return gia tri bien insertPSN.
 */
	public void setInsertPSN(int insertPSN) {
		this.insertPSN = insertPSN;
	}
/**
 * 
 * @return int updatePSN.
 */
	public int getUpdatePSN() {
		return updatePSN;
	}
/**
 * 
 * @param int updatePSN.
 * @return gia tri bien updatePSN.
 */
	public void setUpdatePSN(int updatePSN) {
		this.updatePSN = updatePSN;
	}
	@Override
	public String toString() {
		return "EditForm [userid=" + userid + ", customerName=" + customerName
				+ ", sex=" + sex + ", birthDay=" + birthDay + ", address="
				+ address + ", email=" + email + ", insert=" + insert
				+ ", insertPSN=" + insertPSN + ", updatePSN=" + updatePSN + "]";
	}
}
