<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Users</title>
</head>
<body>
	<br>
	<br>
	<br>
	<a href="${pageContext.request.contextPath}/addMainTable">Add MainTable</a>
	<br>
	<h3>List of all Tables</h3>
	${message}
	<br>
	<br>
	<table border="1px" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th>id</th>
				<th>subId</th>
				<th>str1</th>
				<th>str2</th>
				<th>num1</th>
				<th>num2</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="mainTable" items="${mainTableList}">
				<tr>
					<td>${mainTable.id}</td>
					<td>${mainTable.subId}</td>
					<td>${mainTable.str1}</td>
					<td>${mainTable.str2}</td>
					<td>${mainTable.num1}</td>
					<td>${mainTable.num2}</td>
					<td><a
						href="${pageContext.request.contextPath}/editMainTable/${mainTable.id}">Edit</a></td>
					<td><a
						href="${pageContext.request.contextPath}/deleteMainTable/${mainTable.id}">Delete</a></td>
					<c:forEach var="refTable" items="${mainTable.refTables}">
							<td>${refTable.refId}</td>
							<td>${refTable.refSubId}</td>
							<td>${refTable.str1}</td>
							<td>${refTable.str2}</td>
							<td>${refTable.num1}</td>
							<td>${refTable.num2}</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>


	</table>
</body>
</html>