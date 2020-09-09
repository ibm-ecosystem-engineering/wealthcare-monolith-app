

<html>
<head>

<% 

//Invalidate the session
request.getSession().setAttribute("userDisplayText", null);

%>

<jsp:include page="common/common_header.jsp" /> 
	
	
<br><br>

<form name="loginForm" method="post" action="LoginController">

	<table width="30%" bgcolor="#d6eaf8" align="center">
		<tr>
			<td colspan=2>&nbsp;</td>
		</tr>
		<tr>
			<td colspan=2><center><font size=4><b> Login </b></font></center></td>
		</tr>

		<tr>
			<td width="100">&nbsp;&nbspLogin Id:</td>
			<td><input type="text" size=25 name="loginId"></td>
		</tr>
		<tr>
			<td>&nbsp&nbspPassword:</td>
			<td><input type="Password" size=25 name="password"></td>
		</tr>
		<tr>
			<td colspan=2>&nbsp;</td>
		</tr>	
		<tr>
			<td colspan=2 align="center"><input type="Reset"><input type="submit" onclick="return check(this.form)" value="Login"></td>
		</tr>
	</table>
</form>

<jsp:include page="common/common_footer.jsp" />  


<script language="javascript">
function check(form)
{

if(form.loginId.value != "" && form.password.value != "")
{
	return true;
}
else
{
	alert("Error Password or Username")
	return false;
}
}
</script>
