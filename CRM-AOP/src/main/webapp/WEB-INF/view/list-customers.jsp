<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>

	<!-- reference our style sheet -->
    <link type="image/icon type"
          rel="icon"
          href="${pageContext.request.contextPath}/resources/icon/crm_icon.png"
          sizes="32x32" />
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>
	<div id="wrapper">
			<marquee>CRM - Customer Relationship Manager</marquee>
	</div>


	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">
		<h5> Click the button to create a new Customer! </h5>
		    <input type="button" value="Add Customer"
		           onclick="window.location.href='showFormForAdd'; return false;"
		            class="add-button"/>

			<!--  add our html table here -->
            <h4> List of Customers </h4>
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
				    <!-- construct an "update" link with each customer -->
				    <c:url var="updateLink" value="/customer/showFormForUpdate" >
				        <c:param name="customerId" value="${tempCustomer.id}" />
                    </c:url>
                    <!-- construct an "delete" link with each customer -->
                    <c:url var="deleteLink" value="/customer/delete" >
                        <c:param name="customerId" value="${tempCustomer.id}" />
                    </c:url>

					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<td> <a href="${updateLink}">Update</a> |
						     <a href="${deleteLink}"
						     onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">
						     Delete</a> </td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>


</body>

</html>