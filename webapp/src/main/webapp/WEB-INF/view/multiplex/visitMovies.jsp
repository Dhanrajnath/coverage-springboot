<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>Movie List</title>
	   <!-- reference our style sheet -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <style>
           html, body{
           	margin-left:15px; margin-right:15px;
           	padding:0px;
           	font-family:Verdana, Arial, Helvetica, sans-serif;
           }

            th {
            	border-bottom:1px solid gray;
            	background:none repeat scroll 0 0 #09c332;
            	padding:10px;
            	color: #FFFFFF;
            }

            tr {
            	border-top:1px solid gray;
            	text-align:center;
            }
        </style>

</head>

<body>

	<div id="wrapper">
		<div id="header">
		    <br>
			<h2>Movie List</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">

      			<br>

                <table>
                    <tr>
                        <th>Movie Title</th>
                        <th>Movie Type</th>
                        <th>Movie Rating</th>
                        <th>Action</th>
                    </tr>

                    <!-- loop over and print our movies -->
                    <c:forEach var="tempMovie" items="${movies}">
                         <c:url var="visitLink" value="/multiplex/addMovie">
                            <c:param name="movie_id" value="${tempMovie.idMovie}" />
                         </c:url>

                        <tr>
                            <td> ${tempMovie.movieTitle} </td>
                            <td> ${tempMovie.movieType} </td>
                            <td> ${tempMovie.movieRating} </td>
                            <td> ${tempMovie.addMovie} </td>

                        </tr>

                    </c:forEach>

                </table>

		</div>

	</div>
</body>

</html>









