<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>Movie List</title>

                 <meta charset="utf-8">
                 <meta name="viewport" content="width=device-width, initial-scale=1">

                 <!-- Bootstrap CSS -->
                 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

</head>

<body>
<div class="jumbotron">
    <br>
        <div class="container">
            <div class="header">
                <h2>Movie List</h2>
            </div>
        </div>
    <br>
        <div class="container">
            <div class="content">

                    <button onclick="window.location.href='showFormForAddMovie'; return false;"
                           class="btn btn-info btn-lg" data-toggle="tooltip" title="add movie">
                           Add Movie</button>

                    <br>
                    <br>
                    <table class="table table-bordered table-striped table-hover">
                    <thead class="thead-dark">
                        <tr class="table-primary">
                            <th>Movie Title</th>
                            <th>Movie Type</th>
                            <th>Movie Rating</th>
                            <th>Action</th>
                        </tr>
                    </thead>

                        <!-- loop over and print our movies -->
                        <c:forEach var="tempMovie" items="${movies}">

                             <c:url var="updateLink" value="/movie/showFormForMovieUpdate">
                                <c:param name="movie_id" value="${tempMovie.idMovie}" />
                             </c:url>

                               <c:url var="deleteLink" value="/movie/deleteMovie">
                                            <c:param name="movie_id" value="${tempMovie.idMovie}" />
                                         </c:url>

                            <tr>
                                <td> ${tempMovie.movieTitle} </td>
                                <td> ${tempMovie.movieType} </td>
                                <td> ${tempMovie.movieRating} </td>
                                <td>
                                   <!-- display the update link -->
                                    <a class="btn btn-success btn-sm"
                                    href="${updateLink}">
                                    Update</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a class="btn btn-danger btn-sm"
                                    href="${deleteLink}"
                                    onclick="if (!(confirm('Are you sure you want to delete this movie?'))) return false">
                                    Delete</a>
                                   </td>

                            </tr>

                        </c:forEach>

                    </table>

            </div>

        </div>
    </div>
</body>

</html>









