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
			<div class="row">
				<div class="col">
					<div class="row">
						<div class="col-2"></div>
						<div class="col">
							<form class="form" method="post" action="checkout-process.action">
								<div class="form-group">
									<label for="creditCardNumber">Credit Card Number</label>
									<input class="form-control ${card.isInvalidCC}" type="text" name="creditCardNumber" id="creditCardNumber" placeholder="1313-2424-3535-4646">
									<div class="invalid-feedback">Invalid Credit Card Number</div>
								</div>
								<div class="form-group">
									<label for="expirationDate">Expiration Date</label>
									<div class="row">
										<div class="col-sm-3">
											<input class="form-control ${card.isInvalidExp}" type="number" name="month" id="month" placeholder="mm" max="99">
										</div>
										<div class="col-sm-1">/</div>
										<div class="col-sm-3">	
											<input class="form-control ${card.isInvalidExp}" type="number" name="year" id="year" placeholder="yy" max="99">
										</div>
									</div>
									<label for="cvv">CVV</label>
									<div class="row">
										<div class="col-3">
											<input type="text" name="cvv" id="cvv" class="form-control">
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="address">Address</label>
									<input type="text" name="address" id="address" class="form-control" placeholder="Address" required>
								</div>
								<div class="form-group">
									<input type="submit" class="btn btn-primary" value="Place Order">
								</div>
							</form>
						</div>
						<div class="col-2"></div>
					</div>
				</div>
				<div class="col">
					<h4 class="d-inline">Cart Summary</h4>
					<a href="view-cart.action" class="d-inline card-link">edit</a>
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
								<th class="col d-flex justify-content-center">Quantity</th>
								<th class="col d-flex justify-content-center">Product</th>
								<th class="col d-flex justify-content-center">Total</th>
							</tr>
						</thead>
						<tbody>
					<%
							do {
								double price = product.getDouble("price");
								int quantity = product.getInt("quantity");
								double productOfPrice = price * quantity;
								String img = product.getString("img");
								String name = product.getString("name");
					%>
							<tr class="row">
									<td class="col d-flex align-items-center justify-content-center">
										<%=quantity %>
									</td>
									<td class="col">
										<img class="img-thumbnail" src=<%=img %>>
									</td>
									
									<td class="col d-flex align-items-center justify-content-center">
										<h6><%=name %></h6>
									</td>
									<td class="col d-flex align-items-center justify-content-center">
										<%=productOfPrice %>
									</td>
								</tr>
						</tbody>
					<%	
							} while(product.next());
					%>
								<tr class="row">
									<td class="col d-flex justify-content-end">
										Sub Total:<h6>${sum}</h6>
									</td>
								</tr>
							</tbody>
						</table>
					<%
						} 
					%>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="templates/footer.jsp" %>
</body>
</html>