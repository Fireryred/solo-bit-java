<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Solobit</title>
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
					<thead>
						<tr class=row>
							<th class=col>HP Laptops</th>
						</tr>
					</thead>
					<tbody>
						<tr class=row>
							<td class="col">
								<a href= "product.action?name=spectre">
									<p>HP Spectre x360</p>
									<img class="img-thumbnail h-25" src="https://cdn.mos.cms.futurecdn.net/BWsKGDUhVnQCYUykJSmHxK-970-80.jpg.webp"><!-- Image Link -->
									<p>Php 79,990.00</p>
								</a>
							</td>
							<td class="col">
								<a href= "product.action?name=envy">
									<p>HP Envy x360 1040</p>
									<img class="img-thumbnail h-25" src="https://cdn.mos.cms.futurecdn.net/j6ndSR6hKav95QT83beRB4-970-80.jpg.webp"><!-- Image Link -->
									<p>Php 54,995.00</p>
								</a>
							</td>
							<td class="col">
								<a href= "product.action?name=elite">
									<p>HP Elite Dragonfly</p>
									<img class="img-thumbnail h-25" src="https://cdn.mos.cms.futurecdn.net/347jbCQnSqziigoDYZssr9-970-80.jpg.webp"><!-- Image Link -->
									<p>Php 81,440.00</p>
								</a>
							</td>
							<td class="col">
								<a href= "product.action?name=omen" >
									<p>HP Omen 15</p>
									<img class="img-thumbnail h-25" src="https://cdn.mos.cms.futurecdn.net/YWCwFSLwSi3CPGrvkjqd2Q-970-80.jpg.webp"><!-- Image Link -->
									<p>Php 67,990.00</p>
								</a>
							</td>
							<td class="col">
								<a href= "product.action?name=chromebook">
									<p>HP Chromebook 14</p>
									<img class="img-thumbnail h-25" src="https://cdn.mos.cms.futurecdn.net/g3wPJLSxNpGnv9PZGLHomH-970-80.jpg.webp"><!-- Image Link -->
									<p>Php 17,850.00</p>
								</a>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%@ include file="templates/footer.jsp" %>
</body>
</html>