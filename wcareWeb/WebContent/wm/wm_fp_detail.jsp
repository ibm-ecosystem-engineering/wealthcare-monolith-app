<jsp:include page="../common/common_header.jsp" /> 
	
<%@page import="java.util.*"%>
<%@page import="com.gan.wcare.ejb.model.GoalInfo"%>
<%@page import="com.gan.wcare.ejb.model.InvestmentInfo"%>

<br>
<div class="w3-bar w3-border w3-light-grey">
  <a href="#" class="w3-bar-item w3-button w3-mobile  onclick="return onSelectCustomer();"">Customer</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile w3-blue">Financial Plan</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile"  onclick="return onSelectPortfolio();">Portfolio</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile"  onclick="return onSelectProfile();">Profile</a>
</div>

<p>	<%=session.getAttribute("customerDisplayText")%></p>

<div class="w3-panel w3-blue-grey"">
  <h5><b>Financial plan details </b></h5>
</div> 

	<% 
	GoalInfo data = (GoalInfo) request.getAttribute("mainData"); 
	%>
	<table width="100%" align="center">
		<tr>
			<td width="*">&nbsp;</td>
			<td width="160"><button onclick="onSelectAddInvestment(<%=data.getId()%>)">Add Investment</button></td>
			<td width="140"><button onclick="onSelectDeleteGoal(<%=data.getId()%>)">Delete Goal</button></td>
			<td width="100"><button onclick="onSelectBack()">Back</button></td>
			
		</tr>
	</table>
	
	
	<h4>GOAL # <%=data.getGoalReference()%> : <%=data.getGoalDesc()%></h4>
	<%=data.getGoalAchievementString()%>
			
		<br>
		  <table class="w3-table-all">
		    <thead>
		      <tr class="w3-light-grey">
		          <th>Target Amount</th>        
		        <th>Target Date</th>
		        <th>Investment Amount</th>
		        <th>Investment Current Value</th>
		      </tr>
		    </thead>
			<tr>
				<td><%=data.getTargetAmount()%></td>
				<td><%=data.getTargetDate()%></td>
				<td><%=data.getTotalInvestmentAmount()%></td>
				<td><%=data.getInvestmentCurrentValue()%></td>
			</tr>
		  </table>
  
  		  <br>
  
  
  
	  <table class="w3-table-all">
	    <thead>
	      <tr class="w3-light-grey">
	        <th>Investment Date</th>
	        <th>Investment Amount</th>
	        <th>Stocks</th>        
	        <th>Mutual funds</th>
	        <th>Fixed Deposit</th>
	        <th>Current Value</th>
	      </tr>
	    </thead>
			<%
	
				Iterator<InvestmentInfo> iterator = data.getInvestments().iterator();
				while(iterator.hasNext()) {
					InvestmentInfo investmentInfo = iterator.next(); 
			%>
					<tr>
						<td><%=investmentInfo.getInvestmentDate()%></td>
						<td><%=investmentInfo.getInvestmentAmount()%></td>
						<td><%=investmentInfo.getStockAmount()%>  <BR>(<%=investmentInfo.getCurrentValueStockAmountString()%>)</td>
						<td><%=investmentInfo.getMutualFundAmount()%>  <BR>(<%=investmentInfo.getCurrentValueMutualFundAmountString()%>)</td>
						<td><%=investmentInfo.getFixedDepositAmount()%>  <BR>(<%=investmentInfo.getCurrentValueFixedDepositAmountString()%>)</td>
						<td><%=investmentInfo.getCurrentValueTotalString()%>  <BR><%=investmentInfo.getCurrentValueTotalComments()%></td>
						
					</tr>
			<%
				}
			%>
	  </table>
  
<jsp:include page="../common/common_footer.jsp" /> 



<script>
function onSelectAddInvestment(id) {
  window.location = "WmInvestmentAdd?goalId=" + id;
}
function onSelectBack() {
	  window.location = "WmFinancialPlanList";
}
function onSelectDeleteGoal(id) {
	  window.location = "WmFinancialPlanList?action=deleteGoal&goalId=" + id;
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
