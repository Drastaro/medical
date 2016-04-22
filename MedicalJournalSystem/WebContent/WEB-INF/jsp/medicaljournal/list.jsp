<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Medical Journal System</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>

<!-- bootstrap 3.0.2 -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<!-- font Awesome -->
<link
	href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="${pageContext.request.contextPath}/resources/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />
<!-- DATA TABLES -->
<link
	href="${pageContext.request.contextPath}/resources/css/datatables/dataTables.bootstrap.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
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

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">Registered Medical Journals</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body table-responsive">
						<table id="example1" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>ID</th>
									<th>TITLE</th>
									<th>DESCRIPTION</th>
									<th>RELEASE DATE</th>
									<th>ACTIONS</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="journal" items="${model.journals}" varStatus="status">
									<tr>
										<td>${journal.id}</td>
										<td>${journal.title}</td>
										<td>${journal.description}</td>
										<td>${journal.releaseDate}</td>
										<td><a href="${pageContext.request.contextPath}/medicaljournals/edit?id=${journal.id}"
											class="btn btn-warning userdata-btn btn-edit">EDIT</a><a
											href="${pageContext.request.contextPath}/medicaljournals/delete?id=${journal.id}"
											class="btn btn-danger userdata-btn btn-delete">DELETE</a></td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<th>ID</th>
									<th>TITLE</th>
									<th>DESCRIPTION</th>
									<th>RELEASE DATE</th>
									<th>ACTIONS</th>
								</tr>
							</tfoot>
						</table>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->
			</div>
			<div class="container btn-container">
				<a href="${pageContext.request.contextPath}/medicaljournals/add"
					class="btn btn-success userdata-btn btn-delete">ADD NEW JOURNAL</a>
			</div>
		</div>
	</section>
	<!-- /.content -->



	<!-- jQuery 2.0.2 -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- DATA TABES SCRIPT -->
	<script
		src="${pageContext.request.contextPath}/resources/js/plugins/datatables/jquery.dataTables.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/plugins/datatables/dataTables.bootstrap.js"
		type="text/javascript"></script>
	<!-- AdminLTE App -->
	<script
		src="${pageContext.request.contextPath}/resources/js/AdminLTE/app.js"
		type="text/javascript"></script>
	
	<!-- page script -->
	<script type="text/javascript">
		$(function() {
			$("#example1").dataTable();
			$('#example2').dataTable({
				"bPaginate" : true,
				"bLengthChange" : false,
				"bFilter" : false,
				"bSort" : true,
				"bInfo" : true,
				"bAutoWidth" : false
			});
		});
	</script>

</body>
</html>