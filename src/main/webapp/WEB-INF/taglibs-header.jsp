<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=gb2312"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="/medqc" />
<script language="javascript"
	src="${ctx}/resources/js/jquery/jquery.min.js"></script>

<script language="javascript"
	src="${ctx}/resources/js/jquery/scrollToTop/jquery.scrollToTop.min.js"></script>


<link href="${ctx}/resources/js/jquery/scrollToTop/style.css"
	rel="stylesheet" />

<link href="${ctx}/resources/js/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<script language="javascript"
	src="${ctx}/resources/js/bootstrap/dist/js/bootstrap.min.js"></script>




<!-- navbar -->

<header>
	<a href="#top" id="toTop"></a>
	<nav class="navbar navbar-default navbar-inverse" role="navigation">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${ctx }/">医疗质控管理</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Link</a></li>
					<li><a href="${ctx}/patient/list">病人列表</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Link</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->

	</nav>
</header>

<!-- end navbar -->
<!-- sidebar -->
<!-- end sidebar -->
<script type="text/javascript">
	$(function() {
		$("#toTop").scrollToTop(500);
	});
</script>
