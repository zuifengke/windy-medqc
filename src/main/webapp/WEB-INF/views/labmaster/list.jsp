<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=gb2312" pageEncoding="GB2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx_patient_list" value="/medqc/patient/userlist" />
<html>
<head>
<title>Detail Admin - Home</title>
<!-- bootstrap -->


<!-- open sans font -->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css' />

<!-- lato font -->
<link
	href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900,300italic,400italic,700italic,900italic'
	rel='stylesheet' type='text/css' />

<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

	<%@ include file="/WEB-INF/taglibs-header.jsp"%>


	<!-- main container -->
	<div class="content">

		<!-- settings changer -->
		<div class="skins-nav">
			<a href="#" class="skin first_nav selected"> <span class="icon"></span><span
				class="text">Default</span>
			</a> <a href="#" class="skin second_nav" data-file="css/skins/dark.css">
				<span class="icon"></span><span class="text">Dark skin</span>
			</a>
		</div>

		<div class="container-fluid">
			<div id="pad-wrapper" class="users-list">
				<div class="row-fluid header">
					<h3>病人列表</h3>
					<div class="span10 pull-right">
						<input type="text" class="span5 search"
							placeholder="Type a user's name..." /> <a class="btn-flat small"
							onClick="exportToExcel()">导出excel</a>
						<!-- custom popup filter -->
						<!-- styles are located in css/elements.css -->
						<!-- script that enables this dropdown is located in js/theme.js -->
						<div class="ui-dropdown">
							<div class="head" data-toggle="tooltip" title="Click me!">
								Filter users <i class="arrow-down"></i>
							</div>
							<div class="dialog">
								<div class="pointer">
									<div class="arrow"></div>
									<div class="arrow_border"></div>
								</div>
								<div class="body">
									<p class="title">Show users where:</p>
									<div class="form">
										<input type="text" /> <a class="btn-flat small">Add
											filter</a>

									</div>
								</div>
							</div>
						</div>

						<a href="new-user.html" class="btn-flat success pull-right"> <span>&#43;</span>
							NEW USER
						</a>
					</div>
				</div>

				<!-- Users table -->
				<div class="row-fluid table">
					<table class="table table-hover">
						<thead>
							<tr>

								<th class="span3 sortable"><span class="line"></span> 病人ID号
								</th>
								<th class="span2 sortable"><span class="line"></span>就诊次</th>
								<th class="span3 sortable "><span class="line"></span>测试号
								</th>
								<th class="span3 sortable"><span class="line"></span>项目</th>
								<th class="span3 sortable "><span class="line"></span>标本</th>
								<th class="span3 sortable "><span class="line"></span>申请时间</th>
								<th class="span2 sortable "><span class="line"></span>申请医生</th>
								<th class="span2 sortable "><span class="line"></span>结果</th>
								<th class="span2 sortable "><span class="line"></span>报告时间</th>
								<th class="span2 sortable "><span class="line"></span>报告医生</th>

							</tr>
						</thead>

						<tbody>
							<!-- row -->
							<c:forEach items="${labMasters}" var="p">
								<tr>

									<td><c:out value="${p.patientID}" /></td>
									<td><c:out value="${p.visitID}" /></td>
									<td><c:out value="${p.testID}" /></td>
									<td><c:out value="${p.subject}" /></td>
									<td><c:out value="${p.specimen}" /></td>
									<td><c:out value="${p.requestTime}" /></td>
									<td><c:out value="${p.requestDoctor}" /></td>
									<td><c:out value="${p.resultStatus}" /></td>
									<td><c:out value="${p.reportTime}" /></td>
									<td><c:out value="${p.reportDoctor}" /></td>
								</tr>
							</c:forEach>


						</tbody>

					</table>
				</div>
			
				<!-- end users table -->
			</div>
		</div>
	</div>
	<!-- end main container -->

	<!-- this page specific styles -->
	<link rel="stylesheet"
		href="${ctx}/resources/css/compiled/user-list.css" type="text/css"
		media="screen" />

	<script type="text/javascript">
		//导出到excel
		function exportToExcel() {

			$.post("${ctx}/patient/exportToExcel", {}, function(data) {

				var result = eval(data);
				if (result.message != "导出成功") {
					alert(result);
					return;
				}

				window.open("${ctx}/patient/download?sheetName=" + result.url);

			});
		}
	</script>
</body>
</html>
