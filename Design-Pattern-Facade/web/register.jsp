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
				<form class="form-signin" method="post" action="register.action">
					<h4>Register</h4>
						<div class="form-group">
							<label for="username">Username</label>
							<input type="text" name="username" id="username" class="form-control ${user.isUserValid}" placeholder="Username" required autofocus>
							<div class="invalid-feedback">The Username is already taken</div>
						</div>
						
						<div class="form-group">
							<label for="password">Password</label>
							<input type="password" name="password" id="password" class="form-control ${user.isPassValid}" placeholder="Password" required>
							<div class="invalid-feedback">The password must be minimum eight characters, at least one uppercase letter, one lowercase letter and one number</div>
						</div>
						
						<div class="form-group">
							<label for="confirmPassword">Confirm Password</label>
							<input type="password" name="confirmPassword" id="confirmPassword" class="form-control ${user.isConPassValid}" placeholder="Confirm Password" required>
							<div class="invalid-feedback">Confirm Password must be the same as Password</div>
						</div>
						
						<div class="form-group">
							<label for="email">Email Address</label>
							<input type="email" name="email" id="email" class="form-control ${user.isEmailValid}" placeholder="Email Address" required>
							<div class="invalid-feedback">Invalid-Email</div>
						</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
				</form>
				<div>
					<span>Already Registered? Click <a href="login.php" class="btn-link">here</a> to login</span>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="templates/footer.jsp" %>
</body>
</html>