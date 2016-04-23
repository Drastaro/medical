<!DOCTYPE html>
<html>
<head>
<title>Medical Journal System</title>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/resources/css/AdminLTE.css"
	rel="stylesheet" type="text/css" />

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
						<h3 class="box-title">Medical Journal system</h3>
					</div>
					<div class="box-body">
						<p>Welcome to the Medical Journal System.</p>
						<p>
							If you are logged in as a USER you can do the following actions:
							<ul>
								<li>Search for medical journals</li>
								<li>Subscribe/unsubscribe to medical journals</li>
							</ul>
						</p>
						<p>
							Using the desktop application MedicalJournalDesktopClient you can read the Medical journals you have subscribed to.
						</p>
						<p>
							If you are logged in as a PUBLISHER (admin) you can do the following actions:
							<ul>
								<li>Manage medical journals (add/edit/delete)</li>
								<li>Manage users</li>
							</ul>
						</p>
					
					</div>
				</div>
			</div>
			
		</div>
	</section>


	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.10.3.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/AdminLTE/app.js"
		type="text/javascript"></script>
</body>
</html>