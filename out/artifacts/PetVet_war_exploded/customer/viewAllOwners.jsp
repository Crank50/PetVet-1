<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Justin
  Date: 7/26/16
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>viewAllOwners</title>
</head>
<body>
View All Owners
<br><br>
<table>
    <tr>
        <th>Owner Id</th>
        <th>First</th>
        <th>Last</th>
        <th>Phone</th>
        <th>Address</th>
    </tr>
    <c:forEach items="${owners}" var="owner">
        <tr>
            <td>
                <a href="/mvc_cust/viewOwner?ownerid=${owner.ownerId}">
                    <c:out value="${owner.ownerId}" />
                </a>
            </td>

            <td><c:out value="${owner.firstName}" /></td>
            <td><c:out value="${owner.lastName}" /></td>
            <td><c:out value="${owner.phone}" /></td>
            <td><c:out value="${owner.address}" /></td>
        </tr>
    </c:forEach>
</table>
<br><br>
<a href="/">HOME</a>

</body>
</html>
