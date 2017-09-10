<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Login - Training</title>
<link href="jtable.css" rel="stylesheet" type="text/css" />
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>

</head>
<body bgcolor="#8DEEEE">
	<form action="register1.do" method="post" id="formDemo" name="MyForm">
<div style="color:red">
    </div>
		<div id="header">
			<h1 style="color: red;">Training</h1>
		</div>
		<hr>
		<h3>Login</h3>
		<div id="center" style="padding-top: 8%;">
			<table align="center" cellspacing="10%;">

				<tr>
					<th colspan="2"><h1 style="color: BLUE;">LOGIN</h1></th>
				</tr>
				<tr>
					<th colspan="2"><h5 id="lblErrorMessage" style="color: red;"><% String error =(String)request.getAttribute("lblErrorMessage"); %><%=error != null? error : ""%></h5></th>
				</tr>

				<tr>
					<td>User Id：</td>
					<td> <input type="text" name="userId" size="50" maxlength="8" id="txtUserID"/><br></td>
				</tr>

				<tr>
					<td>Password：</td>
					<td><input type="password" name="password" size="50"maxlength="8" id="txtPassword"/><br></td>
				</tr>

				<tr>
					<td colspan="2" align="center"></td>
				</tr>

			</table>
		</div>
		<div align="center" style="margin-top: 1%;margin-bottom: 15%;">
		<input type="submit"value="Login" id="btnLogin" style="margin-right: 7%;">
		<input type="button" id="btnClear"value="Clear">
		</div>
		<style>
			#footer{
				position: fixed;
				bottom:0;
				width:100%;
			}
		</style>
		<div id="footer">
		<hr>
			<label> Copyright (c) 2000-2008 FUJINET, All Rights Reserved.</label>

		</div>
	</form>
<script type="text/javascript">
	<!--
		// Form validation code will come here.
		function validate() {

			if (document.MyForm.userId.value === ""
					|| document.MyForm.userId.value === null) {
				document.getElementById("lblErrorMessage").innerHTML = "ユーザーIDを入力してください。";

				return false;
			}
			if (document.MyForm.password.value === ""
					|| document.MyForm.password.value === null) {
				document.getElementById("lblErrorMessage").innerHTML = "パスワードを入力してください。";

				return false;
			}
			return (true);
			}
		$("#btnClear").click(function(event) {
			document.MyForm.userId.value = "";
			document.MyForm.password.value = "";
			document.getElementById("lblErrorMessage").innerHTML = "";
	
		});
		$("#formDemo").submit(function(event){
			return validate();
		});
	</script>
</body>
</html>