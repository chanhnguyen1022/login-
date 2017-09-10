/**
 * @(#)CustomerForm.java 01-00 2017/08/16.
 * Copyright(C) FUJINET CO., LTD.
 *
 * Version 1.00.
 */
package fjs.cs.action.form;

import java.sql.Timestamp;

/**
 * CustomerForm
 * 
 * @author chanh-nm 2017/08/21
 * @version 1.00
 */
public class CustomerForm {
	// Day la cac bien luu tru gia tri se duoc hien thi o trang search,jsp
	private int Customer_Id;
	private String Customer_Name;
	private String sex;
	private String birthDay;
	private String address;
	private Timestamp delete_ymd;

	/**
	 * 
	 * @return String Customer_Id.
	 */
	public int getCustomer_Id() {
		return Customer_Id;
	}

	/**
	 * 
	 * @param int customer_Id.
	 * @return gia tri bien Customer_Id.=customer_Id.
	 */
	public void setCustomer_Id(int customer_Id) {
		Customer_Id = customer_Id;
	}

	/**
	 * 
	 * @return String Customer_Name.
	 */
	public String getCustomer_Name() {
		return Customer_Name;
	}

	/**
	 * 
	 * @param String
	 *            Customer_Name.
	 * @return gia tri bien Custome_name= customer_Name.
	 */
	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}

	/**
	 * 
	 * @return String sex/
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 
	 * @param String
	 *            sex
	 * @return gia tri bien sex=sex.
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 
	 * @return String birthday.
	 */
	public String getBirthDay() {
		return birthDay;
	}

	/**
	 * 
	 * @param String
	 *            birthDay.
	 * @return gia tri bien birthDay= birthDay.
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
	 * @param String
	 *            address.
	 * @return gia tri bien address=address.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getDelete_ymd() {
		return delete_ymd;
	}

	public void setDelete_ymd(Timestamp delete_ymd) {
		this.delete_ymd = delete_ymd;
	}

	@Override
	public String toString() {
		return "CustomerForm [Customer_Id=" + Customer_Id + ", Customer_Name="
				+ Customer_Name + ", sex=" + sex + ", birthDay=" + birthDay
				+ ", address=" + address + "]";
	}

}