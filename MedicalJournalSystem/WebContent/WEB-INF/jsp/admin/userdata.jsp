<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Medical Journal System</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/css/AdminLTE.css"
	rel="stylesheet" type="text/css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.${pageContext.request.contextPath}/resources/js/1.3.0/respond.min.js"></script>
        <![endif]-->
</head>
<body>

	<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box box-primary">
					<div class="box-header">
						<h3 class="box-title">Users</h3>
					</div>
					<div class="box-body table-responsive">
						<table id="example1" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>ID</th>
									<th>EMAIL</th>
									<th>ACTIONS</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="user" items="${modele.users}" varStatus="status">
									<tr>
										<td>${user.id}</td>
										<td>${user.email}</td>
										<td><a href="${pageContext.request.contextPath}/users/delete/${user.id}" class="btn btn-danger userdata-btn btn-delete">DELETE</a></td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<th>ID</th>
									<th>EMAIL</th>
									<th>ACTIONS</th>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
			</div>
			<div class="container btn-container">
				<a href="${pageContext.request.contextPath}/users/add"
					class="btn userdata-btn btn-primary">ADD NEW USER</a>
			</div>
		</div>
	</section>



	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/AdminLTE/app.js"
		type="text/javascript"></script>
	
	<!-- page script -->
	<script type="text/javascript">
		
	</script>

</body>
</html>