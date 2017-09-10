/**
 * @(#)CustomerAction.java 01-00 2017/08/16.
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

import fjs.cs.action.form.SearchForm;
import fjs.cs.dao.MSTCUSTOMERDAO;

/**
 * CustomerAction
 *
 * @author chanh-nm 2017/08/21
 * @version 1.00
 */
public class CustomerAction extends Action {

	/**
	 * ActionMapping mapping
	 * ActionForm form
	 * HttpServletRequest request
	 * HttpServletResponse response
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int index = 0;
		HttpSession session = request.getSession();
		// kiểm tra và xóa dữ liệu searchForm trong session
		// khác null tức là có dữ liệu searchForm trong session
		if(session.getAttribute("searchForm") != null ){ 
			session.removeAttribute("searchForm");
		}
		// kiểm tra và xóa dữ liệu message trong session
		// khác null tức là có dữ liệu message trong session
		if(session.getAttribute("message") != null){
			session.removeAttribute("message");
		}
		MSTCUSTOMERDAO dao = new MSTCUSTOMERDAO();
		
		request.setAttribute("list", dao.getAllcustomers(index));
		request.setAttribute("start", index);
		request.setAttribute("all", dao.countCustomers());
		// Di chuyen ve man hinh Search
		return mapping.findForward("search");
	}
}