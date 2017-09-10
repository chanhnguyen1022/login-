/**
 * @(#)addAction.java 01-00 2017/08/16.
 * Copyright(C) FUJINET CO., LTD.
 *
 * Version 1.00.
 */
package fjs.cs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fjs.cs.dao.MSTCUSTOMERDAO;
import fjs.cs.action.form.EditForm;

/**
 * addAction
 * 
 * @author chanh-nm 2017/08/21
 * @version 1.00
 */
public class addAction extends Action {

	/**
	 * ActionMapping mapping ActionForm form HttpServletRequest request
	 * HttpServletResponse response
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		EditForm editForm = (EditForm) form;

		HttpSession session;
		// khoi tao gia tri username de luu tru dua lieu username login vao he
		// thong trong table MSUSER
		String name;
		// khoi tao bien PSN_CD de luu tru du lieu PSN_CD cua user login vao he
		// thong du lieu duoc get co trong table MSTUSER.
		

		session = request.getSession();
		name = (String) session.getAttribute("username");

		MSTCUSTOMERDAO dao = new MSTCUSTOMERDAO();
		//Get du lieu PSN_CD tu table MSTUSER.
		int PSN_CD = dao.getPSNCDbyUsername(name);
		//Set du lieu cho cot InsertPSN bang voi gia tri PSN_CS get duoc.
		editForm.setInsertPSN(PSN_CD);

		dao.addCustomer(editForm);

		// Di chuyen ve man hinh search.
		return mapping.findForward("result");
	}
}