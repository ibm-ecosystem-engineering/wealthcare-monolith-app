<!DOCTYPE html>

<html>

<title>WealthCare Application</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

	<body>


		<!-- !PAGE CONTENT! -->
		<div class="w3-content" style="max-width:1500px">
		
		
		  <!-- Header -->
		  <header class="w3-row w3-xlarge">
		   <div class="w3-panel w3-cyan">
			  <h1><b>WealthCare</b></h1>
			</div> 
		  </header>
	  
		  <div class="w3-row">
  
	<% 
	if (session.getAttribute("userDisplayText") != null) {
	%>
		<table width="100%" align="center">
			<tr>
				<td width="*">&nbsp;</td>
				<td width="400" align="right"><%=session.getAttribute("userDisplayText")%> &nbsp;&nbsp;</td>
				<td width="10"><button onclick="onSelectLogout()">Logout</button></td>
			</tr>
		</table>
	<% 
	}
	%>


  

  
  