/**
 * @(#)EditAction.java 01-00 2017/08/16.
 * Copyright(C) FUJINET CO., LTD.
 *
 * Version 1.00.
 */
package fjs.cs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.*;

import fjs.cs.dao.MSTCUSTOMERDAO;
import fjs.cs.action.form.EditForm;
import fjs.cs.action.form.SearchForm;

/**
 * EditAction
 *
 * @author chanh-nm 2017/08/21
 * @version 1.00
 */
public class EditAction extends Action {

	/**
	 * ActionMapping mapping ActionForm form HttpServletRequest request
	 * HttpServletResponse response
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		EditForm editForm = (EditForm) form;

		String name;
		int id;

		id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		name = (String) session.getAttribute("username");

		MSTCUSTOMERDAO dao = new MSTCUSTOMERDAO();
		// Lay gia tri PSN_CD trong table MSTUSER dua vao username login.
		int PSN_CD = dao.getPSNCDbyUsername(name);
		editForm.setUpdatePSN(PSN_CD);
		editForm.setUserid(id);

		// Edit customer trong table MSTCUSTOMER.
		dao.EditCustomer(editForm);
		
		session.setAttribute("message", "true");
		SearchForm searchForm = (SearchForm) session.getAttribute("searchForm");
		if (searchForm == null) {
			return mapping.findForward("result2");
		}
		// Di chuyen ve man hinh Search.
		return mapping.findForward("result1");
	}
}