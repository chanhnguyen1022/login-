<%@page import="fjs.cs.action.form.CustomerForm"%>
<%@page import="fjs.cs.action.form.SearchForm"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Search - Training</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body bgcolor="CCFFFF">
	<%
		List<CustomerForm> list = (List<CustomerForm>) request.getAttribute("list");
		SearchForm form = (SearchForm) request.getSession().getAttribute("searchForm");
		if(form == null){
			form = new SearchForm();
		}
	%>
	<div
		style="width: 60%; margin-right: 20%; margin-left: 20%; text-align: center;">
		<h1 align="left" style="color: red;"><a href="search.do?start=0" style="text-decoration: none;color: red;">Training</a></h1>
		<hr>
		<div id="center">
			<h4 align="left">Login > Search Customer</h4>

			<div id="1">
				<label id="lblUserName">Welcome <%=request.getSession().getAttribute("username")%><a
					href="login.jsp" id="llblLogout" style="margin-left: 85%;">Log
						Out</a></label>

			</div>

			<p style="padding: 1%; background-color: blue;"></p>
			<br>

			<div id="block-search"
				style="width: 96%; text-align: left; background-color: #F3F781; padding: 2%;">
				<form action="processSearch.do" method="GET" id="searchForm"
					name="Form">

					<label style="margin-right: 12%; font-size: 19px; margin-left: 1%;">Customer
						Name</label> <input type="text" name="customer_Name" id="txtCustomerName"
						style="margin-right: 2%; width: 13%;" <%if (form.getCustomer_Name() != null) {%>
						value="<%=form.getCustomer_Name()%>" <%}%>> <label style="font-size: 18px;">Sex</label>
					<select name="sex" id="cboSex" style="margin-right: 4%;">
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
					</select> <label style="font-size: 18px;">Birthday</label> <input
						type="text" size=10%; name="birthDayStart" id="txtBirthdayForm"
						style="margin-left: 1%;" <%if (form.getBirthDayStart() != null) {%>
						value="<%=form.getBirthDayStart() %>" <%}%>> <label>～</label> <input
						type="text" size="10%;" name="birthDayEnd" id="txtBirthdayTo"
						style="margin-right: 7%;" <%if (form.getBirthDayEnd() != null) {%>
						value="<%=form.getBirthDayEnd()%>" <%}%>> <input type="submit"
						value="&nbsp;&nbsp;&nbsp;Search &nbsp;&nbsp;&nbsp;&nbsp;"
						onclick="return checkBirthday();" id="btnSearch"
						style="font-size: 16px;" size="10%;">
				</form>
			</div>

			<div id="block-page" style="margin-top: 3%;">
				<input type="button" id="btnFirst" value="<<"><input
					type="button" id="btnPrevious" value="<"> <label
					style="margin-right: 80%;"> &nbsp;Previous</label> <label>Next
					&nbsp;</label> <input type="button" id="btnNext" value=">"><input
					type="button" id="btnLast" value=">>">
			</div>
			<%
				int index = (Integer) request.getAttribute("start");
				int all = (Integer) request.getAttribute("all");
			%>
			<script>
				$(document).ready(function(){
					var i =
						<%=index%>
							;
							if ((i * 15) + 15 >=
								<%=all%>
									) {
															document.getElementById("btnNext").disabled = true;
															document.getElementById("btnLast").disabled = true;
														}
							if (i == 0) {
															document.getElementById("btnPrevious").disabled = true;
															document.getElementById("btnFirst").disabled = true;
														}
					$('#btnPrevious')
					.click(
							function() {
							
								 
									window.location.href = "<%=request.getContextPath()%>/page.do?start="
											+ (i - 1);
								
							});
			$('#btnNext')
					.click(
							function() {
							
									window.location.href = "<%=request.getContextPath()%>/page.do?start="
											+ (i + 1);
							});
				});
				$('#btnFirst')
						.click(
								function() {
									window.location.href = "<%=request.getContextPath()%>/page.do?start=0";
								});
				$('#btnLast')
						.click(
								function() {
									
									var all =
			<%=all%>
				;
									var index = Math.floor(all / 15);
									var du = all%15;
									if(du === 0){
										index-=1;
									}
									window.location.href = "<%=request.getContextPath()%>/page.do?start="
											+ (index);
								});
			</script>
			<script>
				function checkBirthday() {
					var start = document.Form.birthDayStart.value;
					var end = document.Form.birthDayEnd.value;
					var rxDatePattern = /^\d{4}\/(0?[1-9]|1[012])\/(0?[1-9]|[12][0-9]|3[01])$/;
					
					
					if (document.Form.birthDayStart.value === ""
							&& document.Form.birthDayEnd.value === "") {
							if(document.Form.sex.value === "false"
								&& document.Form.customer_Name.value === ""){
									alert("Form null");
								}else{
									return true;
								}
					} else {
						if (start.match(rxDatePattern)) {
							if(end === ""){
								return true;
							}else if (end.match(rxDatePattern)) {
								var date1 = new Date(start);
								var date2 = new Date(end);
								if (date2 > date1) {
									return true;
								} else {
									alert("There is an error in the range input of Birthday");
								}
							} else {
								alert("Invalid Birthday (From)");
								return false;
							}
						} else {
							if (end.match(rxDatePattern) && start === "") {
								return true;
							} else {
								alert("Invalid Birthday (From)");
								return false;
							}
						}
					}
					return false;
				}
			</script>
			<div style="width: 100%; background-color: #F3F781;" class="table-data">
				<table align="left" width="100%" cellpadding="10%;"
					style="margin-top: 3%; margin-bottom: 3%;">
					<tbody style="border: 2px solid; border-color: #00CC00;">
						<tr bgcolor="red;" style="text-align: left;">
							<th><input type="checkbox" onchange="checkAll(this)"
								id="chkAll" value="on"></th>
							<th id="llblCustomerID">Customer ID</th>
							<th id="lblCustomerName">Customer Name</th>
							<th id="lblSex">Sex</th>
							<th id="lblBirthday">Birthday</th>
							<th id="lblAddress">Address</th>
						</tr>
						<%
							int count = 0;
							for (CustomerForm cus : list) {
								count++;
						%>
						<tr class="listUser_<%=count % 2%>" style="text-align: left;">
							<td id="chkDetail"><input type="checkbox"
								value="<%=cus.getCustomer_Id()%>"></td>
							<td><a href="edit.do?id=<%=cus.getCustomer_Id()%>"><%=cus.getCustomer_Id()%></a></td>
							<td><%=cus.getCustomer_Name()%></td>
							<td><%=cus.getSex()%></td>
							<td><%=cus.getBirthDay()%></td>
							<td><%=cus.getAddress()%></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>

			</div>
			<div id="block_button" align="left" style="margin-bottom: 3%;">

				<input type="button"
					value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Add New &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
					class="button" onclick="location.href='add.do'" id="btnAddnew"
					style="margin-right: 3%; font-size: 16px;"> <input
					type="submit" name="actionMethod" id="btnDelete"
					value="&nbsp;&nbsp;&nbsp;Delete&nbsp;&nbsp;&nbsp;"
					style="font-size: 16px;">
					<a href="search.do?start=0">View all</a>
			</div>
			<div id="footer" align="left">
				<hr>
				<label> Copyright (c) 2000-2008 FUJINET, All Rights
					Reserved.</label>
			</div>
		</div>
		<script>
		$(document).ready(function(){
			var inputs = $(".table-data").find($("input[type=checkbox]"));
			if(inputs.length === 1){
				document.getElementById("btnDelete").disabled = true;
			}else{
				document.getElementById("btnDelete").disabled = false;
			}
		});
		$('#btnDelete')
				.click(
						function() {
							var r = confirm("Do you want to delete?");
							if (r == true) {
								var selected = "";
								$("input[type=checkbox]:checked").each(
										function() {
											if($(this).val() !== 'on'){
												selected = selected + "-"
												+ $(this).val();
											}
										});
								
								$.ajax({
											url : "<%=request.getContextPath()%>/delete.do?data="
														+ selected,
												type : 'POST',
												success : function(data) {
													alert("削除 :" + selected
															+ " 行を選択してください。");
													window.location.reload();
												},
												error : function(xhr, status,
														error) {
													alert('データの更新に問題があります');
												}
											});
								} else {
									return;
								}
							});
			function enableEditDelete() {
				document.getElementById('editbutton').disabled = false;
				document.getElementById('deletebutton').disabled = false;
			}
			function checkAll(ele) {
				var checkboxes = document.getElementsByTagName('input');
				if (ele.checked) {
					for (var i = 0; i < checkboxes.length; i++) {
						if (checkboxes[i].type == 'checkbox') {
							checkboxes[i].checked = true;
						}
					}
				} else {
					for (var i = 0; i < checkboxes.length; i++) {
						console.log(i)
						if (checkboxes[i].type == 'checkbox') {
							checkboxes[i].checked = false;
						}
					}
				}
			}
		</script>
		<style>
.listUser_0 {
	background-color: #CCFFFF;
}

.listUser_1 {
	background-color: #FFFFFF;
}

table {
	border-collapse: collapse;
}
</style>
</body>
</html>