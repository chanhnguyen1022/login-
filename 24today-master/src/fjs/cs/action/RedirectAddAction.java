/**
 * @(#)RedirectAddAction.java 01-00 2017/08/16.
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
import fjs.cs.action.form.EditForm;

/**
 * RedirectAddAction
 *
 * @author chanh-nm 2017/08/21
 * @version 1.00
 */
public class RedirectAddAction extends Action {
	
	/**
	 * ActionMapping mapping
	 * ActionForm form
	 * HttpServletRequest request
	 * HttpServletResponse response
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		EditForm editForm = new EditForm();
		request.setAttribute("editForm", editForm);
		//Action di chuyen action add new customer.
		request.setAttribute("action", "processAdd.do");

		// Di chuyen den man hinh Add new customer.		
		return mapping.findForward("add");

	}
}