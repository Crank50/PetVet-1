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
    <title>Edit Pet</title>
</head>
<body>
Edit Pet
<br><br>
<form name="updateOwnerForm" method="POST" action="/mvc_cust/updatePet">
    Pet ID:
        <input type="text" name="petId" value="<c:out value="${pet.petId}" />" readonly /><br>
    Pet Name:
        <input type="text" name="petname" value="<c:out value="${pet.name}"/>"/><br>
    Pet Type:<select name = "petType">
    <c:forEach var="ptype" items="${petTypes}">
        <option value="<c:out value="${ptype}"/>"><c:out value="${ptype}"/></option>
    </c:forEach> </select><br>
    Owner ID:
        <input type="text" name="ownerId" value="<c:out value="${pet.ownerId}" />" /><br>
    <input type="submit">
</form>
<a href="/">HOME</a>
</body>

</body>
</html>
