/**
 * @(#)SearchAction.java 01-00 2017/08/16.
 * Copyright(C) FUJINET CO., LTD.
 *
 * Version 1.00.
 */
package fjs.cs.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import fjs.cs.action.form.SearchForm;
import fjs.cs.action.form.CustomerForm;
import fjs.cs.dao.MSTCUSTOMERDAO;

/**
 * SearchAction
 *
 * @author chanh-nm 2017/08/21
 * @version 1.00
 */
public class SearchAction extends Action {
	
	/**
	 * ActionMapping mapping
	 * ActionForm form
	 * HttpServletRequest request
	 * HttpServletResponse response
	 */	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//Danh sach customer. 
		List<CustomerForm> list;
		SearchForm searchForm = (SearchForm) form;
		
		//Danh sach customer duoc get tu database.
		MSTCUSTOMERDAO dao = new MSTCUSTOMERDAO();
		list = dao.searchCustomers(searchForm);
		
		request.setAttribute("list", list);
		request.setAttribute("start", 0);
		request.setAttribute("all", 0);
		HttpSession se = request.getSession();
		se.setAttribute("searchForm", searchForm);
		
			// Di chuyen den man hinh Search		
		return mapping.findForward("result");
	}
}
