<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SoloBit Search for ${name}</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<body>
	<div class="navbar navbar-expand navbar-dark bg-dark sticky-top">
		<a href="index.jsp" class="navbar-brand">Solo Bit</a>
		<div class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto">
			</ul>
			<form class="form-inline my-2 my-lg-0" action="search.action" method="GET">
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
				<table>
				<%
					ResultSet product = (ResultSet) request.getAttribute("product");
					if(!product.next()){
				%>
				<h5>No result found</h5>	
				<%
					}else{
						do{				
				%>
					<tr class="row">
						<td class="col-2">
							<a href="product.action?name=${product.getString("name")}">
								<img class="img-thumbnail h-75 w-100" src=${product.getString("img")}>
							</a>
						</td>
						<td class="col">
							<a class="text-dark card-link" href="product.action?name=${product.getString("name")}">
								<br><br>
								<h6>${product.getString("name")}</h6>
								<p>${product.getDouble("price")}</p>
							</a>
						</td>
					</tr>
				<%
						}while(product.next());
					}
				%>
				</table>
			</div>
		</div>
	</div>
</body>
</html>