<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
	<title>Multiplex List</title>
	   <!-- reference our style sheet -->
	       <!-- Required meta tags -->
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
                <h2>Multiplex Info</h2>
            </div>
        </div>
    <br>
        <div class="container">
            <div class="content">

                    <br>

                    <table class="table table-bordered table-striped table-hover">
                    <thead class="thead-dark">
                        <tr class="table-primary">
                            <th>Multiplex Name</th>
                            <th>Multiplex Rating</th>
                            <th>Multiplex Location</th>
                            <th>Movies</th>
                        </tr>
                    </thead>

                        <c:forEach var="tempMultiplex" items="${multiplex}">


                            <tr>
                                <td> ${tempMultiplex.multiplexName} </td>
                                <td> ${tempMultiplex.multiplexRating} </td>
                                <td> ${tempMultiplex.multiplexLocation} </td>
                                <td>
                                <c:forEach var="temp" items="${tempMultiplex.movieList}">
                                        <li> ${temp.movieTitle} </li>
                                </c:forEach>                                </td>

                            </tr>

                        </c:forEach>

                    </table>

            </div>

        </div>
    </div>
</body>

</html>









