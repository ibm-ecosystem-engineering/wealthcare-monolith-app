<jsp:include page="../common/common_header.jsp" /> 
	
<%@page import="java.util.*"%>

<br>
<div class="w3-bar w3-border w3-light-grey">
  <a href="#" class="w3-bar-item w3-button w3-mobile  onclick="return onSelectCustomer();"">Customer</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile w3-blue">Financial Plan</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile"  onclick="return onSelectPortfolio();">Portfolio</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile"  onclick="return onSelectProfile();">Profile</a>
</div>

<p>	<%=session.getAttribute("customerDisplayText")%></p>

<div class="w3-panel w3-blue-grey"">
  <h5><b>Add Goal </b></h5>
</div>

	<form name="myForm" method="post" action="WmFinancialPlanAdd?action=goalAdd">

	<br>

	<table width="40%" bgcolor="f2f3f4" align="center">
		<tr>
			<td colspan=2>&nbsp;</td>
		</tr>	
		<tr>
			<td width="200">Goal Reference:</td>
			<td><input type="text" size=25 name="goalReference"></td>
		</tr>
		<tr>
			<td width="200">Goal Description:</td>
			<td><input type="text" size=25 name="goalDescription"></td>
		</tr>
		<tr>
			<td width="200">Target Date:</td>
			<td><input type="text" size=25 name="targetDate" value="20-10-2025"></td>
		</tr>
		<tr>
			<td width="200">Target Amount:</td>
			<td><input type="text" size=25 name="targetAmount"></td>
		</tr>
		<tr>
			<td colspan=2>&nbsp;</td>
		</tr>	
		<tr>
			<td colspan=2 align="center">
				<button onclick="onSelectSave()">Save</button> 
				<button onclick="onSelectCancel()">Cancel</button>
			</td>
		</tr>
	
	</table>
	
	
<jsp:include page="../common/common_footer.jsp" /> 



<script>
function onSelectSave() {
  if (validateForm()) {
	  document.myForm.submit();
  }
}

function onSelectCancel() {
	  window.location = "WmFinancialPlanList";
}

function validateForm(form) {

	if(form.goalReference.value == "") {
		alert("Goal Reference should not be empty")
		return false;
	} else if(form.goalDescription.value == "") {
		alert("Goal Description should not be empty")
		return false;
	} else if(form.targetDate.value == "") {
		alert("Target Date should not be empty")
		return false;
	} else if(form.targetAmount.value == "") {
		alert("Target Amount should not be empty")
		return false;
	}  else {
		return true;
	}
}
function onSelectCustomer() {
	  window.location = "WmCustomerList";
}

function onSelectPortfolio() {
	  window.location = "WmPortfolioList";
}
function onSelectProfile() {
	  window.location = "WmProfileList";
}
</script>
