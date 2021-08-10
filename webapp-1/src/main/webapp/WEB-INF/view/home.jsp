<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>
	
	<marquee><h3>Welcome to the luv2code company home page!</h3></marquee>
<br>
<hr>
<!-- display user id and role-->
    <p>
        User:  <security:authentication property="principal.username" />
        <br>
        <br>
        Role(s):  <security:authentication property="principal.authorities" />
    </p>
<hr>
<br>

	<security:authorize access="hasRole('MANAGER')">

    		<!-- Add a link to point to /leaders ... this is for the managers -->

    		<p>
    			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
    			(Only for Manager peeps)
    		</p>

    	</security:authorize>


    	<security:authorize access="hasRole('ADMIN')">

    		<!-- Add a link to point to /systems ... this is for the admins -->

    		<p>
    			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
    			(Only for Admin peeps)
    		</p>

    	</security:authorize>

<br>
    <!-- Add a logout button -->
    <form:form action="${pageContext.request.contextPath}/logout"
               method="POST">

          <input data-toggle="tooltip" title="Logout here!" type="submit" value="Logout" />

    </form:form>


</body>

</html>