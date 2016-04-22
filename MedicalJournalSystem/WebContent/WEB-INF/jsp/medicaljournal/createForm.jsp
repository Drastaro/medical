<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>AdminLTE | Dashboard</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="${pageContext.request.contextPath}/resources/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="${pageContext.request.contextPath}/resources/css/AdminLTE.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/datepicker/datepicker3.css">
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
  

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.${pageContext.request.contextPath}/resources/js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>

	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Upload New Medical Journal
		</h1>
		
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<!-- left column -->
			<div class="col-md-12">
				<!-- general form elements -->
				<div class="box box-primary">
					<div class="box-header">
						<h3 class="box-title"></h3>
					
					<form:form method="post" modelAttribute="journal" action="submit">
						<form:hidden path="id" />
						<div class="box-body">
							<div class="form-group">
								<label for="title">Title</label> 
								<input type="text" class="form-control" id="title" name="title"
									placeholder="Enter journal title" >
							</div>
							<div class="form-group">
								<label for="description">Description</label> 
								<input type="text" class="form-control" id="description" name="description"
									placeholder="Enter journal description" >
							</div>
							<div class="form-group">
								<label for="inputFile">Journal file (*.pdf)</label> <input
									type="file" id="inputFile">
							</div>
							<!-- Date range -->
						<div class="form-group">
							<label>Release date:</label>
							<div class="input-group">
								<div class="input-group-addon">
									<i class="fa fa-calendar"></i>
								</div>
								<input type="text" class="form-control pull-right" name="releaseDate"
									id="releaseDate" />
							</div>
							<!-- /.input group -->
						</div>
						<!-- /.form group -->
							
						</div>
						

						<div class="box-footer">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</form:form>
				</div>
				


			</div>
		
			
		</div>
		<!-- /.row -->
	</section>
	<!-- /.content -->
	<!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
            <!-- Bootstrap -->
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- AdminLTE App -->
        <script src="${pageContext.request.contextPath}/resources/js/AdminLTE/app.js" type="text/javascript"></script>
     
   
   <!-- bootstrap datepicker -->
        <!-- date-range-picker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/daterangepicker/daterangepicker.js"></script>
<!-- bootstrap datepicker -->
<script src="${pageContext.request.contextPath}/resources/js/plugins/datepicker/bootstrap-datepicker.js"></script>
   
   
   <script type="text/javascript">
		$(function() {
			//Date picker
		    $('#releaseDate').datepicker({
		      autoclose: true
		    });

		});
	</script>
   
   
   
    </body>
</html>