<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>Save Movie</title>
	   <!-- reference our style sheet -->
	       <!-- Required meta tags -->
           <meta charset="utf-8">
           <meta name="viewport" content="width=device-width, initial-scale=1">

           <!-- Bootstrap CSS -->
           <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
            <style>

                .error{
                color:red
                }

            </style>


</head>

<body>
<br>
	<div class="form-group">
	    <div class="container">
            <div class="header">
                <h2>Movie</h2>
            </div>
		</div>
	</div>
                    <br>
                    <br>
	<div class="form-group">
	    <div class="container">
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
   </div>
</body>

</html>










