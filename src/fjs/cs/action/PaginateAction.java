/**
 * @(#)PaginateAction.java 01-00 2017/08/16.
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

/**
 * PaginateAction
 *
 * @author chanh-nm 2017/08/21
 * @version 1.00
 */
public class PaginateAction extends Action {
	
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
		int start = Integer.parseInt(request.getParameter("start"));
		request.setAttribute("list", dao.getAllcustomers(start));
		request.setAttribute("start", start);
		request.setAttribute("all", dao.countCustomers());
		
		// Di chuyen den man hinh Search
		return mapping.findForward("page");
	}
}
