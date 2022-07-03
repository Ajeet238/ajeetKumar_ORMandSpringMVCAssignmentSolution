<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student Data</title>

<!--  Bootstrap Integration -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>


</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="gl">GL</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
    </ul>
  <!--
     <form class="form-inline my-2 my-lg-0" action = "search" method="post" >
      
      <tr> <td>First Name</td> <td> <input type="text" name="firstName"></td>
      		 <td>Last Name</td> <td> <input type="text" name="lastName"></td>
      		 <td>Country</td> <td> <input type="text" name="country"></td>
      		 <td colspan = "2">  <button class="btn btn-outline-success my-2 my-sm-0" type="submit" style = "color:white">Search</button> </td>
      </tr>
     </form> 
   -->
  </div>
</nav>
<br />
<div class="container">
<form action ="save" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">FirstName</label>
    <input type="text" class="form-control" placeholder="Enter email" value="${addNewStud.firstName}" name="firstName">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">LastName</label>
    <input type="text" class="form-control" placeholder="Last Name" value="${addNewStud.lastName}" name="lastName">
  </div>
   <div class="form-group">
    <label for="exampleInputPassword1">Email</label>
    <input type="email" class="form-control" placeholder="Email"  value="${addNewStud.email}" name="email">
  </div>
 
  <button type="submit" class="btn btn-primary" value='${addNewStud.id}' name="id">Submit</button>
</form>
</div>
</body>
</html>