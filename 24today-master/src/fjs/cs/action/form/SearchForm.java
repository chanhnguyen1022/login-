/**
 * @(#)SearchForm.java 01-00 2017/08/16.
 * Copyright(C) FUJINET CO., LTD.
 *
 * Version 1.00.
 */
package fjs.cs.action.form;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
/**
 * SearchForm
 *
 * @author chanh-nm 2017/08/21
 * @version 1.00
 */
public class SearchForm extends ActionForm {
	// Khoi tao bien customer_Name luu tru gia tri truong Customer_Name nguoi
	// dung nhap vao trong trang search.jsp.
	private String customer_Name;
	// Khoi tao bien sex luu tru gia tri truong sex nguoi
	// dung nhap vao trong trang search.jsp.
	private String sex;
	// Khoi tao bien birthDayStart luu tru gia tri truong birthDayStart nguoi
	// dung nhap vao trong trang search.jsp.
	private String birthDayStart;
	// Khoi tao bien birthDayEnd luu tru gia tri truong birthDayEnd nguoi
	// dung nhap vao trong trang search.jsp.
	private String birthDayEnd;
/**
 * 
 * @return String customer_Name.
 */
	public String getCustomer_Name() {
		return customer_Name;
	}
/**
 * 
 * @param String customer_Name.
 * @return gia tri bien customer_Name.
 */
	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
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
 * @param String sex
 * @return gia tri cho bien sex.
 */
	public void setSex(String sex) {
		this.sex = sex;
	}
/**
 * 
 * @return String birthDayStart.
 */
	public String getBirthDayStart() {
		return birthDayStart;
	}
/**
 * 
 * @param String birthDayStart.
 * @return gia tri bien birthDayStart.
 */
	public void setBirthDayStart(String birthDayStart) {
		this.birthDayStart = birthDayStart;
	}
/**
 * 
 * @return String birthDayEnd
 */
	public String getBirthDayEnd() {
		return birthDayEnd;
	}
/**
 * 
 * @param String birthDayEnd.
 * @return gia tri bien birthDayEnd.
 */
	public void setBirthDayEnd(String birthDayEnd) {
		this.birthDayEnd = birthDayEnd;
	}

	@Override
	public String toString() {
		return "SearchForm [Customer_Name=" + customer_Name + ", sex=" + sex
				+ ", birthDayStart=" + birthDayStart + ", birthDayEnd="
				+ birthDayEnd + "]";
	}

}