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
        <input type="text" name="petid" value="<c:out value="${pet.petId}" />" readonly /><br>
    Pet Name:
        <input type="text" name="petname" value="<c:out value="${pet.petName}"/>"/><br>
    Pet Type:<select name = "pettype">
        <c:forEach var="ptype" items="${PetTypes}">
        <option value="<c:out value="${ptype}"/>"><c:out value="${ptype}"/></option>
        </c:forEach>
            </select>
    Owner ID:
        <input type="text" name="ownerid" value="<c:out value="${pet.ownerId}" />" /><br>
    <input type="submit">
</form>
</body>

</body>
</html>
