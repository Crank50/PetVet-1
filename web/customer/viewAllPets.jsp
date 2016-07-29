<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Justin
  Date: 7/26/16
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>viewAllPets</title>
</head>
<body>
View All Pets
<br><br>
<table>
    <tr>
        <th>Pet Id</th>
        <th>Pet name</th>
        <th>Pet Type</th>
        <th>Owner Id</th>
    </tr>
    <c:forEach items="${pets}" var="pet">
        <tr>
            <td>
                <a href="/mvc_cust/viewPet?petId=${pet.petId}">
                    <c:out value="${pet.petId}" />
                </a>
            </td>
            <td><c:out value="${pet.name}" /></td>
            <td><c:out value="${pet.petType}" /></td>
            <td><c:out value="${pet.ownerId}" /></td>
        </tr>
    </c:forEach>
</table>
<br><br>
<a href="/">HOME</a>

</body>
</html>
