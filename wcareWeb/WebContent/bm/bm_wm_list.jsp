
<jsp:include page="../common/common_header.jsp" />  

  
<%@page import="java.util.*"%>
<%@page import="com.gan.wcare.jpa.entity.WcWealthManager"%>

<br>
<div class="w3-bar w3-border w3-light-grey">
  <a href="#" class="w3-bar-item w3-button w3-mobile " onclick="return onSelectCustomer();">Customers</a>
  <a href="#" class="w3-bar-item w3-button w3-mobile w3-blue">Wealth Managers</a>
</div>

<br>
<div class="w3-panel w3-blue-grey"">
  <h5><b>Wealth Managers </b></h5>
</div> 


<% 
List<WcWealthManager> list = (List<WcWealthManager>) request.getAttribute("mainData"); 
%>

  <table class="w3-table-all">
    <thead>
      <tr class="w3-light-grey">
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>        
        <th>Gender</th>
      </tr>
    </thead>
		<%
		if(list != null)  {
			Iterator<WcWealthManager> iterator = list.iterator();
			while(iterator.hasNext()) {
				WcWealthManager data = iterator.next(); 
		%>
				<tr>
					<td><%=data.getId()%></td>
					<td><%=data.getFirstName()%></td>
					<td><%=data.getLastName()%></td>
					<td><%=data.getGender()%></td>
				</tr>
		<%
			}
		}
		%>
  </table>
  
<jsp:include page="../common/common_footer.jsp" />  

</html>


<script>
function onSelectCustomer(id) {
  window.location = "BmCustomerList";
}
</script>
