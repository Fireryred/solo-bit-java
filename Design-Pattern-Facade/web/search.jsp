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
<%
	if(session.getAttribute("username") == null){
%>
	<%@ include file="templates/header-guest.jsp" %>
<%
	} else {
%>
	<%@ include file="templates/header-users.jsp" %>		
<%
	}
%>
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
	<%@ include file="templates/footer.jsp" %>
</body>
</html>