	<div class="navbar navbar-expand navbar-dark bg-dark sticky-top">
		<a href="index.jsp" class="navbar-brand">Solo Bit</a>
		<div class="collapse navbar-collapse">
			<ul class="navbar-nav mr-auto">
			</ul>
			<form class="form-inline my-2 my-lg-0" action="search.action" method="GET">
				<input class="form-control mr-sm-2" type="search" name="name" placeholder="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
			<span class="dropdown">
				<a href="" class="nav-link text-light dropdown-toggle" data-toggle="dropdown"><%=session.getAttribute("username") %></a>
				<div class="dropdown-menu dropdown-menu-right">
					<a href="" class="dropdown-item">Account</a>
					<a href="view-cart.action" class="dropdown-item">View Cart</a>
					<a href="logout.action" class="dropdown-item">Logout</a>
				</div>
			</span>
		</div>
	</div>