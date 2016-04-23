<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Medical Journal System</title>
<meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>

<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/AdminLTE.css" rel="stylesheet" type="text/css" />

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
				<div class="box box-primary">
					<div class="box-header">
						<h3 class="box-title">Medical Journals Search</h3>
					</div>
					<div class="box-body table-responsive">
						<c:url var="saveAction" value="/medicaljournals/submit" ></c:url>
					<form method="get" action="${pageContext.request.contextPath}/medicaljournals/search" >
					
						<input type="text" name="q" value="${model.query}"/>
					<button type="submit" class="btn btn-primary">Search</button>
					</form>
					</div>
				</div>
			</div>
			
		</div>
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					
					<div class="box-body table-responsive">
						<table id="searchtable" class="table table-bordered table-hover">
							<thead>
								<tr>
									<th>ID</th>
									<th>TITLE</th>
									<th>DESCRIPTION</th>
									<th>RELEASE DATE</th>
									<th>FILE NAME</th>
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
										<td>${journal.fileName}</td>
										<td>
											<c:choose>
									            <c:when test="${journal.subscribedByCurrentUser==true}">
									               <button type="button" class="btn btn-primary subscribe-btn" style="display: none"id="btn-sub-${journal.id}" data-id="${journal.id}">Subscribe</button>
									               <button type="button" class="btn btn-danger unsubscribe-btn" id="btn-unsub-${journal.id}" data-id="${journal.id}">Unsubscribe</button>
									            </c:when>
									            <c:otherwise>
									               <button type="button" class="btn btn-primary subscribe-btn"  id="btn-sub-${journal.id}" data-id="${journal.id}">Subscribe</button>
									               <button type="button" class="btn btn-danger unsubscribe-btn" style="display: none" id="btn-unsub-${journal.id}" data-id="${journal.id}">Unsubscribe</button>
									            </c:otherwise>
									        </c:choose>
										</td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<th>ID</th>
									<th>TITLE</th>
									<th>DESCRIPTION</th>
									<th>RELEASE DATE</th>
									<th>FILE NAME</th>
									<th>ACTIONS</th>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>


	<script	src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
	<script	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
	<script	src="${pageContext.request.contextPath}/resources/js/AdminLTE/app.js" type="text/javascript"></script>
	
	
	<script type="text/javascript">
		$(function() {
				
				$('.subscribe-btn').on("click",function() {
					$this = $(this);
					$.ajax({
			            url : '${pageContext.request.contextPath}/medicaljournals/subscribe?sub=true&id='+$this.data('id'),
			            success : function(data) {
			                unSubBtnId="#btn-unsub-"+$this.data('id');
			                $(unSubBtnId).show();
			                $this.hide();
			            }
			        });
				});
				$('.unsubscribe-btn').on("click",function() {
					$this = $(this);
					$.ajax({
			            url : '${pageContext.request.contextPath}/medicaljournals/subscribe?sub=false&id='+$this.data('id'),
			            success : function(data) {
			                subBtnId="#btn-sub-"+$this.data('id');
			                $this.hide();
			                $(subBtnId).show();
			            }
			        });
				});
		});
	</script>

</body>
</html>