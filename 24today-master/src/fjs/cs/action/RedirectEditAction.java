/**
 * @(#)RedirectEditAction.java 01-00 2017/08/16.
 * Copyright(C) FUJINET CO., LTD.
 *
 * Version 1.00.
 */
package fjs.cs.action;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fjs.cs.dao.MSTCUSTOMERDAO;
import fjs.cs.action.form.EditForm;

/**
 * RedirectEditAction
 *
 * @author chanh-nm 2017/08/21
 * @version 1.00
 */
public class RedirectEditAction extends Action {
	
	/**
	 * ActionMapping mapping
	 * ActionForm form
	 * HttpServletRequest request
	 * HttpServletResponse response
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		MSTCUSTOMERDAO dao = new MSTCUSTOMERDAO();
		//Bien id luu tru gia tri id cua customer
		int id = Integer.parseInt(request.getParameter("id"));
		//Get du lieu cua customer theo id  hien thi ra form edit trang edsit.jsp
		EditForm editForm = dao.getEditForm(id);
		request.setAttribute("editForm", editForm);
		//Action di chuyen den action edit customer.
		request.setAttribute("action", "processEdit.do?id=" + id);
		
		// Di chuyen den man hinh Edit.
		return mapping.findForward("edit");

	}
}