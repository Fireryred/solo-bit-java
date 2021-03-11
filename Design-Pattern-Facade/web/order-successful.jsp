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
			<h1>Order is Successfull</h1>
			<a href="index.jsp" class="btn btn-primary">Go Back</a>
		</div>
	</div>
</div>
<%@ include file="templates/footer.jsp" %>
</body>
</html>