<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="fjs.cs.action.form.EditForm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit - Training</title>
<!-- Include jTable script file. -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body bgcolor="CCFFFF">
	<%
		EditForm form = (EditForm) request.getAttribute("editForm");
		String action = (String) request.getAttribute("action");
	%>
	<form action="<%=action%>" method="post" id="editForm" name="Form">
		<div
			style="width: 60%; margin-right: 20%; margin-left: 20%; text-align: center;">
			<h1 align="left" style="color: red;">Training</h1>
			<hr>
			<div id="center">
				<h4 align="left"">Login > Search Customer > Edit Customer Info</h4>
				</div><br>
						<div id="1">
					<label id="lblUserName">Welcome <%=request.getSession().getAttribute("username") %><a href="login.jsp" id="llblLogout" style="margin-left:85%;">Log Out</a></label>

			</div>
				<br>
				<div style="background-color: blue;" id="lblScreenName">
					<h4>
						<p style="color: white;" align="left">Edit</p>
					</h4>
				</div>

				<div id="center" width="70%" align="center" style="padding-top:2%;padding-bottom:3%; font-weight: bold;">

					<table cellpadding="10%;">
						<tr>
							<th colspan="2"><h5 id="lblErrorMessage" style="color: red;"></h5></th>
						</tr>
						<tr>
							<td ><label id="lblCustomerID">Cusomer Id</label></td>
							<td><label >
								<%if (form.getUserid() != 0) {%> <%=form.getUserid()%><%}%></label></td>
						</tr>
						<tr>
							<td>Customer Name</td>
							<td><input type="text" size="20%" name="customerName" id="txtCustomerName"
								<%if (form.getCustomerName() != null) {%>
								value="<%=form.getCustomerName()%>" <%}%>></td>
						</tr>
						<tr>
							<td id="cboSex">Sex</td>
							<td align="left"><select name="sex" id="cboSex" style="margin-right: 4%;">
						<option value="false"></option>
						<%
							if (form.getSex()!= null) {
						%>
						<option value="0" <%=(form.getSex().equals("0") ? "selected" : "")%>>Female</option>
						<option value="1" <%=(form.getSex().equals("1") ? "selected" : "")%>>Male</option>
						<%
							} else {
						%>
						<option value="0">Female</option>
						<option value="1">Male</option>
						<%
							}
						%>
					</select></td>
						</tr>
						<tr>
							<td>Birthday</td>
							<td><input type="text" size="10%" name="birthDay" id="txtBirthday"
								<%if (form.getBirthDay() != null) {%>
								value="<%=form.getBirthDay()%>" <%}%>></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><input type="text" size="20%" name="email" id="txtEmail"
								<%if (form.getEmail() != null) {%> value="<%=form.getEmail()%>"
								<%}%>></td>
						</tr>
						<tr>
							<td>Address</td>
							<td><input type="text" style="padding: 7%;" size="35%;" id="txaAddress"
								name="address" <%if (form.getAddress() != null) {%>
								value="<%=form.getAddress()%>" <%}%>></td>
						</tr>							
					</table>
				</div>
				
				<div id="button" style="margin-bottom: 15%;">
				<input type="submit" id="btnSave"
								value="Save"  style="margin-right: 7%;"> <%
 	if (action.equals("processAdd.do")) {
 %> <input
								type="button" id="add" value="Clear"> <%
 	} else {
 %> <input
								type="button" id="edit" value="Clear"> <%
 	}
 %></div>
				<div id="footer" style="width: 100%; text-align: left;">
					<hr>
					<label> Copyright (c) 2000-2008 FUJINET, All Rights Reserved.</label>
				</div>

			</div>
	</form>
	<script>
		function validate() {
			if (document.Form.customerName.value === ""
					|| document.Form.customerName.value === null) {
				document.getElementById("lblErrorMessage").innerHTML = "まだユーザー名を入力していない";

				return false;
			}
			if(document.Form.sex.value==="false"||document.Form.sex.value===null){
				document.getElementById("lblErrorMessage").innerHTML = "あなたはまだ性別を選択していません";

				return false;
			}
			if (document.Form.birthDay.value === ""
					|| document.Form.birthDay.value === null) {
				document.getElementById("lblErrorMessage").innerHTML = "誕生日に入っていない";

				return false;

			}
			if (document.Form.email.value === ""
					|| document.Form.email.value === null) {
				document.getElementById("lblErrorMessage").innerHTML = "まだメールがありません";

				return false;

			}
			if (document.Form.address.value === ""
					|| document.Form.address.value === null) {
				document.getElementById("lblErrorMessage").innerHTML = "住所を入力していない";

				return false;
			}
			var rxDatePattern = /^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$/;

			if (rxDatePattern.test(document.Form.birthDay.value) == false) {
				document.getElementById("lblErrorMessage").innerHTML = "誕生日が不正です。";
				return false;
		}
			var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

			if (reg.test(document.Form.email.value) == false) {
				document.getElementById("lblErrorMessage").innerHTML = "メールアドレスが不正です。";
				return false;
		}
			return (true);
		}

		$("#add").click(function(event) {
			document.Form.customerName.value = "";
			document.Form.birthDay.value = "";
			document.Form.email.value = "";
			document.Form.address.value = "";
			document.getElementById("lblErrorMessage").innerHTML = "";

		});
		$("#edit").click(function(event) {
			window.location.reload();

		});
		$("#editForm").submit(function(event) {
			return validate();
		});
	</script>
</body>
</html>
