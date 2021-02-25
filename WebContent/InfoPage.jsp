<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<body>
	<h1>Add New Employee</h1>
	<form action="EmpControllerServlet" method="post">
		<table>
		
			<input type="hidden" name="id" value="${ param.id }" />
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="${ param.name }"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" value="${ param.email }" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" value="${ param.password }"/></td>
			</tr>
			<tr>
				<td>salary:</td>
				<td><input type="text" name="salary" value="${ param.salary }"/></td>
			</tr>
			<tr>		
			
				<c_rt:choose>
  					<c_rt:when test="${param.name == null}">
						<input  type="hidden" name="action" value="save" /> 
						<td colspan="8"><input type="submit" value="save" /></td>	
					</c_rt:when>			 
					<c_rt:otherwise>
						<input type="hidden" name="action" value="update" />	
						<td colspan="8"><input type="submit" value="update" /></td>
					</c_rt:otherwise>
				</c_rt:choose>
				
			</tr>

			
			
			
		
			

		</table>
	</form>
</body>
</html>