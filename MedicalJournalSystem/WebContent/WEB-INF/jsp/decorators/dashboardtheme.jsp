<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="../pages/examples/500.jsp"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<jsp:include page="../parts/cachecontrol.jsp"></jsp:include>
<html>
<head>
<title><sitemesh:write property='title' /></title>
<sitemesh:write property='head' />
</head>
<body class="skin-black">
	<!-- header logo: style can be found in header.less -->
	<header class="header">
		<a href="${pageContext.request.contextPath}/" class="logo"> <!-- Add the class icon to your logo image or logo icon to add the margining -->
			AdminLTE
		</a>
		<!-- Header Navbar: style can be found in header.less -->
		<nav class="navbar navbar-static-top" role="navigation">
			<!-- Sidebar toggle button-->
			<a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas"
				role="button"> <span class="sr-only">Toggle navigation</span> <span
				class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
			</a>
			<div class="navbar-right">
				<ul class="nav navbar-nav">

					<sec:authorize access="isAuthenticated()">
						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="glyphicon glyphicon-user"></i><span><sec:authentication
										property="principal.username" /><i class="caret"></i></span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header bg-light-blue"><img
									src="${pageContext.request.contextPath}/resources/img/avatar3.png"
									class="img-circle" alt="User Image" />
									<p>
										<sec:authentication property="principal.username" />
									</p></li>
								<!-- Menu Body -->
								<li class="user-body">
									<div class="col-xs-4 text-center">
										<a href="#">Followers</a>
									</div>
									<div class="col-xs-4 text-center">
										<a href="#">Sales</a>
									</div>
									<div class="col-xs-4 text-center">
										<a href="#">Friends</a>
									</div>
								</li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">Profile</a>
									</div>
									<div class="pull-right">
										<a href="${pageContext.request.contextPath}/logout"
											class="btn btn-default btn-flat">Sign out</a>
									</div>
								</li>
							</ul></li>
					</sec:authorize>
				</ul>
			</div>
		</nav>
	</header>
	<div class="wrapper row-offcanvas row-offcanvas-left">
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="left-side sidebar-offcanvas">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel -->

				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu">
					<li class="active"><a
						href="${pageContext.request.contextPath}/"><i
							class="fa fa-file-text-o" aria-hidden="true"></i><span>Document</span>
					</a></li>
					<li><a href="${pageContext.request.contextPath}/listusers">
							<i class="fa fa-user" aria-hidden="true"></i><span>Users</span>
					</a></li>
					<li><a href="${pageContext.request.contextPath}/medicaljournals/">
							<i class="fa fa-user" aria-hidden="true"></i><span>Medical Journals</span>
					</a></li>
					<li><a href="${pageContext.request.contextPath}/medicaljournals/search">
							<i class="fa fa-user" aria-hidden="true"></i><span>Search Medical Journals</span>
					</a></li>
					
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- Right side column. Contains the navbar and content of the page -->
		<aside class="right-side">
			<sitemesh:write property='body' />
		</aside>
		<!-- /.right-side -->
	</div>
	<!-- ./wrapper -->
</body>
</html>