<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SoloBit Search for ${name}</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<body>
<% session.invalidate(); %>
<%@ include file = "templates/header-guest.jsp" %>
	<div class="container">
		<div class="card">
			<div class="card-body">
				<form class="form-signin" method="post" action="login.action">
					<h4>Login</h4>
					<div class="form-group">
						<label for="username">Username</label>
						<input type="text" name="username" id="username" class="form-control ${user.isUserValid}" placeholder="Username" required autofocus>
					</div>
					<div class="form-group">
						<label for="password">Password</label>
						<input type="password" name="password" id="password" class="form-control ${user.isUserValid}" placeholder="Password" required>
						<div class="invalid-feedback">Wrong username and password</div>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
				</form>
				<div>
					<span>No account yet? Click <a href="register.php" class="btn-link">here</a> to register</span>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="templates/footer.jsp" %>
</body>
</html>