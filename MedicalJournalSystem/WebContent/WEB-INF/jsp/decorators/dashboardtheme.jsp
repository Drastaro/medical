<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page errorPage="../pages/500.jsp"%>
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
		<a href="${pageContext.request.contextPath}/" class="logo">
			Medical Journal System </a>
		<nav class="navbar navbar-static-top" role="navigation">

			<div class="navbar-right">
				<ul class="nav navbar-nav">


				</ul>
			</div>
		</nav>
	</header>
	<div class="wrapper row-offcanvas row-offcanvas-left">
		<aside class="left-side sidebar-offcanvas">
			<section class="sidebar">
				<div class="user-panel">
					<sec:authorize access="isAuthenticated()">
						<div class="pull-left info">
							<p>
								<sec:authentication property="principal.username" />
							</p>
							<a href="${pageContext.request.contextPath}/logout">Sign out</a>
						</div>
					</sec:authorize>
				</div>

				<ul class="sidebar-menu">

					<sec:authorize access="isAuthenticated()">
						<li><a href="${pageContext.request.contextPath}/"><i
								class="fa fa-file-text-o" aria-hidden="true"></i><span>Homepage</span>
						</a></li>
						<li><a
							href="${pageContext.request.contextPath}/medicaljournals/search">
								<i class="fa fa-user" aria-hidden="true"></i><span>Medical
									Journals Search</span>
						</a></li>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_PUBLISHER')">
						<li><a
							href="${pageContext.request.contextPath}/medicaljournals/list">
								<i class="fa fa-user" aria-hidden="true"></i><span>Medical
									Journals Admin</span>
						</a></li>

						<li><a href="${pageContext.request.contextPath}/users/list">
								<i class="fa fa-user" aria-hidden="true"></i><span>Users
									admin</span>
						</a></li>
					</sec:authorize>
				</ul>
			</section>
		</aside>

		<aside class="right-side">
			<sitemesh:write property='body' />
		</aside>
	</div>
</body>
</html>