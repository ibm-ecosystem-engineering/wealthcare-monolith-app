<jsp:include page="../common/common_header.jsp" /> 
	
	
<%@page import="java.util.*"%>
<%@page import="com.gan.wcare.ejb.model.GoalInfo"%>
<%@page import="com.gan.wcare.ejb.model.InvestmentInfo"%>

<br>
<div class="w3-bar w3-border w3-light-grey">
    <a href="#" class="w3-bar-item w3-button w3-mobile"  onclick="return onSelectCustomer();">Customer</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile" onclick="return onSelectFP();">Financial Plan</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile w3-blue" >Portfolio</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile"  onclick="return onSelectProfile();">Profile</a>
</div>

<p>	<%=session.getAttribute("customerDisplayText")%></p>

<div class="w3-panel w3-blue-grey"">
  <h5><b>Portfolio </b></h5>
</div>


<% 
List<GoalInfo> list = (List<GoalInfo>) request.getAttribute("mainData"); 
%>

  <table class="w3-table-all">
    <thead>
      <tr class="w3-light-grey">
        <th>Goal Reference</th>
        <th>Goal Desc</th>
        <th>Investment Date</th>
        <th>Investment Amount</th>
        <th>Stocks</th>        
        <th>Mutual funds</th>
        <th>Fixed Deposit</th>
        <th>Current Value</th>
      </tr>
    </thead>
		<%
		if(list != null)  {
			Iterator<GoalInfo> iteratorGoalInfo = list.iterator();
			while(iteratorGoalInfo.hasNext()) {
				GoalInfo goalInfo = iteratorGoalInfo.next(); 
				Iterator<InvestmentInfo> iterator = goalInfo.getInvestments().iterator();
				while(iterator.hasNext()) {
					InvestmentInfo data = iterator.next(); 
		%>
				<tr>
					<td><%=goalInfo.getGoalReference()%></td>
					<td><%=goalInfo.getGoalDesc()%></td>
					<td><%=data.getInvestmentDate()%></td>
					<td><%=data.getInvestmentAmount()%></td>
					<td><%=data.getStockAmount()%>  <BR>(<%=data.getCurrentValueStockAmountString()%>)</td>
					<td><%=data.getMutualFundAmount()%>  <BR>(<%=data.getCurrentValueMutualFundAmountString()%>)</td>
					<td><%=data.getFixedDepositAmount()%>  <BR>(<%=data.getCurrentValueFixedDepositAmountString()%>)</td>
					<td><%=data.getCurrentValueTotalString()%>  <BR><%=data.getCurrentValueTotalComments()%></td>
					
				</tr>
		<%
				}
			}
		}
		%>
  </table>
<jsp:include page="../common/common_footer.jsp" /> 

<script>
function onSelectCustomer() {
  window.location = "WmCustomerList";
}

function onSelectFP() {
	  window.location = "WmFinancialPlanList";
}

function onSelectProfile() {
	  window.location = "WmProfileList";
}
</script>
