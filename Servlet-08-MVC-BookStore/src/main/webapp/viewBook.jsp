<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.logic.bean.BookBean"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>

</head>
<body>
	<h2>Book List</h2>

	<%
	// Retrieving the list from the request attribute
	ArrayList<BookBean> al = (ArrayList<BookBean>) request.getAttribute("list");

	if (al == null || al.isEmpty()) {
	%>
	<p>No records Found</p>
	<%
	} else {
	%>
	<table border = 2px>
		<tr>
			<th>Book ID</th>
			<th>Book Name</th>
			<th>Book Price</th>
			<th>Book Author</th>
		</tr>
		<%
		for (BookBean bb : al) {
		%>
		<tr>
			<td><%=bb.getId()%></td>
			<td><%=bb.getName()%></td>
			<td><%=bb.getPrice()%></td>
			<td><%=bb.getAuthor()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	%>

	<br>
	<a href="index.html">Home</a>

</body>
</html>