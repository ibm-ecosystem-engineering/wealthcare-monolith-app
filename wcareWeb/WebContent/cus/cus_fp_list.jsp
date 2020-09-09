<jsp:include page="../common/common_header.jsp" /> 

<%@page import="java.util.*"%>
<%@page import="com.gan.wcare.ejb.model.GoalInfo"%>

<br>
<div class="w3-bar w3-border w3-light-grey">
  <a href="#" class="w3-bar-item w3-button w3-mobile w3-blue">Financial Plan</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile"  onclick="return onSelectPortfolio();">Portfolio</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile"  onclick="return onSelectProfile();">Profile</a>
</div>

<br>
<div class="w3-panel w3-blue-grey"">
  <h5><b>Financial plan</b></h5>
</div> 


<% 
List<GoalInfo> list = (List<GoalInfo>) request.getAttribute("mainData"); 
%>

  <table class="w3-table-all">
    <thead>
      <tr class="w3-light-grey">
        <th>Goal Reference</th>
        <th>Goal Desc</th>
        <th>Target Amount</th>        
        <th>Target Date</th>
        <th>Investment Amount</th>
        <th>Investment Current Value</th>
        <th>&nbsp;</th>
      </tr>
    </thead>
		<%
		if(list != null)  {
			Iterator<GoalInfo> iterator = list.iterator();
			while(iterator.hasNext()) {
				GoalInfo data = iterator.next(); 
		%>
				<tr>
					<td><%=data.getGoalReference()%></td>
					<td><%=data.getGoalDesc()%></td>
					<td><%=data.getTargetAmount()%></td>
					<td><%=data.getTargetDate()%></td>
					<td><%=data.getTotalInvestmentAmount()%></td>
					<td><%=data.getInvestmentCurrentValue()%></td>
					
					<td><button onclick="onSelectGoal(<%=data.getId()%>)">Select</button></td>
				</tr>
		<%
			}
		}
		%>
  </table>
  
<jsp:include page="../common/common_footer.jsp" /> 


<script>
function onSelectGoal(id) {
  window.location = "CusFinancialPlanDetail?goalId=" + id;
}

function onSelectPortfolio() {
	  window.location = "CusPortfolioList";
}
function onSelectProfile() {
	  window.location = "CusProfileList";
}
</script>
