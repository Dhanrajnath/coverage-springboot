<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>Save Multiplex</title>

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
			<h2>Multiplex</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Multiplex</h3>

		<form:form action="addMultiplex" modelAttribute="multiplex" method="POST">
			<form:hidden path="idMultiplex" />


			<table>
				<tbody>
					<tr>
						<td><label>Multiplex Name:</label></td>
						<td><form:input path="multiplexName" />
						<form:errors path="multiplexName" cssClass="error"/> </td>
					</tr>

					<tr>
						<td><label>Multiplex Rating:</label></td>
						<td><form:input path="multiplexRating" />
						<form:errors path="multiplexRating" cssClass="error"/> </td>
					</tr>

					<tr>
						<td><label>Multiplex Location:</label></td>
						<td><form:input path="multiplexLocation" />
						<form:errors path="multiplexLocation" cssClass="error"/></td>
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
			<a href="${pageContext.request.contextPath}/multiplex/list">Back to List</a>
		</p>

	</div>

</body>

</html>










