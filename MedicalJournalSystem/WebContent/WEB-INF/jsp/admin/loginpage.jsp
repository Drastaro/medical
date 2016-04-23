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

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<div class="header">Sign In</div>
		<form method="post"
			action="<c:url value='/j_spring_security_check' />">
			<c:if test="${param.error != null}">
				<div class="alert alert-danger">
					<p>Invalid email or password.</p>
				</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-info">
					<p>You have been logged out successfully.</p>
				</div>
			</c:if>
			<div class="body bg-gray">
				<div class="form-group">
					<input type="text" name="email" class="form-control"
						placeholder="Email" />
				</div>
				<div class="form-group">
					<input type="password" name="password" class="form-control"
						placeholder="Password" />
				</div>
			</div>
			<div class="footer">
				<button type="submit" class="btn btn-block btn-primary">Sign me in</button>

			</div>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

		
	</div>


	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"
		type="text/javascript"></script>

</body>
</html>