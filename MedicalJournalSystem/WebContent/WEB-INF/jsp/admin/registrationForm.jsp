<!DOCTYPE html>
<html class="bg-black">
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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.${pageContext.request.contextPath}/resources/js/1.3.0/respond.min.js"></script>
        <![endif]-->
</head>
<body class="bg-black">

	<div class="form-box" id="login-box">
		<div class="header">Register User</div>

		<form:form method="post" modelAttribute="command" action="submituser">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<div class="body bg-gray">
				<form:hidden path="id" />
				<div class="form-group">
					<input type="email" name="email" class="form-control"
						placeholder="Email" />
				</div>
				<div class="form-group">
					<input type="password" name="password" class="form-control"
						placeholder="Password" />
					<form:errors path="password" cssClass="error" />

				</div>
				<div class="form-group">
					<input type="password" name="confirm-password" class="form-control"
						placeholder="Confirm Password" />

				</div>
				<!-- Split button -->
				<div class="btn-group">
					<form:select path="userRole">
						<label>User Role</label>
						<form:option value="">Select Role</form:option>
						<form:option value="ROLE_PUBLISHER">PUBLISHER</form:option>
						<form:option value="USER">USER</form:option>
					</form:select>
				</div>

				<div class="footer">
					<br>
					<button type="submit" value="Save"
						class="btn btn-block btn-primary">Register</button>

				</div>
			</div>
		</form:form>
	</div>


	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"
		type="text/javascript"></script>

</body>
</html>