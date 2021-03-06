 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!--  Bootstrap Integration -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
	crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Customer Data</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="gl">GL</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
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

	<div class="container">
		<br />
		<div class="col-sm">
			<a href="addcustomer?id=-1">
				<button type="button" class="btn btn-primary">Add Customer</button>
			</a>
		</div>
		<br />
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<!--  <th scope="col">ID</th> -->
					<th scope="col">First_Name</th>
					<th scope="col">Last_Name</th>
					<th scope="col">Email</th>
					<th scope="col">Action</th>
				</tr>

			</thead>
			<c:forEach items="${cust}" var="b">
				<tbody>
					<tr>

						<!--      <td>${b.id}</td>  -->
						<td>${b.firstName}</td>
						<td>${b.lastName}</td>
						<td>${b.email }</td>
						<td><a href="addcustomer?id=${b.id}">Update || </a><a
							href="delete?id=${b.id}"
							onclick="return confirm('Are you sure you want to delete this item?');">Delete</a></td>
					</tr>

				</tbody>
			</c:forEach>
		</table>

	</div>
</body>
</html>