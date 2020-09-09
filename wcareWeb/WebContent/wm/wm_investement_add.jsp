<jsp:include page="../common/common_header.jsp" /> 
	
<%@page import="java.util.*"%>
<%@page import="com.gan.wcare.ejb.model.GoalInfo"%>

<br>
<div class="w3-bar w3-border w3-light-grey">
    <a href="#" class="w3-bar-item w3-button w3-mobile  onclick="return onSelectCustomer();"">Customer</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile w3-blue">Financial Plan</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile"  onclick="return onSelectPortfolio();">Portfolio</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile"  onclick="return onSelectProfile();">Profile</a>
</div>

<p>	<%=session.getAttribute("customerDisplayText")%></p>

<div class="w3-panel w3-blue-grey"">
  <h5><b>Add Investment </b></h5>
</div>



<% 
GoalInfo data = (GoalInfo) request.getAttribute("mainData"); 
%>

	<form name="myForm" method="post" action="WmInvestmentAdd?action=investmentAdd">

	<br>

	<table width="40%" bgcolor="f2f3f4" align="center">
		<tr>
			<td colspan=2>&nbsp;</td>
		</tr>	
		<tr>
			<td width="200">Goal Reference:</td>
			<td><%=data.getGoalReference()%></td>
		</tr>
		<tr>
			<td width="200">Goal Description:</td>
			<td><%=data.getGoalDesc()%></td>
		</tr>
		
		<tr>
			<td width="200">Investment Amount:</td>
			<td><input type="text" size=25 name="investmentAmount"></td>
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
	  window.location = "WmFinancialPlanDetail";
}

function validateForm(form) {

	if(form.investmentAmount.value != "") {
		return true;
	} else {
		alert("Investment Amount should not be empty")
		return false;
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
