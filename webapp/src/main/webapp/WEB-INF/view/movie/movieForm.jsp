<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>Save Movie</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

    <style>
        .error{
        color:red
        }
    </style>

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Movie</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Movie</h3>

		<form:form action="addMovie" modelAttribute="movie" method="POST">
			<form:hidden path="idMovie" />


			<table>
				<tbody>
					<tr>
						<td><label>Movie Title:</label></td>
						<td><form:input path="movieTitle" />
						<form:errors path="movieTitle" cssClass="error"/> </td>
					</tr>

					<tr>
						<td><label>Movie Type:</label></td>
						<td><form:input path="movieType" />
						<form:errors path="movieType" cssClass="error"/> </td>
					</tr>

					<tr>
						<td><label>Movie Rating:</label></td>
						<td><form:input path="movieRating" />
						<form:errors path="movieRating" cssClass="error"/></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>


				</tbody>
			</table>


		</form:form>

		<div style="clear; both;"></div>

		<p>
			<a href="${pageContext.request.contextPath}/movie/list">Back to List</a>
		</p>

	</div>

</body>

</html>










