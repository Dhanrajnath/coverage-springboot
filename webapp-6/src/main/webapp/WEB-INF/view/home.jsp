<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

<head>
	<title>Home Page</title>
	  <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body>

	<div class="jumbotron jumbotron-fluid">
      <div class="container">
        <h2>Multiplex Info</h2>
      </div>
    </div>
	<marquee><h3>Welcome to the Multiplex Info Page..!</h3></marquee>
<br>
<div class="jumbotron jumbotron-fluid">
  <div class="container">
<!-- display user id and role-->
    <p>
        User:  <security:authentication property="principal.username" />
        <br>
        <br>
        Role(s):  <security:authentication property="principal.authorities" />
    </p>
<hr>
<br>

    <security:authorize access="hasRole('USER')">

        <!-- Add a link to point to /systems ... this is for the admins -->

        <p>
            <a href="${pageContext.request.contextPath}/user/showInfo">Goto multiplex Info ...</a>
        </p>

    </security:authorize>

	<security:authorize access="hasRole('MOVIE')">

    		<!-- Add a link to point to /leaders ... this is for the managers -->

    		<p>
    			<a href="${pageContext.request.contextPath}/movie/list">Goto movie list</a>
    		</p>

    	</security:authorize>


    	<security:authorize access="hasRole('ADMIN')">

    		<!-- Add a link to point to /systems ... this is for the admins -->

    		<p>
    			<a href="${pageContext.request.contextPath}/multiplex/list">Goto multiplex list</a>
    		</p>

    	</security:authorize>

<br>
    <!-- Add a logout button -->
    <form:form action="${pageContext.request.contextPath}/logout"
               method="POST">

          <input data-toggle="tooltip" title="Logout here!" type="submit" value="Logout" />

    </form:form>
</div>
</div>

</body>

</html>