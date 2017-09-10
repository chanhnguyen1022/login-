<%@page import="fjs.cs.action.form.CustomerForm"%>
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
	%>
	<div
		style="width: 60%; margin-right: 20%; margin-left: 20%; text-align: center;">
		<h1 align="left" style="color: red;">Training</h1>
		<hr>
		<div id="center">
			<h4 align="left">Login > Search Customer</h4>

			<div id="1">
					<label id="lblUserName">Welcome <%=request.getSession().getAttribute("username") %><a href="login.jsp" id="llblLogout" style="margin-left:85%;">Log Out</a></label>

			</div>

			<p style="padding: 1%; background-color: blue;"></p>
			<br>

			<div id="block-search"style="width: 96%; text-align: left; background-color: #F3F781;padding: 2%;">
				<form action="processSearch.do" method="post" id="searchForm"
					name="Form">
					
						<label style="margin-right: 2%;">Customer Name</label>
							<input type="text" name="customer_Name"
								id="txtCustomerName" style="margin-right: 3%;" <%if (form.getCustomer_Name() != null) {%>
								value="<%=form.getCustomer_Name()%>" <%}%>>
							<label>Sex</label>
							<select name="sex" id="cboSex" style="margin-right: 5%;">
									<option value="false">--Choose--</option>
									<option value="0" <%=(form.getSex().equals("0")?"selected":"")%>>Female</option>
									<option value="1" <%=(form.getSex().equals("1")?"selected":"")%>>Male</option>
							</select>
							<label>Birthday</label>
							<input type="text" size=10%; " <%if (form.getBirthDayStart() != null) {%>
								value="<%=form.getBirthDayStart()%>" <%}%> name="birthDayStart"
								placeholder="yyyy-mm-dd" id="txtBirthdayForm">
							<label>～</label>
							<input type="text" size="10%;" <%if (form.getBirthDayEnd() != null) {%>
								value="<%=form.getBirthDayEnd()%>" <%}%> name="birthDayEnd"
								placeholder="yyyy-mm-dd" id="txtBirthdayTo" style="margin-right: 15%;">
							<input type="submit" value="Search"
								onclick="return checkBirthday();" id="btnSearch">
				</form>
			</div>

			<div id="block-page" style="margin-top: 3%;">
				<input type="button" id="btnFirst" value="<<"><input
					type="button" id="btnPrevious" value="<"> <label style="margin-right: 80%;">Previous</label>
				<label>Next</label> <input type="button" id="btnNext" value=">"><input
					type="button" id="btnLast" value=">>">
			</div>
			<%
				int index = (Integer) request.getAttribute("start");
				int all = (Integer) request.getAttribute("all");
			%>
			<script>
				$('#btnPrevious')
						.click(
								function() {
									var i =
			<%=index%>
				;
									if (i == 0) {
										document.getElementById("btnPrevious").disabled = true;
									} else {
										window.location.href = "<%=request.getContextPath()%>/page.do?start="
												+ (i - 1);
									}
								});
				$('#btnNext')
						.click(
								function() {
									var i =
			<%=index%>
				;
									if ((i * 15) + 15 >=
			<%=all%>
				) {
										document.getElementById("btnNext").disabled = true;
									} else {
										window.location.href = "<%=request.getContextPath()%>/page.do?start="
												+ (i + 1);
									}
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
									window.location.href = "<%=request.getContextPath()%>/page.do?start="
											+ index;
								});
			</script>
			<script>
				function checkBirthday() {
					var start = document.Form.birthDayStart.value;
					var end = document.Form.birthDayEnd.value;
					var rxDatePattern = /^\d{4}\-(0?[1-9]|1[012])\-(0?[1-9]|[12][0-9]|3[01])$/;
					if (document.Form.birthDayStart.value === ""
							&& document.Form.birthDayEnd.value === "") {
						return true;
					} else {
						if (start.match(rxDatePattern)) {
							if (end.match(rxDatePattern)) {
								var date1 = new Date(start);
								var date2 = new Date(end);
								if (date2 > date1) {
									return true;
								} else {
									alert("There is an error in the range input of Birthday");
								}
							} else {
								alert("Invalid Birthday (To)");
							}
						} else {
							alert("Invalid Birthday (From)");
						}
					}
					return false;
				}
			</script>
			<div
				style="width: 100%; background-color: #F3F781;">
				<table align="left" width="100%" cellpadding="10%;"
					style="margin-top: 3%; margin-bottom: 3%;">
					<tbody style="border: 5px solid;border-color:#00CC00; ">
					<tr bgcolor="red;" style="text-align: left;">
						<th><input type="checkbox" onchange="checkAll(this)"
							id="chkAll"></th>
						<th id="llblCustomerID">Customer ID</th>
						<th id="lblCustomerName">Customer Name</th>
						<th id="lblSex">Sex</th>
						<th id="lblBirthday">Birthday</th>
						<th id="lblAddress">Address</th>
					</tr>
					<%
					int count = 0;
					for (CustomerForm cus : list) {
						count ++;
				%>
					<tr class="listUser_<%=count%2 %>" style="text-align: left;">
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
			
				<input type="button" value="Add New" class="button"
						onclick="location.href='add.do'" id="btnAddnew" style="margin-right: 3%;">
				
				<input type="submit" name="actionMethod" id="btnDelete"
						value="Delete">
			</div>
			<div id="footer" align="left">
				<hr>
				<label> Copyright (c) 2000-2008 FUJINET, All Rights Reserved.</label>
			</div>
		</div>
		<script>
		$('#btnDelete')
				.click(
						function() {
							var r = confirm("Do you want to delete?");
							if (r == true) {
								var selected = "";
								$("input[type=checkbox]:checked").each(
										function() {
											selected = selected + "-"
													+ $(this).val();
										});
								$
										.ajax({
											url : "<%=request.getContextPath()%>/delete.do?data="
													+ selected,
											type : 'POST',
											success : function(data) {
												alert("削除 :" + selected
														+ " 行を選択してください。");
												window.location.reload();
											},
											error : function(xhr, status, error) {
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
