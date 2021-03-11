<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<body>
	<div class="navbar navbar-expand navbar-dark bg-dark sticky-top">
		<a href="index.jsp" class="navbar-brand">Solo Bit</a>
		<div class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto">
			</ul>
			<form class="form-inline my-2 my-lg-0" action="search.action">
				<input class="form-control mr-sm-2" type="search" name="name" placeholder="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
			<a href="" class="nav-link text-light">Login</a>
			<span class="navbar-text">or</span>
			<a href="" class="nav-link text-light">Register</a>
		</div>
	</div>
	<div class="container-fluid">
		<div class="card">
			<div class="card-body">
				<table class="table">
					<tr class="row">
						<td class="col-5"><img class="img-thumbnail" src="${Laptop.img}"></td>
						<td class="col">
							<h4>${Laptop.model}</h4>
							<p>${Laptop.price}</p>
							<h3>Details:</h3>
							<p>Processor: ${Processor.getModel()}</p>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>