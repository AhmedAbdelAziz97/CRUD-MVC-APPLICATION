<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>JSP Page</title>
</head>
<body>
        <table>
            <tr><th>ID</th><th>Name</th><th>Email</th><th>Password</th></tr>
            <%-- <c_rt:set scope="request" var="employeedb" value="${pageContext.request.result}"></c_rt:set>--%>
            <c_rt:forEach var="emp" items="${requestScope.result}">
                <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.email}</td>
                <td>${emp.password}</td>
                <td>${emp.salary}</td>
                
                <td><a href='InfoPage.jsp?id=${emp.id}&name=${emp.name}&email=${emp.email}&password=${emp.password}&salary=${emp.salary}'>edit</a></td>
                <td><a href='EmpControllerServlet?id=${emp.id}&action=delete'>delete</a></td>
                </tr>
                
            </c_rt:forEach> 

        </table> 
        
        <a href="InfoPage.jsp" >Add New Empolyee</a>
</body>
</html>