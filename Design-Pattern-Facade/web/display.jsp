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
				<table class="table">
					<tr class="row">
						<td class="col-5"><img class="img-thumbnail" src="${Laptop.img}"></td>
						<td class="col">
							<h4>${Laptop.model}</h4>
							<p>${Laptop.price}</p>
							<h3>Details:</h3>
							<p>Processor: ${Processor.getModel()}</p>
							<form class="form" action="add-to-cart.action" method="post">
								<div class="form-group">
									<input type="text" name="name" value="${Laptop.model}" class="d-none">
									<label for="qty">Quantity:</label>
									<div class="input-group col-3 p-0">
										<input type="number" name="qty" id="qty" min="1" value="1" class="form-control">
										<div class="input-group-append">
										<%
											if(session.getAttribute("username") == null){
										%>
											<input type="submit" class="btn btn-primary" disabled value="Add to cart">
										</div>
										<div>
											<p>Please login</p>
										<%
											} else {
										%>
											<input type="submit" class="btn btn-primary" ${product.hasOrdered} value="Add to cart">
										<%
											}
										%>
										</div>
									</div>
								</div>
							</form>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<%@ include file="templates/footer.jsp" %>
</body>
</html>