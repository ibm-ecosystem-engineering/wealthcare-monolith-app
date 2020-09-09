<jsp:include page="../common/common_header.jsp" /> 

	
<%@page import="java.util.*"%>
<%@page import="com.gan.wcare.jpa.entity.WcCustomer"%>

<br>
<div class="w3-bar w3-border w3-light-grey">
  <a href="#" class="w3-bar-item w3-button w3-mobile w3-blue">Customer</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile" >Financial Plan</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile"  >Portfolio</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile"  >Profile</a>
</div>

<br>
<div class="w3-panel w3-blue-grey"">
  <h5><b>Customers </b></h5>
</div> 

<% 
List<WcCustomer> list = (List<WcCustomer>) request.getAttribute("mainData"); 
%>

  <table class="w3-table-all">
    <thead>
      <tr class="w3-light-grey">
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>        
        <th>Gender</th>
        <th>Age</th>
        <th>Select</th>
      </tr>
    </thead>
		<%
		if(list != null)  {
			Iterator<WcCustomer> iterator = list.iterator();
			while(iterator.hasNext()) {
				WcCustomer data = iterator.next(); 
		%>
				<tr>
					<td><%=data.getId()%></td>
					<td><%=data.getFirstName()%></td>
					<td><%=data.getLastName()%></td>
					<td><%=data.getGender()%></td>
					<td><%=data.getAge()%></td>
					<td><button onclick="onSelectCustomer(<%=data.getId()%>)">Select</button></td>
				</tr>
		<%
			}
		}
		%>
  </table>

<jsp:include page="../common/common_footer.jsp" /> 


<script>
function onSelectCustomer(customerId) {
  window.location = "WmFinancialPlanList?action=selectCustomer&customerId=" + customerId;
}

</script>
