/**
 * @(#)DeletedAction.java 01-00 2017/08/16.
 * Copyright(C) FUJINET CO., LTD.
 *
 * Version 1.00.
 */
package fjs.cs.action;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fjs.cs.dao.MSTCUSTOMERDAO;

/**
 * DeletedAction
 *
 * @author chanh-nm 2017/08/21
 * @version 1.00
 */
public class DeletedAction extends Action {

	/**
	 * ActionMapping mapping
	 * ActionForm form
	 * HttpServletRequest request
	 * HttpServletResponse response
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//Chuoi customer_id
		String data;
		
		// Lay chuoi customer_id duoc checkbox.
		data = request.getParameter("data");

		//Xoa du lieu customer trong table MSTCUSTOMER.
		MSTCUSTOMERDAO dao = new MSTCUSTOMERDAO();
		ArrayList<Integer> isCus = idCustomers(data);
		for (int i : isCus) {
			dao.deleted(i);
		}
		
		// Di chuyen den man hinh Search		
		return mapping.findForward("search");
	}
		// Phuong thuc dung de lay chuoi customer_id da duoc checkbox.	
	public ArrayList<Integer> idCustomers(String data) {
		
		//Danh sach customer_id.
		ArrayList<Integer> isCus = new ArrayList<Integer>();
		
		//Chuoi customer_id co dang customer_id-cusomer_id-customer_id.
		StringTokenizer strto = new StringTokenizer(data, "-");
		
		//Loai bo ky tu "-" co trong chuoi.
		while (strto.hasMoreTokens()) {
			isCus.add(Integer.parseInt(strto.nextToken()));
		}
		//Tra ve danh sach customer_id sau khi loai bo ky tu "-".
		return isCus;
	}
}
