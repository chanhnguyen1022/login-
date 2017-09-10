/**
 * @(#)UserLoginAction.java 01-00 2017/08/16.
 * Copyright(C) FUJINET CO., LTD.
 *
 * Version 1.00.
 */
package fjs.cs.action.form;


import org.apache.struts.action.ActionForm;

/**
 * UserLoginAction
 *
 * @author chanh-nm 2017/08/21
 * @version 1.00
 */
public class UserLoginForm extends ActionForm {

	private static final long serialVersionUID = 1L;
	//Bien userid luu gia tri userid nhap vao cua user.
	private String userId;
	//Bien password luu gia tri password nhap vao cua user.
	private String password;
	
	
	public UserLoginForm() {
	}
/**
 * @return String userId
 */
	public String getUserId() {
		return userId;
	}
/**
 * 
 * @param String userId
 * @return gan gia tri bien userId la userId.
 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
/**
 * @return String password.
 */
	public String getPassword() {
		return password;
	}
/**
 * 
 * @param String password.
 * @return gan gia tri bien password la password.
 */
	public void setPassword(String password) {
		this.password = password;
	}

public static long getSerialversionuid() {
	return serialVersionUID;
}

}