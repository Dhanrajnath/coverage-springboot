<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>Movie List</title>

                 <meta charset="utf-8">
                 <meta name="viewport" content="width=device-width, initial-scale=1">

                 <!-- Bootstrap CSS -->
                 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
                 <style>
                 .button {
                   border: green;
                   color: green;
                   padding: 10px 22px;
                   text-align: center;
                   text-decoration: none;
                   display: inline-block;
                   font-size: 16px;
                   margin: 1px 2px;
                   transition-duration: 0.4s;
                   cursor: pointer;
                 }
                 .button1:hover {
                   background-color: #4CAF50;
                   color: white;
                 }
                 </style>

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


                    <br>
                    <br>
                    <table class="table table-bordered table-striped table-hover">
                    <thead class="thead-dark">
                        <tr class="table-primary">
                            <th>Movie Title</th>
                            <th>Movie Type</th>
                            <th>Movie Rating</th>
                        </tr>
                    </thead>

                        <!-- loop over and print our movies -->
                        <c:forEach var="tempMovie" items="${multiplex_movie}">


                            <tr>
                                <td> ${tempMovie.movieTitle} </td>
                                <td> ${tempMovie.movieType} </td>
                                <td> ${tempMovie.movieRating} </td>



                            </tr>

                        </c:forEach>

                    </table>

            </div>

        </div>
    </div>
</body>

</html>









