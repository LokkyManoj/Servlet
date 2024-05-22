<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.maintain.model.PojoClasses"%>

<!DOCTYPE html>
<html>
<head>
<title>User Details</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
}

.container {
	width: 600px;
	margin: 50px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.user-details {
	margin-bottom: 20px;
}

.user-details label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
}

.user-details p {
	margin: 5px 0;
}

.btn {
	background-color: #007bff;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.btn:hover {
	background-color: #0056b3;
}

.user-details {
	width: 100%;
}

.user-details table {
	width: 100%;
	border-collapse: collapse;
}

.user-details td {
	padding: 8px;
	border: 2px solid #ddd;
}

.user-details td:first-child {
	width: 120px;
	font-weight: bold;
}

.user-details td:nth-child(odd) {
	background-color: #f2f2f2;
}

.user-details tr:last-child td {
	border-bottom: none;
}
</style>
</head>
<body>
	<div class="container">
		<h2>User Details</h2>
		<div class="user-details">
			<table>
				<thead>
					<tr>
						<th>Name</th>
						<th>Mobile</th>
						<th>DOB</th>
						<th>Email</th>
						<th>Delete</th>
						<th>Update</th>
					</tr>
				</thead>
				<tbody>
					<%
					ArrayList<PojoClasses> userRegister = (ArrayList<PojoClasses>) request.getAttribute("userList");
					if (userRegister != null) {
						for (PojoClasses info : userRegister) {
					%>
					<tr>
						<td><%=info.getId()%></td>
						<td><%=info.getUserName()%></td>
						<td><%=info.getMobileNo()%></td>
						<td><%=info.getDate()%></td>
						<td><%=info.getEmail()%></td>
						<td>
						<td>
							<form action="openServlet" method="post">
								<input type="hidden" name="deleteid" value="<%=info.getId()%>">
								<input type="submit" name="action" value="Delete">
							</form>
						</td>

						<td>
							<form action="UpdateUser.html" method="post">
								<input type="hidden" name="id" value="<%=info.getId()%>">
								<input type="submit" name="action" value="Update">
							</form>
						</td>


					</tr>
					<%
					}
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
