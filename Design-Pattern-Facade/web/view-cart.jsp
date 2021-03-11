<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.ResultSet"%>
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
			<h1>View Cart</h1>
			<%
					ResultSet product = (ResultSet) request.getAttribute("records");
					if(!product.next()){
			%>
			<p>No product has been added to the cart</p>	
			<%
				}else{		
			%>
			<table class="table">
				<thead>
					<tr class="row">
						<th class="col"></th>
						<th class="col d-flex justify-content-center">Product</th>
						<th class="col d-flex justify-content-center">Price</th>
						<th class="col d-flex justify-content-center">Quantity</th>
						<th class="col d-flex justify-content-center">Total</th>
						<th class="col"></th>
					</tr>
				</thead>
			<%
					do {
						double price = product.getDouble("price");
						int quantity = product.getInt("quantity");
						double productOfPrice = price * quantity;
						String img = product.getString("img");
						String name = product.getString("name");
			%>
				<tbody>
					<tr class="row">
						<td class="col">
							<img class="img-thumbnail" src=<%=img %>>
						</td>
						<td class="col d-flex align-items-center justify-content-center">
							<h6><%=name %></h6>
						</td>
						<td class="col d-flex align-items-center justify-content-center"><%=price %></td>
						<td class="col d-flex align-items-center justify-content-center">
							<form action="view-cart-update.action" method="post">
								<input type="number" class="d-none"name="id" value=<%=name %>>
								<input class="form-control" type="number" min="1" value=<%=quantity %> name="qty">
								<input type="submit" class="btn btn-primary" value="Update">
							</form>
						</td>
						<td class="col d-flex align-items-center justify-content-center">
							<form action="view-cart-delete" method="post">
								<%=productOfPrice %>
							</form>
						</td>
						<td class="col d-flex align-items-center justify-content-center">
							<form action="view-cart-delete.php" method="post">
								<input type="number" class="d-none"name="id" value=<%=name %>>
								<input type="submit" class="btn btn-primary" value="Remove">
							</form>
						</td>
					</tr>
			<%	
					} while(product.next());
			%>
				</tbody>
			</table>
			<div class="row">
				<div class="col-6"></div>
				<div class="col">
					<h2>Cart Total</h2>
					<table class="table">
						<tr class="row">
							<td class="col-3"><h6>Total</h6></td>
							<td class="col-3"><%=request.getAttribute("sum")%></td>
						</tr>
					</table>
					<form action="checkout.action" method="post">
						<input type="submit" class="btn btn-primary" value="Proceed to Checkout">
					</form>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
</div>
<%@ include file="templates/footer.jsp" %>
</body>
</html>