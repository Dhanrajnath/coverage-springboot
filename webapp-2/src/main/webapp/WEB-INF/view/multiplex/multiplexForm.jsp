<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>Save Multiplex</title>

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
                <h2>Multiplex</h2>
            </div>
		</div>
	</div>
    <br>
    <br>
	<div class="form-group">
	    <div class="container">
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
                            <td><label>Select Movies:</label></td>
                            <td></td>
                        </tr>
                        <tr>
                            <table class="table table-bordered table-striped table-hover">
                                <thead class="thead-dark">
                                    <tr class="table-primary">
                                        <th>Movie Title</th>
                                        <th>Movie Type</th>
                                        <th>Movie Rating</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>

                                <c:forEach var="tempMovie" items="${movies}">

                                    <tr>
                                        <td> ${tempMovie.movieTitle} </td>
                                        <td> ${tempMovie.movieType} </td>
                                        <td> ${tempMovie.movieRating} </td>
                                        <td>
                                           <form:checkbox path="movieList" value="${tempMovie}" /><br>
                                        </td>

                                    </tr>

                                </c:forEach>

                            </table>

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
    </div>

</body>

</html>
