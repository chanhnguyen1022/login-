/**
 * @(#)UserLoginAction.java 01-00 2017/08/16.
 * Copyright(C) FUJINET CO., LTD.
 *
 * Version 1.00.
 */
package fjs.cs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.*;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import fjs.cs.action.form.UserLoginForm;
import fjs.cs.dao.MSTUSERDAO;
/**
 * UserLoginAction
 *
 * @author chanh-nm 2017/08/21
 * @version 1.00
 */
public class UserLoginAction extends Action {
	/**
	 * ActionMapping mapping
	 * ActionForm form
	 * HttpServletRequest request
	 * HttpServletResponse response
	 */	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserLoginForm loginForm = (UserLoginForm) form;
		// User Id
		String username = loginForm.getUserId();
		// Password		
		String password = loginForm.getPassword();
				
//		Date delete_YMD= loginForm.getDelete_YMD();
		// Checklogin flag	
		boolean checkLoginFlg = false;
		
		// Thuc thi checklogin
		// Check User Id / Password ton tai trong table MSTUSER		
		MSTUSERDAO dao = new MSTUSERDAO();
		checkLoginFlg = dao.authenticate(username,password);
		
		// Truong hop input User Id / Password hop le		
		if (checkLoginFlg) {
			// Di chuyen den man hinh Search			
			HttpSession se = request.getSession();
			se.setAttribute("username", username);
			return mapping.findForward("success");
		}else {
			
			// Noi dung error duoc hien thi o man hinh login khi login khong thanh cong.
			String error="ユーザーIDまたはパスワードが不正です。";
			request.setAttribute("lblErrorMessage",error);
		}
		// Di chuyen ve man hinh Login	
		return mapping.findForward("failure");
		
	}

}