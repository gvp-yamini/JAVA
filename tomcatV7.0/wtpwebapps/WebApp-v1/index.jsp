<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
 function validateUsername(){
	 var text = document.getElementById("username").value;
	 if(text==""){
		 document.getElementById("errorusername").innerHTML = "Provide Username";
		 document.getElementById("errorusername").style.color = "red";
	 }
 }
 function validatePassword(){
	 var text = document.getElementById("password").value;
	 if(text==""){
		 document.getElementById("errorpassword").innerHTML = "Provide Password";
		 document.getElementById("errorpassword").style.color = "red";
	 } 
 }
</script>
</head>
<body>
<h1>Hiring Portal</h1>
<hr/>
					<form action="MyServlet">
					<table>
					    <tr>
					    <td><label>Username</label></td>
						<td><input type="text" id="username" placeholder="username" onblur="validateUsername();"/></td>
						<td><label id="errorusername"></label></td>
						</tr>
						<tr>
						<td><label>Password</label></td>
						<td><input type="password" placeholder="password" onblur="validatePassword();"/></td>
						<td><label id = "errorpassword"></label></td>
						</tr>
						<tr>
						<td></td>
						<td><input type="submit" value="Login" /></td>
						<td></td>
						</tr>
						<tr>
						<td><a href="#">Create an account</a> &nbsp;&nbsp;</td>
						<td></td>
						<td><a href="#">Forgot Password</a></td>
						</tr>
					</table>
					</form>
				</div>
</body>
</html>