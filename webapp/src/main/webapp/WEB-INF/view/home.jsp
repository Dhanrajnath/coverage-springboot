<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Home Page</title>
</head>

<body>
	<h2>Home Page</h2>
	<hr>

	<!-- display user name and role -->

	<p>
		User: <security:authentication property="principal.username" />
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	</p>

	<security:authorize access="hasRole('ADMIN')">

		<!-- Add a link to point to /leaders ... this is for the managers -->

		<p>
			<a href="${pageContext.request.contextPath}/multiplex/list">Multiplex list</a>
			(Only for Admin peeps)
		</p>

	</security:authorize>


	<security:authorize access="hasRole('MOVIE')">

		<!-- Add a link to point to /systems ... this is for the admins -->

		<p>
			<a href="${pageContext.request.contextPath}/movie/list">Movie list</a>
			(Only for hotel peeps)
		</p>

	</security:authorize>

	<hr>


	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">

		<input type="submit" value="Logout" />

	</form:form>

</body>

</html>