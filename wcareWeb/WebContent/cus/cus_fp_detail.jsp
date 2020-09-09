
<jsp:include page="../common/common_header.jsp" />  

	
<%@page import="java.util.*"%>
<%@page import="com.gan.wcare.ejb.model.GoalInfo"%>
<%@page import="com.gan.wcare.ejb.model.InvestmentInfo"%>

<br>
<div class="w3-bar w3-border w3-light-grey">
  <a href="#" class="w3-bar-item w3-button w3-mobile w3-blue">Financial Plan</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile"  onclick="return onSelectPortfolio();">Portfolio</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile"  onclick="return onSelectProfile();">Profile</a>
</div>

<br>
<div class="w3-panel w3-blue-grey"">
  <h5><b>Financial plan Details </b></h5>
</div> 

	<table width="100%" align="center">
		<tr>
			<td width="*">&nbsp;</td>
			<td width="100"><button onclick="onSelectBack()">Back</button></td>
			
		</tr>
	</table>

<% 
GoalInfo data = (GoalInfo) request.getAttribute("mainData"); 
%>

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
  </div>
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
function onSelectBack() {
	  window.location = "CusFinancialPlanList";
}
function onSelectPortfolio() {
	  window.location = "CusPortfolioList";
}
function onSelectProfile() {
	  window.location = "CusProfileList";
}
</script>
