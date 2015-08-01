<%@ page language="java" import="java.util.*" contentType="text/html;charset=gb2312" pageEncoding="GB2312"  %>  
<%@ include file="/WEB-INF/taglibs-bootstrap.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type">
<title>Insert title here</title>
</head>
<body>
	<div>
	
		<table class="table table-hover table-condensed">
			<thead>
				<tr>
					<th>病人ID号</th>
					<th>就诊次</th>
					<th>病人姓名</th>
					<th>科室名称</th>
					<th>诊断</th>
					<th>性别</th>
					<th>责任医生</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lstPatients}" var="p">
					<tr>
						<td><c:out value="${p.patientID}" /></td>
						<td><c:out value="${p.visitID}" /></td>
						<td><c:out value="${p.patientName}" /></td>
						<td><c:out value="${p.deptName}" /></td>
						<td><c:out value="${p.diagnosis}" /></td>
						<td><c:out value="${p.sex}" /></td>
						<td><c:out value="${p.doctorInCharge}" /></td>
					</tr>
				</c:forEach>
			
			</tbody>
		</table>
	</div>
</body>
</html>