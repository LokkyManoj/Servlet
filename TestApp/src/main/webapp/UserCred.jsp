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
	width: 900px;
	margin: 50px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.search-box {
	margin-bottom: 20px;
	text-align: center;
}

.search-box label {
	font-size: 16px;
	font-weight: bold;
	margin-right: 10px;
}

.search-box input[type="text"] {
	width: 60%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	font-size: 16px;
	margin-right: 10px;
}

.search-box button {
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	background-color: #007bff;
	color: white;
	font-size: 16px;
	cursor: pointer;
}

.search-box button:hover {
	background-color: #0056b3;
}

.user-details {
	margin-bottom: 20px;
}

.user-details table {
	width: 100%;
	border-collapse: collapse;
}

.user-details th, .user-details td {
	padding: 8px;
	border: 1px solid #ddd;
}

.user-details th {
	background-color: #f2f2f2;
	font-weight: bold;
}

.user-details tr:nth-child(even) {
	background-color: #f9f9f9;
}

.delete-btn {
	background-color: red;
	color: white;
	border: none;
	padding: 5px 10px;
	border-radius: 5px;
	cursor: pointer;
}

.edit-btn {
	background-color: green;
	color: white;
	border: none;
	padding: 5px 10px;
	border-radius: 5px;
	cursor: pointer;
}
</style>
<script>
function filterTable() {
	let input = document.getElementById("searchInput");
	let filter = input.value.toLowerCase();
	let table = document.getElementById("userTable");
	let trs = table.getElementsByTagName("tr");

	for (let i = 1; i < trs.length; i++) {
		let tds = trs[i].getElementsByTagName("td");
		let found = false;
		for (let j = 0; j < tds.length; j++) {
			if (tds[j]) {
				let txtValue = tds[j].textContent || tds[j].innerText;
				if (txtValue.toLowerCase().indexOf(filter) > -1) {
					found = true;
					break;
				}
			}
		}
		trs[i].style.display = found ? "" : "none";
	}
}
</script> 
</head>
<body>
	<div class="container">
		<h2>User Details</h2>
		<div class="search-box">
			<label for="searchInput">Search Users:</label>
			<input type="text" id="searchInput" onkeyup="filterTable()" placeholder="Enter UserName">
			<button type="button" onclick="filterTable()">Search</button>
		</div>
		<div class="user-details">
			<table id="userTable">
				<thead>
					<tr>
						<th>ID</th>
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
							<form action="openServlet" method="post">
								<input type="hidden" name="deleteid" value="<%=info.getId()%>">
								<input type="submit" name="action" value="Delete" class="delete-btn">
							</form>
						</td>
						<td>
							<input type="hidden" name="action" value="edit">
							<input type="hidden" name="editid" value="<%= info.getId() %>">
							<button class="edit-btn" type="button" onclick="location.href = 'UpdateUser.jsp?editid=<%=info.getId()%>'">Update</button>
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
