<%@ page language="java" import="java.util.*"
	contentType="text/html;charset=gb2312" pageEncoding="GB2312"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type">
<title>Insert title here</title>
<script type="text/javascript">
	//������excel
	function exportToExcel() {
		
		$.post("${ctx}/patient/exportToExcel", {
		}, function(data) {

			var result = eval(data);
			if(result.message!="�����ɹ�")
				{
				alert(result);
				return;
				}
				
				window.open("${ctx}/patient/download?sheetName=" + result.url);

		

		});
	}
</script>
</head>

<body>
<%@ include file="/WEB-INF/taglibs-header.jsp"%>
	
	<div>
		<button type="button" onClick="exportToExcel()"  class="btn btn-default btn-lg">
			 ����excel
		</button>
		<table class="table table-hover table-condensed">
			<thead>
				<tr>
					<th>����ID��</th>
					<th>�����</th>
					<th>��������</th>
					<th>��������</th>
					<th>���</th>
					<th>�Ա�</th>
					<th>����ҽ��</th>
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
	
<%@ include file="/WEB-INF/taglibs-footer.jsp"%>
</body>
</html>